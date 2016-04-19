/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

import Controller.Applicazione;
import Panel.TopPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author cl410688
 */
public class LibroPanel extends JPanel{

    public LibroPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, Applicazione.corsoCorrente);
        
        JPanel panel = new JPanel(new GridLayout(5,2,5,10));
        
        JLabel titolo= new JLabel("Titolo :");
        JLabel descrizione= new JLabel("Descrizione :");
        JLabel prezzo= new JLabel("Prezzo :");
        JLabel telefono= new JLabel("Telefono :");
        JLabel email= new JLabel("Email :");
        
        JTextArea titolo2= new JTextArea(Applicazione.libroAttuale.getTitolo());
        JTextArea descrizione2= new JTextArea(Applicazione.libroAttuale.getDescrizione());
        JTextArea prezzo2= new JTextArea(Integer.toString(Applicazione.libroAttuale.getPrezzo()));
        JTextArea telefono2= new JTextArea(Applicazione.libroAttuale.getTelefono());
        JTextArea email2= new JTextArea(Applicazione.libroAttuale.getEmail());
        
        titolo2.setPreferredSize(new Dimension(200, 150));
        descrizione2.setPreferredSize(new Dimension(200, 150));
        prezzo2.setPreferredSize(new Dimension(200, 150));
        telefono2.setPreferredSize(new Dimension(200, 150));
        email2.setPreferredSize(new Dimension(200, 150));
        
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
  
        add(top);
        add(panel);
     
}

    
}
    

