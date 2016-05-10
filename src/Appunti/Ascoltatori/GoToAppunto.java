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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class GoToAppunto implements ActionListener{

    private String corso;
    private String facoltà;

    public GoToAppunto(String corso, String facoltà) {
        this.corso = corso;
        this.facoltà = facoltà;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("appunto");
        
        Applicazione.appuntoAttuale.setNome(e.getActionCommand());

        InfoQuery.caricaInfoAppunto(corso, facoltà);
        
        Applicazione.corsoAttuale.setNome(corso);
        
        Applicazione.facoltàAttuale.setNome(facoltà);
        
        AppuntoPanel appunto = new AppuntoPanel();
        Grafica.container.add(appunto, "appunto");
        Grafica.card.show(Grafica.container, "appunto");

    }
    
}
