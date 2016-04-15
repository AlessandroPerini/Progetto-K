/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta;

import Università.Corsi.CaricaCorsi;
import Università.Facolta.ListaFacoltàPanel;
import Utils.CheckLogin;
import Utils.ConnessioneDB;
import Utils.DatiTemporanei;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class CaricaFacoltà implements ActionListener, KeyListener{
    
    private CardLayout card;
    private JPanel container;
    
    public CaricaFacoltà(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    private Connection connection = new ConnessioneDB().connect();
    private static ArrayList<String> facoltàList = new ArrayList<>();

    public void carica(){
    
        String sql = "select nome from facoltà";
        if(CheckLogin.isChecked()){
            try{
                PreparedStatement ps1 = connection.prepareStatement(sql);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String facoltà = rs.getString("nome");
                    facoltàList.add(facoltà);

                }
                DatiTemporanei.back.add("facoltà");
                
                ListaFacoltàPanel facoltà = new ListaFacoltàPanel(card, container, facoltàList);
                
                container.add(facoltà,"facoltà");
                card.show(container, "facoltà");

            }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        carica();    
    }

    public static ArrayList<String> getFacoltàList() {
        return facoltàList;
    }

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            carica();
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
 
    public static void svuotaFacoltà(){
    
        facoltàList.clear();
    }
}
