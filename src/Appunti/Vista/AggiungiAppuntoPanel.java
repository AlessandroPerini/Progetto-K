/*
* Pannello dedicato all'inserimento di un nuovo appunto.
* L'appunto potrà essere selezionato dal proprio PC
* e aggiunto sulla piattaforma DropBox
*/
package Appunti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.AggiungiAppunto;
import Header.Vista.TopPanel;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class AggiungiAppuntoPanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private static JTextArea nome, descrizione;
    private static JTextField persorsoFile;
    private JFileChooser fileChooser;
    private File fileAppunto;
    private JButton scegliFile, aggiungi;
    
    //dichiarazione pannelli
    private JPanel filePanel, nomePanel, descrizionePanel, pannelloPrincipale;
    private TopPanel top;
    private JScrollPane scrollPanelNome, scrollPanelPrincipale,scrollPanelDescrizione;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione icone
    private Icon aggiungiNormal, aggiungiHover, aggiungiPressed;
    
    //dichiarazione ascoltatori
    private AggiungiAppunto aggiungiAppunto;
    
    public AggiungiAppuntoPanel() {
        
        //inizializzazione icone
        aggiungiNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        aggiungiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        aggiungiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        
        //inizializzazione bottoni - label - textarea
        nome = new JTextArea("");
        descrizione = new JTextArea("");
        persorsoFile = new JTextField(18);
        aggiungi = new JButton(aggiungiNormal);
        fileChooser = new JFileChooser();
        scegliFile = new JButton("Scegli File");
        fileAppunto = new File("");
        
        //inizializzazione pannelli
        top = new TopPanel("Aggiungi Appunto in '"+applicazione.corsoAttuale.getNome()+"'");
        pannelloPrincipale = new JPanel(new GridBagLayout());
        nomePanel = new JPanel();
        descrizionePanel = new JPanel();
        filePanel = new JPanel();
        gbc = new GridBagConstraints();
        scrollPanelNome = new JScrollPane(nome, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelPrincipale = new JScrollPane(pannelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //creazione componenti - pannelli
        creaComponenti();
        
        creaPannelloCentrale();
        creaPannelloPrincipale();
 
    }
    
    public void creaComponenti(){
        
        descrizionePanel.setBackground(Color.white);
        nome.setBackground(Color.white);
        descrizione.setBackground(Color.white);
        nome.setForeground(Color.BLACK);
        descrizione.setForeground(Color.BLACK);
        nomePanel.setBackground(Color.white);
        aggiungi.setForeground(Color.white);
        
        scrollPanelNome.setBackground(Color.white);
        scrollPanelNome.setBorder(new LineBorder(Color.white));
        scrollPanelNome.setVerticalScrollBar(new CustomScrollBar());
        
        scrollPanelDescrizione.setBackground(Color.white);
        scrollPanelDescrizione.setBorder(new LineBorder(Color.white));
        scrollPanelDescrizione.setVerticalScrollBar(new CustomScrollBar());
        
        persorsoFile.setBackground(Color.white );
        persorsoFile.setBackground(Color.white);
        persorsoFile.setForeground(Color.BLACK);
        
        nomePanel.setBorder(BorderFactory.createTitledBorder("Nome"));
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        nome.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        nome.setLineWrap(true);
        nome.setWrapStyleWord(true);
        
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);

        aggiungi.setBorder(BorderFactory.createEmptyBorder());
        aggiungi.setContentAreaFilled(false);
        aggiungi.setRolloverIcon(aggiungiHover);
        aggiungi.setPressedIcon(aggiungiPressed);
        aggiungi.setText("UPLOAD");
        aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        aggiungi.setHorizontalTextPosition(JButton.CENTER);
        aggiungi.setVerticalTextPosition(JButton.CENTER);
        aggiungi.setPreferredSize(new Dimension(110, 40));
        aggiungi.setEnabled(false);
    }
    
    public void creaPannelloCentrale(){
        
        nomePanel.add(scrollPanelNome);
        descrizionePanel.add(scrollPanelDescrizione);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(nomePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(descrizionePanel, gbc);
        
        //metodo per l'aggiunta dei file
        persorsoFile.setEditable(false);
        scegliFile.addActionListener((ActionEvent e) -> {
            fileChooser.showOpenDialog(null);
            fileAppunto = fileChooser.getSelectedFile();
            
            if(fileAppunto != null){
                persorsoFile.setText(fileAppunto.getAbsolutePath());
                aggiungi.setEnabled(true);
                aggiungi.setText("UPLOAD");
                aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 14));
                aggiungi.setHorizontalTextPosition(JButton.CENTER);
                aggiungi.setVerticalTextPosition(JButton.CENTER);
                aggiungiAppunto = new AggiungiAppunto(nome, descrizione, fileAppunto, aggiungi, scegliFile);
                aggiungi.addActionListener(aggiungiAppunto);
            }
        });
        
        filePanel.add(persorsoFile);
        filePanel.add(scegliFile);
        filePanel.setBorder(BorderFactory.createTitledBorder("File"));
        filePanel.setBackground(Color.white);
        //fine file
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(filePanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(40, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(aggiungi, gbc);
    }
    
    public void creaPannelloPrincipale(){
        
        top.setBackground(Color.white);
        setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 450));
        scrollPanelNome.setPreferredSize(new Dimension(250, 50));
        scrollPanelDescrizione.setPreferredSize(new Dimension(250, 100));
        
        add(top);
        add(scrollPanelPrincipale);
    }
    
    public static void clearForm(){
        
        nome.setText("");
        descrizione.setText("");
    }
    
}
