/*
 * Pannello contenente le informazioni relative al libro selezionato
 * E' inoltre possibile eliminare il libro se si è colui che l'ha caricato
 */
package Libri.Vista;

import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.EliminaLibro;
import Preferiti.Ascoltatori.AggiungiLibroPreferito;
import Preferiti.Ascoltatori.RimuoviLibroPreferito;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author cl410688
 */
public class LibroPanel extends JPanel{

    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione pannelli
    private JPanel top, panelloPrincipale, preferitiPanel, descrizionePanel;
    private JScrollPane scrollDescrizione, scrollPanelPrincipale;
    
    //dichiarazione label - textarea - buttoni
    private JLabel email, telefono, prezzo;
    private JTextArea descrizione;
    private JButton preferitiOn, preferitiOff, elimina; 
    
    //dichiarazione ascoltatori
    private AggiungiLibroPreferito aggiungiLibroPreferito;
    private RimuoviLibroPreferito rimuoviLibroPreferito;
    private EliminaLibro eliminaLibro;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc, gbc2;
    
    public LibroPanel() {
        
        //inizializzazione label - textarea - bottoni
        email = new JLabel("<html><b>Caricato da: </b>"+applicazione.libroAttuale.getStudente()+"</html>");
        telefono = new JLabel("<html><b>Telefono: </b>"+applicazione.libroAttuale.getTelefono()+"</html>");
        prezzo = new JLabel("<html><b>Prezzo: </b>"+applicazione.libroAttuale.getPrezzo()+" €</html>");
        descrizione = new JTextArea(applicazione.libroAttuale.getDescrizione());
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        elimina = new JButton(new ImageIcon(getClass().getResource("/immagini/deleteNormal.png")));
        
        //inizializzazione pannelli
        top = new TopPanel(applicazione.libroAttuale.getTitolo());
        panelloPrincipale = new JPanel(new GridBagLayout());
        preferitiPanel = new JPanel();
        descrizionePanel = new JPanel();
        scrollDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelPrincipale = new JScrollPane(panelloPrincipale, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //inizializzazione ascoltatori
        aggiungiLibroPreferito = new AggiungiLibroPreferito();
        rimuoviLibroPreferito = new RimuoviLibroPreferito();
        eliminaLibro = new EliminaLibro();

        //inizializzazione variabili layout
        gbc = new GridBagConstraints();
        gbc2 = new GridBagConstraints();

        //creazione pannelli
        creaPannelloPreferiti();
        creaPannelloInfoLibro();
        creaButtoneElimina();
        creaPannelloPrincipale();
        
    }
    
    public void creaPannelloPreferiti(){

        preferitiPanel.setPreferredSize(new Dimension(650, 35));
        
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        preferitiOff.addActionListener(aggiungiLibroPreferito);
      
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
        }
    }
    
    public void creaPannelloInfoLibro(){
    
        email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(email, gbc);
        
        telefono.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(telefono, gbc);
        
        prezzo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(prezzo, gbc);

        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descrizione.setBackground(new Color(239,242,243));
        scrollDescrizione.setPreferredSize(new Dimension(300, 150));
        scrollDescrizione.setVerticalScrollBar(new CustomScrollBar());
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        descrizione.setEditable(false);
        descrizionePanel.add(scrollDescrizione);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(descrizionePanel, gbc);
    }
    
    public void creaButtoneElimina(){
        
        elimina.setBorder(BorderFactory.createEmptyBorder());
        elimina.setContentAreaFilled(false);
        elimina.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/deleteHover.png")));
        elimina.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/deletePressed.png")));
        elimina.setText("ELIMINA");
        elimina.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        elimina.setForeground(Color.white);
        elimina.setIconTextGap(-81);
        elimina.setPreferredSize(new Dimension(110, 40));
        
        elimina.setBackground(new Color(249,123,123));
        elimina.addActionListener(eliminaLibro);

        if (applicazione.libroAttuale.getStudente().equals(applicazione.guest.getEmail())) {
            
            panelloPrincipale.add(elimina);
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.insets = new Insets(30, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            panelloPrincipale.add(elimina, gbc);
        }
    }
    
    public void creaPannelloPrincipale(){
    
        setBackground(Color.white);
        top.setBackground(Color.white);
        preferitiPanel.setBackground(Color.white);
        panelloPrincipale.setBackground(Color.white);
        scrollPanelPrincipale.setBackground(Color.white);
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 415));
        
        add(top);
        add(preferitiPanel);
        add(scrollPanelPrincipale);
    }
    
}
    

