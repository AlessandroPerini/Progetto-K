
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

/**
* Qui viene caricato un determinato file su Dropbox con il seguente formato: nomeFacoltà.nomeCorso.nomeApputno
*/
public class Upload {
    
    //dichiarazione variabili
    private String percorsoFile;
    private String nomeFile;
    
    //inizializzazione variabili
    public static boolean uploadOK = false;

    public Upload(String percorso, String nome) {
        this.percorsoFile = percorso;
        this.nomeFile = nome;
    }
    
    public void up() throws IOException, DbxException {

        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());

        //utilizza il token generato dall'autenticazione
        DbxClient client = new DbxClient(config, "_lcMc5LLpBQAAAAAAAAB_Uw-4dGvjNPY0kjwXwTH6CgROUkbEv040W7JwQLacvFu");

        //setta il file da caricare
        File inputFile = new File(percorsoFile);
        FileInputStream inputStream = new FileInputStream(inputFile);
        
        try {
            //effettua l'upload del file passatogli nella root della cartella del progetto su Dropbox
            DbxEntry.File uploadedFile = client.uploadFile("/"+nomeFile+"",
                DbxWriteMode.add(), inputFile.length(), inputStream);
            uploadOK = true;
        } finally {
            inputStream.close();
        }
    
    }
    
}
