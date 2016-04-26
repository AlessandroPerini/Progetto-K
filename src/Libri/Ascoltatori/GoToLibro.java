/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Libri.Vista.LibroPanel;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class GoToLibro implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("libro");
        Applicazione.libroAttuale.setTitolo(e.getActionCommand());

        InfoQuery iQuery = new InfoQuery();
        iQuery.caricaInfoLibro();
        
        LibroPanel libro = new LibroPanel();
        Grafica.container.add(libro, "libro");
        Grafica.card.show(Grafica.container, "libro"); 

    }
    
}
