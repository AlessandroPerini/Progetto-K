
import Application.Applicazione;
import Database.DeleteQuery;
import Database.InsertQuery;
import Database.ListeQuery;
import Entità.Libro;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;




/**
 *  Test di unità del caricamento Libro.
 *  Il test prevede un caricamento di Libro nel database, un successivo prelievo dal database dei libri 
 *  della facoltà e del corso attuali, ed infine la ricerca all'interno della lista, del libro inserito in precedenza
 * 
 *  @author aless
 */
public class TestCaricamentoLibro {
    
    @Test
    public void hello() {
    
        try {
            // Riempio i conponendi di Applicazioni che le query utilizzeranno
            Applicazione applicazione  = Applicazione.getInstance();
            applicazione.inizializzaUtente("adrian.procop01@universitadipavia.it", "alexcabrini5", "3123454245", "Adrian");
            applicazione.facoltàAttuale.setNome("Ingegneria dell'Informazione");
            applicazione.corsoAttuale.setNome("Fondamenti di Informatica I");
            
            String titolo = "Informatica";
            String descrizione = "Dalla A alla Z passando per C";
            String numero = "3123454245";
            
            // Inserisce il libro nel database
            InsertQuery.inserisciLibro(titolo, descrizione, 20, numero);
            
            // Preleva tutti i libri della facoltàAttuale e del corsoAttuale e li inserisce in listaLibriAttuali
            ListeQuery.caricaLibri();
            
            // Scandisce la lista di libriAttuali e ricerca quello inserito in precedenza
            for (Libro arg : applicazione.listaLibriAttuali) {
                
                assertEquals(arg.getTitolo(), titolo);
                assertEquals(arg.getDescrizione(), descrizione);
                assertEquals(arg.getTelefono(), numero);
                
                // Elimina libro per pulire il database
                applicazione.setLibroAttuale(arg);
                DeleteQuery.eliminaLibro();
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestCaricamentoLibro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
