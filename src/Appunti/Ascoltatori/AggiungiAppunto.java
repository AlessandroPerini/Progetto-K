/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Appunti.Vista.AggiungiAppuntoPanel;
import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import Dropbox.Upload;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiAppunto implements ActionListener{
    
    private JTextArea nome;
    private JTextArea descrizione;
    private File file;
    
    public AggiungiAppunto(JTextArea nome, JTextArea descrizione, File file) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.file = file;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((!nome.getText().equals(""))&&(!descrizione.getText().equals(""))){
            
            try {
                if(ControlloQuery.controlloNomeAppunto(nome.getText())){
                    
                    try {
                        InsertQuery.inserisciAppunto(nome.getText(), descrizione.getText());
                    } catch (SQLException sQLException) {
                        JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    //parte di caricamento file su dropbox
                    
                    String percorso = file.getPath();
                    
                    int i = percorso.lastIndexOf('.');
                    String formato = percorso.substring(i+1);
                    
                    String nomeFile = nome.getText()+"."+Applicazione.corsoAttuale.getNome()+"."+Applicazione.facoltàAttuale.getNome()+"."+formato+"";
                    
                    Upload upload = new Upload(percorso, nomeFile);
                    
                    upload.up();
                    
                    //fine parte caricamento su dropbox
                    
                    JOptionPane.showMessageDialog(null, "Appunto aggiunto correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    
                    Applicazione.svuotaAppunti();
                    
                    ListeQuery.caricaAppunti();
                    
                    Applicazione.back.remove(Applicazione.back.size()-1);
                    
                    ListaAppuntiPanel appunti = new ListaAppuntiPanel();
                    Grafica.container.add(appunti, "appunti");
                    Grafica.card.show(Grafica.container, "appunti");
                    
                    AggiungiAppuntoPanel.clearForm();
                }
                
                else{
                    JOptionPane.showMessageDialog(null, "Un appunto con lo stesso nome è già presente all'interno \ndi '"+Applicazione.facoltàAttuale.getNome()+">"+Applicazione.corsoAttuale.getNome()+"', verifica "
                            + "che non sia \nlo stesso e riprova cambiando nome.","Impossibile caricare appunto" , JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (SQLException ex) {
                System.out.println("Errore durante il controllo del nome dell'appunto");
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            catch (DbxException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Inserisci prima un nome e una descrizione del tuo appunto", "Nome o descrizione mancante", JOptionPane.ERROR_MESSAGE);
        }
    }
}
