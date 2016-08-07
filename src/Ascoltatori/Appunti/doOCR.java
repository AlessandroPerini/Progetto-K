/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Ascoltatori.Appunti;

import Application.Applicazione;
import Application.Converter;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author aless
 */
public class doOCR implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    JTextArea jTextArea;
    
    public doOCR(JTextArea jTextArea) {
        
        this.jTextArea = jTextArea;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        try {
            DownloadFileAppunto download = new DownloadFileAppunto();
            boolean DownloadSecret = download.DownloadSecret();
            if(DownloadSecret){
                String convert = Converter.convert();
                jTextArea.setText(convert);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(doOCR.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DbxException ex) {
            Logger.getLogger(doOCR.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
