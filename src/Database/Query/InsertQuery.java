/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Application.Controller.Applicazione;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class InsertQuery {

    public static void inserisciLibro(String titolo, String descrizione, int prezzo, String telefono){

        String insertLibro = "INSERT INTO libri VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLibro);
                ps1.clearParameters();
                ps1.setInt(1, prossimoID("libri"));
                ps1.setString(2, titolo);
                ps1.setString(3, descrizione);
                ps1.setString(4, Applicazione.facoltàPremuta);
                ps1.setString(5, Applicazione.corsoPremuto);
                ps1.setString(6, Applicazione.guest.getEmail());
                ps1.setString(7, telefono);
                ps1.setInt(8, prezzo);
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void inserisciAppunto(String nome, String descrizione){
        
        String insertAppunto = "INSERT INTO appunti VALUES (?, ?, ?, ?, ?);";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertAppunto);
                ps1.clearParameters();
                ps1.setString(1, nome);
                ps1.setString(2, descrizione);
                ps1.setString(3, Applicazione.guest.getEmail());              
                ps1.setString(4, Applicazione.corsoPremuto);
                ps1.setString(5, Applicazione.facoltàPremuta);
                ps1.execute();
                
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static int prossimoID(String tabella){
    
        String tabellaQuery = tabella.replaceAll("'", "\\\\'");
        
        int prossimoID = 0;
        
        String selectId = "select max(id) as massimo from "+tabellaQuery+"";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectId);
                
                ResultSet rs = ps1.executeQuery();

                if(rs.next()) {

                    prossimoID = rs.getInt("massimo");

                }
          
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return prossimoID+1;
    }
    
    public static void inserisciDomanda(String titolo, String domanda){
        
        String insertDomanda= "INSERT INTO domande VALUES (?, ?, ?, 0, ?, ?);";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertDomanda);
                ps1.clearParameters();
                ps1.setString(1, titolo);
                ps1.setString(2, domanda);
                ps1.setString(3, Applicazione.guest.getEmail());              
                ps1.setString(4, Applicazione.corsoPremuto);
                ps1.setString(5, Applicazione.facoltàPremuta);
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public static void inserisciRisposta(String risposta){

   
        String insertRisposta = "INSERT INTO risposte VALUES (?, ?, ?, ?, 0, 0);";
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertRisposta);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
                ps1.setString(2, Applicazione.guest.getEmail());
                ps1.setInt(3, prossimoID("risposte"));
                ps1.setString(4, risposta);              

                
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void inserisciValutazione(JTextArea commento, JSlider punteggio){
        
        String inserisciValutazione = "INSERT INTO valutazioni VALUES (?, ?, ?, ?, ?, ?)";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(inserisciValutazione);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.appuntoAttuale.getNome());
                ps1.setString(2, Applicazione.guest.getEmail());              
                ps1.setString(3, commento.getText());
                ps1.setInt(4, punteggio.getValue());
                ps1.setString(5, Applicazione.facoltàPremuta);
                ps1.setString(6, Applicazione.corsoPremuto);
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    public static void inserisciLikeDomanda(){
        
        String insertLikeDomanda = "INSERT INTO likeDomanda VALUES (?, ?, ?, ?)";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLikeDomanda);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.corsoPremuto);
                ps1.setString(2, Applicazione.domandaAttuale.getTitolo());
                ps1.setString(3, Applicazione.guest.getEmail());
                ps1.setString(4, Applicazione.facoltàPremuta);
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void updateTelefono(String telefono){
        
        String sql = "update studenti set telefono='"+telefono+"' where email='"+Applicazione.guest.getEmail()+"'";
        
         try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(sql);
                
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
