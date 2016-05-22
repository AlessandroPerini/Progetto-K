/*
* Ascoltatore dedicato al caricamento di tutti gli appunti relativi 
* al corso selezionato
*/
package Appunti.Ascoltatori;

import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class CaricaAppunti implements ActionListener{
    
    private ListaAppuntiPanel appunti;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaAppunti();
            
            Applicazione.back.add("appunti");

            Ordina.Appunti();
            
            appunti = new ListaAppuntiPanel();
            Grafica.container.add(appunti, "appunti");
            Grafica.card.show(Grafica.container, "appunti");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento degli appunti");
        }
        
    }
}
