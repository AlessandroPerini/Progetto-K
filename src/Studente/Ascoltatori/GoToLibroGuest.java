/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Application.Controller.Applicazione;
import Database.Query.InfoQuery;
import Libri.Vista.LibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToLibroGuest implements ActionListener{
   
    private CardLayout card;
    private JPanel container;
    
    public GoToLibroGuest(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("libro guest");
        
        for (int i = 0; i < Applicazione.libriGuest.size(); i++) {
            if (Applicazione.libriGuest.get(i).getTitolo().equals(e.getActionCommand())) {
                Applicazione.libroAttuale = Applicazione.libriGuest.get(i);
            }
 
        }
        
        LibroPanel libroGuest = new LibroPanel(card, container);
        container.add(libroGuest, "libro guest");
        card.show(container, "libro guest"); 

    }
    
}
