/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Appunti.Ascoltatori.AggiungiAppunto;
import Application.Controller.Applicazione;
import Libri.Ascoltatori.AggiungiLibro;
import Header.TopPanel;
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
public class AggiungiAppuntoPanel extends JPanel{
    
    private static JTextArea nome2 = new JTextArea();
    private static JTextArea descrizione2 = new JTextArea();
    
    public AggiungiAppuntoPanel() {
        
        TopPanel top = new TopPanel("Aggiungi Appunto in "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(5,2,5,10));
        
        JLabel nome = new JLabel("Nome :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel email = new JLabel("Email :");
        
        nome2 = new JTextArea("");
        descrizione2 = new JTextArea("");
        JLabel email2 = new JLabel(Applicazione.guest.getEmail());
 
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        nome2.setLineWrap(true);
        
        JButton aggiungi = new JButton("Aggiungi");
        AggiungiAppunto aggiungiAppunto = new AggiungiAppunto(nome2, descrizione2);
        aggiungi.addActionListener(aggiungiAppunto);
        
        panel.add(nome);
        panel.add(nome2);
        panel.add(descrizione);
        panel.add(scrollPanel);
        panel.add(email);
        panel.add(email2);
        
        panel.add(aggiungi);

        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 450));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
    }
    
    public static void clearForm(){
    
        nome2.setText("");
        descrizione2.setText("");
    }
}
