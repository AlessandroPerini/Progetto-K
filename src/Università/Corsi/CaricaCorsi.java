/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi;

import Controller.Applicazione;
import Database.Connection.ConnessioneDB;
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

        Applicazione.facoltàCorrente = e.getActionCommand();
        
        String sql = "select * from corsi where facoltà=?";
    try{
            Applicazione.back.add("facoltà");
            
            PreparedStatement ps1 = connection.prepareStatement(sql);
            ps1.setString(1, e.getActionCommand());

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){

                String nomeCorso = rs.getString("nome");
                int annoCorso = rs.getInt("anno");
                Corso corso = new Corso(nomeCorso, annoCorso);
                Applicazione.corsiAttuali.add(corso);
                
    }
            Applicazione.back.add("corsi");
            
            ListaCorsiPanel corsi = new ListaCorsiPanel(card, container, Applicazione.corsiAttuali);
            container.add(corsi, "corsi");
            card.show(container, "corsi");


    }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

}
