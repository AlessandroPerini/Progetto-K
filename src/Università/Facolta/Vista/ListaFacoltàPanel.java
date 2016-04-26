/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import Panel.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Facoltà;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author te4o
 */
public class ListaFacoltàPanel extends JPanel{

    private JButton[] facoltà = new JButton[Applicazione.listaFacoltàAttuali.size()];

    public ListaFacoltàPanel(ArrayList<Facoltà> facoltàList) {
    
        TopPanel top = new TopPanel("Facoltà");
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaFacoltàAttuali.size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        panel.add(searchPanel);

        for (int i = 0; i < Applicazione.listaFacoltàAttuali.size(); i++) {
            facoltà[i] = new JButton();
            facoltà[i].setText(facoltàList.get(i).getNome());
            facoltà[i].addActionListener(caricaCorsi);
            panel.add(facoltà[i]);
        }

        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
    

