/*
* Ascoltatore per la rimozione di un corso preferito
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Grafica.Grafica;
import Database.DeleteQuery;
import Grafica.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class RimuoviCorsoPreferito implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private CorsoPanel corso;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaCorsoPreferito();
            
            applicazione.preferiti.getCorsiPreferiti().remove(applicazione.corsoAttuale);
            
            corso = new CorsoPanel();
            Grafica.container.add(corso, "corso");
            Grafica.card.show(Grafica.container, "corso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del corso preferito ", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
