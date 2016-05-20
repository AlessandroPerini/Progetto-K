/*
* Ascoltatore dedicato all'apertura del pannello delle recensioni
* Quindi carica le recensioni relative all'appunto selezionato
* eseguendo una query e le mostra in un pannello aposito.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.RecensioniAppuntoPanel;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class GoToRecensioniAppuntoPanel implements ActionListener{
    
    private RecensioniAppuntoPanel recensioni;
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaRecensioniAppunto();
            
            Applicazione.back.add("recensioni");
            
            recensioni = new RecensioniAppuntoPanel();
            Grafica.container.add(recensioni, "recensioni");
            Grafica.card.show(Grafica.container, "recensioni");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle recensioni");
        }
        
    }
    
}
