/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Header.Vista;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Header.Ascoltatori.Back;
import Header.Ascoltatori.Menù;
import Segnalazione.SegnalazionePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{
    
    private JComboBox menu;
    
    public TopPanel(String t) {
        
        Icon backNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        JButton backButton = new JButton(backNormal);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        Icon backHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        backButton.setRolloverIcon(backHover);
        Icon backPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        backButton.setPressedIcon(backPressed);
        backButton.setText("<   BACK");
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        backButton.setForeground(Color.white);
        backButton.setIconTextGap(-85);
        Back back = new Back();
        backButton.addActionListener(back);
        backButton.setPreferredSize(new Dimension(110, 40));
        
        JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(110, 40));
        empty.setBackground(Color.white);
        
        //-------------------------------------- SEGNALAZIONE!!! --------------------------------------
        JButton segnalazioni = new JButton();
        segnalazioni.setText("Segnalazioni");
        segnalazioni.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        segnalazioni.setForeground(new Color(255, 102, 102));
        segnalazioni.setBorder(new LineBorder(new Color(255, 102, 102), 1));
        segnalazioni.setBackground(Color.white);
        segnalazioni.setPreferredSize(new Dimension(110, 40));
        segnalazioni.setFocusPainted(false);
        
        segnalazioni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Applicazione.back.add("segnalazione");
                
                SegnalazionePanel segnalazione = new SegnalazionePanel();
                Grafica.container.add(segnalazione, "segnalazione");
                Grafica.card.show(Grafica.container, "segnalazione");
            }
        });
        //----------------------------------- FINE SEGNALAZIONE!!! -----------------------------------
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(420, 40));
        title.requestFocus();
        
        String[] opzioni = new String[]{"Home","Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        
        menu.setBackground(Color.white);
        menu.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        menu.setPreferredSize(new Dimension(110, 40));
        Menù menù = new Menù(menu);
        menu.addActionListener(menù);
        resetMenu();
        
        if (Applicazione.back.get(Applicazione.back.size()-1).equals("facoltà")) {add(segnalazioni);}
        else{add(backButton);}
        add(title);
        add(menu);
        
    }
    
    public void resetMenu() {
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
    
}
