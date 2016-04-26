/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Libri.Vista.AggiungiLibroPanel;
import QeA.Vista.AggiungiDomandaPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author danie
 */
public class GoToAggiungiDomanda implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToAggiungiDomanda(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiDomanda");

        AggiungiDomandaPanel aggiungiDomandaPanel = new AggiungiDomandaPanel(card, container);
        container.add(aggiungiDomandaPanel, "aggiungiDomanda");
        card.show(container, "aggiungiDomanda");
    }
    
}
