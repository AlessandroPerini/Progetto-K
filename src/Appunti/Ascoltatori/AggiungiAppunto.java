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
import Frame.GifFrame;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private JButton bottone;
    private JButton botton2;
    
    public AggiungiAppunto(JTextArea nome, JTextArea descrizione, File file, JButton bottone, JButton botton2) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.file = file;
        this.bottone = bottone;
        this.botton2 = botton2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((!nome.getText().equals(""))&&(!descrizione.getText().equals(""))){
            if((nome.getText().length()<21000000)&&(descrizione.getText().length()<500)){
                try {
                    if(ControlloQuery.controlloNomeAppunto(nome.getText())){
                        if(file.length()<2100000){
                            
                            bottone.setEnabled(false);
                            botton2.setEnabled(false);
                            
                            GifFrame.apri();
                            
                            new java.util.Timer().schedule(
                                    new java.util.TimerTask() {
                                        @Override
                                        public void run() {
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
                                            
                                            try {
                                                upload.up();
                                                //fine parte caricamento su dropbox
                                                
                                                
                                                if(Upload.uploadOK){
                                                    
                                                    GifFrame.chiudi();
                                                    
                                                    JOptionPane.showMessageDialog(null, "Appunto aggiunto correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                                                    
                                                    Applicazione.svuotaAppunti();
                                                    
                                                    ListeQuery.caricaAppunti();
                                                    
                                                    Applicazione.back.remove(Applicazione.back.size()-1);
                                                    
                                                    ListaAppuntiPanel appunti = new ListaAppuntiPanel();
                                                    Grafica.container.add(appunti, "appunti");
                                                    Grafica.card.show(Grafica.container, "appunti");
                                                    
                                                    AggiungiAppuntoPanel.clearForm();
                                                    
                                                    bottone.setEnabled(true);
                                                    botton2.setEnabled(true);
                                                    
                                                    
                                                }
                                            } catch (IOException ex) {
                                                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                                            }
                                            catch (DbxException ex) {
                                                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                                            }
                                            catch (SQLException ex) {
                                                System.out.println("Errore durante il controllo del nome dell'appunto");
                                            }
                                            
                                        }
                                    },
                                    10
                            );
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Il file supera la dimensione massima consentita (max 20Mb)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                            
                        }
                        
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Un appunto con lo stesso nome è già presente all'interno \ndi '"+Applicazione.facoltàAttuale.getNome()+">"+Applicazione.corsoAttuale.getNome()+"', verifica "
                                + "che non sia \nlo stesso e riprova cambiando nome.","Impossibile caricare appunto" , JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (SQLException ex) {
                    System.out.println("Errore durante il controllo del nome dell'appunto");
                }
                
            }
            
            else{
                JOptionPane.showMessageDialog(null, "Nome(max 100 caratteri) e/o Descrizione (max 500 caratteri troppo lunghi)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Nome e/o descrizione non validi", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
        
    }

}
