/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Libri.Vista;

import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.AggiungiLibro;
import Utils.Vista.ScrollBarUI;
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
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class AggiungiLibroPanel extends JPanel{
    
    private static JTextArea nome, descrizione;
    private JButton aggiungi;
    private JSpinner prezzo;
    private JCheckBox telefono;
    private JPanel prezzoPanel, nomePanel, descrizionePanel;
    private JLabel euro;
    
    public AggiungiLibroPanel() {
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        setBackground(Color.white);
        
        TopPanel top = new TopPanel("Aggiungi Libro in "+Applicazione.corsoAttuale.getNome());
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
        scrollPanelNome.setPreferredSize(new Dimension(250, 50));
        scrollPanelNome.setBackground(Color.white);
        scrollPanelNome.setBorder(new LineBorder(Color.white));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(Color.white);
        scrollBar.setPreferredSize(new Dimension(13, 0));
        scrollBar.setUI(new ScrollBarUI());
        scrollBar.setUnitIncrement(16);
        scrollPanelNome.setVerticalScrollBar(scrollBar);
        nome.setLineWrap(true);
        nome.setWrapStyleWord(true);
        
        JScrollPane scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDescrizione.setPreferredSize(new Dimension(250, 100));
        scrollPanelDescrizione.setBackground(Color.white);
        scrollPanelDescrizione.setBorder(new LineBorder(Color.white));
        JScrollBar scrollBar2 = new JScrollBar();
        scrollBar2.setBackground(Color.white);
        scrollBar2.setPreferredSize(new Dimension(13, 0));
        scrollBar2.setUI(new ScrollBarUI());
        scrollBar2.setUnitIncrement(16);
        scrollPanelDescrizione.setVerticalScrollBar(scrollBar2);
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        
        nomePanel.add(scrollPanelNome);
        descrizionePanel.add(scrollPanelDescrizione);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(nomePanel, gbc);
        
        telefono = new JCheckBox("Vuoi far vedere il tuo numero?");
        telefono.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        telefono.setBorder(BorderFactory.createTitledBorder("Telefono"));
        telefono.setBackground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(telefono, gbc);
        
        SpinnerNumberModel prezzoModel = new SpinnerNumberModel(0, 0, 999, 1);
        prezzo = new JSpinner(prezzoModel);
        ((DefaultEditor) prezzo.getEditor()).getTextField().setEditable(false);
        prezzo.setPreferredSize(new Dimension(150, 30));
        prezzo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        prezzo.setBackground(Color.white);
        JComponent editor = prezzo.getEditor();
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
        spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        
        euro = new JLabel("€");
        euro.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        euro.setBackground(Color.white);
        
        prezzoPanel = new JPanel();
        prezzoPanel.add(euro);
        prezzoPanel.add(prezzo);
        prezzoPanel.setBorder(BorderFactory.createTitledBorder("Prezzo"));
        prezzoPanel.setBackground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(prezzoPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
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
        aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        aggiungi.setForeground(Color.white);
        aggiungi.setIconTextGap(-88);
        aggiungi.setPreferredSize(new Dimension(110, 40));
        aggiungi.setEnabled(true);
        aggiungi.setText("AGGIUNGI");
        AggiungiLibro aggiungiLibro = new AggiungiLibro(nome, descrizione, prezzo, telefono);
        aggiungi.addActionListener(aggiungiLibro);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 0);
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
