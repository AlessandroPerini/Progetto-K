/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studenti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class Back implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        Applicazione.back.remove(Applicazione.back.size()-1);
        Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
    }
}
