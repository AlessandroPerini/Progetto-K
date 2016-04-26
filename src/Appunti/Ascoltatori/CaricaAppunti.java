/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class CaricaAppunti implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("appunti");
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaAppunti();

        ListaAppuntiPanel appunti = new ListaAppuntiPanel();
        Grafica.container.add(appunti, "appunti");
        Grafica.card.show(Grafica.container, "appunti");
 
    }
}
