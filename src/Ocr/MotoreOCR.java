/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ocr;

import java.io.File;

/**
 *
 * @author aless
 */
public interface MotoreOCR {
    
    void setLanguage(String language);
    String doOCR(File imageFile);
}
