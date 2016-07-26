
import Application.Controller.Applicazione;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import QeA.Domanda;
import Utils.Azioni.Cerca;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 * Dato che non è possibile inserire una domanda con lo stesso titolo nello stesso corso e facolta,
 * per eseguire nuovamente il test sarà necessario non ricaricare le domande, oppure eliminare quelle precedenti
 * 
 */
public class TestCercaDomanda {
    
    
    public static void main(String[] args) {

        int oltre = (int) System.currentTimeMillis();
        String domanda1 = "Prova 1 "+oltre;
        String domanda2 = "Test 2 "+oltre;
        String domanda3 = "Provola 3 "+oltre;
        
        try {
            Applicazione applicazione = Applicazione.getInstance();
            
            applicazione.inizializzaUtente("adrian.procop01@universitadipavia.it", "alexcabrini5", "3123454245", "Adrian");
            applicazione.facoltàAttuale.setNome("Ingegneria dell'Informazione");
            applicazione.corsoAttuale.setNome("Fondamenti di Informatica I");
            
            InsertQuery.inserisciDomanda(domanda1, "Descrizione 1");
            InsertQuery.inserisciDomanda(domanda2, "Descrizione 2");
            InsertQuery.inserisciDomanda(domanda3, "Descrizione 3");           
                  
            ListeQuery.caricaDomande();

            Cerca.Domande(new JTextField("Te"));

            for(Domanda d: applicazione.listaDomandeAttuali){
                System.out.println(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TestCercaDomanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
