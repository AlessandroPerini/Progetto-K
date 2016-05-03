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
        
        String studenteQuery = Applicazione.guest.getEmail().replaceAll("'", "\\\\'");
        String domandaQuery = Applicazione.domandaAttuale.getTitolo().replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        
        String selectLikeStudente = "Select * from likeDomanda where studente= '" + studenteQuery + "' and domanda= '" + domandaQuery + "'and corso= '" + corsoQuery + "' and facoltà= '" + facoltàQuery + "'";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLikeStudente);
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
        
        String studenteQuery = Applicazione.guest.getEmail().replaceAll("'", "\\\\'");
        String appuntoQuery = Applicazione.appuntoAttuale.getNome().replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        
        String selectValutazioneStudente = "Select * from valutazioni where studente= '" + studenteQuery + "' and appunto= '" + appuntoQuery + "'and corso= '" + corsoQuery + "' and facoltà= '" + facoltàQuery + "'";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
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
        
        String nomeQuery = nome.replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        
        String selectValutazioneStudente = "Select * from appunti where nome= '" + nomeQuery + "'and corso= '" + corsoQuery + "' and facoltà= '" + facoltàQuery + "'";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
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
        
        String titoloQuery = titolo.replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        
        String selectValutazioneStudente = "Select * from domande where titolo= '" + titoloQuery + "'and corso= '" + corsoQuery + "' and facoltà= '" + facoltàQuery + "'";
        boolean bool = true;
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectValutazioneStudente);
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
