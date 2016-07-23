/*
* Pagina con il form per l'aggiunta di un nuovo libro
*/
package Libri.Vista;

import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.AggiungiLibro;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    
    public Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private static JTextArea nome, descrizione;
    private JButton aggiungi;
    private JSpinner prezzo;
    private SpinnerNumberModel prezzoModel;
    private JCheckBox telefono;
    private JLabel euro;
    
    //dichiarazione pannelli
    private JPanel top, panelloPrincipale, prezzoPanel, nomePanel, descrizionePanel;
    private JScrollPane scrollPanelNome, scrollPanelDescrizione, scrollPanelPrincipale;
    
    //dichiarazione ascoltatori
    private AggiungiLibro aggiungiLibro; 
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    public AggiungiLibroPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel("Aggiungi Libro in '"+applicazione.corsoAttuale.getNome()+"'");
        panelloPrincipale = new JPanel(new GridBagLayout());
        nomePanel = new JPanel();
        descrizionePanel = new JPanel();
        prezzoPanel = new JPanel();
        scrollPanelPrincipale = new JScrollPane(panelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        //inizializzazione oggetti
        nome = new JTextArea("");
        descrizione = new JTextArea("");
        telefono = new JCheckBox("Vuoi far vedere il tuo numero?");
        prezzoModel = new SpinnerNumberModel(0, 0, 999, 1);
        prezzo = new JSpinner(prezzoModel);
        euro = new JLabel("€");
        aggiungi = new JButton(new ImageIcon(getClass().getResource("/immagini/buttonNormal.png")));
        
        //inizializzazione ascoltatori
        aggiungiLibro = new AggiungiLibro(nome, descrizione, prezzo, telefono);
        
        //inizializzazione variabili layout
        gbc = new GridBagConstraints();
        
        
        //creazione pannelli
        creaPannelloNome();
        creaPannelloTelefono();
        creaPannelloPrezzo();
        creaPannelloDescrizione();
        creaPannelloBottone();
        creaPannelloPrincipale();
        
    }
    
    public void creaPannelloNome(){
        
        nomePanel.setBackground(Color.white);
        nomePanel.setBorder(BorderFactory.createTitledBorder("Titolo"));
        
        nome.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        nome.setBackground(Color.white);
        nome.setForeground(Color.BLACK);
        
        scrollPanelNome = new JScrollPane(nome, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelNome.setPreferredSize(new Dimension(250, 50));
        scrollPanelNome.setBackground(Color.white);
        scrollPanelNome.setBorder(new LineBorder(Color.white));
        scrollPanelNome.setVerticalScrollBar(new CustomScrollBar());
        nome.setLineWrap(true);
        nome.setWrapStyleWord(true);
        
        nomePanel.add(scrollPanelNome);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(nomePanel, gbc);
    }
    
    public void creaPannelloTelefono(){
        
        telefono.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        telefono.setBorder(BorderFactory.createTitledBorder("Telefono"));
        telefono.setBackground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(telefono, gbc);
    }
    
    public void creaPannelloPrezzo(){
        
        ((DefaultEditor) prezzo.getEditor()).getTextField().setEditable(false);
        prezzo.setPreferredSize(new Dimension(150, 30));
        prezzo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        prezzo.setBackground(Color.white);
        JComponent editor = prezzo.getEditor();
        JSpinner.DefaultEditor spinnerEditor = (JSpinner.DefaultEditor)editor;
        spinnerEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        
        
        euro.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        euro.setBackground(Color.white);
        
        
        prezzoPanel.add(euro);
        prezzoPanel.add(prezzo);
        prezzoPanel.setBorder(BorderFactory.createTitledBorder("Prezzo"));
        prezzoPanel.setBackground(Color.white);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(prezzoPanel, gbc);
    }
    
    public void creaPannelloDescrizione(){
        
        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        descrizione.setBackground(Color.white);
        descrizione.setForeground(Color.BLACK);
        
        scrollPanelDescrizione = new JScrollPane(descrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDescrizione.setPreferredSize(new Dimension(250, 100));
        scrollPanelDescrizione.setBackground(Color.white);
        scrollPanelDescrizione.setBorder(new LineBorder(Color.white));
        scrollPanelDescrizione.setVerticalScrollBar(new CustomScrollBar());
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        
        descrizionePanel.add(scrollPanelDescrizione);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(descrizionePanel, gbc);
    }
    
    public void creaPannelloBottone(){
        
        aggiungi.setBorder(BorderFactory.createEmptyBorder());
        aggiungi.setContentAreaFilled(false);
        aggiungi.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/buttonHover.png")));
        aggiungi.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/buttonPressed.png")));
        aggiungi.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        aggiungi.setForeground(Color.white);
        aggiungi.setIconTextGap(-88);
        aggiungi.setPreferredSize(new Dimension(110, 40));
        aggiungi.setEnabled(true);
        aggiungi.setText("AGGIUNGI");
        aggiungi.addActionListener(aggiungiLibro);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panelloPrincipale.add(aggiungi, gbc);
    }
    
    public void creaPannelloPrincipale(){
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 450));
        
        add(top);
        add(scrollPanelPrincipale);
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        panelloPrincipale.setBackground(Color.white);
    }
    
    public static void clearForm(){
        
        nome.setText("");
        descrizione.setText("");
    }
}
