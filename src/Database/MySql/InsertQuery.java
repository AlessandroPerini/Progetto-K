/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.MySql;

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
        
        String titoloQuery = titolo.replaceAll("'", "\\\\'");
        String descrizioneQuery = descrizione.replaceAll("'", "\\\\'");;
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");;
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");;
        
        String insertLibro = "INSERT INTO libri VALUES ('"+prossimoID()+"', '"+titoloQuery+"', '"+descrizioneQuery+"', '"+facoltàQuery+"', '"+corsoQuery+"', '"+Applicazione.guest.getEmail()+"', '"+Applicazione.guest.getTelefono()+"', '"+prezzo+"');";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(insertLibro);
                ps1.execute();
                
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public int prossimoID(){
    
        int prossimoID = 0;
        
        String selectId = "select max(id) as massimo from libri";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectId);
                ResultSet rs = ps1.executeQuery();

                    if(rs.next()) {
                        
                        prossimoID = rs.getInt("massimo");
                    }
          
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        return prossimoID+1;
    }
}
