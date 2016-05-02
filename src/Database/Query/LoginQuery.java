/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Application.Controller.Applicazione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class LoginQuery {
    
    private static boolean check = false;
    private static int punti;
    private static String telefono;
    
    public static void login(String email, String password){
        
    String sql = "select * from studenti where email=? and password=?";
        
        try{
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(sql);
            ps1.setString(1, email);
            ps1.setString(2, password);
            
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                
                check = true;

                String sql_telefono = "select telefono from studenti where email=?";
                PreparedStatement ps3 = Applicazione.DBconnection.prepareStatement(sql_telefono);
                ps3.setString(1, email);
                ResultSet rs3 = ps3.executeQuery();
                if(rs3.next()){telefono = rs3.getString("telefono");}
                        
                Applicazione.inizializzaUtente(email, password, telefono);
           }
                 
        InternalError LoginEx = new InternalError("Wrong email/password");
        if(check == false) {throw LoginEx;}
        } catch (SQLException ex) {
            Logger.getLogger(LoginQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}