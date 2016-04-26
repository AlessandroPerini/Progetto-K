/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Università.Corsi.Vista.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class CaricaCorsi implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        Applicazione.back.add("corsi");
        Applicazione.facoltàPremuta = e.getActionCommand();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaCorsi();

        ListaCorsiPanel corsi = new ListaCorsiPanel();
        Grafica.container.add(corsi, "corsi");
        Grafica.card.show(Grafica.container, "corsi");
 
    }

}
