/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

import Controller.Applicazione;
import Università.Corsi.CaricaCorsi;
import Università.Corsi.ListaCorsiPanel;
import Database.Connection.ConnessioneDB;
import Database.MySql.ListeQuery;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class CaricaLibri implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    
    public CaricaLibri(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("libri");
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaLibri();

        ListaLibriPanel libri = new ListaLibriPanel(card, container);
        container.add(libri, "libri");
        card.show(container, "libri");
 
    }

}
