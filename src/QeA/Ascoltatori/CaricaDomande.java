/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import QeA.Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Te4o
 */
public class CaricaDomande implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("domande");
        
        try {
            ListeQuery.caricaDomande();

            ListaDomandePanel domande = new ListaDomandePanel();
            
            Grafica.container.add(domande, "domande");
            Grafica.card.show(Grafica.container, "domande");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle domande");

        }
        
    }
    
}
