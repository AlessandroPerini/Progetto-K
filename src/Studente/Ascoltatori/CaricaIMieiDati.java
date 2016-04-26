/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Studente.Vista.iMieiDatiPanel;
import Application.Controller.Applicazione;
import Database.Query.GuestQuery;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class CaricaIMieiDati implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public CaricaIMieiDati(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("i miei dati");
        
        GuestQuery gQuery = new GuestQuery();
        gQuery.caricaMieiAppunti();
        gQuery.caricaMieiLibri();
        gQuery.caricaMieDomande();

        iMieiDatiPanel mieiDatiPanel = new iMieiDatiPanel(card, container);
        container.add(mieiDatiPanel, "i miei dati");
        card.show(container, "i miei dati");
    }
    
}
