/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università;

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
    private static ArrayList<String> corsiList = new ArrayList<>();
    
    @Override
    public void actionPerformed(ActionEvent e) {

        String sql = "select nome from corsi where facoltà=?";
    try{
            DatiTemporanei.back.add("facoltà");
            
            PreparedStatement ps1 = connection.prepareStatement(sql);
            ps1.setString(1, e.getActionCommand());

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){

                String corso = rs.getString("nome");
                corsiList.add(corso);
                
    }
            CorsiPanel corsi = new CorsiPanel(card, container, corsiList);
            container.add(corsi,"corsi");
            card.show(container, "corsi");
            
            DatiTemporanei.back.add("corsi");

    }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    public static ArrayList<String> getCorsi() {
        return corsiList;
    }

    public static void svuotaCorsi(){
    
        corsiList.clear();
    }
    
}
