/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Vista;

import Libri.Ascoltatori.AggiungiLibro;
import Application.Controller.Applicazione;
import Header.TopPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author te4o
 */
public class AggiungiLibroPanel extends JPanel{
    
    private static JTextArea titolo2 = new JTextArea();
    private static JTextArea descrizione2 = new JTextArea();
    private static JSpinner prezzo2 = new JSpinner();
    
    public AggiungiLibroPanel() {
        
        TopPanel top = new TopPanel("Aggiungi Libro in "+Applicazione.corsoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(7,2,5,10));
        
        JPanel prezzoPanel = new JPanel(new GridLayout(1, 2));
        
        JLabel titolo = new JLabel("Titolo :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel prezzo = new JLabel("Prezzo :");
        JLabel telefono = new JLabel("Telefono :");
        JLabel email = new JLabel("Email :");
        
        SpinnerNumberModel prezzoModel = new SpinnerNumberModel(0, 0, 999, 1);  
        
        titolo2 = new JTextArea("");
        descrizione2 = new JTextArea("");
        prezzo2 = new JSpinner(prezzoModel);
        JLabel email2 = new JLabel(Applicazione.guest.getEmail());
        JCheckBox telefono2 = new JCheckBox("Vuoi far vedere il tuo numero?");
         
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        titolo2.setLineWrap(true);
        
        JLabel euro = new JLabel("€");
        euro.setFont(new Font("Arial", Font.PLAIN, 20));
        prezzo2.setFont(new Font("Arial", Font.PLAIN, 20));
        ((DefaultEditor)prezzo2.getEditor()).getTextField().setEditable(false);
        
        JButton aggiungi = new JButton("Aggiungi");
        AggiungiLibro aggiungiLibro = new AggiungiLibro(titolo2, descrizione2, prezzo2,telefono2);
        aggiungi.addActionListener(aggiungiLibro);
        
        prezzoPanel.add(euro);
        prezzoPanel.add(prezzo2);
        
        panel.add(titolo);
        panel.add(titolo2);
        panel.add(descrizione);
        panel.add(scrollPanel);
        panel.add(prezzo);
        panel.add(prezzoPanel);
        panel.add(telefono);
        panel.add(telefono2);
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
    
        titolo2.setText("");
        descrizione2.setText("");
        prezzo2.setValue(0);
    }
}
