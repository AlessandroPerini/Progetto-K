/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import static Application.Controller.Applicazione.svuotaListaFacoltàXRamo;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Panel.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Ascoltatori.CercaFacoltà;
import Università.Facolta.Facoltà;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

/**
 *
 * @author te4o
 */
public class ListaFacoltàPanel extends JPanel{

    private JLabel[] facoltà = new JLabel[Applicazione.listaFacoltàAttuali.size()];
    private JPanel[] pannelli = new JPanel[Applicazione.ramiFacoltà.size()];
    private JScrollPane[] scrollP = new JScrollPane[Applicazione.ramiFacoltà.size()];
   
   private TitledBorder[] titoloBordo = new TitledBorder[Applicazione.ramiFacoltà.size()];
    private JTextField searchField;
    private JPanel panel,searchPanel;
    private TopPanel top;
    private JButton searchButton, clearSearch;
    private CercaFacoltà cercaFacoltà;
    public ListaFacoltàPanel() {
    
        top = new TopPanel("Facoltà");
        
        panel = new JPanel(new GridLayout(5,2));
        
        //pannello ricerca
        searchPanel = new JPanel();
        searchField = new JTextField(30);;
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        searchButton = new JButton("Search");
        
        cercaFacoltà = new CercaFacoltà(searchField);
        searchField.addKeyListener(cercaFacoltà);
        searchButton.addActionListener(cercaFacoltà);

        clearSearch = new JButton("x");
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
        
     
        ListeQuery lq = new ListeQuery();
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
         for (int i = 0; i < Applicazione.ramiFacoltà.size(); i++) {
             
            lq.caricaFacoltà(Applicazione.ramiFacoltà.get(i));
            pannelli[i] = new JPanel(new GridLayout(Applicazione.listaFacoltàXRamo.size()+1, 1));
            scrollP[i] = new JScrollPane();
            titoloBordo[i] = new TitledBorder(Applicazione.ramiFacoltà.get(i));
            titoloBordo[i].setTitleFont(new Font("Arial", Font.BOLD, 15));
            titoloBordo[i].setTitleColor(Color.RED);
            pannelli[i].setBorder(titoloBordo[i]);
            
            for (int j = 0; j < Applicazione.listaFacoltàXRamo.size(); j++) {
                facoltà[j] = new JLabel();
                facoltà[j].setText(Applicazione.listaFacoltàXRamo.get(j));

                facoltà[j].setName("facoltà"+j);
                facoltà[j].addMouseListener(caricaCorsi);
                pannelli[i].add(facoltà[j]);
        }
            scrollP[i]= new JScrollPane(pannelli[i],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollP[i].setPreferredSize(new Dimension(30, 210));
            scrollP[i].getVerticalScrollBar().setUnitIncrement(5);
            panel.add(scrollP[i]);
            svuotaListaFacoltàXRamo();
         }

        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(searchPanel);
        add(scrollPanel);
    }
    
}
    

