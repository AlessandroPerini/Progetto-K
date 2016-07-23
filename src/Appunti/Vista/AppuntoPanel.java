/*
* Pannello dedicato all'download di un appunto.
* Si può anche valutare l'appunto oppure leggere le recensioni fatte da altri studenti
* riguardanti l'appunto in questione.
*/
package Appunti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.EliminaAppunto;
import Appunti.Ascoltatori.GoToRecensioniAppuntoPanel;
import Appunti.Ascoltatori.DownloadFileAppunto;
import Database.Query.ControlloQuery;
import Valutazioni.Vista.ValutaAppuntoFrame;
import Header.Vista.TopPanel;
import Preferiti.Ascoltatori.AggiungiAppuntoPreferito;
import Preferiti.Ascoltatori.RimuoviAppuntoPreferito;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
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
    
    public Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione bottoni - textarea - label
    private JButton valuta, recensioni, preferitiOn , preferitiOff, scarica, elimina;
    private JTextArea descrizione;
    private JLabel media, email;
    
    //dichiarazione pannelli
    private JPanel top, pannelloPrincipale, preferitiPanel, recensioniPanel, descrizionePanel, empty;
    private JScrollPane scrollPanelDescrizione, scrollPanelPrincipale;
    
    //dichiarazione variabili
    private String mediaTagliata, s;
    
    //dichiarazione immagini
    private Icon scaricaNormal,  scaricaHover, scaricaPressed,
            eliminaNormal, eliminaHover, eliminaPressed;
    
    //dichiarazione ascoltatori
    private DownloadFileAppunto downloadAppunto;
    private EliminaAppunto eliminaAppunto;
    private AggiungiAppuntoPreferito aggiungiAppuntoPreferito;
    private RimuoviAppuntoPreferito rimuoviAppuntoPreferito;
    private GoToRecensioniAppuntoPanel goToRecensioniAppuntoPanel;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc, gbc2;
    
    public AppuntoPanel() {
        
        //dichiarazione icone
        scaricaNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        scaricaHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        scaricaPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        eliminaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        eliminaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        eliminaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        
        //inizializzazione bottoni - textarea - label
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        recensioni = new JButton("Recensioni");
        valuta = new JButton("Valuta");
        scarica = new JButton(scaricaNormal);
        elimina = new JButton(eliminaNormal);
        descrizione = new JTextArea(applicazione.appuntoAttuale.getDescrizione());
        email = new JLabel("<html><b>Caricato da: </b>"+applicazione.appuntoAttuale.getStudente()+"</html>");
        
        //inizializzazione pannelli
        pannelloPrincipale = new JPanel(new GridBagLayout());
        top = new TopPanel(applicazione.appuntoAttuale.getNome());
        preferitiPanel = new JPanel();
        recensioniPanel = new JPanel(new GridBagLayout());
        empty = new JPanel();
        descrizionePanel = new JPanel();
        scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelPrincipale = new JScrollPane(pannelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //inizializzazione actionListener
        downloadAppunto = new DownloadFileAppunto(elimina, elimina);
        aggiungiAppuntoPreferito = new AggiungiAppuntoPreferito();
        rimuoviAppuntoPreferito = new RimuoviAppuntoPreferito();
        eliminaAppunto = new EliminaAppunto(elimina, elimina);
        
        //dichiarazione variabili layout
        gbc = new GridBagConstraints();
        gbc2 = new GridBagConstraints();
        
        //creazione componenti - pannelli
        creaComponenti();
        creaPannelloPreferiti();
        creaPannelloCentrale();
        creaPannelloPrincipale();
        
    }
    
    public void creaComponenti(){
        
        scrollPanelDescrizione.setVerticalScrollBar(new CustomScrollBar());
        scrollPanelDescrizione.setPreferredSize(new Dimension(300, 150));

        recensioniPanel.setBackground(Color.white);
        recensioniPanel.setPreferredSize(new Dimension(680, 30));

        recensioni.setForeground(new Color(218,194,127));
        recensioni.setBorder(new LineBorder(new Color(218,194,118), 1));
        recensioni.setBackground(Color.white);
        recensioni.setFont(new Font("Century Gothic", Font.BOLD, 15));
        
        valuta.setForeground(new Color(43,122,219));
        valuta.setBorder(new LineBorder(new Color(43,122,219), 1));
        valuta.setBackground(Color.white);
        valuta.setFont(new Font("Century Gothic", Font.BOLD, 15));
        
        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        descrizionePanel.add(scrollPanelDescrizione);
        
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
        scarica.setHorizontalTextPosition(JButton.CENTER);
        scarica.setVerticalTextPosition(JButton.CENTER);
        scarica.setPreferredSize(new Dimension(110, 40));
        
        elimina.setBorder(BorderFactory.createEmptyBorder());
        elimina.setContentAreaFilled(false);
        elimina.setRolloverIcon(eliminaHover);
        elimina.setPressedIcon(eliminaPressed);
        elimina.setText("ELIMINA");
        elimina.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        elimina.setForeground(Color.white);
        elimina.setHorizontalTextPosition(JButton.CENTER);
        elimina.setVerticalTextPosition(JButton.CENTER);
        elimina.setPreferredSize(new Dimension(110, 40));
        elimina.setBackground(new Color(249,123,123));

    }
    
    public void creaPannelloPreferiti(){
        
        preferitiPanel.setBackground(Color.white);
        preferitiPanel.setPreferredSize(new Dimension(650, 35));
        
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));

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
    }
    
    public void creaPannelloCentrale(){
        
        mediaTagliata = Float.toString(applicazione.appuntoAttuale.getMedia());
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
            if((ControlloQuery.controlloValutazioneAppunto())&&(!applicazione.appuntoAttuale.getStudente().equals(applicazione.guest.getEmail()))){
                
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
        pannelloPrincipale.add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(descrizionePanel, gbc);
        
        scarica.addActionListener(downloadAppunto);
        elimina.addActionListener(eliminaAppunto);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(scarica, gbc);
        
        if (applicazione.appuntoAttuale.getStudente().equals(applicazione.guest.getEmail())) {
            
            pannelloPrincipale.add(elimina);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            pannelloPrincipale.add(elimina, gbc);
        }
    }
    
    public void creaPannelloPrincipale(){
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);

        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 380));
        scrollPanelPrincipale.getVerticalScrollBar().setUnitIncrement(16);
        scrollPanelPrincipale.setVerticalScrollBar(new CustomScrollBar());
        
        add(top);
        add(preferitiPanel);
        add(recensioniPanel);
        add(scrollPanelPrincipale);
    }
}
