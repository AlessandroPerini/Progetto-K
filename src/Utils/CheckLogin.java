/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Studente.Studente;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class CheckLogin {

    private static Connection connection = new DbConnection().connect();
    
    private static ArrayList<Studente> studenti = new ArrayList<>();
    private static boolean checkLogin = false;
    private static Studente guest = new Studente("", "", 0, "");
    private static int punti;
    private static String telefono;
  
    public static void Check(String email, String password){
        
        checkLogin= false;
    
        String sql = "select * from credenziali where email=? and password=?";
        
        try{
            PreparedStatement ps1 = connection.prepareStatement(sql);
            ps1.setString(1, email);
            ps1.setString(2, password);
            
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                checkLogin = true;
                
                String sql_punti = "select punti from credenziali where email=?";
                PreparedStatement ps2 = connection.prepareStatement(sql_punti);
                ps2.setString(1, email);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.next()){punti = rs2.getInt("punti");}

                String sql_telefono = "select telefono from credenziali where email=?";
                PreparedStatement ps3 = connection.prepareStatement(sql_telefono);
                ps3.setString(1, email);
                ResultSet rs3 = ps3.executeQuery();
                if(rs3.next()){telefono = rs3.getString("telefono");}
                        
                guest = new Studente(email, password, punti, telefono);
                guest.setNickname();
                
           }
            
            
        InternalError LoginEx = new InternalError("Wrong email/password");
        if(checkLogin == false) {throw LoginEx;}
        }catch(Exception e){
        }
    }
    
    public static Studente getGuest() {
        return guest;
    }
    
    public static void deleteGuest(){guest = new Studente("", "", 0, "");}

    public static boolean isCheckLogin() {
        return checkLogin;
    }  
    
}
