/*
* Classe con le query per l'eliminazione dei dati
*/
package Database.Query;

import Application.Controller.Applicazione;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author te4o
 */
public class DeleteQuery {
    
    public static Applicazione applicazione = Applicazione.getInstance();
    
    public static void eliminaLibro() throws SQLException{
        
        if (applicazione.libroAttuale.getStudente().equals(applicazione.guest.getEmail())) {
            
            String eliminaLibro = "delete from libri where id=?";

            PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLibro);
            ps1.clearParameters();
            ps1.setInt(1, applicazione.libroAttuale.getID());
            
            ps1.execute();
            
        }
    }
    
    public static void eliminaAppunto() throws SQLException{
        
        if (applicazione.appuntoAttuale.getStudente().equals(applicazione.guest.getEmail()))  {
            
            String eliminaAppunto = "delete from appunti where nome=?";

            PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaAppunto);
            ps1.clearParameters();
            ps1.setString(1, applicazione.appuntoAttuale.getNome());
            
            ps1.execute();

        }
    }
    
    public static void eliminaDomanda() throws SQLException{
        
        if (applicazione.domandaAttuale.getStudente().equals(applicazione.guest.getEmail())) {
            
            String eliminaDomanda = "delete from domande where titolo=?";

            PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaDomanda);
            ps1.clearParameters();
            ps1.setString(1, applicazione.domandaAttuale.getTitolo());
            
            ps1.execute();
            
            
        }
    }
    
    public static void eliminaFacoltàPreferita() throws SQLException{
        
        String eliminaFacoltàPreferita = "delete from facoltàPreferite where facoltà=? and studente=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaFacoltàPreferita);
        ps1.clearParameters();
        ps1.setString(1, applicazione.facoltàAttuale.getNome());
        ps1.setString(2, applicazione.guest.getEmail());
        
        ps1.execute();
 
    }
    
    public static void eliminaCorsoPreferito() throws SQLException{
        
        String eliminaCorsoPreferito = "delete from corsiPreferiti where corso=? and facoltà=? and studente=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.corsoAttuale.getNome());
        ps1.setString(2, applicazione.facoltàAttuale.getNome());
        ps1.setString(3, applicazione.guest.getEmail());
        
        ps1.execute();

    }
    
    public static void eliminaAppuntoPreferito() throws SQLException{
        
        String eliminaAppuntoPreferito = "delete from appuntiPreferiti where studentePref=? and appunto=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaAppuntoPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setString(2, applicazione.appuntoAttuale.getNome());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLibroPreferito() throws SQLException{
        
        String eliminaLibroPreferito = "delete from libriPreferiti where studentePref=? and id=? and corso=? and facoltà=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setInt(2, applicazione.libroAttuale.getID());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaDomandaPreferita() throws SQLException{
        
        String eliminaDomandaPreferita = "delete from domandePreferite where studentePref=? and domanda=? and corso=? and facoltà=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();

    }
    
    public static void eliminaAppuntiPreferiti() throws SQLException{
        
        String eliminaAppuntoPreferito = "delete from appuntiPreferiti where appunto=? and corso=? and facoltà=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaAppuntoPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.appuntoAttuale.getNome());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLibriPreferiti() throws SQLException{
        
        String eliminaLibroPreferito = "delete from libriPreferiti where id=? and corso=? and facoltà=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
        ps1.clearParameters();
        ps1.setInt(1, applicazione.libroAttuale.getID());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();

    }
    
    public static void eliminaDomandePreferite() throws SQLException{
        
        String eliminaDomandaPreferita = "delete from domandePreferite where domanda=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLikeRisposta(int id) throws SQLException{
        
        String eliminaLikeRisposta = "delete from likeRisposte where studente=? and id=? ";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLikeRisposta);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setInt(2, id);
        
        ps1.execute();
        
    }
    
    public static void decrementaLikeDomanda() throws SQLException{
        
        String updateLikeDomanda = "update `domande` set `like`=? where `titolo`=? and `corso`=? and `facoltà`=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(updateLikeDomanda);
        ps1.clearParameters();
        ps1.setInt(1, (applicazione.domandaAttuale.getLike()-1));
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLikeDomanda() throws SQLException{
        
        String eliminaLikeDomanda = "delete from likeDomanda where corso=? and domanda=?and studente=? and facoltà=?  ";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, applicazione.corsoAttuale.getNome());
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.guest.getEmail());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaValutazioneAppunto() throws SQLException{
        
        String eliminaValutazione = "delete from valutazioni where appunto=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaValutazione);
        ps1.clearParameters();
        ps1.setString(1, applicazione.appuntoAttuale.getNome());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaRisposteDomanda() throws SQLException{
        
        String eliminaRisposta = "delete from risposte where domanda=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaRisposta);
        ps1.clearParameters();
        ps1.setString(1, applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaTuttiLikeDomanda() throws SQLException{
        
        String eliminaLikeDomanda = "delete from likeDomanda where corso=? and domanda=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, applicazione.corsoAttuale.getNome());
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaTuttiLikeRisposta() throws SQLException{
        
        String eliminaLikeRisposta = "delete from likeRisposte where id=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(eliminaLikeRisposta);
        
        for(int i=0; i<applicazione.listaRisposteAttuali.size(); i++){
            
            ps1.clearParameters();
            ps1.setInt(1, applicazione.listaRisposteAttuali.get(i).getId());
            ps1.execute();
        }
        
    }
    
}
