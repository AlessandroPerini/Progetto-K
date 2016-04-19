/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Panel.TopPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class AppuntoPanel extends JPanel{
    
    public AppuntoPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, Applicazione.appuntoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        
        JLabel email = new JLabel("Email :");
        JLabel nome = new JLabel("Nome :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel media = new JLabel("Media :");
        
        JTextArea email2 = new JTextArea(Applicazione.appuntoAttuale.getStudente());
        JTextArea nome2 = new JTextArea(Applicazione.appuntoAttuale.getNome());
        JTextArea descrizione2 = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        JTextArea media2 = new JTextArea(Float.toString(Applicazione.appuntoAttuale.getMedia()));

        nome2.setPreferredSize(new Dimension(150, 100));
        descrizione2.setPreferredSize(new Dimension(150, 100));
        media2.setPreferredSize(new Dimension(150, 100));
        email2.setPreferredSize(new Dimension(150, 100));
        
        panel.add(email);
        panel.add(email2);
        panel.add(nome);
        panel.add(nome2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(media);
        panel.add(media2);
        panel.add(email);
        panel.add(email2);
  
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
     
}
}
