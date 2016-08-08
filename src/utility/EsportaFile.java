/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package utility;

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
    
    public static void esportaFile(JTextArea testo) throws FileNotFoundException{
        
        Applicazione applicazione = Applicazione.getInstance();
        String path = System.getProperty("user.home") + "\\Downloads\\" + applicazione.appuntoAttuale.getNome() +".txt";
        PrintStream scrivi = new PrintStream(new FileOutputStream(path));
        scrivi.println(testo.getText());
        scrivi.close();
    }
}
