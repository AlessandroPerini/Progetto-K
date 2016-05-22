/*
* Ascoltatore per l'aggiunta di un appunto preferito
*/
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Database.Query.InsertQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class AggiungiAppuntoPreferito implements ActionListener{
    
    private AppuntoPanel appunto;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciAppuntoPreferito();
 
            Applicazione.preferiti.getAppuntiPreferiti().add(Applicazione.appuntoAttuale);
            
            appunto = new AppuntoPanel();
            Grafica.container.add(appunto, "appunto");
            Grafica.card.show(Grafica.container, "appunto");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
