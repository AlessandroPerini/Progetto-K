package Ocr;

import Application.Applicazione;
import Ocr.HPEImplementor;
import Ocr.TesseractImplementor;
import java.io.File;
import Ocr.OCREngine;

public class Converter {
    
    private Applicazione applicazione = Applicazione.getInstance();
    private String filePath = null;
    private String language = "ita";
    private OCREngine OcrEngine;
    private String priority;
       
    public Converter(String priority){
        this.filePath = null;
        this.priority = priority;
        createEngineInstance();
    }
    
    public Converter(String priority, String filePath){
        this.filePath = filePath;
        this.priority = priority;
        createEngineInstance();
    }
    
    private void createEngineInstance(){
        
        if(priority.equals("Velocità")){
            OcrEngine = new TesseractImplementor();
        }else{
            OcrEngine = new HPEImplementor();
        }
    }

    public void setLanguage(String language){
        this.language = language;
    }
    
    public String convert() {

        File imageFile;
        OcrEngine.setLanguage(language);
        if(filePath == null){
            imageFile = new File(applicazione.fileScaricato);
        }else{
            imageFile = new File(filePath);
        }
        return OcrEngine.doOCR(imageFile);
    }
 
}