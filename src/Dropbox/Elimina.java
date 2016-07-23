/*
*  Qui viene eliminato un determinato file da Dropbox a seguito dell'eliminazione del relativo appunto
*/
package Dropbox;

import Application.Controller.Applicazione;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import java.util.Locale;

/**
 *
 * @author te4o
 */
public class Elimina {
    
    public Applicazione applicazione = Applicazione.getInstance();
    
    //inizializzazione variabili
    public static boolean eliminaOk = false;
    
    public void del() throws DbxException{
        
        DbxRequestConfig config = new DbxRequestConfig("UNI Per Voi",
            Locale.getDefault().toString());
        
        //utilizza il token generato dall'autenticazione
        DbxClient client = new DbxClient(config, "_lcMc5LLpBQAAAAAAAAB_Uw-4dGvjNPY0kjwXwTH6CgROUkbEv040W7JwQLacvFu");
        
        //nome completo del file su dropbox
        String nomeCompleto = applicazione.appuntoAttuale.getNome()+"."+
                              applicazione.corsoAttuale.getNome()+"."+
                              applicazione.facoltàAttuale.getNome();
        String formato = "";
        
        //ricerca file per formato
        DbxEntry.WithChildren listing = client.getMetadataWithChildren("/");
        for (DbxEntry child : listing.children) {
            
            String nomeFile = child.name;

            nomeFile = nomeFile.replace(".", ",");
            String parti[] = nomeFile.split(",");
            String appunto = parti[0];
            
            nomeFile = nomeFile.replace(",", ".");
            if (applicazione.appuntoAttuale.getNome().equals(appunto)) {
                int i = nomeFile.lastIndexOf('.');
                formato = nomeFile.substring(i);
            }
            eliminaOk = true;
        }//fine ricerca

        //elimiazione file passatogli (solo nome.formato) dalla root della cartella del progetto su Dropbox
        client.delete("/"+nomeCompleto+""+formato+"");

    }
    
}
