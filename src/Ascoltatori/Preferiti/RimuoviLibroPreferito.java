/*
* Ascoltatore per la rimozione di un libro preferito
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Vista.Grafica;
import Database.DeleteQuery;
import Vista.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class RimuoviLibroPreferito implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private LibroPanel libro;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            DeleteQuery.eliminaLibroPreferito();
            
            applicazione.preferiti.getLibriPreferiti().remove(applicazione.libroAttuale);
            
            libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del libro preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
