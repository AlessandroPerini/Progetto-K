package Ocr;

import Application.Applicazione;
import Ocr.HPEImplementor;
import Ocr.MotoreOCR;
import Ocr.TesseractImplementor;
import java.io.File;

public class Converter {
    
    private Applicazione applicazione = Applicazione.getInstance();
    private String percorsoFile = null;
    private String language = "ita";
    private MotoreOCR motoreOCR;
    private String priorità;
       
    public Converter(String priorità){
        this.percorsoFile = null;
        this.priorità = priorità;
        istanziaMotore();
    }
    
    public Converter(String priorità, String percorsoFile){
        this.percorsoFile = percorsoFile;
        this.priorità = priorità;
        istanziaMotore();
    }
    
    private void istanziaMotore(){
        
        if(priorità.equals("Velocità")){
            motoreOCR = new TesseractImplementor();
        }else{
            motoreOCR = new HPEImplementor();
        }
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