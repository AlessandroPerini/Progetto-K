/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Application.Controller.Applicazione;
import QeA.Vista.DomandaPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToDomandaGuest implements ActionListener{
 
    private CardLayout card;
    private JPanel container;
    
    public GoToDomandaGuest(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("domanda guest");
        
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            if (Applicazione.domandeGuest.get(i).getTitolo().equals(e.getActionCommand())) {
                Applicazione.domandaAttuale = Applicazione.domandeGuest.get(i);
            }
 
        }
        
        DomandaPanel domandaGuest = new DomandaPanel(card, container);
        container.add(domandaGuest, "domanda guest");
        card.show(container, "domanda guest"); 

    }
}
