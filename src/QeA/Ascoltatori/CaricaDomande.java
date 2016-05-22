/*
* Ascoltatore dedicato al caricamento di tutte le domande relative
* al corso selezionato
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import QeA.Vista.ListaDomandePanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class CaricaDomande implements ActionListener{
    
    private ListaDomandePanel domande;
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            ListeQuery.caricaDomande();

            Applicazione.back.add("domande");
            
            Ordina.Domande();
            
            domande = new ListaDomandePanel();
            Grafica.container.add(domande, "domande");
            Grafica.card.show(Grafica.container, "domande");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle domande");

        }
        
    }
    
}
