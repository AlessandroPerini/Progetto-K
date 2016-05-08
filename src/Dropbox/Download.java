/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropbox;

import Application.Controller.Applicazione;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class Download {
    
    private String nome = Applicazione.appuntoAttuale.getNome();
    private String corso = Applicazione.corsoAttuale.getNome();
    private String facoltà = Applicazione.facoltàAttuale.getNome();
    private String formato = "";

    public void down() throws IOException, DbxException {
    
        String computerUserName = System.getProperty("user.home");
        String nomeCompleto = nome+"."+corso+"."+facoltà;
        
        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());

        DbxClient client = new DbxClient(config, "WXpJMW2LU9AAAAAAAAAAB_Dq0cw6AU_7Hq8V_Y7_DZ3-SbhtCs-9_v8RhktUAPnX");
        
        //ricerca file per formato
        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
        for (DbxEntry child : listing.children) {
            
            String nomeFile = child.name;

            nomeFile = nomeFile.replace(".", ",");
            String parti[] = nomeFile.split(",");
            String appunto = parti[0];
            
            nomeFile = nomeFile.replace(",", ".");
            if (nome.equals(appunto)) {
                int i = nomeFile.lastIndexOf('.');
                formato = nomeFile.substring(i);
            }
        }//fine ricerca

        FileOutputStream outputStream = new FileOutputStream(computerUserName+"\\Downloads\\"+nome+""+formato+"");
        
        try {
            DbxEntry.File downloadedFile = client.getFile("/"+nomeCompleto+""+formato+"", null,
                outputStream);
            
            String[] opzioni = new String[] {"Ok", "Apri File"};
            
            int risposta = JOptionPane.showOptionDialog(null, "Download correttamente eseguito.\nIl file è stato salvato nella tua cartella \ndei Download  "
                    + "("+computerUserName+"\\Downloads)", "Operazione avvenuta con successo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, opzioni, opzioni[0]);
            
            if(risposta==1){
                Desktop desktop = Desktop.getDesktop();
            File file = new File(computerUserName+"\\Downloads\\"+nome+""+formato+"");
            desktop.open(file);
            }
        } finally {
            outputStream.close();
        }
    }
}
