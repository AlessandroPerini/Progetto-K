/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Panel.TopPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
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
public class ListaDomandePanel extends JPanel{
    
    //private JButton[] domande = new JButton[Applicazione.ListaDomandeAttuali.size()];
    private JLabel[] domande = new JLabel[Applicazione.ListaDomandeAttuali.size()];
    private JButton addDomanda, searchButton;
    private JTextField searchField;
    public ListaDomandePanel(CardLayout card, JPanel container) {
    
        TopPanel top = new TopPanel(card, container, "Domande ");
        
        JPanel panel = new JPanel(new GridBagLayout());
        JPanel centro = new JPanel(new BorderLayout());
        
        GridBagConstraints gbcImg = new GridBagConstraints();
        
            JPanel searchPanel = new JPanel();
            searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);
            addDomanda = new JButton("Aggiungi\n Domanda");
          
            centro.add(searchPanel, BorderLayout.NORTH);
            
            gbcImg.gridx = 0;
            gbcImg.gridy = 0;
            gbcImg.insets = new Insets(10, 0, 0, 10);
            gbcImg.anchor = GridBagConstraints.LINE_START;
            panel.add(addDomanda, gbcImg);
        
        GoToDomanda goToDomanda = new GoToDomanda(card, container);
        GoToAggiungiDomanda goToAggiungiDomanda = new GoToAggiungiDomanda(card, container);
        
        addDomanda.addActionListener(goToAggiungiDomanda);
                
        
        for (int i = 0; i < Applicazione.ListaDomandeAttuali.size(); i++) {
            domande[i] = new JLabel();
            domande[i].setText(Applicazione.ListaDomandeAttuali.get(i).getTitolo());
            domande[i].setName("domande"+i);
            domande[i].addMouseListener(goToDomanda);
            gbcImg.gridx = 0;
            gbcImg.gridy = i+1;
            gbcImg.insets = new Insets(10, 0, 0, 10);
            gbcImg.anchor = GridBagConstraints.LINE_START;
            panel.add(domande[i], gbcImg);
        }
        centro.add(panel, BorderLayout.CENTER);
        JScrollPane scrollPanel = new JScrollPane(centro,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
