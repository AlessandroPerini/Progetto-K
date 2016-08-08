/*
* Ascoltatore per l'aggiunta di un corso preferito
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Grafica.Grafica;
import Database.InsertQuery;
import Grafica.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class AggiungiCorsoPreferito implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private CorsoPanel corso;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciCorsoPreferito();
            
            applicazione.preferiti.getCorsiPreferiti().add(applicazione.corsoAttuale);
            
            corso = new CorsoPanel();
            Grafica.container.add(corso, "corso");
            Grafica.card.show(Grafica.container, "corso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
