package Ocr;

import Application.Applicazione;
import java.io.File;

public class Converter {
    
    private Applicazione applicazione = Applicazione.getInstance();
    private String percorsoFile;
    private String language = "ita";
    private MotoreOCR motoreOCR;
       
    public Converter(MotoreOCR motoreOCR){
        this.percorsoFile = null;
        this.motoreOCR = motoreOCR;
    }
    
    public Converter(MotoreOCR motoreOCR, String percorsoFile){
        this.motoreOCR = motoreOCR;
        this.percorsoFile = percorsoFile;
    }

    public void setLanguage(String language){
        this.language = language;
    }
    
    public String convert() {

        File imageFile;
        motoreOCR.setLanguage(language);
        
        if(percorsoFile == null){
            imageFile = new File(applicazione.fileScaricato);
        }else{
            imageFile = new File(percorsoFile);
        }
        
        return motoreOCR.doOCR(imageFile);
    }
 
}