/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università;

import Panel.TopPanel;
import Utils.DatiTemporanei;
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
public class FacoltàPanel extends JPanel{

    private JButton[] facoltà = new JButton[CaricaFacoltà.getFacoltàList().size()];

    public FacoltàPanel(CardLayout card, JPanel container, ArrayList<String> facoltàList) {
    
        TopPanel top = new TopPanel(card, container, "Facoltà", true, false);
        
        JPanel panel = new JPanel(new GridLayout(CaricaFacoltà.getFacoltàList().size()+1, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        CaricaCorsi caricaCorsi = new CaricaCorsi(card, container);
        
        panel.add(searchPanel);

        for (int i = 0; i < CaricaFacoltà.getFacoltàList().size(); i++) {
            facoltà[i] = new JButton();
            facoltà[i].setText(facoltàList.get(i));
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
    

