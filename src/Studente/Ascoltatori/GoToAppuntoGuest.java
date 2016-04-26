/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Appunti.Vista.AppuntoPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class GoToAppuntoGuest implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("appunto guest");
        
        for (int i = 0; i < Applicazione.appuntiGuest.size(); i++) {
            if (Applicazione.appuntiGuest.get(i).getNome().equals(e.getActionCommand())) {
                Applicazione.appuntoAttuale = Applicazione.appuntiGuest.get(i);
            }
 
        }
        
        AppuntoPanel appuntoGuest = new AppuntoPanel();
        Grafica.container.add(appuntoGuest, "appunto guest");
        Grafica.card.show(Grafica.container, "appunto guest"); 

    }
}
