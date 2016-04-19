/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

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
 * @author cl410688
 */
public class LibroPanel extends JPanel{

    public LibroPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, Applicazione.libroPremuto);
        
        JPanel panel = new JPanel(new GridLayout(5,2,5,10));
        
        JLabel titolo= new JLabel("Titolo :");
        JLabel descrizione= new JLabel("Descrizione :");
        JLabel prezzo= new JLabel("Prezzo :");
        JLabel telefono= new JLabel("Telefono :");
        JLabel email= new JLabel("Email :");
        
        JTextArea titolo2= new JTextArea(Applicazione.libroAttuale.getTitolo(),2,10);
        JTextArea descrizione2= new JTextArea(Applicazione.libroAttuale.getDescrizione(),6,10);
        JLabel prezzo2= new JLabel(Integer.toString(Applicazione.libroAttuale.getPrezzo()));
        JLabel telefono2= new JLabel(Applicazione.libroAttuale.getTelefono());
        JLabel email2= new JLabel(Applicazione.libroAttuale.getEmail());
 
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        titolo2.setEditable(false);
        titolo2.setLineWrap(true);
        
        
        panel.add(titolo);
        panel.add(titolo2);
        panel.add(descrizione);
        panel.add(scrollPanel);
        panel.add(prezzo);
        panel.add(prezzo2);
        panel.add(telefono);
        panel.add(telefono2);
        panel.add(email);
        panel.add(email2);
        
        
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 410));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
}

    
}
    

