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
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class SalvaFile implements ActionListener {

    private File file;
    private JTextArea nomeFile;

    public SalvaFile(File file, JTextArea nomeFile) {
        this.file = file;
        this.nomeFile = nomeFile;
    }  
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String percorso = file.getPath();
            
            int i = percorso.lastIndexOf('.');
            String formato = percorso.substring(i+1);
            
            String nome = nomeFile.getText()+"."+Applicazione.corsoAttuale.getNome()+"."+Applicazione.facoltàAttuale.getNome()+"."+formato+"";
            
            Upload upload = new Upload(percorso, nome);
            
            upload.up();
            /* SALVATAGGIO IN LOCALE
            
            String pathIn = file.getPath();
            File fileIn = new File (pathIn);
            
            int i = pathIn.lastIndexOf('.');
            String formato = pathIn.substring(i+1);
            
            String pathOut = "files\\appunti\\"+nomeFile.getText()+"."+Applicazione.corsoAttuale.getNome()+"."+Applicazione.facoltàAttuale.getNome()+"."+formato+"";
            File fileOut = new File(pathOut);
            
            try {
            Files.copy(fileIn.toPath(),fileOut.toPath());
            } catch (IOException ex) {
            Logger.getLogger(SalvaFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            */
        } catch (IOException ex) {
            Logger.getLogger(SalvaFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DbxException ex) {
            Logger.getLogger(SalvaFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
