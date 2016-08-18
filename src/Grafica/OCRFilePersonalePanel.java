package Grafica;

import Application.Applicazione;
import Ascoltatori.Appunti.doOCR;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import Utility.EsportaFile;
import java.awt.GridLayout;
import javax.swing.JComboBox;

/**
 *
 * @author aless
 */
public class OCRFilePersonalePanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    
    private static JTextField percorsoFile;
    private static JTextArea testo = new JTextArea("");
    private JButton ocr, esporta, scegliFile;
    private JFileChooser fileChooser;
    private File fileAppunto = null;
    private boolean filePersonale = true;
    private JComboBox<String> lingua;
    
    //dichiarazione pannelli
    private JPanel sceltaFilePanel, testoPanel, pannelloPrincipale, bottoniPanel, linguaPanel;
    private TopPanel top;
    private JScrollPane scrollPanelTesto;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione icone
    private Icon bottoneNormale, aggiungiHover, aggiungiPressed;
    
    //dichiarazione ascoltatori
    private doOCR doOcr;
    
    
    public OCRFilePersonalePanel() {
        
        //inizializzazione icone
        bottoneNormale = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonNormal.png"));
        aggiungiHover = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonHover.png"));
        aggiungiPressed = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonPressed.png"));
        
        //inizializzazione bottoni - label - textarea
        testo.setEditable(false);
        percorsoFile = new JTextField(18);
        ocr = new JButton(bottoneNormale);
        esporta = new JButton(bottoneNormale);
        fileChooser = new JFileChooser();
        scegliFile = new JButton("Scegli File");
        lingua = new JComboBox<>(new String[] {"Italiano", "Inglese"});
        
        //inizializzazione pannelli
        top = new TopPanel("OCR appunto");
        pannelloPrincipale = new JPanel(new GridBagLayout());
        linguaPanel = new JPanel();
        sceltaFilePanel = new JPanel();
        testoPanel = new JPanel();
        bottoniPanel = new JPanel(new GridLayout(2, 1, 15, 50));
        bottoniPanel.setSize(120, 300);
        gbc = new GridBagConstraints();
        scrollPanelTesto = new JScrollPane(testo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //creazione componenti - pannelli
        creaComponenti();
        creaPannelloCentrale();
        creaPannelloPrincipale();
        
    }
    
    public void creaComponenti(){
        
        sceltaFilePanel.setBackground(Color.white);
        percorsoFile.setBackground(Color.white);
        percorsoFile.setForeground(Color.BLACK);
        percorsoFile.setText("");
        percorsoFile.setEditable(false);
        
        testoPanel.setBackground(Color.white);
        testo.setBackground(Color.white);
        testo.setForeground(Color.BLACK);
        
        bottoniPanel.setBackground(Color.white);
        
        scrollPanelTesto.setBackground(Color.white);
        scrollPanelTesto.setBorder(new LineBorder(Color.white));
        scrollPanelTesto.setVerticalScrollBar(new CustomScrollBar());
        
        sceltaFilePanel.setBorder(BorderFactory.createTitledBorder("Appunto da convertire:"));
        testoPanel.setBorder(BorderFactory.createTitledBorder("Testo convertito:"));
        testoPanel.setSize(450 , 300);
        
        linguaPanel.setBackground(Color.white);
        linguaPanel.setBorder(BorderFactory.createTitledBorder("Lingua: "));
        
        percorsoFile.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
        testo.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        testo.setLineWrap(true);
        testo.setWrapStyleWord(true);
        
        ocr.setBorder(BorderFactory.createEmptyBorder());
        ocr.setContentAreaFilled(false);
        ocr.setRolloverIcon(aggiungiHover);
        ocr.setPressedIcon(aggiungiPressed);
        ocr.setText("OCR");
        ocr.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        ocr.setHorizontalTextPosition(JButton.CENTER);
        ocr.setVerticalTextPosition(JButton.CENTER);
        ocr.setPreferredSize(new Dimension(110, 40));
        ocr.setEnabled(false);
        
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
        linguaPanel.add(lingua);
        
        percorsoFile.setEditable(false);
        scegliFile.addActionListener((ActionEvent e) -> {
            fileChooser.showOpenDialog(null);
            fileAppunto = fileChooser.getSelectedFile();
            
            if(fileAppunto != null){
                percorsoFile.setText(fileAppunto.getAbsolutePath());
                ocr.setEnabled(true);
                ocr.setText("OCR");
                ocr.setFont(new Font("Century Gothic", Font.PLAIN, 14));
                ocr.setHorizontalTextPosition(JButton.CENTER);
                ocr.setVerticalTextPosition(JButton.CENTER);
                String language = (String) lingua.getSelectedItem();
                if(language.equals("Italiano")){
                    language = "ita";
                }else language = "eng";
                doOcr = new doOCR(filePersonale, percorsoFile.getText(), ocr, testo, language);
                ocr.addActionListener(doOcr);
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        sceltaFilePanel.add(percorsoFile);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        sceltaFilePanel.add(scegliFile);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.LINE_START;
        pannelloPrincipale.add(sceltaFilePanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(linguaPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        testoPanel.add(scrollPanelTesto);
        pannelloPrincipale.add(testoPanel, gbc);
        
        bottoniPanel.add(ocr);
        bottoniPanel.add(esporta);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(bottoniPanel, gbc);
        
        esporta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    if((fileAppunto != null)&&(!testo.getText().equals(""))){
                        EsportaFile esportaFile = new EsportaFile(testo, fileAppunto.getName());
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
        percorsoFile.setText("");
    }
    
}
