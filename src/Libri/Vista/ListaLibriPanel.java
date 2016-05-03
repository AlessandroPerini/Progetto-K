/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Vista;

import Libri.Ascoltatori.GoToLibro;
import Libri.Ascoltatori.GoToAggiungiLibro;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.CercaAppunti;
import Header.TopPanel;
import Libri.Ascoltatori.CercaLibri;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Corsi.Ascoltatori.GoToCorso;
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
 * @author Te4o
 */
public class ListaLibriPanel extends JPanel{
    
    private JButton[] libri = new JButton[Applicazione.listaLibriAttuali.size()];
    private JTextField searchField;

    public ListaLibriPanel() {
    
        TopPanel top = new TopPanel("Libri "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaLibriAttuali.size()+2, 1));
        
        //pannello ricerca
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton searchButton = new JButton("Search");
        
        CercaLibri cercaLibri = new CercaLibri(searchField);
        searchField.addKeyListener(cercaLibri);
        searchButton.addActionListener(cercaLibri);

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
        
        JButton addLibro = new JButton("Aggiungi Libro");
        GoToAggiungiLibro aggiungiLibro = new GoToAggiungiLibro();
        addLibro.addActionListener(aggiungiLibro);
        
        panel.add(addLibro);
        
        GoToLibro goToLibro = new GoToLibro();
        
        for (int i = 0; i < Applicazione.listaLibriAttuali.size(); i++) {
            libri[i] = new JButton();
            libri[i].setText(Applicazione.listaLibriAttuali.get(i).getTitolo());
            libri[i].addActionListener(goToLibro);
            panel.add(libri[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    } 
}
