/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package utilityaaa;

import Application.Applicazione;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 *
 * @author aless
 */
public class EsportaFile {
    
    private boolean filePersonale = false;
    private JTextArea testo;
    private String path;
    private String titolo = "";
    
    public EsportaFile(JTextArea testo){
        this.filePersonale = false;
        this.testo = testo;
    }
    
    public EsportaFile(JTextArea testo, String titolo){
        this.filePersonale = true;
        this.testo = testo;
        this.titolo = titolo;
    }
    
    public void esportaFile() throws FileNotFoundException{
        
        Applicazione applicazione = Applicazione.getInstance();
        if(filePersonale){
            path = System.getProperty("user.home") + "\\Downloads\\" + titolo +".txt";
        }else{
            path = System.getProperty("user.home") + "\\Downloads\\" + applicazione.appuntoAttuale.getNome() +".txt";
        }
        PrintStream scrivi = new PrintStream(new FileOutputStream(path));
        scrivi.println(testo.getText());
        scrivi.close();
    }
}
