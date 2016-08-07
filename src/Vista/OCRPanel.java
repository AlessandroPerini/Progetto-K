/*
* Pannello dedicato alla conversione dell'appunto tramite OCR.
*/
package Vista;

import Application.Applicazione;
import Ascoltatori.Appunti.doOCR;
import utility.EsportaFile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author aless
 */
public class OCRPanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    
    private static JTextField titolo;
    private static JTextArea testo;
    private JButton ocr, esporta;
    
    //dichiarazione pannelli
    private JPanel titoloPanel, testoPanel, bottoniPanel, pannelloPrincipale;
    private TopPanel top;
    private JScrollPane scrollPanelTesto;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione icone
    private Icon bottoneNormale, aggiungiHover, aggiungiPressed;
    
    //dichiarazione ascoltatori
    private doOCR doOcr;
    
    
    public OCRPanel() {
        
        //inizializzazione icone
        bottoneNormale = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        aggiungiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        aggiungiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        
        //inizializzazione bottoni - label - textarea
        testo = new JTextArea("");
        titolo = new JTextField(18);
        ocr = new JButton(bottoneNormale);
        esporta = new JButton(bottoneNormale);
        
        //inizializzazione pannelli
        top = new TopPanel("OCR appunto");
        pannelloPrincipale = new JPanel(new GridBagLayout());
        titoloPanel = new JPanel();
        testoPanel = new JPanel();
        bottoniPanel = new JPanel();
        gbc = new GridBagConstraints();
        scrollPanelTesto = new JScrollPane(testo, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //inizializzazione actionListener
        
        doOcr = new doOCR(testo);  
        
        
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
        
        scrollPanelTesto.setBackground(Color.white);
        scrollPanelTesto.setBorder(new LineBorder(Color.white));
        scrollPanelTesto.setVerticalScrollBar(new CustomScrollBar());
        
        titoloPanel.setBorder(BorderFactory.createTitledBorder("Titolo appunto da convertire"));
        testoPanel.setBorder(BorderFactory.createTitledBorder("Testo convertito:"));
        
        titolo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        
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
        ocr.setPreferredSize(new Dimension(90, 40));
        ocr.setEnabled(true);
        
        esporta.setBorder(BorderFactory.createEmptyBorder());
        esporta.setContentAreaFilled(false);
        esporta.setRolloverIcon(aggiungiHover);
        esporta.setPressedIcon(aggiungiPressed);
        esporta.setText("Esporta .txt");
        esporta.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        esporta.setHorizontalTextPosition(JButton.CENTER);
        esporta.setVerticalTextPosition(JButton.CENTER);
        esporta.setPreferredSize(new Dimension(90, 40));
        esporta.setEnabled(true);
        
    }
    
    public void creaPannelloCentrale(){
        
        testoPanel.add(scrollPanelTesto);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        titoloPanel.add(titolo);
        pannelloPrincipale.add(titoloPanel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        testoPanel.add(testo);
        pannelloPrincipale.add(testoPanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        bottoniPanel.add(ocr);
        bottoniPanel.add(esporta);
        pannelloPrincipale.add(bottoniPanel, gbc);
        
        ocr.addActionListener(doOcr);
        esporta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    EsportaFile.esportaFile(testo);
                    JOptionPane.showMessageDialog(null, "Appunto convertito correttamente. Lo trovi nella cartella dei tuoi Downloads!", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(OCRPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void creaPannelloPrincipale(){
        
        top.setBackground(Color.white);
        setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);
        
        scrollPanelTesto.setPreferredSize(new Dimension(250, 50));
        
        add(top);
        add(pannelloPrincipale);
    }
    
    public static void clearForm(){
        
        testo.setText("");
        titolo.setText("");
    }
    
}