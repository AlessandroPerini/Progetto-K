/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Frame;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Ascoltatori.VotaAppunto;
import Appunti.Vista.AppuntoPanel;
import Database.Query.InfoQuery;
import Database.Query.InsertQuery;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private JPanel container;
    private JButton annulla, conferma;

    public ValutaAppuntoFrame() {
        this.valutaFrame = new JFrame();
    }

    public void apri(){
 
        valutaFrame = new JFrame("Valuta Appunto");
        valutaFrame.setSize(700, 560);
        valutaFrame.setLocationRelativeTo(null);
        valutaFrame.setResizable(false);
        valutaFrame.setUndecorated(true);
        
        container = new JPanel();
        valutaFrame.setContentPane(container);
        
        titoloFrame = new JLabel("Valuta appunto: "+Applicazione.appuntoAttuale.getNome());
        
        punteggio = new JSlider(1, 5);
        punteggio.setLabelTable(punteggio.createStandardLabels(1));
        punteggio.setMajorTickSpacing(1);
        punteggio.setPaintLabels(true);
        
        commento = new JTextArea();
        commento.setLineWrap(true);
        commento.setWrapStyleWord(true);
        commento.setPreferredSize(new Dimension(250, 150));
        
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
        annulla.setIconTextGap(-90);
        annulla.setPreferredSize(new Dimension(110, 40));
        annulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valutaFrame.setVisible(false);
            }
        });
        
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
        conferma.setIconTextGap(-90);
        conferma.setPreferredSize(new Dimension(110, 40));
        VotaAppunto votaAppunto = new VotaAppunto(commento, punteggio, valutaFrame);
        conferma.addActionListener(votaAppunto);
        
        container.add(titoloFrame);
        container.add(punteggio);
        container.add(commento);
        container.add(annulla);
        container.add(conferma);
        
        valutaFrame.setVisible(true);
    }
    
    
    
}
