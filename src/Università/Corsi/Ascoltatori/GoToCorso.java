/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class GoToCorso implements ActionListener{

    private String facoltà;

    public GoToCorso(String facoltà) {
        this.facoltà = facoltà;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.corsoAttuale.setNome(e.getActionCommand());
        
        InfoQuery.caricaInfoCorso(facoltà);
        
        Applicazione.facoltàAttuale.setNome(facoltà);
  
        CorsoPanel corso = new CorsoPanel();
        Grafica.container.add(corso, "corso");
        Grafica.card.show(Grafica.container, "corso");

        Applicazione.back.add("corso");
    }
    
}
