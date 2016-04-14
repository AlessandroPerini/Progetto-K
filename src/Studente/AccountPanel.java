/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente;

import Login.LoginPanel;
import Utils.DatiTemporanei;
import Utils.CheckLogin;
import java.awt.CardLayout;
import java.awt.Dimension;
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
 * @author te4o
 */
public class AccountPanel extends JPanel{
    
    private static JLabel email;
    private static JLabel nick;
    private static JLabel points;
    private static JLabel phone;

    public AccountPanel(final CardLayout card, final JPanel container) {
    
        setPreferredSize(new Dimension(700, 500));
        
        //top panel
        JPanel top = new JPanel((new GridLayout(1, 3, 140, 0)));
        
        JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            card.show(container, DatiTemporanei.back);
                    }
                });

        JButton favourites = new JButton("* Preferiti *");

        JLabel title = new JLabel("Account");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));

        top.add(back);
        top.add(title);
        top.add(favourites);
        //end top panel
        
        //body panel
        JPanel body = new JPanel((new GridLayout(5, 1, 0, 20)));
        
        JPanel emailRow = new JPanel();
        JPanel nickRow = new JPanel();
        JPanel pointsRow = new JPanel();
        JPanel phoneRow = new JPanel();
        
        JButton logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(120, 75));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Are you scure to logout?", "Logout confirmation", JOptionPane.YES_NO_OPTION);
                
                if(showConfirmDialog == 0 ){

                    card.show(container, "login");
                    LoginPanel.clearForm();
                    CheckLogin.deleteGuest();
                }
            }
        });
        
        JPanel logoutPanel = new JPanel();
        logoutPanel.add(logout);
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------");

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        email = new JLabel(CheckLogin.getGuest().getEmail());
        email.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel nickLabel = new JLabel("Nickname: ");
        nickLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nick = new JLabel(CheckLogin.getGuest().getNickname());
        nick.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel pointsLabel = new JLabel("Points: ");
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));

        points = new JLabel(Integer.toString(CheckLogin.getGuest().getPunti()));
        points.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JLabel phoneLabel = new JLabel("Telefono: ");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));

        phone = new JLabel(CheckLogin.getGuest().getTelefono());
        phone.setFont(new Font("Arial", Font.PLAIN, 18));

        emailRow.add(emailLabel);
        emailRow.add(email);

        nickRow.add(nickLabel);
        nickRow.add(nick);

        pointsRow.add(pointsLabel);
        pointsRow.add(points);
        
        phoneRow.add(phoneLabel);
        phoneRow.add(phone);
        
        body.add(line);
        body.add(emailRow);
        body.add(nickRow);
        body.add(pointsRow);
        body.add(phoneRow);
        //end body panel
        
        add(top);
        add(body);
        add(logoutPanel);
        
    }

    
}
