/*
* Ascoltatore per la rimozione di un appunto preferito
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Grafica.Grafica;
import Grafica.AppuntoPanel;
import Database.DeleteQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class RimuoviAppuntoPreferito implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private AppuntoPanel appunto;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaAppuntoPreferito();
            
            applicazione.preferiti.getAppuntiPreferiti().remove(applicazione.appuntoAttuale);
            
            appunto = new AppuntoPanel();
            Grafica.container.add(appunto, "appunto");
            Grafica.card.show(Grafica.container, "appunto");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione dellappunto preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
