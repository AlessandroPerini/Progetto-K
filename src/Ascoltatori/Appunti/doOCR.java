/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Ascoltatori.Appunti;

import Application.Applicazione;
import Application.Converter;
import Entità.Appunto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import tess4j.Tesseract;
import tess4j.TesseractException;
import utility.EsportaFile;

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
        
        
        DownloadFileAppunto download = new DownloadFileAppunto();
        download.actionPerformed(e);
        
        String convert = Converter.convert();
        
        jTextArea.setText(convert);
        
    }
    
}
