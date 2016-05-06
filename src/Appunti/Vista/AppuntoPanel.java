/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Appunti.Ascoltatori.EliminaAppunto;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToRecensioniAppuntoPanel;
import Appunti.Ascoltatori.Vota;
import Database.Query.ControlloQuery;
import Database.Query.InfoQuery;
import Header.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiAppuntoPreferito;
import Preferiti.Facoltà.Ascoltatori.RimuoviAppuntoPreferito;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
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
    
    private JSlider punteggio;
    private JButton valuta;
    
    public AppuntoPanel() {
        
        TopPanel top = new TopPanel(Applicazione.appuntoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(8,2,10,10));
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon("files\\immagini\\preferitiOn.png"));
        JButton preferitiOff = new JButton(new ImageIcon("files\\immagini\\preferitiOff.png"));
        
        AggiungiAppuntoPreferito aggiungiAppuntoPreferito = new AggiungiAppuntoPreferito();
        preferitiOff.addActionListener(aggiungiAppuntoPreferito);
        
        RimuoviAppuntoPreferito rimuoviAppuntoPreferito = new RimuoviAppuntoPreferito();
        preferitiOn.addActionListener(rimuoviAppuntoPreferito);
        
        if (ControlloQuery.controlloAppuntoPreferito()) {
            panel.add(preferitiOff);
        }
        else {
            panel.add(preferitiOn);
        }
        //fine zona preferito
        
        JLabel email = new JLabel("Email :");
        JLabel nome = new JLabel("Nome :");
        JLabel descrizione = new JLabel("Descrizione :");
        JLabel media = new JLabel("Media :");
        
        punteggio = new JSlider(1, 5);
        valuta = new JButton("Vota");
        
        JTextArea commento = new JTextArea();
        commento.setLineWrap(true);
        commento.setWrapStyleWord(true);
        
        JLabel email2 = new JLabel(Applicazione.appuntoAttuale.getStudente());
        JLabel nome2 = new JLabel(Applicazione.appuntoAttuale.getNome());
        JTextArea descrizione2 = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        JLabel media2 = new JLabel(Float.toString(InfoQuery.mediaAppunto()));
        
        JScrollPane scrollPanel = new JScrollPane(descrizione2);
        
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        punteggio.setLabelTable(punteggio.createStandardLabels(1));
        punteggio.setMajorTickSpacing(1);
        punteggio.setPaintLabels(true);
        
        Vota vota = new Vota(commento, punteggio);
        valuta.addActionListener(vota);
        
        JButton recensioni = new JButton("Recensioni");
        GoToRecensioniAppuntoPanel goToRecensioniAppuntoPanel = new GoToRecensioniAppuntoPanel();
        recensioni.addActionListener(goToRecensioniAppuntoPanel);
        
        panel.add(recensioni);
        panel.add(nome);
        panel.add(nome2);
        panel.add(descrizione);
        panel.add(descrizione2);
        panel.add(media);
        panel.add(media2);
        panel.add(email);
        panel.add(email2);
        if((ControlloQuery.controlloValutazioneAppunto())&&(!Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail()))){
            panel.add(punteggio);
            panel.add(commento);
            panel.add(valuta);
        }
        
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
