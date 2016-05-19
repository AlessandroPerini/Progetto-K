/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.RecensioniAppuntoPanel;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class GoToRecensioniAppuntoPanel implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaRecensioniAppunto();
            
            Applicazione.back.add("recensioni");
            
            RecensioniAppuntoPanel recensioni = new RecensioniAppuntoPanel();
            Grafica.container.add(recensioni, "recensioni");
            Grafica.card.show(Grafica.container, "recensioni");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle recensioni");
        }
        
    }
    
}
