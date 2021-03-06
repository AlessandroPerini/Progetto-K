/*
* Ascoltatore dedicato al caricamento di tutti gli appunti relativi 
* al corso selezionato
*/
package Ascoltatori.Appunti;
import Application.Applicazione;
import Grafica.ListaAppuntiPanel;
import Grafica.Grafica;
import Database.ListeQuery;
import Utility.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class CaricaAppunti implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();

    private ListaAppuntiPanel appunti;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaAppunti();
            
            applicazione.back.add("appunti");

            Ordina.Appunti();
            
            appunti = new ListaAppuntiPanel();
            Grafica.container.add(appunti, "appunti");
            Grafica.card.show(Grafica.container, "appunti");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento degli appunti");
        }
        
    }
}
