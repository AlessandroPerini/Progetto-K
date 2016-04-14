/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Login.LoginPanel;
import Studente.AccountPanel;
import Utils.DatiTemporanei;
import Utils.Login;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{
    
    private String back;
    
    public TopPanel(final CardLayout card, final JPanel container, String t, final String back) {
        
        this.back = back;
        
        setLayout(new GridLayout(1, 3, 150, 0));
        
        JButton preferiti = new JButton("*Preferiti*");
        preferiti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        
        JButton account = new JButton("Account");
        account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                DatiTemporanei.back = back;
                card.show(container, "account");
            }
        });
        
        add(preferiti);
        add(title);
        add(account);
    }
    
    
}
