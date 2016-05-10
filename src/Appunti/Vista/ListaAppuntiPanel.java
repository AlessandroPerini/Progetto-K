/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Appunti.Ascoltatori.GoToAppunto;
import Appunti.Ascoltatori.GoToAggiungiAppunto;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.CercaAppunti;
import Header.Vista.TopPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class ListaAppuntiPanel extends JPanel{
    
    private JButton[] appunti = new JButton[Applicazione.listaAppuntiAttuali.size()];
    private JTextField searchField;
    private JLabel noAppunti;

    public ListaAppuntiPanel() {
    
        TopPanel top = new TopPanel("Appunti "+Applicazione.corsoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaAppuntiAttuali.size()+3, 1));
        
        //pannello ricerca
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton searchButton = new JButton("Search");
        
        CercaAppunti cercaAppunti = new CercaAppunti(searchField);
        searchField.addKeyListener(cercaAppunti);
        searchButton.addActionListener(cercaAppunti);

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
        
        JButton addAppunto = new JButton("Aggiungi Appunto");
        GoToAggiungiAppunto aggiungiAppunto = new GoToAggiungiAppunto();
        addAppunto.addActionListener(aggiungiAppunto);
        
        panel.add(addAppunto);

        GoToAppunto goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        int size = Applicazione.listaAppuntiAttuali.size();
        if(size == 0){
            noAppunti = new JLabel("Non ci sono appunti relativi a questo corso.");
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(noAppunti);
        
        }else{
            for (int i = 0; i < Applicazione.listaAppuntiAttuali.size(); i++) {
            appunti[i] = new JButton();
            appunti[i].setText(Applicazione.listaAppuntiAttuali.get(i).getNome());
            appunti[i].addActionListener(goToAppunto);
            panel.add(appunti[i]);
        }
        }
       
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
