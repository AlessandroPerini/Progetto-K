/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Studente.AccountPanel;
import Utils.CheckLogin;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Te4o
 */
public class DoLogin implements ActionListener, KeyListener{

    private CardLayout card;
    private JPanel container;
    private JTextField email;
    private JPasswordField password;
    
    public DoLogin(CardLayout card, JPanel container, JTextField email, JPasswordField password) {
        this.card = card;
        this.container = container;
        this.email = email;
        this.password = password;
    }
    
    public void doIt(){
    
        try {
            CheckLogin.Check(email.getText()+"@universitadipavia.it", password.getText());
        
            String nomeCompleto = CheckLogin.getGuest().getNome()+" "+CheckLogin.getGuest().getCognome();
            JOptionPane.showMessageDialog(null, "Benvenuto "+nomeCompleto+"!","Login avvenuto con succensso" , JOptionPane.INFORMATION_MESSAGE);

            AccountPanel account = new AccountPanel(card, container);
            container.add(account,"account");
                
            } catch (InternalError LoginEx) {
              JOptionPane.showMessageDialog(null, "You've typed incorrect email or password.", "Wrong email/password", JOptionPane.ERROR_MESSAGE);
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        doIt();
    }

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            doIt();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
