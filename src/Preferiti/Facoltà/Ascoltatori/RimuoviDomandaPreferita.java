/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Preferiti.Facoltà.Ascoltatori;

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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaDomandaPreferita();
            
            Applicazione.preferiti.getDomandePreferite().remove(Applicazione.domandaAttuale);
            
            DomandaPanel domanda = new DomandaPanel();
            Grafica.container.add(domanda, "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione della domanda preferita", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
