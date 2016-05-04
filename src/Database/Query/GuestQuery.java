/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Appunti.Appunto;
import Application.Controller.Applicazione;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Facoltà;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class GuestQuery {
    
    public static void caricaMieiAppunti(){
    
        String selectMieiAppunti = "select * from appunti where studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectMieiAppunti);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeAppunto = rs.getString("nome");
                    String descrizioneAppunto = rs.getString("descrizione");
                    String emailAppunto = rs.getString("studente");

                    Appunto appunto = new Appunto(nomeAppunto, descrizioneAppunto,  emailAppunto);
                    Applicazione.appuntiGuest.add(appunto);
                }

            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void caricaMieiLibri(){
    
        String selectMieiLibri = "select * from libri where studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectMieiLibri);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeLibro = rs.getString("titolo");
                String descrizioneLibro = rs.getString("descrizione");
                String idLibro = rs.getString("id");
                String emailLibro = rs.getString("studente");
                String telefonoLibro = rs.getString("telefono");
                int prezzoLibro = rs.getInt("prezzo");
                
                Libro libro = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro, prezzoLibro);
                Applicazione.libriGuest.add(libro);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
 
    public static void caricaMieDomande(){
    
        String selectDomande = "select * from domande where studente=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomande);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.guest.getEmail());
                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String titoloDomanda = rs.getString("titolo");
                String testoDomanda = rs.getString("domanda");
                String studenteDomanda = rs.getString("studente");
               
                Domanda domanda = new Domanda(titoloDomanda, testoDomanda, studenteDomanda);
                Applicazione.domandeGuest.add(domanda);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
