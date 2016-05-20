/*
* Classe non le query di caricamento dei dati relativi all'utente loggato
*/
package Database.Query;

import Appunti.Appunto;
import Application.Controller.Applicazione;
import Libri.Libro;
import QeA.Domanda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author te4o
 */
public class GuestQuery {
    
    public static void caricaMieiAppunti() throws SQLException{
        
        String selectMieiAppunti = "select * from appunti where studente=?";

        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectMieiAppunti);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nomeAppunto = rs.getString("nome");
            String descrizioneAppunto = rs.getString("descrizione");
            String emailAppunto = rs.getString("studente");
            String corso = rs.getString("corso");
            String facoltà = rs.getString("facoltà");
            float media = rs.getFloat("media");
            
            Appunto appunto = new Appunto(nomeAppunto, descrizioneAppunto,  emailAppunto, corso, facoltà, media);
            Applicazione.appuntiGuest.add(appunto);
        }
        
    }
    
    public static void caricaMieiLibri() throws SQLException{
        
        String selectMieiLibri = "select * from libri where studente=?";

        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectMieiLibri);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nomeLibro = rs.getString("titolo");
            String descrizioneLibro = rs.getString("descrizione");
            int idLibro = rs.getInt("id");
            String emailLibro = rs.getString("studente");
            String telefonoLibro = rs.getString("telefono");
            int prezzoLibro = rs.getInt("prezzo");
            String corso = rs.getString("corso");
            String facoltà = rs.getString("facoltà");
            
            Libro libro = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro, prezzoLibro, corso, facoltà);
            Applicazione.libriGuest.add(libro);
            
        }
    }
    
    public static void caricaMieDomande() throws SQLException{
        
        String selectDomande = "select * from domande where studente=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomande);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String titoloDomanda = rs.getString("titolo");
            String testoDomanda = rs.getString("domanda");
            String studenteDomanda = rs.getString("studente");
            int studenteLike = rs.getInt("like");
            String corso = rs.getString("corso");
            String facoltà = rs.getString("facoltà");
            
            Domanda domanda = new Domanda(titoloDomanda, testoDomanda, studenteDomanda, studenteLike, corso, facoltà);
            Applicazione.domandeGuest.add(domanda);
            
        }
    }
}
