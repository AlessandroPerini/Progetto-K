/*
* Ascoltatore per l'aggiunta di un libro preferito
*/
package Ascoltatori.Preferiti;

import Application.Applicazione;
import Grafica.Grafica;
import Database.InsertQuery;
import Grafica.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class AggiungiLibroPreferito implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private LibroPanel libro;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            InsertQuery.inserisciLibroPreferito();

            applicazione.preferiti.getLibriPreferiti().add(applicazione.libroAttuale);
            
            libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del preferito", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
