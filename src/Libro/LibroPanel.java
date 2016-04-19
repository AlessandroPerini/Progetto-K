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
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author cl410688
 */
public class LibroPanel extends JPanel{

    public LibroPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, Applicazione.corsoCorrente);
      //  Libro libro = new Libro("titol","descr", 0, "3386243174", "porcino",1000);
        Libro libro;
       // libro= Applicazione.libroCorrente;
        
        JPanel panel = new JPanel(new GridLayout(5,2));
        
        JLabel titolo= new JLabel("Titolo libro");
        JLabel descrizione= new JLabel("Descrizione");
        JLabel prezzo= new JLabel("prezzo");
        JLabel telefono= new JLabel("Telefono");
        JLabel email= new JLabel("Email");
        
      //  JLabel titolo2= new JLabel(libro.getTitolo());
        JLabel descrizione2= new JLabel(libro.getDescrizione());
        JLabel prezzo2= new JLabel(""+libro.getPrezzo());
        JLabel telefono2= new JLabel(libro.getTelefono());
        JLabel email2= new JLabel(libro.getEmail());
        

        panel.add(titolo);
        panel.add(titolo2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(prezzo);
        panel.add(prezzo2);
        panel.add(telefono );
        panel.add(telefono2);
        panel.add(email);
        panel.add(email2);
        
        
        
        add(top);
        add(panel);
     
}

    
}
    

