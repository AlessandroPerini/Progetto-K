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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiLibroPanel extends JPanel{
    
    private static JTextArea titolo2 = new JTextArea();
    private static JTextArea descrizione2 = new JTextArea();
    private static JTextArea prezzo2 = new JTextArea();
    
    public AggiungiLibroPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, "Aggiungi Libro in "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(6,2,5,10));
        
        JLabel titolo = new JLabel("Titolo :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel prezzo = new JLabel("Prezzo :");
        JLabel telefono = new JLabel("Telefono :");
        JLabel email = new JLabel("Email :");
        
        titolo2 = new JTextArea("");
        descrizione2 = new JTextArea("");
        prezzo2 = new JTextArea("");
        JLabel email2 = new JLabel(Applicazione.guest.getEmail());
        JLabel telefono2 = new JLabel(Applicazione.guest.getTelefono());
 
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        titolo2.setLineWrap(true);
        
        JButton aggiungi = new JButton("Aggiungi");
        AggiungiLibro aggiungiLibro = new AggiungiLibro(card, container, titolo2, descrizione2, prezzo2);
        aggiungi.addActionListener(aggiungiLibro);
        
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
        
        panel.add(aggiungi);
        
        
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 410));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
    }
    
    public static void clearForm(){
    
        titolo2.setText("");
        descrizione2.setText("");
        prezzo2.setText("");
    }
}
