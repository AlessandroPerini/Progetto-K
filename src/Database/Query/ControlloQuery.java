/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Database.Query;

import Application.Controller.Applicazione;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Te4o
 */
public class ControlloQuery {
    
    public static boolean controlloLikeDomanda() throws SQLException {
        
        String selectLikeStudente = "Select * from likeDomanda where studente=? and domanda=? and corso=? and facoltà=?";
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLikeStudente);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        return bool;
    }
    
    public static boolean controlloValutazioneAppunto() throws SQLException {
        
        String selectValutazioneStudente = "Select * from valutazioni where studente=? and appunto=? and corso=? and facoltà=?";
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.appuntoAttuale.getNome());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloNomeAppunto(String nome) throws SQLException {
        
        String selectValutazioneStudente = "Select * from appunti where nome=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
        ps1.clearParameters();
        ps1.setString(1, nome);
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        return bool;
    }
    
    public static boolean controlloTitoloDomanda(String titolo) throws SQLException {
        
        String selectValutazioneStudente = "Select * from domande where titolo=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
        ps1.clearParameters();
        ps1.setString(1, titolo);
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        return bool;
    }
    
    public static boolean controlloFacoltàPreferita() throws SQLException{
        
        String selectFacoltàPreferita = "Select * from facoltàPreferite where facoltà=? and studente=?";
        
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectFacoltàPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.facoltàAttuale.getNome());
        ps1.setString(2, Applicazione.guest.getEmail());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloCorsoPreferito() throws SQLException{
        
        String selectCorsoPreferito = "Select * from corsiPreferiti where corso=? and facoltà=? and studente=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.corsoAttuale.getNome());
        ps1.setString(2, Applicazione.facoltàAttuale.getNome());
        ps1.setString(3, Applicazione.guest.getEmail());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloAppuntoPreferito() throws SQLException{
        
        String selectCorsoPreferito = "Select * from appuntiPreferiti where studentePref=? and appunto=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.appuntoAttuale.getNome());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloLibroPreferito() throws SQLException{
        
        String selectLibroPreferito = "Select * from libriPreferiti where studentePref=? and id=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLibroPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setInt(2, Applicazione.libroAttuale.getID());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloDomandaPreferita() throws SQLException{
        
        String selectDomandaPreferita = "Select * from domandePreferite where studentePref=? and domanda=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.guest.getEmail());
        ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, Applicazione.corsoAttuale.getNome());
        ps1.setString(4, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloAppuntiPreferiti() throws SQLException{
        
        String selectCorsoPreferito = "Select * from appuntiPreferiti where appunto=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.appuntoAttuale.getNome());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloLibriPreferiti() throws SQLException{
        
        String selectLibroPreferito = "Select * from libriPreferiti where id=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLibroPreferito);
        ps1.clearParameters();
        ps1.setInt(1, Applicazione.libroAttuale.getID());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    
    public static boolean controlloDomandePreferite() throws SQLException{
        
        String selectDomandaPreferita = "Select * from domandePreferite where domanda=? and corso=? and facoltà=?";
        
        boolean bool = true;
        
        PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, Applicazione.corsoAttuale.getNome());
        ps1.setString(3, Applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if (rs.next()) {
            bool = false;
        } else {
            bool = true;
        }
        
        return bool;
    }
    public static void controlloLike( int id, int valore){
            String sql ="select * from likeRisposte where studente=? and id=? ";
            int valoreLike = 0;
            
            try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(sql);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ps1.setInt(2, id);
               
                ResultSet rs = ps1.executeQuery();
            
                if (rs.next()) 
                {
                    valoreLike = rs.getInt("like");
                    if(valoreLike == valore){
                        DeleteQuery.eliminaLikeRisposta(id);
                    }else{
                        DeleteQuery.eliminaLikeRisposta(id);
                        InsertQuery.inserisciLikeRisposta(id, valore);
                    }
                }else{
                    
                    InsertQuery.inserisciLikeRisposta(id, valore);
                }
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
}
