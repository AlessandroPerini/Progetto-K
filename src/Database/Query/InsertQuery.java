/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Controller.Applicazione;
import Libri.Libro;
import Università.Corsi.CaricaCorsi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class InsertQuery {
    
    public void inserisciLibro(String titolo, String descrizione, int prezzo){
    
        String max =  "11";
        
        String insertLibro = "INSERT INTO libri VALUES ('"+max+"', '"+titolo+"', '"+descrizione+"', '"+Applicazione.facoltàPremuta+"', '"+Applicazione.corsoPremuto+"', '"+Applicazione.guest.getEmail()+"', '"+Applicazione.guest.getTelefono()+"', '"+prezzo+"');";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(insertLibro);
                ps1.execute();
                
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
