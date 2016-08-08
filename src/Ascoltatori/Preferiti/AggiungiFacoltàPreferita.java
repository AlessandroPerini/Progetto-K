/*
* Ascoltatore per l'aggiunta di una facoltà preferita
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Grafica.Grafica;
import Database.InsertQuery;
import Grafica.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class AggiungiFacoltàPreferita implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private ListaCorsiPanel corsi;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciFacoltàPreferita();

            applicazione.preferiti.getFacoltàPreferite().add(applicazione.facoltàAttuale);
            
            corsi = new ListaCorsiPanel();
            Grafica.container.add(corsi, "corsi");
            Grafica.card.show(Grafica.container, "corsi");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
