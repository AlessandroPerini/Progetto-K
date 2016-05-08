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
import java.util.logging.Level;
import java.util.logging.Logger;
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
            if(ControlloQuery.controlloNomeAppunto(nome.getText())){

                InsertQuery.inserisciAppunto(nome.getText(), descrizione.getText());

                //parte di caricamento file su dropbox
                try {
                    String percorso = file.getPath();

                    int i = percorso.lastIndexOf('.');
                    String formato = percorso.substring(i+1);

                    String nomeFile = nome.getText()+"."+Applicazione.corsoAttuale.getNome()+"."+Applicazione.facoltàAttuale.getNome()+"."+formato+"";

                    Upload upload = new Upload(percorso, nomeFile);

                    upload.up();

                } catch (IOException ex) {
                    Logger.getLogger(AggiungiAppunto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DbxException ex) {
                    Logger.getLogger(AggiungiAppunto.class.getName()).log(Level.SEVERE, null, ex);
                }//fine parte caricamento su dropbox

                Applicazione.svuotaAppunti();

                ListeQuery.caricaAppunti();

                Applicazione.back.remove(Applicazione.back.size()-1);

                ListaAppuntiPanel appunti = new ListaAppuntiPanel();
                Grafica.container.add(appunti, "appunti");
                Grafica.card.show(Grafica.container, "appunti");

                AggiungiAppuntoPanel.clearForm();
            }
            else{
                JOptionPane.showMessageDialog(null, "Un appunto con lo stesso nome è già presente all'interno \ndi '"+Applicazione.facoltàPremuta+">"+Applicazione.corsoPremuto+"', verifica "
                        + "che non sia \nlo stesso e riprova cambiando nome.","Impossibile caricare appunto" , JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
             JOptionPane.showMessageDialog(null, "Inserisci prima un nome e una descrizione del tuo appunto", "Nome o descrizione mancante", JOptionPane.ERROR_MESSAGE);
        }
    }
}
