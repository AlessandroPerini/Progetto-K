/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

import Controller.Applicazione;
import Database.Query.ListeQuery;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAggiungiLibro implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToAggiungiLibro(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiLibro");

        AggiungiLibroPanel aggiungiLibroPanel = new AggiungiLibroPanel(card, container);
        container.add(aggiungiLibroPanel, "aggiungiLibro");
        card.show(container, "aggiungiLibro");
    }
    
}
