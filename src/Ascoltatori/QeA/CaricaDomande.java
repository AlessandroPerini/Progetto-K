/*
* Ascoltatore dedicato al caricamento di tutte le domande relative
* al corso selezionato
*/
package Ascoltatori.QeA;

import Application.Applicazione;
import Grafica.Grafica;
import Database.ListeQuery;
import Grafica.ListaDomandePanel;
import utilityaaa.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class CaricaDomande implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private ListaDomandePanel domande;
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            ListeQuery.caricaDomande();

            applicazione.back.add("domande");
            
            Ordina.Domande();

            domande = new ListaDomandePanel();
            Grafica.container.add(domande, "domande");
            Grafica.card.show(Grafica.container, "domande");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle domande");

        }
        
    }
    
}
