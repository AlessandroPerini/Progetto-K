/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Studente.Vista.iMieiDatiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.GuestQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class CaricaIMieiDati implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("i miei dati");
        
        GuestQuery gQuery = new GuestQuery();
        gQuery.caricaMieiAppunti();
        gQuery.caricaMieiLibri();
        gQuery.caricaMieDomande();

        iMieiDatiPanel mieiDatiPanel = new iMieiDatiPanel();
        Grafica.container.add(mieiDatiPanel, "i miei dati");
        Grafica.card.show(Grafica.container, "i miei dati");
    }
    
}
