/*
* Ascoltatore per la rimozione di un libro preferito
*/
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Libri.Vista.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class RimuoviLibroPreferito implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaLibroPreferito();
            
            Applicazione.preferiti.getLibriPreferiti().remove(Applicazione.libroAttuale);
            
            LibroPanel libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del libro preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
