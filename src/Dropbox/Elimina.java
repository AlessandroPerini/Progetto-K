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
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class Elimina {
    
    public void del() throws DbxException{
        
        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());
        
        DbxClient client = new DbxClient(config, "_lcMc5LLpBQAAAAAAAAB_Uw-4dGvjNPY0kjwXwTH6CgROUkbEv040W7JwQLacvFu");
        
        String nomeCompleto = Applicazione.appuntoAttuale.getNome()+"."+
                              Applicazione.corsoAttuale.getNome()+"."+
                              Applicazione.facoltàAttuale.getNome();
        String formato = "";
        
        //ricerca file per formato
        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
        for (DbxEntry child : listing.children) {
            
            String nomeFile = child.name;

            nomeFile = nomeFile.replace(".", ",");
            String parti[] = nomeFile.split(",");
            String appunto = parti[0];
            
            nomeFile = nomeFile.replace(",", ".");
            if (Applicazione.appuntoAttuale.getNome().equals(appunto)) {
                int i = nomeFile.lastIndexOf('.');
                formato = nomeFile.substring(i);
            }
        }//fine ricerca


        client.delete("/"+nomeCompleto+""+formato+"");

    }
    
}
