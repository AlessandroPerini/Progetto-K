
import Application.Controller.Applicazione;
import Database.Query.DeleteQuery;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import QeA.Domanda;
import Utils.Azioni.Cerca;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test di controllo della ricerca di una domanda.
 * Vengono inserite nel database alcune domande.
 * In seguito viene eseguita la query di ricerca e si effettua il controllo dei dati
 * 
 * @author aless
 */

public class TestCercaDomanda {
    
    @Test
    public void hello() {
        
        try {
            /* Poichè il primo parametro della query inserisciDomanda è chiave primaria nella tabella domande del database,
            *  il prarametro verrà costruito concatenando alla stringa base il currentTimeMillis, per evitare ripetizioni.
            */
            int oltre = (int) System.currentTimeMillis();
            ArrayList<String> domande = new ArrayList<>();
            String stringa_da_trovare = "Prova"+oltre;
            
            domande.add(stringa_da_trovare);
            domande.add("Test" + oltre);
            domande.add("Tentativo" + oltre);
            
            int numero_match_trovati = 0;
            int numero_match_effettivi = 1; // Poichè cercando stringa_da_trovare avrò un solo match
            
            // Riempio i conponendi di Applicazioni che le query utilizzeranno
            Applicazione applicazione = Applicazione.getInstance();
            applicazione.inizializzaUtente("adrian.procop01@universitadipavia.it", "alexcabrini5", "3123454245", "Adrian");
            applicazione.facoltàAttuale.setNome("Ingegneria dell'Informazione");
            applicazione.corsoAttuale.setNome("Analisi I");
            
            InsertQuery.inserisciDomanda(domande.get(0), "Descrizione 0");                    
            InsertQuery.inserisciDomanda(domande.get(1), "Descrizione 1");
            InsertQuery.inserisciDomanda(domande.get(2), "Descrizione 2");
            
            // Carica in listaDomandeAttuali le domande relative alla facoltà e al corso attuale.
            ListeQuery.caricaDomande();
            Cerca.Domande(new JTextField(stringa_da_trovare));
            
            for(Domanda domanda: applicazione.listaDomandeAttuali){
                numero_match_trovati ++;
            }
            
            // Eliminazione domande inserite per il test
            for (int i = 0; i < domande.size() ; i++) {
                applicazione.listaDomandeAttuali.clear();
                ListeQuery.caricaDomande();
                Cerca.Domande(new JTextField(domande.get(i)));
                applicazione.setDomandaAttuale(applicazione.listaDomandeAttuali.get(0));
                DeleteQuery.eliminaDomanda();
            }
            
            assertEquals(numero_match_effettivi, numero_match_trovati);
            
        } catch (SQLException ex) {
            Logger.getLogger(TestCercaDomanda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}