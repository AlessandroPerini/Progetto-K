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

/**
 *
 * @author Te4o
 */
public class CaricaLibri implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("libri");
        
        ListeQuery.caricaLibri();

        ListaLibriPanel libri = new ListaLibriPanel();
        Grafica.container.add(libri, "libri");
        Grafica.card.show(Grafica.container, "libri");
 
    }

}
