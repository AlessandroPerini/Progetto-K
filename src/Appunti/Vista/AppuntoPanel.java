/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Appunti.Ascoltatori.EliminaAppunto;
import Application.Controller.Applicazione;
import Header.TopPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class AppuntoPanel extends JPanel{
    
    private JSlider valutazione;
    private JButton valuta;
    
    public AppuntoPanel() {
        
        TopPanel top = new TopPanel(Applicazione.appuntoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(7,2,10,10));
        
        JLabel email = new JLabel("Email :");
        JLabel nome = new JLabel("Nome :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel media = new JLabel("Media :");
        
        valutazione = new JSlider(1, 5);
        valuta = new JButton("Vota");
        
        JLabel email2 = new JLabel(Applicazione.appuntoAttuale.getStudente());
        JLabel nome2 = new JLabel(Applicazione.appuntoAttuale.getNome());
        JTextArea descrizione2 = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        JLabel media2 = new JLabel(Float.toString(Applicazione.appuntoAttuale.getMedia()));
        
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        valutazione.setLabelTable(valutazione.createStandardLabels(1));
        valutazione.setMajorTickSpacing(1);
        valutazione.setPaintLabels(true);
        
        panel.add(nome);
        panel.add(nome2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(media);
        panel.add(media2);
        panel.add(email);
        panel.add(email2);
        panel.add(valutazione);
        panel.add(valuta);
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            EliminaAppunto eliminaAppunto = new EliminaAppunto();
            JButton elimina = new JButton("Elimina");
            elimina.setBackground(new Color(249,123,123));
            elimina.addActionListener(eliminaAppunto);
            panel.add(elimina);
        }
 
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 450));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
}
}
