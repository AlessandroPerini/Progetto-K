
import Application.Controller.Applicazione;
import Database.Query.DeleteQuery;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import Libri.Libro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  Test d'unità del Caricamento libro.
 *  
 * 
 */
public class TestQuery {
    
    
    public static void main(String[] args) {
        
        boolean verificato=false;        
        Applicazione applicazione  = Applicazione.getInstance();
        applicazione.inizializzaUtente("adrian.procop01@universitadipavia.it", "alexcabrini5", "3123454245", "Adrian");
        applicazione.facoltàAttuale.setNome("Ingegneria dell'Informazione");
        applicazione.corsoAttuale.setNome("Fondamenti di Informatica I");
        String titolo="informatica";
        String descrizione="Dalla A alla Z passando per C";
        String numero="3123454245";
        try { 
            
            InsertQuery.inserisciLibro("informatica", "Dalla A alla Z passando per C", 20, "3123454245");
            ListeQuery.caricaLibri();
            
            for (Libro arg : applicazione.listaLibriAttuali) {
                
               
                if((arg.getTitolo().equals(titolo))&&(arg.getDescrizione().equals(descrizione))&&(arg.getTelefono().equals(numero)))
                verificato=true;
                applicazione.setLibroAttuale(arg);
                DeleteQuery.eliminaLibro();
                        
                }
        } catch (SQLException ex) {
            Logger.getLogger(TestQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(verificato) System.out.println("Test superato");
        else System.out.println("Test non superato");
    }
    
    
    
}
