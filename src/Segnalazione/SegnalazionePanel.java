/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Segnalazione;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Header.Vista.TopPanel;
import Utils.CustomScrollbarUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class SegnalazionePanel extends JPanel{
    
    boolean ok = false;
    
    public SegnalazionePanel(){
        
        setBackground(Color.white);
        TopPanel top = new TopPanel("Inviaci un consiglio o una segnalazione");
        top.setBackground(Color.white);
        
        JTextArea testo = new JTextArea("");
        testo.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        testo.setBackground(new Color(204, 229, 255));
        testo.setForeground(Color.BLACK);
        
        JScrollPane scrollPanel = new JScrollPane(testo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(600, 400));
        scrollPanel.setBackground(Color.white);
        scrollPanel.setBorder(new LineBorder(Color.white));
        JScrollBar scrollBar2 = new JScrollBar();
        scrollBar2.setBackground(Color.white);
        scrollBar2.setPreferredSize(new Dimension(13, 0));
        scrollBar2.setUI(new CustomScrollbarUI());
        scrollBar2.setUnitIncrement(16);
        scrollPanel.setVerticalScrollBar(scrollBar2);
        testo.setLineWrap(true);
        testo.setWrapStyleWord(true);
        
        Icon button = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        JButton submit = new JButton(button);
        submit.setBorder(BorderFactory.createEmptyBorder());
        submit.setContentAreaFilled(false);
        Icon buttonHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        submit.setRolloverIcon(buttonHover);
        Icon buttonPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        submit.setPressedIcon(buttonPressed);
        submit.setText("INVIA");
        submit.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        submit.setForeground(Color.white);
        submit.setIconTextGap(-72);
        submit.setPreferredSize(new Dimension(110, 40));
        
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if((!testo.getText().equals(""))&&(testo.getText().length()<2000)){
                    String insertSegnalazione = "INSERT INTO segnalazioni VALUES (?, ?);";
                    
                    PreparedStatement ps1;
                    try {
                        ps1 = Applicazione.DBconnection.prepareStatement(insertSegnalazione);
                        
                        ps1.clearParameters();
                        ps1.setString(1, Applicazione.guest.getEmail());
                        ps1.setString(2, testo.getText());
                        
                        ps1.execute();
                        
                        ok = true;
                        
                        
                    } catch (SQLException ex) {
                        System.out.println("Errore durante l'invio della segnalazione");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Testo non valido (max 2000 caratteri)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    
                }
                
                if(ok){
                    
                    JOptionPane.showMessageDialog(null, "Grazie per la segnalazione ;)", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    
                    Applicazione.back.remove(Applicazione.back.size()-1);
                    Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
                    
                    testo.setText("");
                }
            }
        });
        
        add(top);
        add(scrollPanel);
        add(submit);
    }
}
