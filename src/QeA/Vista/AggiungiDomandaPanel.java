/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Vista;

import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import QeA.Ascoltatori.AggiungiDomanda;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiDomandaPanel extends JPanel{
    
    private static JTextArea nome, descrizione;
    private JButton  aggiungi;
    private JPanel nomePanel, descrizionePanel;
    
    public AggiungiDomandaPanel() {
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setBackground(Color.white);
        
        TopPanel top = new TopPanel("Aggiungi Appunto in "+Applicazione.corsoAttuale.getNome());
        top.setBackground(Color.white);
        
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        
        nome = new JTextArea("");
        descrizione = new JTextArea("");
        
        nomePanel = new JPanel();
        nomePanel.setBackground(Color.white);
        descrizionePanel = new JPanel();
        descrizionePanel.setBackground(Color.white);
        
        nomePanel.setBorder(BorderFactory.createTitledBorder("Titolo"));
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        nome.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        
        nome.setBackground(Color.white);
        nome.setForeground(Color.BLACK);
        descrizione.setBackground(Color.white);
        descrizione.setForeground(Color.BLACK);
        
        JScrollPane scrollPanelNome = new JScrollPane(nome, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelNome.setPreferredSize(new Dimension(250, 80));
        nome.setLineWrap(true);
        nome.setWrapStyleWord(true);
        
        JScrollPane scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDescrizione.setPreferredSize(new Dimension(250, 150));
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        
        nomePanel.add(scrollPanelNome);
        descrizionePanel.add(scrollPanelDescrizione);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(-10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(nomePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(descrizionePanel, gbc);
        
        Icon aggiungiNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        aggiungi = new JButton(aggiungiNormal);
        aggiungi.setBorder(BorderFactory.createEmptyBorder());
        aggiungi.setContentAreaFilled(false);
        Icon aggiungiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        aggiungi.setRolloverIcon(aggiungiHover);
        Icon aggiungiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        aggiungi.setPressedIcon(aggiungiPressed);
        aggiungi.setText("AGGIUNGI");
        aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        aggiungi.setForeground(Color.white);
        aggiungi.setIconTextGap(-88);
        aggiungi.setPreferredSize(new Dimension(110, 40));
        AggiungiDomanda aggiungiDomanda = new AggiungiDomanda(nome, descrizione);
        aggiungi.addActionListener(aggiungiDomanda); 
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(aggiungi, gbc);
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        
        add(top);
        add(scrollPanel);
        
    }
    
    public static void clearForm(){
        
        nome.setText("");
        descrizione.setText("");
    }
}

