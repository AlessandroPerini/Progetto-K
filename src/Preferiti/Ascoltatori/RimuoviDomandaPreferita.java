/*
* Ascoltatore per la rimozione di una domanda preferita
*/
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import QeA.Vista.DomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class RimuoviDomandaPreferita implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private DomandaPanel domanda;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaDomandaPreferita();
            
            applicazione.preferiti.getDomandePreferite().remove(applicazione.domandaAttuale);
            
            domanda = new DomandaPanel();
            Grafica.container.add(domanda, "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione della domanda preferita", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
