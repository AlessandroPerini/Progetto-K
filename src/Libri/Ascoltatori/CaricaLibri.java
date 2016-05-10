/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Te4o
 */
public class CaricaLibri implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaLibri();
            
            Applicazione.back.add("libri");
            
            ListaLibriPanel libri = new ListaLibriPanel();
            Grafica.container.add(libri, "libri");
            Grafica.card.show(Grafica.container, "libri");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei libri");
        }
        
    }
    
}
