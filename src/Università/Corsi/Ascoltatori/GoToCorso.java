/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class GoToCorso implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.corsoPremuto = e.getActionCommand();
  
        CorsoPanel corso = new CorsoPanel();
        Grafica.container.add(corso, "corso");
        Grafica.card.show(Grafica.container, "corso");

        Applicazione.back.add("corso");
    }
    
}
