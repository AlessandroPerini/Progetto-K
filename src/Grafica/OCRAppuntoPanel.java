/*
* Pannello dedicato alla conversione dell'appunto tramite OCR.
*/
package Grafica;

import Application.Applicazione;
import Ascoltatori.Appunti.OcrAscoltatore;
import Utility.EsportaFile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author aless
 */
public class OCRAppuntoPanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    
    private static JTextField titolo;
    private static JTextArea testo = new JTextArea();
    private JButton ocrButton, esporta;
    private JRadioButton velocità;
    private JRadioButton precisione;
    private ButtonGroup bg = new ButtonGroup();
    
    //dichiarazione pannelli
    private JPanel titoloPanel, testoPanel, bottoniPanel, pannelloPrincipale, radioPanel, destraPanel;
    private TopPanel top;
    private JScrollPane scrollPanelTesto;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione icone
    private Icon bottoneNormale, aggiungiHover, aggiungiPressed;
    
    //dichiarazione ascoltatori
    private OcrAscoltatore ocrAscoltatore;
    
    
    public OCRAppuntoPanel() {
        
        //inizializzazione icone
        bottoneNormale = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonNormal.png"));
        aggiungiHover = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonHover.png"));
        aggiungiPressed = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonPressed.png"));
        
        //inizializzazione bottoni - label - textarea
        testo = new JTextArea("");
        testo.setEditable(false);
        titolo = new JTextField(26);
        ocrButton = new JButton(bottoneNormale);
        esporta = new JButton(bottoneNormale);
        velocità = new JRadioButton("Velocità", true);
        precisione = new JRadioButton("Precisione");
        
        //inizializzazione pannelli
        top = new TopPanel("OCR appunto");
        pannelloPrincipale = new JPanel(new GridBagLayout());
        titoloPanel = new JPanel();
        testoPanel = new JPanel();
        bottoniPanel = new JPanel(new GridLayout(2, 1, 15, 50));
        bottoniPanel.setSize(120, 300);
        gbc = new GridBagConstraints();
        scrollPanelTesto = new JScrollPane(testo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        radioPanel = new JPanel(new GridLayout(2, 1, 0, 0));
        destraPanel = new JPanel(new GridLayout(2, 1, 15, 50));
        
        //creazione componenti - pannelli
        creaComponenti();
        
        creaPannelloCentrale();
        creaPannelloPrincipale();
        
    }
    
    public void creaComponenti(){
        
        titoloPanel.setBackground(Color.white);
        titolo.setBackground(Color.white);
        titolo.setForeground(Color.BLACK);
        titolo.setText(applicazione.appuntoAttuale.getNome());
        titolo.setEditable(false);
        
        testoPanel.setBackground(Color.white);
        testo.setBackground(Color.white);
        testo.setForeground(Color.BLACK);
        
        bottoniPanel.setBackground(Color.white);
        
        velocità.setBackground(Color.white);
        precisione.setBackground(Color.white);
        
        bg.add(velocità);
        bg.add(precisione);
        
        destraPanel.setBackground(Color.white);
        
        radioPanel.setBackground(Color.white);
        radioPanel.setBorder(BorderFactory.createTitledBorder("Priorità alla "));
        
        scrollPanelTesto.setBackground(Color.white);
        scrollPanelTesto.setBorder(new LineBorder(Color.white));
        scrollPanelTesto.setVerticalScrollBar(new CustomScrollBar());
        
        titoloPanel.setBorder(BorderFactory.createTitledBorder("Appunto da convertire:"));
        testoPanel.setBorder(BorderFactory.createTitledBorder("Testo convertito:"));
        testoPanel.setSize(450 , 300);
        
        titolo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        testo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        testo.setLineWrap(true);
        testo.setWrapStyleWord(true);
        testo.setText("");
        
        ocrButton.setBorder(BorderFactory.createEmptyBorder());
        ocrButton.setContentAreaFilled(false);
        ocrButton.setRolloverIcon(aggiungiHover);
        ocrButton.setPressedIcon(aggiungiPressed);
        ocrButton.setText("OCR");
        ocrButton.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        ocrButton.setHorizontalTextPosition(JButton.CENTER);
        ocrButton.setVerticalTextPosition(JButton.CENTER);
        ocrButton.setPreferredSize(new Dimension(110, 40));
        ocrButton.setEnabled(true);
        
        esporta.setBorder(BorderFactory.createEmptyBorder());
        esporta.setContentAreaFilled(false);
        esporta.setRolloverIcon(aggiungiHover);
        esporta.setPressedIcon(aggiungiPressed);
        esporta.setText("Esporta .txt");
        esporta.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        esporta.setHorizontalTextPosition(JButton.CENTER);
        esporta.setVerticalTextPosition(JButton.CENTER);
        esporta.setPreferredSize(new Dimension(110, 40));
        esporta.setEnabled(true);
        
    }
    
    public void creaPannelloCentrale(){
        
        testoPanel.add(scrollPanelTesto);
        radioPanel.add(velocità);
        radioPanel.add(precisione);
        destraPanel.add(radioPanel);
        destraPanel.add(bottoniPanel);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        titoloPanel.add(titolo);
        pannelloPrincipale.add(titoloPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        testoPanel.add(scrollPanelTesto);
        
        pannelloPrincipale.add(testoPanel, gbc);
        
        bottoniPanel.add(ocrButton);
        bottoniPanel.add(esporta);
        
        bottoniPanel.add(ocrButton);
        bottoniPanel.add(esporta);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(destraPanel, gbc);
        
        
        ocrButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String priorità;
                if(velocità.isSelected()){
                    priorità = "Velocità";
                }else priorità = "Precisione";
                OcrAscoltatore doOCR = new OcrAscoltatore(priorità, ocrButton, testo);
                doOCR.actionPerformed(e);
            }
        });
        
        esporta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    if(!testo.getText().equals("")){
                        EsportaFile esportaFile = new EsportaFile(testo);
                        esportaFile.esportaFile();
                        JOptionPane.showMessageDialog(null, "File esportato! Lo trovi nella cartella dei tuoi Downloads", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(null, "Prima di esportare è necessario convertire il file", "Attenzione", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante l'esportazione del file", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
    }
    
    public void creaPannelloPrincipale(){
        
        top.setBackground(Color.white);
        
        setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);
        
        scrollPanelTesto.setPreferredSize(new Dimension(450 , 300));
        
        add(top);
        add(pannelloPrincipale);
    }
    
    public static void clearForm(){
        
        testo.setText("");
        titolo.setText("");
    }
    
}