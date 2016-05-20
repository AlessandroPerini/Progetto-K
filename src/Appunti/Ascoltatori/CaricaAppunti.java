/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaAppunti();
            
            Applicazione.back.add("appunti");

            Ordina.Appunti();
            
            ListaAppuntiPanel appunti = new ListaAppuntiPanel();
            Grafica.container.add(appunti, "appunti");
            Grafica.card.show(Grafica.container, "appunti");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento degli appunti");
        }
        
    }
}
