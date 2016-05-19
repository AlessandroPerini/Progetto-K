/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Vista;

import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.EliminaLibro;
import Preferiti.Ascoltatori.AggiungiLibroPreferito;
import Preferiti.Ascoltatori.RimuoviLibroPreferito;
import Utils.CustomScrollbarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author cl410688
 */
public class LibroPanel extends JPanel{

    private JPanel top, panel, preferitiPanel, descrizionePanel;
    private JLabel email, telefono, prezzo;
    private JTextArea descrizione;
    private JScrollPane scrollPanel;
    
    public LibroPanel() {
        
        setBackground(Color.white);
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        top = new TopPanel(Applicazione.libroAttuale.getTitolo());
        top.setBackground(Color.white);
        
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        
        preferitiPanel = new JPanel();
        preferitiPanel.setBackground(Color.white);
        preferitiPanel.setPreferredSize(new Dimension(650, 35));
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        JButton preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        AggiungiLibroPreferito aggiungiLibroPreferito = new AggiungiLibroPreferito();
        preferitiOff.addActionListener(aggiungiLibroPreferito);
        
        RimuoviLibroPreferito rimuoviLibroPreferito = new RimuoviLibroPreferito();
        preferitiOn.addActionListener(rimuoviLibroPreferito);
        
        try {
            if (ControlloQuery.controlloLibroPreferito()) {
                preferitiPanel.add(preferitiOff);
            }
            else {
                preferitiPanel.add(preferitiOn);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo dell'appunto preferito");
        }//fine zona preferito
        
        email = new JLabel("<html><b>Caricato da: </b>"+Applicazione.libroAttuale.getStudente()+"</html>");
        email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(email, gbc);
        
        telefono = new JLabel("<html><b>Telefono: </b>"+Applicazione.libroAttuale.getTelefono()+"</html>");
        telefono.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(telefono, gbc);
        
        prezzo = new JLabel("<html><b>Prezzo: </b>"+Applicazione.libroAttuale.getPrezzo()+" €</html>");
        prezzo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(prezzo, gbc);

        descrizionePanel = new JPanel();
        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        descrizione = new JTextArea(Applicazione.libroAttuale.getDescrizione());
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descrizione.setBackground(new Color(239,242,243));
        scrollPanel = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(300, 150));
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(Color.white);
        scrollBar.setPreferredSize(new Dimension(13, 0));
        scrollBar.setUI(new CustomScrollbarUI());
        scrollBar.setUnitIncrement(16);
        scrollPanel.setVerticalScrollBar(scrollBar);
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        descrizione.setEditable(false);
        descrizionePanel.add(scrollPanel);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(descrizionePanel, gbc);
                
        Icon eliminaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        JButton elimina = new JButton(eliminaNormal);
        elimina.setBorder(BorderFactory.createEmptyBorder());
        elimina.setContentAreaFilled(false);
        Icon eliminaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        elimina.setRolloverIcon(eliminaHover);
        Icon eliminaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        elimina.setPressedIcon(eliminaPressed);
        elimina.setText("ELIMINA");
        elimina.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        elimina.setForeground(Color.white);
        elimina.setIconTextGap(-81);
        elimina.setPreferredSize(new Dimension(110, 40));
        
        elimina.setBackground(new Color(249,123,123));
        EliminaLibro eliminaLibro = new EliminaLibro();
        elimina.addActionListener(eliminaLibro);

        if (Applicazione.libroAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            panel.add(elimina);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(elimina, gbc);
        }
        
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 400));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(preferitiPanel);
        add(scrollPanel1);

    }
    
}
    

