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
        
        String eliminaFacoltàPreferita = "delete from facoltàPreferite where facoltà=? and studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaFacoltàPreferita);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàAttuale.getNome());
                ps1.setString(2, Applicazione.guest.getEmail());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaCorsoPreferito(){
        
        String deleteCorsoPreferito = "delete from corsiPreferiti where corso=? and facoltà=? and studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteCorsoPreferito);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.corsoAttuale.getNome());
                ps1.setString(2, Applicazione.facoltàAttuale.getNome());
                ps1.setString(3, Applicazione.guest.getEmail());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaAppuntoPreferito(){
        
        String deleteAppuntoPreferito = "delete from appuntiPreferiti where studentePref=? and appunto=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteAppuntoPreferito);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ps1.setString(2, Applicazione.appuntoAttuale.getNome());
                ps1.setString(3, Applicazione.corsoAttuale.getNome());
                ps1.setString(4, Applicazione.facoltàAttuale.getNome());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaLibroPreferito(){
        
        String eliminaLibroPreferito = "delete from libriPreferiti where studentePref=? and id=? and libro=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ps1.setInt(2, Applicazione.libroAttuale.getID());
                ps1.setString(3, Applicazione.libroAttuale.getTitolo());
                ps1.setString(4, Applicazione.corsoAttuale.getNome());
                ps1.setString(5, Applicazione.facoltàAttuale.getNome());

                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaDomandaPreferita(){
        
        String eliminaDomandaPreferita = "delete from domandePreferite where studentePref=? and domanda=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
                ps1.setString(3, Applicazione.corsoAttuale.getNome());
                ps1.setString(4, Applicazione.facoltàAttuale.getNome());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaAppuntiPreferiti(){
        
        String deleteAppuntoPreferito = "delete from appuntiPreferiti where appunto=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(deleteAppuntoPreferito);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.appuntoAttuale.getNome());
                ps1.setString(2, Applicazione.corsoAttuale.getNome());
                ps1.setString(3, Applicazione.facoltàAttuale.getNome());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaLibriPreferiti(){
        
        String eliminaLibroPreferito = "delete from libriPreferiti where id=? and libro=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaLibroPreferito);
                ps1.clearParameters();
                ps1.setInt(1, Applicazione.libroAttuale.getID());
                ps1.setString(2, Applicazione.libroAttuale.getTitolo());
                ps1.setString(3, Applicazione.corsoAttuale.getNome());
                ps1.setString(4, Applicazione.facoltàAttuale.getNome());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void eliminaDomandePreferite(){
        
        String eliminaDomandaPreferita = "delete from domandePreferite where domanda=? and corso=? and facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(eliminaDomandaPreferita);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
                ps1.setString(2, Applicazione.corsoAttuale.getNome());
                ps1.setString(3, Applicazione.facoltàAttuale.getNome());
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
