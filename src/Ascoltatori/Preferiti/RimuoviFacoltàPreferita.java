/*
* Ascoltatore per la rimozione di una facoltà preferita
*/
package Ascoltatori.Preferiti;


import Application.Applicazione;
import Vista.Grafica;
import Database.DeleteQuery;
import Vista.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class RimuoviFacoltàPreferita implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private ListaCorsiPanel corsi;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaFacoltàPreferita();
            
            applicazione.preferiti.getFacoltàPreferite().remove(applicazione.facoltàAttuale);
            
            corsi = new ListaCorsiPanel();
            Grafica.container.add(corsi, "corsi");
            Grafica.card.show(Grafica.container, "corsi");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione della facoltà preferita", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
