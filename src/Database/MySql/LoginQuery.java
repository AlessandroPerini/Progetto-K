/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.MySql;

import Controller.Applicazione;
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
    private int punti;
    private String telefono;
    
    private String email;
    private String password;

    public LoginQuery(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public void login(){
        
    String sql = "select * from studenti where email=? and password=?";
        
        try{
            PreparedStatement ps1 = Applicazione.connection.prepareStatement(sql);
            ps1.setString(1, email);
            ps1.setString(2, password);
            
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                
                check = true;
                
                String sql_punti = "select punti from studenti where email=?";
                PreparedStatement ps2 = Applicazione.connection.prepareStatement(sql_punti);
                ps2.setString(1, email);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()){punti = rs2.getInt("punti");}

                String sql_telefono = "select telefono from studenti where email=?";
                PreparedStatement ps3 = Applicazione.connection.prepareStatement(sql_telefono);
                ps3.setString(1, email);
                ResultSet rs3 = ps3.executeQuery();
                if(rs3.next()){telefono = rs3.getString("telefono");}
                        
                Applicazione.inizializzaUtente(email, password, punti, telefono);
           }
                 
        InternalError LoginEx = new InternalError("Wrong email/password");
        if(check == false) {throw LoginEx;}
        } catch (SQLException ex) {
            Logger.getLogger(LoginQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}