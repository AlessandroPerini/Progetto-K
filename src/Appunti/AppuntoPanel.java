/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Panel.TopPanel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
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
        
        TopPanel top = new TopPanel(card, container, Applicazione.appuntoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(6,2,10,10));
        
        JLabel email = new JLabel("Email :");
        JLabel nome = new JLabel("Nome :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel media = new JLabel("Media :");
        
        JLabel email2 = new JLabel(Applicazione.appuntoAttuale.getStudente());
        JLabel nome2 = new JLabel(Applicazione.appuntoAttuale.getNome());
        JTextArea descrizione2 = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        JLabel media2 = new JLabel(Float.toString(Applicazione.appuntoAttuale.getMedia()));
        
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        panel.add(nome);
        panel.add(nome2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(media);
        panel.add(media2);
        panel.add(email);
        panel.add(email2);
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            EliminaAppunto eliminaAppunto = new EliminaAppunto(card, container);
            JButton elimina = new JButton("Elimina");
            elimina.setBackground(new Color(249,123,123));
            elimina.addActionListener(eliminaAppunto);
            panel.add(elimina);
        }
 
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 410));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
}
}
