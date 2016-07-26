
package Dropbox;

import Application.Controller.Applicazione;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

/**
* Qui viene scaricato un determinato file da Dropbox e salvato in locale
*/
public class Download {
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //inizializzazione variabili
    private String nome = applicazione.appuntoAttuale.getNome();
    private String corso = applicazione.corsoAttuale.getNome();
    private String facoltà = applicazione.facoltàAttuale.getNome();
    private String formato = "";
    public static boolean downloadOK = false;

    public String down() throws IOException, DbxException {
    
        //prende il percorso "C:\Users\'nome_utente'\" (purtroppo presumibilmente funziona solo con Windows)
        String computerUserName = System.getProperty("user.home");
        
        //nome completo del file su dropbox
        String nomeCompleto = nome+"."+corso+"."+facoltà;
        
        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());

        //utilizza il token generato dall'autenticazione
        DbxClient client = new DbxClient(config, "_lcMc5LLpBQAAAAAAAAB_Uw-4dGvjNPY0kjwXwTH6CgROUkbEv040W7JwQLacvFu");
        
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

        //setta la destinazione del file scaricato nella cartella "C:\Users\'nome_utente'\Downloads" (purtroppo presumibilmente funziona solo con Windows)
        FileOutputStream outputStream = new FileOutputStream(computerUserName+"\\Downloads\\"+nome+""+formato+"");
        
        try {
            //preleva il file passatogli (solo nome.formato) dalla root della cartella del progetto su Dropbox e lo salva in locale
            DbxEntry.File downloadedFile = client.getFile("/"+nomeCompleto+""+formato+"", null,
                outputStream);
            
            downloadOK = true;
            
        } finally {
            outputStream.close();
        }
        return formato;
    }
    
}
