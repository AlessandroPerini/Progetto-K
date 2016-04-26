/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Vista;

import Università.Corsi.Ascoltatori.GoToCorso;
import Application.Controller.Applicazione;
import Panel.TopPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author te4o
 */
public class ListaCorsiPanel extends JPanel{
    
    private JButton[] corsi = new JButton[Applicazione.listaCorsiAttuali.size()];

    public ListaCorsiPanel() {
    
        TopPanel top = new TopPanel(Applicazione.facoltàPremuta);
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaCorsiAttuali.size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        GoToCorso goToCorso = new GoToCorso();
        
        for (int i = 0; i < Applicazione.listaCorsiAttuali.size(); i++) {
            corsi[i] = new JButton();
            corsi[i].setText(Applicazione.listaCorsiAttuali.get(i).getNome());
            corsi[i].addActionListener(goToCorso);
            panel.add(corsi[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }  
    
}
