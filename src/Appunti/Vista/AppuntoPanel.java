/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Vista;

import Appunti.Ascoltatori.EliminaAppunto;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToRecensioniAppuntoPanel;
import Appunti.Ascoltatori.DownloadFileAppunto;
import Database.Query.ControlloQuery;
import Frame.ValutaAppuntoFrame;
import Header.Vista.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiAppuntoPreferito;
import Preferiti.Facoltà.Ascoltatori.RimuoviAppuntoPreferito;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class AppuntoPanel extends JPanel{
    
    private JButton valuta;
    private JPanel top, panel, preferitiPanel, recensioniPanel;
    private JTextArea descrizione;
    private JScrollPane scrollPanel;
    
    public AppuntoPanel() {
        
        setBackground(Color.white);
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        top = new TopPanel(Applicazione.appuntoAttuale.getNome());
        top.setBackground(Color.white);
        
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        
        preferitiPanel = new JPanel();
        preferitiPanel.setBackground(Color.white);
        preferitiPanel.setPreferredSize(new Dimension(650, 35));
        
        recensioniPanel = new JPanel(new GridBagLayout());
        recensioniPanel.setBackground(Color.white);
        recensioniPanel.setPreferredSize(new Dimension(680, 30));
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        JButton preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        AggiungiAppuntoPreferito aggiungiAppuntoPreferito = new AggiungiAppuntoPreferito();
        preferitiOff.addActionListener(aggiungiAppuntoPreferito);
        
        RimuoviAppuntoPreferito rimuoviAppuntoPreferito = new RimuoviAppuntoPreferito();
        preferitiOn.addActionListener(rimuoviAppuntoPreferito);
        
        try {
            if (ControlloQuery.controlloAppuntoPreferito()) {
                preferitiPanel.add(preferitiOff);
            }
            else {
                preferitiPanel.add(preferitiOn);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo dell'appunto preferito");
        }//fine zona preferito
        
        
        String mediaTagliata = Float.toString(Applicazione.appuntoAttuale.getMedia());
        String s = mediaTagliata.replace(".", ",");
        String parts[] = s.split(",");
        mediaTagliata = parts[0]+"."+parts[1].charAt(0);
        JLabel media = new JLabel("Punteggio: "+mediaTagliata+" / 5   ");
        media.setFont(new Font("Century Gothic", Font.BOLD, 15));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 0, 0, 0);
        gbc2.anchor = GridBagConstraints.LINE_START;
        recensioniPanel.add(media, gbc2);

        JButton recensioni = new JButton("Recensioni");
        recensioni.setForeground(new Color(218,194,127));
        recensioni.setBorder(new LineBorder(new Color(218,194,118), 1, true));
        recensioni.setBackground(Color.white);
        recensioni.setFont(new Font("Century Gothic", Font.BOLD, 15));
        GoToRecensioniAppuntoPanel goToRecensioniAppuntoPanel = new GoToRecensioniAppuntoPanel();
        recensioni.addActionListener(goToRecensioniAppuntoPanel);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 105, 0, 0);
        gbc2.anchor = GridBagConstraints.CENTER;
        recensioniPanel.add(recensioni, gbc2);
        
        valuta = new JButton("Vota");
        valuta.setForeground(new Color(43,122,219));
        valuta.setBorder(new LineBorder(new Color(43,122,219), 1, true));
        valuta.setBackground(Color.white);
        valuta.setFont(new Font("Century Gothic", Font.BOLD, 15));
        valuta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ValutaAppuntoFrame valutaAppuntoFrame = new ValutaAppuntoFrame();
                valutaAppuntoFrame.apri();
            }
        });
        
        try {
            if((ControlloQuery.controlloValutazioneAppunto())&&(!Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail()))){       
                
                gbc2.gridx = 2;
                gbc2.gridy = 0;
                gbc2.insets = new Insets(0, 200, 0, 0);
                gbc2.anchor = GridBagConstraints.LINE_END;
                recensioniPanel.add(valuta, gbc2);
                
            }
            else{
                JPanel empty = new JPanel();
                empty.setBackground(Color.white);
                empty.setPreferredSize(new Dimension(50,30));
                gbc2.gridx = 2;
                gbc2.gridy = 0;
                gbc2.insets = new Insets(0, 200, 0, 0);
                gbc2.anchor = GridBagConstraints.LINE_END;
                recensioniPanel.add(empty, gbc2);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo della valutazione dell'appunto");
        }
        
        JLabel email = new JLabel("Caricato da: "+Applicazione.appuntoAttuale.getStudente());
        email.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(email, gbc);
        
        JTextArea descrizione = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descrizione.setBackground(new Color(239,242,243));
        scrollPanel = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(300, 150));
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        descrizione.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(scrollPanel, gbc);
        
        Icon scaricaNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        JButton scarica = new JButton(scaricaNormal);
        scarica.setBorder(BorderFactory.createEmptyBorder());
        scarica.setContentAreaFilled(false);
        Icon scaricaHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        scarica.setRolloverIcon(scaricaHover);
        Icon scaricaPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        scarica.setPressedIcon(scaricaPressed);
        scarica.setText("DOWNLOAD");
        scarica.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        scarica.setForeground(Color.white);
        scarica.setIconTextGap(-96);
        scarica.setPreferredSize(new Dimension(110, 40));
        
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
        
        DownloadFileAppunto download = new DownloadFileAppunto(elimina, elimina);
        scarica.addActionListener(download);
        
        elimina.setBackground(new Color(249,123,123));
        EliminaAppunto eliminaAppunto = new EliminaAppunto(elimina, elimina);
        elimina.addActionListener(eliminaAppunto);
        
        panel.add(scarica);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(scarica, gbc);
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            panel.add(elimina);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(elimina, gbc);
        }
        
        JScrollPane scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 380));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(preferitiPanel);
        add(recensioniPanel);
        add(scrollPanel1);
        
    }
}
