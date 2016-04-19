/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
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
 * @author Te4o
 */
public class ListaDomandePanel extends JPanel{
    
    private JButton[] domande = new JButton[Applicazione.ListaDomandeAttuali.size()];

    public ListaDomandePanel(CardLayout card, JPanel container) {
    
        TopPanel top = new TopPanel(card, container, "Domande "+Applicazione.libroPremuto);
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.ListaDomandeAttuali.size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        GoToDomanda goToDomanda = new GoToDomanda(card, container);
        
        for (int i = 0; i < Applicazione.ListaDomandeAttuali.size(); i++) {
            domande[i] = new JButton();
            domande[i].setText(Applicazione.ListaDomandeAttuali.get(i).getTitolo());
            domande[i].addActionListener(goToDomanda);
            panel.add(domande[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
