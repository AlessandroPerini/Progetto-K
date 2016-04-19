/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

import Controller.Applicazione;
import Panel.TopPanel;
import Università.Corsi.CaricaCorsi;
import Università.Corsi.GoToCorso;
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
 * @author Te4o
 */
public class ListaLibriPanel extends JPanel{
    
    private JButton[] libri = new JButton[Applicazione.ListaLibriAttuali.size()];

    public ListaLibriPanel(CardLayout card, JPanel container) {
    
        TopPanel top = new TopPanel(card, container, "Libri "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.ListaLibriAttuali.size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        GoToLibro goToLibro = new GoToLibro(card, container);
        
        for (int i = 0; i < Applicazione.ListaLibriAttuali.size(); i++) {
            libri[i] = new JButton();
            libri[i].setText(Applicazione.ListaLibriAttuali.get(i).getTitolo());
            libri[i].addActionListener(goToLibro);
            panel.add(libri[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    } 
}
