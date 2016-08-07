/*
* Ascoltatore dedicato al caricamento di tutti i dati riguardanti l'utente:
* appunti inseriti, libri in vendita, domande poste
*/
package Ascoltatori.Studenti;

import Application.Applicazione;
import Vista.iMieiDatiPanel;
import Vista.Grafica;
import Database.GuestQuery;
import utility.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class CaricaIMieiDati implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private iMieiDatiPanel mieiDatiPanel;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            
            GuestQuery.caricaTuttiMieiDati();
            
            applicazione.back.add("i miei dati");
            
            Ordina.ListeMieiDati();
            
            mieiDatiPanel = new iMieiDatiPanel();
            Grafica.container.add(mieiDatiPanel, "i miei dati");
            Grafica.card.show(Grafica.container, "i miei dati");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
