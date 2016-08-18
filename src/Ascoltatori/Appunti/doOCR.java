/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Ascoltatori.Appunti;

import Application.Applicazione;
import Application.Converter;
import Grafica.GifFrame;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author aless
 */
public class doOCR implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    private Converter converter;
    private JTextArea jTextArea;
    private GifFrame gif = new GifFrame();
    private boolean filePersonale = false;
    private String percorsoFile;
    private String language = "ita";
    private JButton ocr;
    
    public doOCR(JButton ocr, JTextArea jTextArea, String language) {
        this.jTextArea = jTextArea;
        this.language = language;
        this.ocr = ocr;
    }
    
    public doOCR(Boolean filePersonale, String percorsoFile, JButton ocr, JTextArea jTextArea, String language) {
        this.filePersonale = true;
        this.percorsoFile = percorsoFile;
        this.jTextArea = jTextArea;
        this.language = language;
        this.ocr = ocr;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        ocr.removeActionListener(this);
        ocr.setEnabled(false);
        gif.apri();
        new java.util.Timer().schedule(new java.util.TimerTask() {
            
            @Override
            public void run() {
                
                try {
                    if(!filePersonale){
                        DownloadFileAppunto download = new DownloadFileAppunto();
                        boolean DownloadSecret = download.DownloadSecret();
                        if(DownloadSecret){
                            converter = new Converter();
                            converter.setLanguage(language);
                            String convert = converter.convert();
                            gif.chiudi();
                            jTextArea.setText(convert);
                            jTextArea.setEditable(true);
                        }
                    }else{
                        converter = new Converter(percorsoFile);
                        converter.setLanguage(language);
                        String convert = converter.convert();
                        gif.chiudi();
                        jTextArea.setText(convert);
                        jTextArea.setEditable(true);
                    }
                    
                } catch (IOException ex) {
                    gif.chiudi();
                    JOptionPane.showMessageDialog(null, "Errore. Riprova", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                } catch (DbxException ex) {
                    gif.chiudi();
                    JOptionPane.showMessageDialog(null, "Errore. Riprova", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }, 10 );
        
    }
    
}
