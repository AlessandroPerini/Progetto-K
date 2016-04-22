/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Libri.AggiungiLibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAggiungiAppunto implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToAggiungiAppunto(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiAppunto");

        AggiungiAppuntoPanel aggiungiAppuntoPanel = new AggiungiAppuntoPanel(card, container);
        container.add(aggiungiAppuntoPanel, "aggiungiAppunto");
        card.show(container, "aggiungiAppunto");
    }
    
}
