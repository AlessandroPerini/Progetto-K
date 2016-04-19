/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import Controller.Applicazione;
import Università.Corsi.CorsoPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class GoToLibro implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToLibro(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        LibroPanel libro = new LibroPanel(card, container);
        container.add(libro, "libro");
        card.show(container, "libro");

        Applicazione.back.add("libro");

    }
    
}
