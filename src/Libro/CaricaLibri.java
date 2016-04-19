/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import Controller.Applicazione;
import Università.Corsi.CaricaCorsi;
import Università.Corsi.ListaCorsiPanel;
import Database.Connection.ConnessioneDB;
import Database.Query.listeQuery;
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
    
    private Connection connection = new ConnessioneDB().connect();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String sql = "select * from libri where facoltà=? and corso=?";
  
        Applicazione.back.add("libri");
        Applicazione.back.add("corso");
        
        listeQuery dQuery = new listeQuery();
        dQuery.caricaLibri();

        ListaLibriPanel libri = new ListaLibriPanel(card, container, Applicazione.libriAttuali);
        container.add(libri, "libri");
        card.show(container, "libri");
 
    }

}
