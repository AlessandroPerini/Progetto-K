/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Universita.Corsi.Vista.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class RimuoviCorsoPreferito implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaCorsoPreferito();
            
            
            Applicazione.preferiti.getCorsiPreferiti().remove(Applicazione.corsoAttuale);
            
            CorsoPanel corso = new CorsoPanel();
            Grafica.container.add(corso, "corso");
            Grafica.card.show(Grafica.container, "corso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del corso preferito ", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
