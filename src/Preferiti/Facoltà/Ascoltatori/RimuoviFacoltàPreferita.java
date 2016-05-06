/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Database.Query.InsertQuery;
import Università.Corsi.Vista.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class RimuoviFacoltàPreferita implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaFacoltàPreferita();
        
        Applicazione.preferiti.getFacoltàPreferite().remove(Applicazione.facoltàAttuale);
        
        ListaCorsiPanel corsi = new ListaCorsiPanel();
        Grafica.container.add(corsi, "corsi");
        Grafica.card.show(Grafica.container, "corsi");
    }
}
