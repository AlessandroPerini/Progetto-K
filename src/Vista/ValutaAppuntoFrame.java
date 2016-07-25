/*
* Frame per permettere la valutazione di un appunto, tramite l'inserimento
* di un punteggio e un commento.
*/
package Vista;

import Application.Applicazione;
import Vista.Grafica;
import Ascoltatori.Valutazioni.VotaAppunto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class ValutaAppuntoFrame{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextArea commento;
    private JSlider punteggio;
    private JLabel titoloFrame;
    private JButton annulla, conferma;
    
    //dichiarazione frame - pannelli
    private JFrame valutaFrame;
    private JPanel container, mainPanel, commentoPanel, buttonPanel;
    private JScrollPane scrollPanelCommento;
    
    //dichiarazione icone
    private ImageIcon confermaNormal, confermaHover, confermaPressed, annullaNormal, annullaHover, annullaPressed;
    
    //dichiarazione ascoltatori
    private VotaAppunto votaAppunto;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc, gbc2;
    
    public ValutaAppuntoFrame() {
        this.valutaFrame = new JFrame();
    }
    
    public void apri(){

        //inizializzaione immagini
        confermaNormal = new ImageIcon(getClass().getResource("/immagini/buttonNormal.png"));
        confermaHover = new ImageIcon(getClass().getResource("/immagini/buttonHover.png"));
        confermaPressed = new ImageIcon(getClass().getResource("/immagini/buttonPressed.png"));
        annullaNormal = new ImageIcon(getClass().getResource("/immagini/deleteNormal.png"));
        annullaHover = new ImageIcon(getClass().getResource("/immagini/deleteHover.png"));
        annullaPressed = new ImageIcon(getClass().getResource("/immagini/deletePressed.png"));
        
        //inizializzazione oggetti
        titoloFrame = new JLabel("Valuta Appunto '"+applicazione.appuntoAttuale.getNome()+"'");
        commentoPanel = new JPanel();
        punteggio = new JSlider(1, 5);
        commento = new JTextArea();
        annulla = new JButton(annullaNormal);
        conferma = new JButton(confermaNormal);
        
        //inizializzazione frame - pannelli
        valutaFrame = new JFrame("Valuta Appunto");
        container = new JPanel();
        mainPanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new GridBagLayout());
        scrollPanelCommento = new JScrollPane(commento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //iniziaqlizzazione ascoltatori
        votaAppunto = new VotaAppunto(commento, punteggio, valutaFrame);
        
        //inizializzazione variabili di layout
        gbc = new GridBagConstraints();
        gbc2 = new GridBagConstraints();
        
        //creazione frame - pannello
        creaFrame();
        creaPannello();
        
    }
    
    public void creaFrame(){
        
        valutaFrame.setSize(550, 444);
        valutaFrame.setResizable(false);
        valutaFrame.setUndecorated(true);
        valutaFrame.setVisible(true);
        
        //centra questo frame esattamente al centro rispetto al MainFrame
        int x = (int) (Grafica.posizione().getX() + 350 - valutaFrame.getWidth()/2);
        int y = (int) (Grafica.posizione().getY() + 280 - valutaFrame.getHeight()/2);
        valutaFrame.setLocation(x, y);
        
        container.setBackground(Color.white);
        container.setBorder(new LineBorder(new Color(53,53,53), 3));
        valutaFrame.setContentPane(container);
    }
    
    public void creaPannello(){
        
        mainPanel.setBackground(Color.white);
        buttonPanel.setBackground(Color.white);
        
        titoloFrame.setFont(new Font("Century Gothic", Font.BOLD, 23));
        titoloFrame.setBackground(Color.white);
        titoloFrame.setToolTipText(titoloFrame.getText());
        titoloFrame.setPreferredSize(new Dimension(500, 25));
        titoloFrame.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titoloFrame, gbc);
        
        punteggio.setPreferredSize(new Dimension(150,50));
        punteggio.setLabelTable(punteggio.createStandardLabels(1));
        punteggio.setMajorTickSpacing(1);
        punteggio.setBackground(Color.white);
        punteggio.setPaintLabels(true);
        punteggio.setBorder(BorderFactory.createTitledBorder("Punteggio"));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(punteggio, gbc);
        
        commentoPanel.setBackground(Color.white);
        commentoPanel.setBorder(BorderFactory.createTitledBorder("Commento"));
        
        commento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        commento.setBackground(Color.white);
        commento.setForeground(Color.BLACK);
        
        scrollPanelCommento.setPreferredSize(new Dimension(300, 150));
        scrollPanelCommento.setBorder(new LineBorder(Color.white));
        scrollPanelCommento.setVerticalScrollBar(new CustomScrollBar());
        commento.setLineWrap(true);
        commento.setWrapStyleWord(true);
        commentoPanel.add(scrollPanelCommento);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(20, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(commentoPanel, gbc);
        
        creaBottoni();
        
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 0, 0, 55);
        gbc2.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(annulla, gbc2);
        
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        gbc2.insets = new Insets(0, 55, 0, 0);
        gbc2.anchor = GridBagConstraints.CENTER;
        buttonPanel.add(conferma, gbc2);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(buttonPanel, gbc);
        
        container.add(mainPanel);
    }
    
    public void creaBottoni(){

        annulla.setBorder(BorderFactory.createEmptyBorder());
        annulla.setContentAreaFilled(false);
        annulla.setRolloverIcon(annullaHover);
        annulla.setPressedIcon(annullaPressed);
        annulla.setText("ANNULLA");
        annulla.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        annulla.setForeground(Color.white);
        annulla.setIconTextGap(-86);
        annulla.setPreferredSize(new Dimension(110, 40));
        annulla.addActionListener((ActionEvent e) -> {
            valutaFrame.dispose();
            valutaFrame.setVisible(false);
        });
        
        conferma.setBorder(BorderFactory.createEmptyBorder());
        conferma.setContentAreaFilled(false);
        conferma.setRolloverIcon(confermaHover);
        conferma.setPressedIcon(confermaPressed);
        conferma.setText("CONFERMA");
        conferma.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        conferma.setForeground(Color.white);
        conferma.setIconTextGap(-93);
        conferma.setPreferredSize(new Dimension(110, 40));
        conferma.addActionListener(votaAppunto);
    }
}
