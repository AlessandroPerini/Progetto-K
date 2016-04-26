/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Vista;

import Appunti.Ascoltatori.CaricaAppunti;
import Application.Controller.Applicazione;
import Libri.Ascoltatori.CaricaLibri;
import Panel.TopPanel;
import QeA.Ascoltatori.CaricaDomande;
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
 * @author Te4o
 */
public class CorsoPanel extends JPanel{

    public CorsoPanel() {
        
        TopPanel top = new TopPanel(Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(4, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        CaricaLibri caricaLibri = new CaricaLibri();
        CaricaDomande caricaDomande = new CaricaDomande();
        CaricaAppunti caricaAppunti = new CaricaAppunti();
        
        JButton appunti = new JButton("Appunti");
        JButton libri = new JButton("Libri");
        JButton qea = new JButton("Q&A");
        
        libri.addActionListener(caricaLibri);
        qea.addActionListener(caricaDomande);
        appunti.addActionListener(caricaAppunti);
        
        panel.add(appunti);
        panel.add(libri);
        panel.add(qea);
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
     
}
