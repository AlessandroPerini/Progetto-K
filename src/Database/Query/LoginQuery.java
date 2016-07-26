/*
* Classe non la query per verificare i dati di accesso
*/
package Database.Query;

import Application.Controller.Applicazione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
* Classe contenente la query per verificare la correttezza dei dati di accesso per il login
* Il metodo è di tipo statico, accessibile senza nessità di instanziare la classe.
* Il metodo rilancia l'eventuale eccezione al componente del livello superiore.
*/
public class LoginQuery {
    
    private static Applicazione applicazione = Applicazione.getInstance();

    //inizializzazione variaili
    private static boolean check = false;
    private static String telefono = "", nickname = "";
    
    public static void login(String email, char[] psw) throws SQLException{
        
        String sql = "select * from studenti where CAST(email AS BINARY)=? and CAST(password AS BINARY)=?";
        
        String password = String.valueOf(psw);
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(sql);
        ps1.clearParameters();
        ps1.setString(1, email);
        ps1.setString(2, password);
        
        ResultSet rs = ps1.executeQuery();
        
        if(rs.next()){
            
            check = true;
            
            telefono = rs.getString("telefono");
            nickname = rs.getString("nickname");
            
            applicazione.inizializzaUtente(email, password, telefono, nickname);
        }
    }
    
}