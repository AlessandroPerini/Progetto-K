/*
* Classe con le queri di caricamento dei dati una determinata entità (Facoltà, Corso, Appunto, ...)
*/
package Database;

import Application.Applicazione;
import Entità.Appunto;
import Entità.Libro;
import Entità.Domanda;
import Entità.Corso;
import Entità.Facoltà;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author te4o
 */
public class InfoQuery {
    
    private static Applicazione applicazione = Applicazione.getInstance();
    
    public static void caricaInfoFacoltà() throws SQLException{
        
        String selectInfoFacoltà = "select * from facoltà where nome=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectInfoFacoltà);
        ps1.clearParameters();
        ps1.setString(1, applicazione.facoltàAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nome = rs.getString("nome");
            String ramo = rs.getString("ramo");
            
            applicazione.facoltàAttuale = new Facoltà(nome, ramo);
            
        }
    }
    
    public static void caricaInfoCorso(String facoltà) throws SQLException{
        
        String selectInfoCorso = "select * from corsi where nome=? and facoltà=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectInfoCorso);
        ps1.clearParameters();
        ps1.setString(1, applicazione.corsoAttuale.getNome());
        ps1.setString(2, facoltà);
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nome= rs.getString("nome");
            String fac = rs.getString("facoltà");
            int anno = rs.getInt("anno");
            
            applicazione.corsoAttuale = new Corso(nome, anno, fac);
            
        }
    }
    
    public static void caricaInfoLibro(String corso, String facoltà, int id) throws SQLException{
        
        String selectInfoLibro = "select * from libri where facoltà=? and corso=? and id=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectInfoLibro);
        ps1.clearParameters();
        ps1.setString(1, facoltà);
        ps1.setString(2, corso);
        ps1.setInt(3, id);
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nomeLibro = rs.getString("titolo");
            String descrizioneLibro = rs.getString("descrizione");
            int idLibro = rs.getInt("id");
            String emailLibro = rs.getString("studente");
            String telefonoLibro = rs.getString("telefono");
            int prezzoLibro = rs.getInt("prezzo");
            String cor = rs.getString("corso");
            String fac = rs.getString("facoltà");
            
            applicazione.libroAttuale = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro,  prezzoLibro, cor, fac);
            
        }
    }
    
    public static void caricaInfoDomanda(String corso, String facoltà) throws SQLException{
        
        String selectInfoDomanda = "select * from domande where facoltà=? and corso=? and titolo=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectInfoDomanda);
        ps1.clearParameters();
        ps1.setString(1, facoltà);
        ps1.setString(2, corso);
        ps1.setString(3,applicazione.domandaAttuale.getTitolo());
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String titoloDomanda = rs.getString("titolo");
            String testoDomanda = rs.getString("domanda");
            String studenteDomanda = rs.getString("studente");
            int likeDomanda = rs.getInt("like");
            String cor = rs.getString("corso");
            String fac = rs.getString("facoltà");
            
            applicazione.domandaAttuale = new Domanda(titoloDomanda, testoDomanda, studenteDomanda, likeDomanda, cor, fac);
            
        }
    }
    
    public static void caricaInfoAppunto(String corso, String facoltà) throws SQLException{
        
        String selectInfoDomanda = "select * from appunti where facoltà=? and corso=? and nome=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectInfoDomanda);
        ps1.clearParameters();
        ps1.setString(1, facoltà);
        ps1.setString(2, corso);
        ps1.setString(3,applicazione.appuntoAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            String nomeAppunto = rs.getString("nome");
            String descrizioneAppunto = rs.getString("descrizione");
            String emailAppunto = rs.getString("studente");
            String cor = rs.getString("corso");
            String fac = rs.getString("facoltà");
            float media = rs.getFloat("media");
            
            applicazione.appuntoAttuale = new Appunto(nomeAppunto, descrizioneAppunto, emailAppunto, cor, fac, media);
            
        }
    }
    
    public static float mediaAppunto() throws SQLException{
        
        float media = 0;
        
        String selectMediaAppunto = "SELECT avg(punteggio) as media FROM valutazioni where facoltà=? and corso=? and appunto=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectMediaAppunto);
        ps1.clearParameters();
        ps1.setString(1, applicazione.facoltàAttuale.getNome());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3,applicazione.appuntoAttuale.getNome());
        
        ResultSet rs = ps1.executeQuery();
        
        if(rs.next()){
            
            media = rs.getFloat("media");
            
        }
        return media;
        
    }
    
    public static int likeDomanda() throws SQLException{
        
        int like = 0;
        
        String selectLikeDomanda = "SELECT * FROM likeDomanda where facoltà=? and corso=? and domanda=?";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, applicazione.facoltàAttuale.getNome());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3,applicazione.domandaAttuale.getTitolo());
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            
            like++;
            
        }
        return like;
    }
    
    public static int likeRisposta(int id, int valore) throws SQLException {
        int like = 0;
        int dislike = 0;
        
        String selectLikeRisposta = "SELECT * FROM likeRisposte where id=? ";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectLikeRisposta);
        ps1.clearParameters();
        ps1.setInt(1, id);
        
        ResultSet rs = ps1.executeQuery();
        
        while(rs.next()){
            if(rs.getInt("like") == 1){
                like++;
            }else{
                dislike++;
            }
        }
        
        if(valore == 1){
            return like;
        }else{
            return dislike;
        }
        
    }
    
    
}
