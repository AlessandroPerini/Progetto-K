/*
* Ascoltatore dedicato all'apertura del pannello delle recensioni
* Quindi carica le recensioni relative all'appunto selezionato
* eseguendo una query e le mostra in un pannello apposito.
*/
package Ascoltatori.Appunti;

import Application.Applicazione;
import Vista.Grafica;
import Vista.RecensioniAppuntoPanel;
import Database.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class GoToRecensioniAppuntoPanel implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private RecensioniAppuntoPanel recensioni;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaRecensioniAppunto();
            
            applicazione.back.add("recensioni");
            
            recensioni = new RecensioniAppuntoPanel();
            Grafica.container.add(recensioni, "recensioni");
            Grafica.card.show(Grafica.container, "recensioni");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle recensioni");
        }
        
    }
    
}
