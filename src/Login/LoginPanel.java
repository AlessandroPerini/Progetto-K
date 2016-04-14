/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Login;

import Studente.AccountPanel;
import Università.FacoltàPanel;
import Utils.Login;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Te4o
 */
public class LoginPanel extends JPanel implements KeyListener {
    
    private static JTextField email = new JTextField();
    private static JPasswordField password = new JPasswordField();
    
    private CardLayout card;
    private JPanel container;
    
    public LoginPanel(final CardLayout card, final JPanel container){   
        
        this.card = card;
        this.container = container; 
        JPanel main = new JPanel(new GridLayout(3, 1));
        
        JPanel up = new JPanel(new GridLayout(2, 1, 0, 30));
        JPanel down = new JPanel(new GridLayout(5, 1, 0, 10));
        JPanel down1 = new JPanel();
        JPanel down2 = new JPanel();
        JPanel down3 = new JPanel();
        JPanel down4 = new JPanel();
        
        JPanel submit = new JPanel();
        
        JLabel title = new JLabel("Progetto K");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subTitle = new JLabel("Benvenuto! Effetua il login con le credenziale dell'ateneo.");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 25));
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        email = new JTextField();
        email.setColumns(15);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setFont(new Font("Arial", Font.PLAIN, 15));
        
        JLabel at = new JLabel("@universitadipavia.it");
        at.setFont(new Font("Arial", Font.PLAIN, 15));
                
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        
        password = new JPasswordField();
        password.setColumns(15);
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setHorizontalAlignment(SwingConstants.CENTER);
        
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                
                login();
            }
        });
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------");
        
        up.add(title);
        up.add(subTitle);
        
        down1.add(emailLabel);
        down2.add(email);
        down2.add(at);
        down3.add(passwordLabel);
        down4.add(password);
        
        down.add(line);
        down.add(down1);
        down.add(down2);
        down.add(down3);
        down.add(down4);
        
        submit.add(login);
        
        main.add(up);
        main.add(down);
        main.add(submit);
        
        email.addKeyListener(this);
        password.addKeyListener(this);
        login.addKeyListener(this);
        
        add(main);
    }

    public static void clearForm(){
        
        email.setText("");
        password.setText("");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            login();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    public void login(){
        try {

                Login.Check(email.getText()+"@universitadipavia.it", password.getText());
                JOptionPane.showMessageDialog(null, "Successful login.", "Login confirmed", JOptionPane.INFORMATION_MESSAGE);

                AccountPanel account = new AccountPanel(card, container);
                FacoltàPanel facoltà = new FacoltàPanel(card, container);
                
                container.add(facoltà,"facoltà");
                container.add(account,"account");
                card.show(container, "facoltà");
                
            } catch (InternalError LoginEx) {
                JOptionPane.showMessageDialog(null, "You've typed incorrect email or password.", "Wrong email/password", JOptionPane.ERROR_MESSAGE);
            }
    }
    
}
