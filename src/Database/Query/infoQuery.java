/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Controller.Applicazione;
import Database.Connection.ConnessioneDB;
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
    
        String selectInfoLibro = "select * from libri where facolta=? and corso=? and libro=?";
        
         try{
                PreparedStatement ps1 = connection.prepareStatement(selectInfoLibro);
                ps1.setString(1, Applicazione.facoltàCorrente);
                ps1.setString(1, Applicazione.corsoCorrente);
                ps1.setString(1, "");

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
