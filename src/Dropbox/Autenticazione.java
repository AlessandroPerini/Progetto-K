
package Dropbox;

import com.dropbox.core.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
* Classe che deve essere eseguita solo per generare un token da utilizzare per effettuare le
* operazioni su Dropbox (download, upload, elimina). Viene creato un link ad una pagina di 
* dropbox e dopo aver effettuato i login con un account a Dropbox (quell'account sarà quello
* dal quale verranno caricati i file) la pagina restituirà un codice. Quest'ultima va inserito 
* nella pagina dell'output di netbeans e verrà così stampato il token finale.
*/
public class Autenticazione {
  
    public static void main(String[] args) throws IOException, DbxException {

        //dati dell'app (si trovano della pagina dell app accedendo a Dropbox Developers)
        final String APP_KEY = "v725fq2n09ko0kn";
        final String APP_SECRET = "dpglz54rrf9r4g6";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);

        DbxRequestConfig config = new DbxRequestConfig("Uni Per Voi",
            Locale.getDefault().toString());
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(config, appInfo);

        //Login utente e autorizzazione app
        String authorizeUrl = webAuth.start();
        System.out.println("1. Go to: " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first)");
        System.out.println("3. Copy the authorization code.");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine().trim();

        //Questo fallisce se l'utente inserisce un codice di autorizzazione non valido
        DbxAuthFinish authFinish = webAuth.finish(code);
        String accessToken = authFinish.accessToken;

        DbxClient client = new DbxClient(config, accessToken);
        
        System.out.println("Linked account: " + client.getAccountInfo().displayName);
        System.out.println("Access Token : "+accessToken);

    }

}

