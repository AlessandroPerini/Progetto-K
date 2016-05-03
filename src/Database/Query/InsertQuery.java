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
    
    private static String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
    private static String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
    
    public static void inserisciLibro(String titolo, String descrizione, int prezzo){
        
        String titoloQuery = titolo.replaceAll("'", "\\\\'");
        String descrizioneQuery = descrizione.replaceAll("'", "\\\\'");
        
        String insertLibro = "INSERT INTO libri VALUES ('"+prossimoID("libri")+"', '"+titoloQuery+"', '"+descrizioneQuery+"', '"+facoltàQuery+"' ,'"+corsoQuery+"', '"+Applicazione.guest.getEmail()+"', '"+Applicazione.guest.getTelefono()+"', '"+prezzo+"');";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLibro);
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void inserisciAppunto(String nome, String descrizione){
        
        String nomeQuery = nome.replaceAll("'", "\\\\'");
        String descrizioneQuery = descrizione.replaceAll("'", "\\\\'");
        
        String insertAppunto = "INSERT INTO appunti VALUES ('"+nomeQuery+"', '"+descrizioneQuery+"', '"+0+"', '"+Applicazione.guest.getEmail()+"', '"+corsoQuery+"', '"+facoltàQuery+"');";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertAppunto);
                ps1.execute();
                
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static int prossimoID(String tabella){
    
        int prossimoID = 0;
        
        String selectId = "select max(id) as massimo from "+tabella;
        
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
        
        String titoloQuery = titolo.replaceAll("'", "\\\\'");
        String domandaQuery = domanda.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        
        String insertDomanda= "INSERT INTO domande VALUES ('"+corsoQuery+"','"+Applicazione.guest.getEmail()+"','"+titoloQuery+"', '"+domandaQuery+"', 0,'"+facoltàQuery+"');";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertDomanda);
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    public static void inserisciRisposta(String risposta){
        
        String rispostaQuery = risposta.replaceAll("'", "\\\\'");
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
   
        String insertRisposta = "INSERT INTO risposte VALUES (?,'"+Applicazione.guest.getEmail()+"','"+prossimoID("risposte")+"','"+rispostaQuery+"',0,0);";
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertRisposta);
                ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void inserisciValutazione(JTextArea commento, JSlider punteggio){
        
        String commentoQuery = commento.getText().replaceAll("'", "\\\\'");
        
        String inserisciValutazione = "INSERT INTO valutazioni VALUES ('"+Applicazione.appuntoAttuale.getNome()+"','"+Applicazione.guest.getEmail()+"'"
                + ",'"+commentoQuery+"','"+punteggio.getValue()+"', '"+facoltàQuery+"', '"+corsoQuery+"')";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(inserisciValutazione);
                ps1.execute();
                
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
       public static void inserisciLikeDomanda(){
        
          String studenteQuery = Applicazione.guest.getEmail().replaceAll("'", "\\\\'");
          String domandaQuery = Applicazione.domandaAttuale.getTitolo().replaceAll("'", "\\\\'");
          String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        
        String insertLikeDomanda = "INSERT INTO likeDomanda VALUES ('"+corsoQuery+"', '"+domandaQuery+"', '"+studenteQuery+"')";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(insertLikeDomanda);
                ps1.execute();
                
            }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
