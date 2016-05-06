/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Appunti.Vista.ListaAppuntiPanel;
import Database.Query.DeleteQuery;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class RimuoviAppuntoPreferito implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaAppuntoPreferito();
        
        Applicazione.preferiti.getAppuntiPreferiti().remove(Applicazione.appuntoAttuale);
        
        AppuntoPanel appunto = new AppuntoPanel();
        Grafica.container.add(appunto, "appunto");
        Grafica.card.show(Grafica.container, "appunto");
    }
}
