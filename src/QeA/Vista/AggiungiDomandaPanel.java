/*
* Pannello dedicato all'inserimento di unanuova domanda
*/
package QeA.Vista;

import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import QeA.Ascoltatori.AggiungiDomanda;
import Utils.Vista.CustomScrollBar;
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
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class AggiungiDomandaPanel extends JPanel{
    
    //dichiarazione textarea - bottoni
    private static JTextArea nome, descrizione;
    private JButton  aggiungi;
    
    //dichiarazione pannelli
    private JPanel nomePanel, descrizionePanel, panelloPrincipale;
    private TopPanel top;
    private JScrollPane scrollPanelNome, scrollPanelDescrizione, scrollPanelPrincipale;
    
    //dichiarazione icone
    private Icon aggiungiNormal, aggiungiHover, aggiungiPressed;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione ascoltatori
    private AggiungiDomanda aggiungiDomanda;
    
    public AggiungiDomandaPanel() {
     
        //inizializzazione icone
        aggiungiNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        aggiungiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        aggiungiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        
        //inizializzazione bottoni - textarea
        nome = new JTextArea("");
        descrizione = new JTextArea("");
        aggiungi = new JButton(aggiungiNormal);
        
        //inizializzazione pannelli
        top = new TopPanel("Aggiungi Domanda in '"+Applicazione.corsoAttuale.getNome()+"'");
        gbc = new GridBagConstraints();
        panelloPrincipale = new JPanel(new GridBagLayout());
        nomePanel = new JPanel();
        descrizionePanel = new JPanel();
        scrollPanelNome = new JScrollPane(nome, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelPrincipale = new JScrollPane(panelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
       
        //creazione pannelli
        creaPannelloCentrale();
        creaPannelloPrincipale();

    }
    
    public void creaPannelloCentrale(){

        nomePanel.setBackground(Color.white);
        descrizionePanel.setBackground(Color.white);
        
        nomePanel.setBorder(BorderFactory.createTitledBorder("Titolo"));
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        nome.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        
        nome.setBackground(Color.white);
        nome.setForeground(Color.BLACK);
        descrizione.setBackground(Color.white);
        descrizione.setForeground(Color.BLACK);
        
        scrollPanelNome.setBackground(Color.white);
        scrollPanelNome.setBorder(new LineBorder(Color.white));
        scrollPanelNome.setVerticalScrollBar(new CustomScrollBar());
        
        scrollPanelDescrizione.setBackground(Color.white);
        scrollPanelDescrizione.setBorder(new LineBorder(Color.white));
        scrollPanelDescrizione.setVerticalScrollBar(new CustomScrollBar());
        
        scrollPanelNome.setPreferredSize(new Dimension(250, 50));
        scrollPanelDescrizione.setPreferredSize(new Dimension(250, 150));
        
        nomePanel.add(scrollPanelNome);
        descrizionePanel.add(scrollPanelDescrizione);
        
        nome.setLineWrap(true);
        nome.setWrapStyleWord(true);
        
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(-10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(nomePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(descrizionePanel, gbc);
        
        aggiungi.setBorder(BorderFactory.createEmptyBorder());
        aggiungi.setContentAreaFilled(false);
        aggiungi.setRolloverIcon(aggiungiHover);
        aggiungi.setPressedIcon(aggiungiPressed);
        aggiungi.setText("AGGIUNGI");
        aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        aggiungi.setForeground(Color.white);
        aggiungi.setIconTextGap(-88);
        aggiungi.setPreferredSize(new Dimension(110, 40));
        
        aggiungiDomanda = new AggiungiDomanda(nome, descrizione);
        aggiungi.addActionListener(aggiungiDomanda); 
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(50, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(aggiungi, gbc);
        
    }
    
    public void creaPannelloPrincipale(){

        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 450));
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        panelloPrincipale.setBackground(Color.white);
        
        add(top);
        add(scrollPanelPrincipale);
    }
    
    public static void clearForm(){
        
        nome.setText("");
        descrizione.setText("");
    }
}

