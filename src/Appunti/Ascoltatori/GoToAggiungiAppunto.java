/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Appunti.Vista.AggiungiAppuntoPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Libri.Vista.AggiungiLibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAggiungiAppunto implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiAppunto");

        AggiungiAppuntoPanel aggiungiAppuntoPanel = new AggiungiAppuntoPanel();
        Grafica.container.add(aggiungiAppuntoPanel, "aggiungiAppunto");
        Grafica.card.show(Grafica.container, "aggiungiAppunto");
    }
    
}
