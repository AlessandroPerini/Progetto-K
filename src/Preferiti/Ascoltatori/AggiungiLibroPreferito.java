/*
* Ascoltatore per l'aggiunta di un libro preferito
*/
package Preferiti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import Libri.Vista.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class AggiungiLibroPreferito implements ActionListener{
    
    private LibroPanel libro;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciLibroPreferito();

            Applicazione.preferiti.getLibriPreferiti().add(Applicazione.libroAttuale);
            
            libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
