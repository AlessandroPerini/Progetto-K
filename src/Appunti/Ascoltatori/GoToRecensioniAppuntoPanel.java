/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Appunti.Vista.RecensioniAppuntoPanel;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class GoToRecensioniAppuntoPanel implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("recensioni");

        ListeQuery.caricaRecensioniAppunto();
        
        RecensioniAppuntoPanel recensioni = new RecensioniAppuntoPanel();
        Grafica.container.add(recensioni, "recensioni");
        Grafica.card.show(Grafica.container, "recensioni");
    }
    
}
