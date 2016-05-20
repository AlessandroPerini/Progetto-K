/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Valutazioni.Vista;

import Application.Vista.Grafica;
import Valutazioni.Ascoltatori.VotaAppunto;
import Utils.Vista.ScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class ValutaAppuntoFrame{
    
    private JTextArea commento;
    private JSlider punteggio;
    private JFrame valutaFrame;
    private JLabel titoloFrame;
    private JPanel container, mainPanel, commentoPanel, buttonPanel;
    private JButton annulla, conferma;

    public ValutaAppuntoFrame() {
        this.valutaFrame = new JFrame();
    }

    public void apri(){
 
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        valutaFrame = new JFrame("Valuta Appunto");
        valutaFrame.setSize(550, 444);
        valutaFrame.setResizable(false);
        valutaFrame.setUndecorated(true);
        //centra questo frame esattamente al centro rispetto al MainFrame
        int x = (int) (Grafica.posizione().getX() + 350 - valutaFrame.getWidth()/2);
        int y = (int) (Grafica.posizione().getY() + 280 - valutaFrame.getHeight()/2);
        valutaFrame.setLocation(x, y);
        
        container = new JPanel();
        container.setBackground(Color.white);
        container.setBorder(new LineBorder(new Color(53,53,53), 3));
        valutaFrame.setContentPane(container);
        
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.white);
        
        buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setBackground(Color.white);
        
        titoloFrame = new JLabel("Valuta appunto");
        titoloFrame.setFont(new Font("Century Gothic", Font.BOLD, 25));
        titoloFrame.setBackground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titoloFrame, gbc);
        
        punteggio = new JSlider(1, 5);
        punteggio.setPreferredSize(new Dimension(150,50));
        punteggio.setLabelTable(punteggio.createStandardLabels(1));
        punteggio.setMajorTickSpacing(1);
        punteggio.setBackground(Color.white);
        punteggio.setPaintLabels(true);
        punteggio.setBorder(BorderFactory.createTitledBorder("Punteggio"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(punteggio, gbc);
        
        commentoPanel = new JPanel();
        commentoPanel.setBackground(Color.white);
        commentoPanel.setBorder(BorderFactory.createTitledBorder("Commento"));
        
        commento = new JTextArea();
        commento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        commento.setBackground(Color.white);
        commento.setForeground(Color.BLACK);
        JScrollPane scrollPanel = new JScrollPane(commento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(300, 150));
        scrollPanel.setBorder(new LineBorder(Color.white));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(Color.white);
        scrollBar.setPreferredSize(new Dimension(13, 0));
        scrollBar.setUI(new ScrollBarUI());
        scrollBar.setUnitIncrement(16);
        scrollPanel.setVerticalScrollBar(scrollBar);
        commento.setLineWrap(true);
        commento.setWrapStyleWord(true);
        commentoPanel.add(scrollPanel);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(commentoPanel, gbc);
        
        Icon annullaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        annulla = new JButton(annullaNormal);
        annulla.setBorder(BorderFactory.createEmptyBorder());
        annulla.setContentAreaFilled(false);
        Icon annullaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        annulla.setRolloverIcon(annullaHover);
        Icon annullaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        annulla.setPressedIcon(annullaPressed);
        annulla.setText("ANNULLA");
        annulla.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        annulla.setForeground(Color.white);
        annulla.setIconTextGap(-86);
        annulla.setPreferredSize(new Dimension(110, 40));
        annulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valutaFrame.dispose();
                valutaFrame.setVisible(false);
            }
        });
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 0, 0, 55);
        gbc2.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(annulla, gbc2);
        
        Icon confermaNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        conferma = new JButton(confermaNormal);
        conferma.setBorder(BorderFactory.createEmptyBorder());
        conferma.setContentAreaFilled(false);
        Icon confermaHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        conferma.setRolloverIcon(confermaHover);
        Icon confermaPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        conferma.setPressedIcon(confermaPressed);
        conferma.setText("CONFERMA");
        conferma.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        conferma.setForeground(Color.white);
        conferma.setIconTextGap(-93);
        conferma.setPreferredSize(new Dimension(110, 40));
        VotaAppunto votaAppunto = new VotaAppunto(commento, punteggio, valutaFrame);
        conferma.addActionListener(votaAppunto);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 55, 0, 0);
        gbc2.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(conferma, gbc2);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);
        
        container.add(mainPanel);
        
        valutaFrame.setVisible(true);
    }

    
}
