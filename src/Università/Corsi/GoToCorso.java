/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi;

import Utils.DatiTemporanei;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class GoToCorso implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToCorso(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DatiTemporanei.corsoCorrente = e.getActionCommand();
  
        CorsoPanel corso = new CorsoPanel(card, container);
        container.add(corso, "corso");
        card.show(container, "corso");

        DatiTemporanei.back.add("corso");
    }
    
}
