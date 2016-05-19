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
import Valutazione.Vista.ValutaAppuntoFrame;
import Header.Vista.TopPanel;
import Preferiti.Ascoltatori.AggiungiAppuntoPreferito;
import Preferiti.Ascoltatori.RimuoviAppuntoPreferito;
import Utils.CustomScrollbarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author Te4o
 */
public class AppuntoPanel extends JPanel{
    
    private JButton valuta, recensioni, preferitiOn , preferitiOff, scarica, elimina;
    private JPanel top, panel, preferitiPanel, recensioniPanel, descrizionePanel, empty;
    private JTextArea descrizione;
    private JLabel media, email;
    private JScrollPane scrollPanel, scrollPanel1;
    private GridBagConstraints gbc, gbc2;
    private AggiungiAppuntoPreferito aggiungiAppuntoPreferito;
    private RimuoviAppuntoPreferito rimuoviAppuntoPreferito;
    private GoToRecensioniAppuntoPanel goToRecensioniAppuntoPanel;
    private String mediaTagliata, s;
    private Icon scaricaNormal,  scaricaHover, scaricaPressed,
            eliminaNormal, eliminaHover, eliminaPressed;
    private DownloadFileAppunto download;
    private EliminaAppunto eliminaAppunto;
    
    public AppuntoPanel() {
        //dichiarazione panel
        panel = new JPanel(new GridBagLayout());
        top = new TopPanel(Applicazione.appuntoAttuale.getNome());
        preferitiPanel = new JPanel();
        recensioniPanel = new JPanel(new GridBagLayout());
        empty = new JPanel();
        descrizionePanel = new JPanel();
        gbc = new GridBagConstraints();
        gbc2 = new GridBagConstraints();
        
        //dichiarazione icon
        scaricaNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        scaricaHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        scaricaPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        eliminaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        eliminaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        eliminaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        
        //dichiarazione button
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        recensioni = new JButton("Recensioni");
        valuta = new JButton("Valuta");
        scarica = new JButton(scaricaNormal);
        elimina = new JButton(eliminaNormal);
        descrizione = new JTextArea(Applicazione.appuntoAttuale.getDescrizione());
        email = new JLabel("<html><b>Caricato da: </b>"+Applicazione.appuntoAttuale.getStudente()+"</html>");
        
        scrollPanel = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBackground(Color.white);
        scrollBar.setPreferredSize(new Dimension(13, 0));
        scrollBar.setUI(new CustomScrollbarUI());
        scrollBar.setUnitIncrement(16);
        scrollPanel.setVerticalScrollBar(scrollBar);
        
        scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //dichiarazione actionListener
        download = new DownloadFileAppunto(elimina, elimina);
        aggiungiAppuntoPreferito = new AggiungiAppuntoPreferito();
        rimuoviAppuntoPreferito = new RimuoviAppuntoPreferito();
        eliminaAppunto = new EliminaAppunto(elimina, elimina);
        
        initComponent();
        
        //preferito
        preferitiOff.addActionListener(aggiungiAppuntoPreferito);
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
        }
        //fine zona preferito
        
        mediaTagliata = Float.toString(Applicazione.appuntoAttuale.getMedia());
        s = mediaTagliata.replace(".", ",");
        String parts[] = s.split(",");
        mediaTagliata = parts[0]+"."+parts[1].charAt(0);
        media = new JLabel("Punteggio: "+mediaTagliata+" / 5   ");
        
        media.setFont(new Font("Century Gothic", Font.BOLD, 15));
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 0, 0, 0);
        gbc2.anchor = GridBagConstraints.LINE_START;
        recensioniPanel.add(media, gbc2);
        
        goToRecensioniAppuntoPanel = new GoToRecensioniAppuntoPanel();
        recensioni.addActionListener(goToRecensioniAppuntoPanel);
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 110, 0, 0);
        gbc2.anchor = GridBagConstraints.CENTER;
        recensioniPanel.add(recensioni, gbc2);
        
        valuta.addActionListener((ActionEvent e) -> {
            ValutaAppuntoFrame valutaAppuntoFrame = new ValutaAppuntoFrame();
            valutaAppuntoFrame.apri();
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
        
        email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(descrizionePanel, gbc);
        
        scarica.addActionListener(download);
        elimina.addActionListener(eliminaAppunto);
        
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
        
        
        add(top);
        add(preferitiPanel);
        add(recensioniPanel);
        add(scrollPanel1);
        
    }
    public void initComponent(){
        setBackground(Color.white);
        top.setBackground(Color.white);
        panel.setBackground(Color.white);
        
        preferitiPanel.setBackground(Color.white);
        preferitiPanel.setPreferredSize(new Dimension(650, 35));
        
        recensioniPanel.setBackground(Color.white);
        recensioniPanel.setPreferredSize(new Dimension(680, 30));
        
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        recensioni.setForeground(new Color(218,194,127));
        recensioni.setBorder(new LineBorder(new Color(218,194,118), 1));
        recensioni.setBackground(Color.white);
        recensioni.setFont(new Font("Century Gothic", Font.BOLD, 15));
        
        valuta.setForeground(new Color(43,122,219));
        valuta.setBorder(new LineBorder(new Color(43,122,219), 1));
        valuta.setBackground(Color.white);
        valuta.setFont(new Font("Century Gothic", Font.BOLD, 15));
        
        scrollPanel.setPreferredSize(new Dimension(300, 150));
        
        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        descrizionePanel.add(scrollPanel);
        
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descrizione.setBackground(new Color(239,242,243));
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        descrizione.setEditable(false);
        
        scarica.setBorder(BorderFactory.createEmptyBorder());
        scarica.setContentAreaFilled(false);
        scarica.setRolloverIcon(scaricaHover);
        scarica.setPressedIcon(scaricaPressed);
        scarica.setText("DOWNLOAD");
        scarica.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        scarica.setForeground(Color.white);
        scarica.setIconTextGap(-96);
        scarica.setPreferredSize(new Dimension(110, 40));
        
        elimina.setBorder(BorderFactory.createEmptyBorder());
        elimina.setContentAreaFilled(false);
        elimina.setRolloverIcon(eliminaHover);
        elimina.setPressedIcon(eliminaPressed);
        elimina.setText("ELIMINA");
        elimina.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        elimina.setForeground(Color.white);
        elimina.setIconTextGap(-81);
        elimina.setPreferredSize(new Dimension(110, 40));
        elimina.setBackground(new Color(249,123,123));
        
        scrollPanel1.setPreferredSize(new Dimension(650, 380));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
    }
}
