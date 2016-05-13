/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Header.Vista;

import Application.Controller.Applicazione;
import Header.Ascoltatori.Back;
import Header.Ascoltatori.Menù;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{
    
    private JComboBox menu;
    
    public TopPanel(String t) {
        
        Icon button = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png")); 
        JButton backButton = new JButton(button);
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
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(420, 40));
        
        String[] opzioni = new String[]{"Home","Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        
        menu.setBackground(Color.white);
        menu.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        menu.setPreferredSize(new Dimension(110, 40));
        Menù menù = new Menù(menu);
        menu.addActionListener(menù);
        resetMenu();
        
        if (Applicazione.back.get(Applicazione.back.size()-1).equals("facoltà")) {add(empty); empty.setBackground(Color.white);}
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
