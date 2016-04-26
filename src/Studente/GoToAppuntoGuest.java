/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente;

import Appunti.AppuntoPanel;
import Controller.Applicazione;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAppuntoGuest implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    
    public GoToAppuntoGuest(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("appunto guest");
        
        for (int i = 0; i < Applicazione.appuntiGuest.size(); i++) {
            if (Applicazione.appuntiGuest.get(i).getNome().equals(e.getActionCommand())) {
                Applicazione.appuntoAttuale = Applicazione.appuntiGuest.get(i);
            }
 
        }
        
        AppuntoPanel appuntoGuest = new AppuntoPanel(card, container);
        container.add(appuntoGuest, "appunto guest");
        card.show(container, "appunto guest"); 

    }
}
