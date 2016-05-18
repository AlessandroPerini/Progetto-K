/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universita.Corsi.Vista;

import Appunti.Ascoltatori.CaricaAppunti;
import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Libri.Ascoltatori.CaricaLibri;
import Header.Vista.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiCorsoPreferito;
import Preferiti.Facoltà.Ascoltatori.RimuoviCorsoPreferito;
import QeA.Ascoltatori.CaricaDomande;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class CorsoPanel extends JPanel{
    private TopPanel top;
    private JPanel panel, centro, topPref, doubleTop;
    private JButton appunti, libri, qea;
    private CaricaLibri caricaLibri;
    private CaricaDomande caricaDomande;
    private CaricaAppunti caricaAppunti;
    private GridBagConstraints gbcImg;
        
    public CorsoPanel() {
        
        setBackground(Color.white);
        
        top = new TopPanel(Applicazione.corsoAttuale.getNome());
        top.setBackground(Color.white);
        
        topPref = new JPanel();
        topPref.setBackground(Color.white);
        
        doubleTop = new JPanel(new GridLayout(2, 1, 0, 5));
        doubleTop.setBackground(Color.white);
        
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        
        centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.white);

        gbcImg = new GridBagConstraints();
        
        caricaLibri = new CaricaLibri();
        caricaDomande = new CaricaDomande();
        caricaAppunti = new CaricaAppunti();
        
        this.build();
        
        libri.addActionListener(caricaLibri);
        qea.addActionListener(caricaDomande);
        appunti.addActionListener(caricaAppunti);
        libri.setBackground(Color.white);
        libri.setBorder(new LineBorder(Color.white, 1, true));
        appunti.setBackground(Color.white);
        appunti.setBorder(new LineBorder(Color.white, 1, true));
        qea.setBackground(Color.white);
        qea.setBorder(new LineBorder(Color.white, 1, true));
        
        centro.add(panel, BorderLayout.CENTER);
        
        doubleTop.add(top);
        doubleTop.add(topPref);
        
        add(doubleTop);
        add(panel);
    }
    
    public void build(){

        //preferito
        JButton preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        JButton preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        AggiungiCorsoPreferito aggiungiCorsoPreferito = new AggiungiCorsoPreferito();
        preferitiOff.addActionListener(aggiungiCorsoPreferito);
        
        RimuoviCorsoPreferito rimuoviCorsoPreferito = new RimuoviCorsoPreferito();
        preferitiOn.addActionListener(rimuoviCorsoPreferito);
        
        try {
            if (ControlloQuery.controlloCorsoPreferito()) {
                topPref.add(preferitiOff);
            }
            else {
                topPref.add(preferitiOn);
            }
      
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del corso preferito");
        }//fine zona preferito
        
        JLabel appuntiLab = new JLabel("Appunti");
        appuntiLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 0;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 30, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(appuntiLab,gbcImg);
        
        JLabel libriLab = new JLabel("Libri");
        libriLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 1;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(libriLab,gbcImg);
        
        JLabel qeaLab = new JLabel("Q&A");
        qeaLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(qeaLab,gbcImg);
        
        // riga 0 colonna 0

        ImageIcon appuntiIco = new ImageIcon(this.getClass().getResource("/immagini/appunti.png"));
        appunti = new JButton(appuntiIco);
        
        appunti.setPreferredSize(new Dimension(166, 200));
        gbcImg.gridx = 0;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 50, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;    
        panel.add(appunti,gbcImg);
        
        // riga 0 colonna 1
        ImageIcon libriIco = new ImageIcon(this.getClass().getResource("/immagini/libri.png"));
        libri = new JButton(libriIco);
        libri.setPreferredSize(new Dimension(166, 215));
        gbcImg.gridx = 1;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 35, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;    
        panel.add(libri, gbcImg);
        
        // riga 0 colonna 2
        ImageIcon qeaIco = new ImageIcon(this.getClass().getResource("/immagini/qea.png"));
        qea = new JButton(qeaIco);
        qea.setPreferredSize(new Dimension(200, 200));
        gbcImg.gridx = 2;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;    
        panel.add(qea,gbcImg);
    }
     
}
