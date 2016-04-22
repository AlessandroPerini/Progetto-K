/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Panel.TopPanel;
import QeA.AggiungiDomanda;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
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
public class AggiungiDomandaPanel extends JPanel{
    
    private static JTextArea titolo2 = new JTextArea();
    private static JTextArea descrizione2 = new JTextArea();
   
    JPanel pp = new JPanel();
    
    public AggiungiDomandaPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, "Aggiungi Domanda in "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(4,2,5,10));
       
        
        JLabel titolo = new JLabel("Titolo :");
        JLabel descrizione = new JLabel("Descrizione :");
         
        JLabel telefono = new JLabel("Telefono :");
        JLabel email = new JLabel("Email :");
        
        titolo2 = new JTextArea("");
        descrizione2 = new JTextArea("");
 
        JLabel email2 = new JLabel(Applicazione.guest.getEmail());
        JLabel telefono2 = new JLabel(Applicazione.guest.getTelefono());
 
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        titolo2.setLineWrap(true);
        
       
        JButton aggiungi = new JButton("Aggiungi");
        AggiungiDomanda aggiungiDomanda = new AggiungiDomanda(card, container, titolo2, descrizione2);
        aggiungi.addActionListener(aggiungiDomanda);
        
      //  prezzoPanel.add(euro);
        
        panel.add(titolo);
        panel.add(titolo2);
        panel.add(descrizione);
        panel.add(scrollPanel);
      
        panel.add(email);
        panel.add(email2);
        
        panel.add(aggiungi);
        panel.add(pp);
        
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 410));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
    }
    
    public static void clearForm(){
    
        titolo2.setText("");
        descrizione2.setText("");
       // prezzo2.setValue(0);
    }
}
