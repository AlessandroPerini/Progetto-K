/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Controller.Applicazione;
import Database.Connection.ConnessioneDB;
import Libro.Libro;
import Università.Corsi.CaricaCorsi;
import Università.Facolta.Facoltà;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class infoQuery {
    
    private Connection connection = new ConnessioneDB().connect();
    
    public void caricaInfoLibro(){
    
        String selectInfoLibro = "select * from libri where facoltà=? and corso=? and titolo=?";
        
         try{
                PreparedStatement ps1 = connection.prepareStatement(selectInfoLibro);
                ps1.setString(1, Applicazione.facoltàCorrente);
                ps1.setString(2, Applicazione.corsoCorrente);
                ps1.setString(3,Applicazione.libroCorrente);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeLibro = rs.getString("titolo");
                    String descrizioneLibro = rs.getString("descrizione");
                    String idLibro = rs.getString("id");
                    String emailLibro = rs.getString("studente");
                    String telefonoLibro = rs.getString("telefono");
                    int prezzoLibro = rs.getInt("prezzo");
                
                    Applicazione.libroAttuale = new Libro(nomeLibro, descrizioneLibro, idLibro, telefonoLibro,emailLibro,  prezzoLibro);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
