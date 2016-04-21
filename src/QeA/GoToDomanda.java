/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Database.MySql.InfoQuery;
import Università.Corsi.CorsoPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author cl410688
 */
public class GoToDomanda  implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public GoToDomanda(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("domanda");
        Applicazione.domandaPremuta = e.getActionCommand();
        
        InfoQuery iQuery = new InfoQuery();
        iQuery.caricaInfoDomanda();
        
        DomandaPanel domanda = new DomandaPanel(card, container);
        container.add(domanda, "domanda");
        card.show(container, "domanda");

        
    }
    
}