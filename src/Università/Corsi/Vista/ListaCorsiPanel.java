/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Università.Corsi.Vista;

import Università.Corsi.Ascoltatori.GoToCorso;
import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Database.Query.ListeQuery;
import Header.Vista.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiFacoltàPreferita;
import Preferiti.Facoltà.Ascoltatori.RimuoviFacoltàPreferita;
import Utils.Ordina;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author te4o
 */
public class ListaCorsiPanel extends JPanel{
    
    private JLabel[] corsi = new JLabel[Applicazione.listaCorsiAttuali.size()];
    private JPanel[] panels = new JPanel[3];
    private JScrollPane[] scrollP = new JScrollPane[3];
    
    private TitledBorder[] titoloBordo = new TitledBorder[Applicazione.listaRamiFacoltà.size()];
    private JPanel panel, topPref;
    private TopPanel top;
    public ListaCorsiPanel() {
        
        setBackground(Color.white);
        
        top = new TopPanel(Applicazione.facoltàAttuale.getNome());
        top.setBackground(Color.white);
        
        panel = new JPanel(new GridLayout(1, 3, 10, 0));
        panel.setBackground(Color.white);
        
        topPref = new JPanel();
        topPref.setBackground(Color.white);
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        JButton preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        AggiungiFacoltàPreferita aggiungiFacoltàPreferita = new AggiungiFacoltàPreferita();
        preferitiOff.addActionListener(aggiungiFacoltàPreferita);
        
        RimuoviFacoltàPreferita rimuoviFacoltàPreferita = new RimuoviFacoltàPreferita();
        preferitiOn.addActionListener(rimuoviFacoltàPreferita);
        
        try {
            if (ControlloQuery.controlloFacoltàPreferita()) {
                topPref.add(preferitiOff);
            }
            else {
                topPref.add(preferitiOn);
            }
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo della facoltà preferita");
        }//fine zona preferito
        
        GoToCorso goToCorso = new GoToCorso(Applicazione.facoltàAttuale.getNome());
        
        for (int i = 0; i < 3; i++) {
            
            try {
                ListeQuery.caricaCorsi(i+1);
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei corsi per anno");
            }
            
            Ordina.CorsiXAnno();
            
            panels[i] = new JPanel(new GridLayout(Applicazione.listaCorsiXAnno.size()+1, 1, 0, 5));
            panels[i].setBackground(Color.white);
            
            scrollP[i] = new JScrollPane();
            titoloBordo[i] = new TitledBorder(""+(i+1)+"° Anno");
            
            titoloBordo[i].setTitleFont(new Font("Century Gothic", Font.BOLD, 17));
            titoloBordo[i].setTitleColor(new Color(0,85,118));
            panels[i].setBorder(titoloBordo[i]);
            
            for (int j = 0; j < Applicazione.listaCorsiXAnno.size(); j++) {
                corsi[j] = new JLabel();
                corsi[j].setPreferredSize(new Dimension(150, 20));
                corsi[j].setFont(new Font("Century Gothic", Font.PLAIN, 14));
                corsi[j].setText(Applicazione.listaCorsiXAnno.get(j).getNome());
                corsi[j].setName("corso"+j);
                corsi[j].addMouseListener(goToCorso);
                panels[i].add(corsi[j]);
            }
            
            JScrollBar scrollBar = new JScrollBar();
            scrollBar.setBackground(Color.white);
            scrollBar.setPreferredSize(new Dimension(0, 20));
            scrollP[i]= new JScrollPane(panels[i],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollP[i].setPreferredSize(new Dimension(220, 320));
            scrollP[i].setBorder(new LineBorder(Color.white, 1, true));
            scrollP[i].getVerticalScrollBar().setUnitIncrement(16);
            scrollP[i].setVerticalScrollBar(scrollBar);
            scrollP[i].setBackground(Color.white);
            panel.add(scrollP[i]);
            Applicazione.svuotaCorsiXAnno();
            
        }
        
        add(top);
        add(topPref);
        add(panel);
    }
    
}
