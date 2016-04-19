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
        
        JPanel panel = new JPanel(new GridLayout(5,2,10,10));
        
        JLabel titolo = new JLabel("Titolo :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel prezzo = new JLabel("Prezzo :");
        JLabel telefono = new JLabel("Telefono :");
        JLabel email = new JLabel("Email :");
        
        JTextArea titolo2 = new JTextArea(Applicazione.libroAttuale.getTitolo());
        JTextArea descrizione2 = new JTextArea(Applicazione.libroAttuale.getDescrizione());
        JTextArea prezzo2 = new JTextArea(Integer.toString(Applicazione.libroAttuale.getPrezzo()));
        JTextArea telefono2 = new JTextArea(Applicazione.libroAttuale.getTelefono());
        JTextArea email2 = new JTextArea(Applicazione.libroAttuale.getEmail());
        
        titolo2.setPreferredSize(new Dimension(150, 100));
        descrizione2.setPreferredSize(new Dimension(150, 100));
        prezzo2.setPreferredSize(new Dimension(150, 100));
        telefono2.setPreferredSize(new Dimension(150, 100));
        email2.setPreferredSize(new Dimension(150, 100));
        
        panel.add(titolo);
        panel.add(titolo2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(prezzo);
        panel.add(prezzo2);
        panel.add(telefono);
        panel.add(telefono2);
        panel.add(email);
        panel.add(email2);
  
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
     
}

    
}
    

