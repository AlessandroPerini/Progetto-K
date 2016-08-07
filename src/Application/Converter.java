package Application;

import java.io.File;
import javax.swing.JOptionPane;
import tess4j.Tesseract;
import tess4j.TesseractException;

public class Converter {
    
    public static String convert() {
        
        Applicazione applicazione = Applicazione.getInstance();
        
        String file = applicazione.fileScaricato;
        File imageFile = new File(file);
        
        Tesseract tesseract = Tesseract.getInstance();
        String result = "";
        
        try {
            result = tesseract.doOCR(imageFile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Errore durante la conversione dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
}