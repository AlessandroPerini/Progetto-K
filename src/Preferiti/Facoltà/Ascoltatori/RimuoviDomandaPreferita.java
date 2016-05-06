/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Libri.Vista.LibroPanel;
import QeA.Vista.DomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class RimuoviDomandaPreferita implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaDomandaPreferita();
        
        Applicazione.preferiti.getDomandePreferite().remove(Applicazione.domandaAttuale);
        
        DomandaPanel domanda = new DomandaPanel();
        Grafica.container.add(domanda, "domanda");
        Grafica.card.show(Grafica.container, "domanda");
    }
}
