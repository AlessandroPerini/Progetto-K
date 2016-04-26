/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Database.MySql.ListeQuery;
import Libri.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class CaricaDomande implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public CaricaDomande(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("domande");
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaDomande();

        ListaDomandePanel domande = new ListaDomandePanel(card, container);
        
        container.add(domande, "domande");
        card.show(container, "domande");
 
    }
    
}
