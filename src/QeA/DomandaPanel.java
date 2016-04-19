/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Panel.TopPanel;
import Università.Corsi.CaricaCorsi;
import Università.Facolta.CaricaFacoltà;
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
 * @author cl410688
 */
public class DomandaPanel 
    extends JPanel{

  // private JButton[] domandone = new JButton[Applicazione.domande.size()];
    private JButton[] domandone = new JButton[2];
   
    public DomandaPanel(CardLayout card, JPanel container) {
        
        ArrayList<Domanda> domande = new ArrayList<>();
        
        domande.add(new Domanda("quanto pesa un kg di piume?", 0,"0",""));
        domande.add(new Domanda("quanto è forte alex?", 0,"0",""));
        
        //domande =  Applicazione.domande;
        
        
        TopPanel top = new TopPanel(card, container, "Domande");
        
        JPanel panel = new JPanel(new GridLayout(domande.size()+1, 1));
        
        JPanel searchPanel = new JPanel();
        
        
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        
        panel.add(searchPanel);
        
        GoToDomanda go = new GoToDomanda(card, container);

        for (int i = 0; i < domande.size(); i++) {
            domandone[i] = new JButton();
            domandone[i].setText(domande.get(i).getDomanda());
           domandone[i].addActionListener(go);
            panel.add(domandone[i]);
        }

        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
    



