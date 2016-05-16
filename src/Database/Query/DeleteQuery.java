/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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
    
    public static void eliminaLibro() throws SQLException{
        
        if (Applicazione.libroAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaLibro = "delete from libri where id=?";
            
            
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibro);
            ps1.clearParameters();
            ps1.setInt(1, Applicazione.libroAttuale.getID());
            
            ps1.execute();
            
        }
    }
    
    public static void eliminaAppunto() throws SQLException{
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail()))  {
            
            String eliminaAppunto = "delete from appunti where nome=?";
            
            
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaAppunto);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.appuntoAttuale.getNome());
            
            ps1.execute();
            
            
        }
    }
    
    public static void eliminaDomanda() throws SQLException{
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaDomanda = "delete from domande where titolo=?";
            
            
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomanda);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
            
            ps1.execute();
            
            
        }
    }
    
    public static void eliminaFacoltàPreferita() throws SQLException{
        
        String eliminaFacoltàPreferita = "delete from facoltàPreferite where facoltà=? and studente=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaFacoltàPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.facoltàAttuale.getNome());
        ps1.setString(2, Applicazione.guest.getEmail());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaCorsoPreferito() throws SQLException{
        
        String deleteCorsoPreferito = "delete from corsiPreferiti where corso=? and facoltà=? and studente=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.corsoAttuale.getNome());
        ps1.setString(2, Applicazione.facoltàAttuale.getNome());
        ps1.setString(3, Applicazione.guest.getEmail());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaAppuntoPreferito() throws SQLException{
        
        String deleteAppuntoPreferito = "delete from appuntiPreferiti where studentePref=? and appunto=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteAppuntoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.appuntoAttuale.getNome());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLibroPreferito() throws SQLException{
        
        String eliminaLibroPreferito = "delete from libriPreferiti where studentePref=? and id=? and corso=? and facoltà=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setInt(2, Applicazione.libroAttuale.getID());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaDomandaPreferita() throws SQLException{
        
        String eliminaDomandaPreferita = "delete from domandePreferite where studentePref=? and domanda=? and corso=? and facoltà=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaAppuntiPreferiti() throws SQLException{
        
        String deleteAppuntoPreferito = "delete from appuntiPreferiti where appunto=? and corso=? and facoltà=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteAppuntoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.appuntoAttuale.getNome());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLibriPreferiti() throws SQLException{
        
        String eliminaLibroPreferito = "delete from libriPreferiti where id=? and corso=? and facoltà=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
        ps1.clearParameters();
        ps1.setInt(1, Applicazione.libroAttuale.getID());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
        
    }
    
    public static void eliminaDomandePreferite() throws SQLException{
        
        String eliminaDomandaPreferita = "delete from domandePreferite where domanda=? and corso=? and facoltà=?";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLikeRisposta(int id) throws SQLException{
        
        String eliminaLikeRisposta = "delete from likeRisposte where studente=? and id=? ";
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLikeRisposta);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setInt(2, id);
        
        ps1.execute();
        
    }
    
    public static void decrementaLikeDomanda() throws SQLException{
        
        String sql = "update `domande` set `like`=? where `titolo`=? and `corso`=? and `facoltà`=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(sql);
        ps1.clearParameters();
        ps1.setInt(1, (Applicazione.domandaAttuale.getLike()-1));
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaLikeDomanda() throws SQLException{
        
        String insertLikeDomanda = "delete from likeDomanda where corso=? and domanda=?and studente=? and facoltà=?  ";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.corsoAttuale.getNome());
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.guest.getEmail());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void eliminaValutazioneAppunto() throws SQLException{
        
        String eliminaValutazione = "delete from valutazioni where appunto=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaValutazione);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.appuntoAttuale.getNome());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaRisposteDomanda() throws SQLException{
        
        String eliminaRisposta = "delete from risposte where domanda=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaRisposta);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaTuttiLikeDomanda() throws SQLException{
        
        String insertLikeDomanda = "delete from likeDomanda where corso=? and domanda=? and facoltà=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.corsoAttuale.getNome());
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
    }
    
    public static void eliminaTuttiLikeRisposta() throws SQLException{
        
        String eliminaLikeRisposta = "delete from likeRisposte where id=?";
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLikeRisposta);
        
        for(int i=0; i<Applicazione.listaRisposteAttuali.size(); i++){
            
            ps1.clearParameters();
            ps1.setInt(1, Applicazione.listaRisposteAttuali.get(i).getId());
            ps1.execute();
        }
        
    }
    
}
