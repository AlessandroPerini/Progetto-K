/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import Università.Corsi.Vista.CorsoPanel;
import Università.Corsi.Vista.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class AggiungiCorsoPreferito implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        InsertQuery.inserisciCorsoPreferito();
        
        Applicazione.preferiti.getCorsiPreferiti().add(Applicazione.corsoAttuale);
        
        CorsoPanel corso = new CorsoPanel();
        Grafica.container.add(corso, "corso");
        Grafica.card.show(Grafica.container, "corso");
    }
}
