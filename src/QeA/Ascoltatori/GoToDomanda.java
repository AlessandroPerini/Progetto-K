/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import QeA.Vista.DomandaPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author adrian
 */
public class GoToDomanda implements MouseListener{ 
    
    private static DomandaPanel domanda;
    private String text;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        Applicazione.back.add("domanda");
        
        if(e.getComponent() instanceof JLabel) {
            JLabel label = (JLabel)e.getComponent();
            text = label.getText();
        }
        
        if(e.getComponent() instanceof JButton) {
           JButton button = (JButton)e.getComponent();
           text = button.getText();
        }
      
        Applicazione.domandaAttuale.setTitolo(text);
        
        InfoQuery.caricaInfoDomanda();
        
        ListeQuery.caricaRisposteDomanda();
        
        domanda = new DomandaPanel();
        
        Grafica.container.add(domanda, "domanda");
        Grafica.card.show(Grafica.container, "domanda");
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
