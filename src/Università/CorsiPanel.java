/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università;

import Panel.TopPanel;
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
 * @author te4o
 */
public class CorsiPanel extends JPanel{
    
    private JButton[] corsi = new JButton[CaricaCorsi.getCorsi().size()];

    public CorsiPanel(CardLayout card, JPanel container, ArrayList<String> corsiList) {
    
        TopPanel top = new TopPanel(card, container, "Corsi", false, true);
        
        JPanel panel = new JPanel(new GridLayout(CaricaCorsi.getCorsi().size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        for (int i = 0; i < CaricaCorsi.getCorsi().size(); i++) {
            corsi[i] = new JButton();
            corsi[i].setText(corsiList.get(i));
            panel.add(corsi[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
    
}
