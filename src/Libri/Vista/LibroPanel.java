/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Vista;

import Libri.Ascoltatori.EliminaLibro;
import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Header.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiLibroPreferito;
import Preferiti.Facoltà.Ascoltatori.RimuoviLibroPreferito;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author cl410688
 */
public class LibroPanel extends JPanel{
    
    private TopPanel top;
    private JPanel panel;
    private JLabel titolo, titolo2, descrizione, prezzo, prezzo2, telefono, telefono2, email, email2;
    private JTextArea descrizione2;
    private JScrollPane scrollPanel, scrollPanel1;
    private JButton elimina;
            
    public LibroPanel() {
        
        top = new TopPanel(Applicazione.libroAttuale.getTitolo());
        
        panel = new JPanel();
        
        this.build();
       
        scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 450));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
     
    }
    
    public void build(){
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //preferito
        JButton preferitiOn = new JButton(new ImageIcon("files\\immagini\\preferitiOn.png"));
        JButton preferitiOff = new JButton(new ImageIcon("files\\immagini\\preferitiOff.png"));
        
        AggiungiLibroPreferito aggiungiLibroPreferito = new AggiungiLibroPreferito();
        preferitiOff.addActionListener(aggiungiLibroPreferito);
        
        RimuoviLibroPreferito rimuoviLibroPreferito = new RimuoviLibroPreferito();
        preferitiOn.addActionListener(rimuoviLibroPreferito);
        
        try {
            if (ControlloQuery.controlloLibroPreferito()) {
                panel.add(preferitiOff);
            }
            else {
                panel.add(preferitiOn);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del libro preferito");
        }//fine zona preferito
        
        //prima riga - colonna 0
        this.titolo = new JLabel("titolo");
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.titolo, gbc);
        
        //colonna 1
        this.titolo2 = new JLabel(Applicazione.libroAttuale.getTitolo());
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.insets = new Insets(10, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.titolo2, gbc);
        
        //seconda riga - colonna 0
        
        this.descrizione = new JLabel("descrizione:");
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.descrizione, gbc);
        
        //colonna 1
        this.descrizione2 = new JTextArea(Applicazione.libroAttuale.getDescrizione(),7,30);
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        this.scrollPanel = new JScrollPane();
        scrollPanel.setViewportView(descrizione2);
        scrollPanel.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.insets = new Insets(20, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel, gbc);
        
        // terza riga - colonna 0
        
        this.prezzo = new JLabel("prezzo:");
	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.prezzo, gbc);
        
        //colonna 1
        this.prezzo2 = new JLabel(""+Applicazione.libroAttuale.getPrezzo());
	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.insets = new Insets(5, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.prezzo2, gbc);
        
        // quarta riga - colonna 0
        
        this.telefono = new JLabel("telefono:");
	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.telefono, gbc);
        
        //colonna 1
        this.telefono2 = new JLabel(Applicazione.libroAttuale.getTelefono());
	gbc.gridx = 1;
	gbc.gridy = 3;
	gbc.insets = new Insets(5, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.telefono2, gbc);
        
        // quita riga colonna 0
        
        this.email = new JLabel("email:");
	gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.email, gbc);
        
        //colonna 1
        this.email2 = new JLabel(Applicazione.libroAttuale.getStudente());
	gbc.gridx = 1;
	gbc.gridy = 4;
	gbc.insets = new Insets(5, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.email2, gbc);
        
        if (Applicazione.libroAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            EliminaLibro eliminaLibro = new EliminaLibro();
            this.elimina = new JButton("Elimina");
            elimina.setBackground(new Color(249,123,123));
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.insets = new Insets(5, 30, 0, 10);
            gbc.anchor = GridBagConstraints.LINE_START;
            elimina.addActionListener(eliminaLibro);
            panel.add(this.elimina, gbc);
        }
    }

    
}
    

