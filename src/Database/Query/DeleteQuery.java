/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Application.Controller.Applicazione;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class DeleteQuery {
    
    public static void eliminaLibro(){
        
        if (Applicazione.libroAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaLibro = "delete from libri where titolo=?";

            try{
                    PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibro);
                    ps1.clearParameters();
                    ps1.setString(1, Applicazione.libroAttuale.getTitolo());
                    
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    public static void eliminaAppunto(){
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail()))  {
            
            String eliminaAppunto = "delete from appunti where nome=?";

            try{
                    PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaAppunto);
                    ps1.clearParameters();
                    ps1.setString(1, Applicazione.appuntoAttuale.getNome());
                    
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    public static void eliminaDomanda(){
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaDomanda = "delete from domande where titolo=?";

            try{
                    PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomanda);
                    ps1.clearParameters();
                    ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
                    
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    public static void eliminaFacoltàPreferita(){
        
        String insertFacoltàPreferita = "delete from facoltàPreferite where facoltà=? and studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertFacoltàPreferita);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.guest.getEmail());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
