/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dropbox;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class Upload {
    
    private String percorsoFile;
    private String nomeFile;

    public Upload(String percorso, String nome) {
        this.percorsoFile = percorso;
        this.nomeFile = nome;
    }
    
    public void up() throws IOException, DbxException {

        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());

        DbxClient client = new DbxClient(config, "_lcMc5LLpBQAAAAAAAAB_Uw-4dGvjNPY0kjwXwTH6CgROUkbEv040W7JwQLacvFu");

        File inputFile = new File(percorsoFile);
        FileInputStream inputStream = new FileInputStream(inputFile);
        
        try {
            DbxEntry.File uploadedFile = client.uploadFile("/"+nomeFile+"",
                DbxWriteMode.add(), inputFile.length(), inputStream);
            JOptionPane.showMessageDialog(null, "Il tuo file è stato caricato correttamente", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
        } finally {
            inputStream.close();
        }
    
    }
    
}
