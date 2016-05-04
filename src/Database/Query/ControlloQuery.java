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

    public static boolean controlloLikeDomanda() {
        
        String selectLikeStudente = "Select * from likeDomanda where studente=? and domanda=? and corso=? and facoltà=?";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLikeStudente);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
            ps1.setString(3, Applicazione.corsoPremuto);
            ps1.setString(4, Applicazione.facoltàPremuta);
            
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                bool = false;
            } else {
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }
    
    public static boolean controlloValutazioneAppunto() {
        
        String selectValutazioneStudente = "Select * from valutazioni where studente=? and appunto=? and corso=? and facoltà=?";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            ps1.setString(2, Applicazione.appuntoAttuale.getNome());
            ps1.setString(3, Applicazione.corsoPremuto);
            ps1.setString(4, Applicazione.facoltàPremuta);
            
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                bool = false;
            } else {
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }
    
    public static boolean controlloNomeAppunto(String nome) {
        
        String selectValutazioneStudente = "Select * from appunti where nome=? and corso=? and facoltà=?";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
            ps1.clearParameters();
            ps1.setString(1, nome);
            ps1.setString(2, Applicazione.corsoPremuto);
            ps1.setString(3, Applicazione.facoltàPremuta);
            System.out.println("Select * from appunti where nome="+nome+" and "
                    + "corso="+Applicazione.corsoPremuto+" and facoltà="+Applicazione.facoltàPremuta+"");
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                bool = false;
            } else {
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }
    
    public static boolean controlloTitoloDomanda(String titolo) {
             
        String selectValutazioneStudente = "Select * from domande where titolo=? and corso=? and facoltà=?";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
            ps1.setString(2, Applicazione.corsoPremuto);
            ps1.setString(3, Applicazione.facoltàPremuta);
            
            ResultSet rs = ps1.executeQuery();
            
            if (rs.next()) {
                bool = false;
            } else {
                bool = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bool;
    }
    
}
