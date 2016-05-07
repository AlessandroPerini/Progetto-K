/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Dropbox.Upload;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class CaricaFileAppunto implements ActionListener {

    private File file;
    private JTextArea nomeFile;

    public CaricaFileAppunto(File file, JTextArea nomeFile) {
        this.file = file;
        this.nomeFile = nomeFile;
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(!nomeFile.getText().equals("")){
            try {
                String percorso = file.getPath();

                int i = percorso.lastIndexOf('.');
                String formato = percorso.substring(i+1);

                String nome = nomeFile.getText()+"."+Applicazione.corsoAttuale.getNome()+"."+Applicazione.facoltàAttuale.getNome()+"."+formato+"";

                Upload upload = new Upload(percorso, nome);

                upload.up();

            } catch (IOException ex) {
                Logger.getLogger(CaricaFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DbxException ex) {
                Logger.getLogger(CaricaFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Inserisci prima un file", "File mancante", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
