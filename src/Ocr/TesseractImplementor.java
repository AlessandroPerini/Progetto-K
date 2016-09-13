/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocr;

import Tesseract.tess4j.Tesseract;
import Tesseract.tess4j.TesseractException;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author aless
 */
public class TesseractImplementor implements OCREngine{

    private Tesseract tesseract = Tesseract.getInstance();
    private String result = "";
    
    @Override
    public void setLanguage(String language) {
        
        if(language.equals("Italiano")){
            language = "ita";
        }else language = "eng";
        
        tesseract.setLanguage(language);
    }

    @Override
    public String doOCR(File imageFile) {
        
        try {
            result = tesseract.doOCR(imageFile);
        } catch (TesseractException ex) {
            JOptionPane.showMessageDialog(null, "Problema durante la conversione. Riprova", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
    
}
