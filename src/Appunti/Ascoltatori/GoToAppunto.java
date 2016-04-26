/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Appunti.Vista.AppuntoPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Libri.Vista.LibroPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class GoToAppunto implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("appunto");
        
        Applicazione.appuntoAttuale.setNome(e.getActionCommand());

        InfoQuery iQuery = new InfoQuery();
        iQuery.caricaInfoAppunto();
        
        AppuntoPanel appunto = new AppuntoPanel();
        Grafica.container.add(appunto, "appunto");
        Grafica.card.show(Grafica.container, "appunto");

    }
    
}
