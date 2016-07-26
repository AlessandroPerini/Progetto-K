
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Database.Query.DeleteQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
* Ascoltatore per la rimozione di un appunto preferito
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
