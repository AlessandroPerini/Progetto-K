/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.AggiungiLibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAggiungiLibro implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiLibro");

        AggiungiLibroPanel aggiungiLibroPanel = new AggiungiLibroPanel();
        Grafica.container.add(aggiungiLibroPanel, "aggiungiLibro");
        Grafica.card.show(Grafica.container, "aggiungiLibro");
    }
    
}
