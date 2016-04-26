/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
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
 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("domanda guest");
        
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            if (Applicazione.domandeGuest.get(i).getTitolo().equals(e.getActionCommand())) {
                Applicazione.domandaAttuale = Applicazione.domandeGuest.get(i);
            }
 
        }
        
        DomandaPanel domandaGuest = new DomandaPanel();
        Grafica.container.add(domandaGuest, "domanda guest");
        Grafica.card.show(Grafica.container, "domanda guest"); 

    }
}
