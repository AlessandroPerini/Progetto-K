/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import Università.Corsi.CaricaCorsi;
import Università.Corsi.ListaCorsiPanel;
import Utils.ConnessioneDB;
import Utils.DatiTemporanei;
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
    private static ArrayList<String> libriList = new ArrayList<>();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String sql = "select * from libri where facoltà=? and corso=?";
    try{
            DatiTemporanei.back.add("corso");
            
            PreparedStatement ps1 = connection.prepareStatement(sql);
            ps1.setString(1, DatiTemporanei.facoltàCorrente);
            ps1.setString(2, DatiTemporanei.corsoCorrente);

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){

                String libro = rs.getString("titolo");
                libriList.add(libro);
                
    }
            ListaLibriPanel libri = new ListaLibriPanel(card, container, libriList);
            container.add(libri, "libri");
            card.show(container, "libri");
            
            DatiTemporanei.back.add("libri");

    }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public static ArrayList<String> getLibri() {
        return libriList;
    }

    public static void svuotaLibri(){
    
        libriList.clear();
    }
}
