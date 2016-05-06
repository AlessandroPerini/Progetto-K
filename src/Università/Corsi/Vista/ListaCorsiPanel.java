/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Vista;

import Università.Corsi.Ascoltatori.GoToCorso;
import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Header.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiFacoltàPreferita;
import Preferiti.Facoltà.Ascoltatori.RimuoviFacoltàPreferita;
import Università.Corsi.Ascoltatori.CercaCorsi;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
    private JTextField searchField;
    
    public ListaCorsiPanel() {
    
        TopPanel top = new TopPanel(Applicazione.facoltàAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaCorsiAttuali.size()+2, 1));
        
        //pannello ricerca
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton searchButton = new JButton("Search");
        
        CercaCorsi cercaCorsi = new CercaCorsi(searchField);
        searchField.addKeyListener(cercaCorsi);
        searchButton.addActionListener(cercaCorsi);

        JButton clearSearch = new JButton("x");
        clearSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(clearSearch);
        searchPanel.add(searchButton);
        // fine pannello ricerca
        
        panel.add(searchPanel);
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon("files\\immagini\\preferitiOn.png"));
        JButton preferitiOff = new JButton(new ImageIcon("files\\immagini\\preferitiOff.png"));
        
        AggiungiFacoltàPreferita aggiungiFacoltàPreferita = new AggiungiFacoltàPreferita();
        preferitiOff.addActionListener(aggiungiFacoltàPreferita);
        
        RimuoviFacoltàPreferita rimuoviFacoltàPreferita = new RimuoviFacoltàPreferita();
        preferitiOn.addActionListener(rimuoviFacoltàPreferita);
        
        if (ControlloQuery.controlloFacoltàPreferita()) {
            panel.add(preferitiOff);
        }
        else {
            panel.add(preferitiOn);
        }
        //fine zona preferito
        
        GoToCorso goToCorso = new GoToCorso();
        
        for (int i = 0; i < Applicazione.listaCorsiAttuali.size(); i++) {
            corsi[i] = new JButton();
            corsi[i].setText(Applicazione.listaCorsiAttuali.get(i).getNome());
            corsi[i].addActionListener(goToCorso);
            panel.add(corsi[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }  
    
}
