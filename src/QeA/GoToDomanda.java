/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Database.MySql.InfoQuery;
import Database.MySql.ListeQuery;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author adrian
 */
public class GoToDomanda implements MouseListener{
    private CardLayout card;
    private JPanel container;   
    private static DomandaPanel domanda;
    String text;
    
    public GoToDomanda(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        
        Applicazione.back.add("domanda");
        
        if(e.getComponent() instanceof JLabel) {
            JLabel label = (JLabel)e.getComponent();
            text = label.getText();
        }
        Applicazione.domandaPremuta = text;
        
        InfoQuery iQuery = new InfoQuery();
        iQuery.caricaInfoDomanda();
        
        ListeQuery lQuery = new ListeQuery();
        lQuery.caricaRisposteDomanda();
        
        domanda = new DomandaPanel(card, container);
        for(int i = 0;i < Applicazione.risposteAttuali.size();i++){
            domanda.risposte2.append(Applicazione.risposteAttuali.get(i));
        }
        
        container.add(domanda, "domanda");
        card.show(container, "domanda");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      e.getComponent().setForeground(Color.red);
    }

    @Override
    public void mouseExited(MouseEvent e) {
      e.getComponent().setForeground(Color.black);
    }

    public static DomandaPanel getDomanda() {
        return domanda;
    }
    
    
}
