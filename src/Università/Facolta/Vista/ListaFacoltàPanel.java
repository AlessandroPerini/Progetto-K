/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Panel.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Ascoltatori.CercaFacoltà;
import Università.Facolta.Facoltà;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JTextField searchField;

    public ListaFacoltàPanel() {
    
        TopPanel top = new TopPanel("Facoltà");
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaFacoltàAttuali.size()+1, 1));
        
        //pannello ricerca
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(30);;
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton searchButton = new JButton("Search");
        
        CercaFacoltà cercaFacoltà = new CercaFacoltà(searchField);
        searchField.addKeyListener(cercaFacoltà);
        searchButton.addActionListener(cercaFacoltà);

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
        
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        for (int i = 0; i < Applicazione.listaFacoltàAttuali.size(); i++) {
            facoltà[i] = new JButton();
            facoltà[i].setText(Applicazione.listaFacoltàAttuali.get(i).getNome());
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
    

