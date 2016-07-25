/*
* Classe con le query di inserimento dati
*/
package Database;

import Application.Applicazione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class InsertQuery {
    
    private static Applicazione applicazione = Applicazione.getInstance();
    
    public static void inserisciLibro(String titolo, String descrizione, int prezzo, String telefono) throws SQLException{
        
        String insertLibro = "INSERT INTO libri VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertLibro);
        ps1.clearParameters();
        ps1.setInt(1, prossimoID("libri"));
        ps1.setString(2, titolo);
        ps1.setString(3, descrizione);
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        ps1.setString(5, applicazione.corsoAttuale.getNome());
        ps1.setString(6, applicazione.guest.getEmail());
        ps1.setString(7, telefono);
        ps1.setInt(8, prezzo);
        
        ps1.execute();
        
    }
    
    public static void inserisciAppunto(String nome, String descrizione) throws SQLException{
        
        String insertAppunto = " INSERT INTO appunti VALUES (?, ?, ?, ?, ?, 0);";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertAppunto);
        ps1.clearParameters();
        ps1.setString(1, nome);
        ps1.setString(2, descrizione);
        ps1.setString(3, applicazione.guest.getEmail());
        ps1.setString(4, applicazione.corsoAttuale.getNome());
        ps1.setString(5, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void inserisciDomanda(String titolo, String domanda) throws SQLException{
        
        String insertDomanda= "INSERT INTO domande VALUES (?, ?, ?, 0, ?, ?);";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertDomanda);
        ps1.clearParameters();
        ps1.setString(1, titolo);
        ps1.setString(2, domanda);
        ps1.setString(3, applicazione.guest.getEmail());
        ps1.setString(4, applicazione.corsoAttuale.getNome());
        ps1.setString(5, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();

    }
    
    public static void inserisciRisposta(String risposta) throws SQLException{

        String insertRisposta = "INSERT INTO risposte VALUES (?, ?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertRisposta);
        ps1.clearParameters();
        ps1.setString(1, applicazione.domandaAttuale.getTitolo());
        ps1.setString(2, applicazione.guest.getEmail());
        ps1.setInt(3, prossimoID("risposte"));
        ps1.setString(4, risposta);
        ps1.setString(5, applicazione.guest.getNickname());
        ps1.setString(6, applicazione.corsoAttuale.getNome());
        ps1.setString(7, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void inserisciValutazione(JTextArea commento, JSlider punteggio) throws SQLException{
        
        String inserisciValutazione = "INSERT INTO valutazioni VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(inserisciValutazione);
        ps1.clearParameters();
        ps1.setString(1, applicazione.appuntoAttuale.getNome());
        ps1.setString(2, applicazione.guest.getEmail());
        ps1.setString(3, applicazione.guest.getNickname());
        ps1.setString(4, commento.getText());
        ps1.setInt(5, punteggio.getValue());
        ps1.setString(6, applicazione.facoltàAttuale.getNome());
        ps1.setString(7, applicazione.corsoAttuale.getNome());
        
        ps1.execute();
  
    }
    
    public static void inserisciLikeDomanda() throws SQLException{
        
        String insertLikeDomanda = "INSERT INTO likeDomanda VALUES (?, ?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertLikeDomanda);
        ps1.clearParameters();
        ps1.setString(1, applicazione.corsoAttuale.getNome());
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.guest.getEmail());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void updateTelefono(String telefono) throws SQLException{
        
        String updateTelefono = "update studenti set telefono=? where email=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(updateTelefono);
        ps1.clearParameters();
        ps1.setString(1, telefono);
        ps1.setString(2, applicazione.guest.getEmail());
        
        ps1.execute();
        
    }
    
    public static void updateNickname(String nickname) throws SQLException{
        
        String updateNickname = "update studenti set nickname=? where email=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(updateNickname);
        ps1.clearParameters();
        ps1.setString(1, nickname);
        ps1.setString(2, applicazione.guest.getEmail());
        
        ps1.execute();
        
    }
    
    public static void updateMedia(float media) throws SQLException{
        
        String updateMediaAppunto = "update appunti set media=? where nome=? and corso=? and facoltà=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(updateMediaAppunto);
        ps1.clearParameters();
        ps1.setFloat(1, media);
        ps1.setString(2, applicazione.appuntoAttuale.getNome());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void updateLikeDomanda() throws SQLException{
        
        String updateLikeDomanda = "update `domande` set `like`=? where `titolo`=? and `corso`=? and `facoltà`=?";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(updateLikeDomanda);
        ps1.clearParameters();
        ps1.setInt(1, (applicazione.domandaAttuale.getLike()+1));
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.corsoAttuale.getNome());
        ps1.setString(4, applicazione.facoltàAttuale.getNome());

        ps1.execute();
        
    }
    
    public static void inserisciFacoltàPreferita() throws SQLException{
        
        String insertFacoltàPreferita = "INSERT INTO facoltàPreferite VALUES (?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertFacoltàPreferita);
        ps1.clearParameters();
        ps1.setString(1, applicazione.facoltàAttuale.getNome());
        ps1.setString(2, applicazione.facoltàAttuale.getRamo());
        ps1.setString(3, applicazione.guest.getEmail());
        
        ps1.execute();
  
    }
    
    public static void inserisciCorsoPreferito() throws SQLException{
        
        String insertCorsoPreferito = "INSERT INTO corsiPreferiti VALUES (?, ?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertCorsoPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setString(2, applicazione.corsoAttuale.getNome());
        ps1.setString(3, applicazione.facoltàAttuale.getNome());
        ps1.setInt(4, applicazione.corsoAttuale.getAnno());
        
        ps1.execute();
        
    }
    
    public static void inserisciAppuntoPreferito() throws SQLException{
        
        String insertAppuntoPreferito = "INSERT INTO appuntiPreferiti VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertAppuntoPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setString(2, applicazione.appuntoAttuale.getNome());
        ps1.setString(3, applicazione.appuntoAttuale.getDescrizione());
        ps1.setString(4, applicazione.appuntoAttuale.getStudente());
        ps1.setString(5, applicazione.corsoAttuale.getNome());
        ps1.setString(6, applicazione.facoltàAttuale.getNome());
        ps1.setFloat(7, applicazione.appuntoAttuale.getMedia());
        
        ps1.execute();
        
    }
    
    public static void inserisciLibroPreferito() throws SQLException{
        
        String insertLibroPreferito = "INSERT INTO libriPreferiti VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertLibroPreferito);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setInt(2, applicazione.libroAttuale.getID());
        ps1.setString(3, applicazione.libroAttuale.getTitolo());
        ps1.setString(4, applicazione.libroAttuale.getDescrizione());
        ps1.setString(5, applicazione.libroAttuale.getTelefono());
        ps1.setInt(6, applicazione.libroAttuale.getPrezzo());
        ps1.setString(7, applicazione.libroAttuale.getStudente());
        ps1.setString(8, applicazione.corsoAttuale.getNome());
        ps1.setString(9, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void inserisciDomandaPreferita() throws SQLException{
        
        String insertDomandaPreferita = "INSERT INTO domandePreferite VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(insertDomandaPreferita);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setString(2, applicazione.domandaAttuale.getTitolo());
        ps1.setString(3, applicazione.domandaAttuale.getDomanda());
        ps1.setInt(4, applicazione.domandaAttuale.getLike());
        ps1.setString(5, applicazione.domandaAttuale.getStudente());
        ps1.setString(6, applicazione.corsoAttuale.getNome());
        ps1.setString(7, applicazione.facoltàAttuale.getNome());
        
        ps1.execute();
        
    }
    
    public static void inserisciLikeRisposta(int id, int like) throws SQLException{
        
        String sql = "INSERT INTO likeRisposte VALUES (?, ?, ?)";

        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(sql);
        ps1.clearParameters();
        ps1.setString(1, applicazione.guest.getEmail());
        ps1.setInt(2, id);
        ps1.setInt(3, like);
        
        ps1.execute();
        
    }
    
    public static int prossimoID(String tabella) throws SQLException{
        
        String tabellaQuery = tabella.replaceAll("'", "\\\\'");
        
        int prossimoID = 0;
        
        String selectId = "select max(id) as massimo from "+tabellaQuery+"";
        
        PreparedStatement ps1 = applicazione.DBconnection.prepareStatement(selectId);
        
        ResultSet rs = ps1.executeQuery();
        
        if(rs.next()) {
            
            prossimoID = rs.getInt("massimo");
            
        }
        
        return prossimoID+1;
    }
   
}
