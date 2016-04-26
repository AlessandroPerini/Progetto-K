/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Corsi.Vista.ListaCorsiPanel;
import Database.Connection.ConnessioneDB;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("libri");
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaLibri();

        ListaLibriPanel libri = new ListaLibriPanel();
        Grafica.container.add(libri, "libri");
        Grafica.card.show(Grafica.container, "libri");
 
    }

}
