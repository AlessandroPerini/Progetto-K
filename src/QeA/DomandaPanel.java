/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Libri.EliminaLibro;
import Panel.TopPanel;
import Università.Corsi.CaricaCorsi;
import Università.Facolta.CaricaFacoltà;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author cl410688
 */
public class DomandaPanel extends JPanel{

 
    private JButton rispondi;
    private TopPanel top;
    private JPanel panel;
    private JLabel titolo, titolo2, descrizione, like,
                   email, email2, like2, risposte,rispondiLabel;
    private JTextArea descrizione2, rispondiArea;
    public JTextArea risposte2;
    private JScrollPane scrollPanel, scrollPanel1, scrollPanel3, scrollPanel4;
    private JButton elimina;
    
   
    public DomandaPanel(CardLayout card, JPanel container) {
        
        top = new TopPanel(card, container, Applicazione.domandaPremuta);
        
        panel = new JPanel();
        
        this.build(card, container);

        scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 410));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
    }
    
    public void build(CardLayout card, JPanel container){
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //prima riga - colonna 0
        
        this.email = new JLabel("Email:");
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.email, gbc);
        
        //colonna 1
        this.email2 = new JLabel(Applicazione.domandaAttuale.getStudente());
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.email2, gbc);
        
        //seconda riga - colonna 0
        
        this.titolo = new JLabel("Titolo:");
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.titolo, gbc);
        
        //colonna 1
        this.titolo2 = new JLabel(Applicazione.domandaAttuale.getTitolo());
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.titolo2, gbc);
        
         //seconda riga - colonna 0
        
        this.descrizione = new JLabel("Descrizione:");
	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.descrizione, gbc);
        
        //colonna 1
        this.descrizione2 = new JTextArea(Applicazione.domandaAttuale.getDomanda(),5,25);
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        this.scrollPanel = new JScrollPane();
        scrollPanel.setViewportView(descrizione2);
        scrollPanel.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel, gbc);
        
        // quarta riga - colonna 0
        
        this.like= new JLabel("Like:");
	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.like, gbc);
        
        //colonna 1
        this.like2 = new JLabel(Integer.toString(Applicazione.domandaAttuale.getLike()));
	gbc.gridx = 1;
	gbc.gridy = 3;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.like2, gbc);
        
        
        this.risposte = new JLabel("Risposte Date:");
        gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.risposte, gbc);
        
        this.risposte2 = new JTextArea(10,25);
        risposte2.setEditable(false);
        risposte2.setLineWrap(true);
        risposte2.setWrapStyleWord(true);
        
        this.scrollPanel3 = new JScrollPane();
        scrollPanel3.setViewportView(risposte2);
        scrollPanel3.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 4;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel3, gbc);
        
        this.rispondiLabel = new JLabel("Risposta:");
        gbc.gridx = 0;
	gbc.gridy = 5;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.rispondiLabel, gbc);
        
        this.rispondiArea = new JTextArea(5,25);
        rispondiArea.setLineWrap(true);
        rispondiArea.setWrapStyleWord(true);
        
        this.scrollPanel4 = new JScrollPane();
        scrollPanel4.setViewportView(rispondiArea);
        scrollPanel4.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 5;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel4, gbc);
        
        this.rispondi = new JButton("Rispondi");
        gbc.gridx = 1;
	gbc.gridy = 6;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.rispondi, gbc);
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            EliminaDomanda eliminaDomanda = new EliminaDomanda(card, container);
            this.elimina = new JButton("Elimina");
            elimina.setBackground(new Color(249,123,123));
            gbc.gridx = 1;
            gbc.gridy = 7;
            gbc.insets = new Insets(5, 30, 0, 10);
            gbc.anchor = GridBagConstraints.LINE_START;
            elimina.addActionListener(eliminaDomanda);
            panel.add(this.elimina, gbc);
        }
    }
    
}
    



