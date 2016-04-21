/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi;

import Controller.Applicazione;
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
 * @author te4o
 */
public class CaricaCorsi implements ActionListener{

    private CardLayout card;
    private JPanel container;
    
    public CaricaCorsi(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    private Connection connection = new ConnessioneDB().connect();
    
    @Override
    public void actionPerformed(ActionEvent e) {

        Applicazione.back.add("corsi");
        Applicazione.facoltàPremuta = e.getActionCommand();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaCorsi();

        ListaCorsiPanel corsi = new ListaCorsiPanel(card, container);
        container.add(corsi, "corsi");
        card.show(container, "corsi");
 
    }

}
