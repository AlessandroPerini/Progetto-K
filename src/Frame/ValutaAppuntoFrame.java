/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Frame;

import Appunti.Ascoltatori.VotaAppunto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class ValutaAppuntoFrame{
    
    private JTextArea commento;
    private JSlider punteggio;
    private JFrame valutaFrame;
    private JLabel titoloFrame;
    private JPanel container, titolo, body, commentoPanel;;
    private JButton annulla, conferma;

    public ValutaAppuntoFrame() {
        this.valutaFrame = new JFrame();
    }

    public void apri(){
 
        GridBagConstraints gbc = new GridBagConstraints();
        
        valutaFrame = new JFrame("Valuta Appunto");
        valutaFrame.setSize(700, 560);
        valutaFrame.setLocationRelativeTo(null);
        valutaFrame.setResizable(false);
        valutaFrame.setUndecorated(true);
        
        container = new JPanel();
        container.setBackground(Color.white);
        valutaFrame.setContentPane(container);
        
        titolo = new JPanel();
        titolo.setBackground(Color.white);
        titolo.setPreferredSize(new Dimension(650,100));
        
        body = new JPanel(new GridBagLayout());
        body.setBackground(Color.white);
        
        titoloFrame = new JLabel("Valuta appunto");
        titoloFrame.setFont(new Font("Century Gothic", Font.BOLD, 23));
        titoloFrame.setBackground(Color.white);
        
        titolo.add(titoloFrame);
        
        punteggio = new JSlider(1, 5);
        punteggio.setPreferredSize(new Dimension(150,50));
        punteggio.setLabelTable(punteggio.createStandardLabels(1));
        punteggio.setMajorTickSpacing(1);
        punteggio.setBackground(Color.white);
        punteggio.setPaintLabels(true);
        punteggio.setBorder(BorderFactory.createTitledBorder("Punteggio"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 325, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(punteggio, gbc);

        commentoPanel = new JPanel();
        commentoPanel.setBackground(Color.white);
        commentoPanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        commento = new JTextArea();
        commento.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        commento.setBackground(Color.white);
        commento.setForeground(Color.BLACK);
        JScrollPane scrollPanel = new JScrollPane(commento, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(300, 200));
        commento.setLineWrap(true);
        commento.setWrapStyleWord(true);
        commentoPanel.add(scrollPanel);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 325, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(commentoPanel, gbc);
        
        Icon annullaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        annulla = new JButton(annullaNormal);
        annulla.setBorder(BorderFactory.createEmptyBorder());
        annulla.setContentAreaFilled(false);
        Icon annullaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        annulla.setRolloverIcon(annullaHover);
        Icon annullaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        annulla.setPressedIcon(annullaPressed);
        annulla.setText("ANNULLA");
        annulla.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        annulla.setForeground(Color.white);
        annulla.setIconTextGap(-88);
        annulla.setPreferredSize(new Dimension(110, 40));
        annulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valutaFrame.setVisible(false);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(50, -30, 0, 30);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(annulla, gbc);
        
        Icon confermaNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        conferma = new JButton(confermaNormal);
        conferma.setBorder(BorderFactory.createEmptyBorder());
        conferma.setContentAreaFilled(false);
        Icon confermaHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        conferma.setRolloverIcon(confermaHover);
        Icon confermaPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        conferma.setPressedIcon(confermaPressed);
        conferma.setText("CONFERMA");
        conferma.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        conferma.setForeground(Color.white);
        conferma.setIconTextGap(-92);
        conferma.setPreferredSize(new Dimension(110, 40));
        VotaAppunto votaAppunto = new VotaAppunto(commento, punteggio, valutaFrame);
        conferma.addActionListener(votaAppunto);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(50, 0, 0, 220);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(conferma, gbc);
        
        container.add(titolo);
        container.add(body);
        
        valutaFrame.setVisible(true);
    }

    
}
