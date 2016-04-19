/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Database.Query.infoQuery;
import Libri.LibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class GoToAppunto implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToAppunto(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("appunto");
        Applicazione.appuntoPremuto = e.getActionCommand();

        infoQuery iQuery = new infoQuery();
        iQuery.caricaInfoAppunto();
        
        AppuntoPanel appunto = new AppuntoPanel(card, container);
        container.add(appunto, "appunto");
        card.show(container, "appunto");

    }
    
}
