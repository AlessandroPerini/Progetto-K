/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Dropbox.Download;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Te4o
 */
public class ScaricaFileAppunto implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            Download download = new Download();
            download.down();
            
        } catch (IOException ex) {
            Logger.getLogger(ScaricaFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DbxException ex) {
            Logger.getLogger(ScaricaFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
