/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Vista;

import Appunti.Ascoltatori.CaricaAppunti;
import Application.Controller.Applicazione;
import Libri.Ascoltatori.CaricaLibri;
import Panel.TopPanel;
import QeA.Ascoltatori.CaricaDomande;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class CorsoPanel extends JPanel{
    private TopPanel top;
    private JPanel panel, centro;
    private JButton appunti, libri, qea;
    private CaricaLibri caricaLibri;
    private CaricaDomande caricaDomande;
    private CaricaAppunti caricaAppunti;
    private JScrollPane scrollPanel;
    private GridBagConstraints gbcImg;
        
    public CorsoPanel() {
        
         top = new TopPanel(Applicazione.corsoPremuto);
        
        panel = new JPanel(new GridBagLayout());
        centro = new JPanel(new BorderLayout());

        gbcImg = new GridBagConstraints();
        
        caricaLibri = new CaricaLibri();
        caricaDomande = new CaricaDomande();
        caricaAppunti = new CaricaAppunti();
        this.build();
        libri.addActionListener(caricaLibri);
        qea.addActionListener(caricaDomande);
        appunti.addActionListener(caricaAppunti);
        libri.setBackground(new Color(238,238,238));
        appunti.setBackground(new Color(238,238,238));
        qea.setBackground(new Color(238,238,238));
        
        
        centro.add(panel, BorderLayout.CENTER);
        
        scrollPanel = new JScrollPane(centro,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
    public void build(){
        
        JLabel appuntiLab = new JLabel("Appunti");
        appuntiLab.setFont(new Font("Arial", Font.BOLD, 20));
        gbcImg.gridx = 0;
        gbcImg.gridy = 0;
        gbcImg.insets = new Insets(10, 0, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(appuntiLab,gbcImg);
        
        JLabel libriLab = new JLabel("Libri");
        libriLab.setFont(new Font("Arial", Font.BOLD, 20));
        gbcImg.gridx = 1;
        gbcImg.gridy = 0;
        gbcImg.insets = new Insets(10, 0, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(libriLab,gbcImg);
        
        JLabel qeaLab = new JLabel("Q&A");
        qeaLab.setFont(new Font("Arial", Font.BOLD, 20));
        gbcImg.gridx = 2;
        gbcImg.gridy = 0;
        gbcImg.insets = new Insets(10, 0, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(qeaLab,gbcImg);
        
        // riga 0 colonna 0

        ImageIcon appuntiIco = new ImageIcon("files\\immagini\\appunti.png");
        appunti = new JButton(appuntiIco);
        
        appunti.setPreferredSize(new Dimension(166, 200));
        gbcImg.gridx = 0;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(10, 0, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(appunti,gbcImg);
        
         // riga 0 colonna 1
        ImageIcon libriIco = new ImageIcon("files\\immagini\\libri.png");
        libri = new JButton(libriIco);
        libri.setPreferredSize(new Dimension(166, 200));
        gbcImg.gridx = 1;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(10, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(libri, gbcImg);
        
        // riga 0 colonna 2
        ImageIcon qeaIco = new ImageIcon("files\\immagini\\qea.png");
        qea = new JButton(qeaIco);
        qea.setPreferredSize(new Dimension(166, 200));
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(10, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;    
        panel.add(qea,gbcImg);
    }
     
}
