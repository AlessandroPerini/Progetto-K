/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente;

import Utils.CheckLogin;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author te4o
 */
public class AccountPanel extends JPanel{

    public AccountPanel(final CardLayout card, final JPanel container) {
    
        setPreferredSize(new Dimension(700, 500));
        //top panel
        JPanel top = new JPanel((new GridLayout(1, 3, 120, 0)));
        
        JButton back = new JButton("Back");
                back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                            card.show(container, "" + 2);
                    }
                });

        JButton favourites = new JButton("Favourites");

        JLabel title = new JLabel("Account");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));

        top.add(back);
        top.add(title);
        top.add(favourites);
        //end top panel
        
        //body panel
        JPanel body = new JPanel((new GridLayout(6, 1, 0, 20)));
        
        JPanel emailRow = new JPanel();
        JPanel nickRow = new JPanel();
        JPanel pointsRow = new JPanel();
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------");

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel email = new JLabel("...");
        email.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel nickLabel = new JLabel("Nickname: ");
        nickLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel nick = new JLabel("...");
        nick.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel pointsLabel = new JLabel("Points: ");
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel points = new JLabel("...");
        points.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JLabel phoneLabel = new JLabel("Telefono: ");
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel phone = new JLabel("...");
        points.setFont(new Font("Arial", Font.PLAIN, 18));

        emailRow.add(emailLabel);
        emailRow.add(email);

        nickRow.add(nickLabel);
        nickRow.add(nick);

        pointsRow.add(pointsLabel);
        pointsRow.add(points);

        body.add(line);
        body.add(emailRow);
        body.add(nickRow);
        body.add(pointsRow);
        //end body panel
        
        add(top);
        add(body);
        
    }
    
    public static void setData(){
    
       
    }
    
}
