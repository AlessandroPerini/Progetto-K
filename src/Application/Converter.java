package Application;

import java.io.File;
import javax.swing.JOptionPane;
import Tesseract.tess4j.Tesseract;

public class Converter {
    
    private Applicazione applicazione = Applicazione.getInstance();
    private String percorsoFile;
       
    public Converter(){
        this.percorsoFile = null;
    }
    
    public Converter(String percorsoFile){
        this.percorsoFile = percorsoFile;
    }

    public String convert() {

        File imageFile;
        
        if(percorsoFile == null){
            imageFile = new File(applicazione.fileScaricato);
        }else{
            imageFile = new File(percorsoFile);
        }
        
        Tesseract tesseract = Tesseract.getInstance();
        String result = "";

        try {
            result = tesseract.doOCR(imageFile);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Errore. Il file potrebbe essere gia in un formato testuale. Controlla nella tua cartella dei Downloads", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }
 
}