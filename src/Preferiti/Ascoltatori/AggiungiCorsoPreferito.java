/*
* Ascoltatore per l'aggiunta di un corso preferito
*/
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class AggiungiCorsoPreferito implements ActionListener{
    
    private CorsoPanel corso;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciCorsoPreferito();
            
            Applicazione.preferiti.getCorsiPreferiti().add(Applicazione.corsoAttuale);
            
            corso = new CorsoPanel();
            Grafica.container.add(corso, "corso");
            Grafica.card.show(Grafica.container, "corso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
