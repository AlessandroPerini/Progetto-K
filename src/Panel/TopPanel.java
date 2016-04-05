/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Login.LoginPanel;
import Studente.AccountPanel;
import Utils.CheckLogin;
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

    public TopPanel(final CardLayout card, final JPanel container,JPanel accountPanel, String t) {
        
        setLayout(new GridLayout(1, 3, 120, 0));
        
        JButton logout = new JButton("Logout");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Are you scure to logout?", "Logout confirmation", JOptionPane.YES_NO_OPTION);
                
                if(showConfirmDialog == 0 ){

                    card.show(container, "" + 1);
                    LoginPanel.clearForm();
                    CheckLogin.deleteGuest();
                }
            }
        });
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        
        JButton account = new JButton("Account");
        account.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                card.show(container, "" + 3);
                AccountPanel.setData();
            }
        });
        
        add(logout);
        add(title);
        add(account);
    }
    
    
}
