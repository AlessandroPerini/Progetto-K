
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import QeA.Vista.DomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
* Ascoltatore per l'aggiunta di una domanda preferita
*/
public class AggiungiDomandaPreferita implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private DomandaPanel domanda;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciDomandaPreferita();

            applicazione.preferiti.getDomandePreferite().add(applicazione.domandaAttuale);
            
            domanda = new DomandaPanel();
            Grafica.container.add(domanda, "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
