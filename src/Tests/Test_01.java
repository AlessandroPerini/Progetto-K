/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Frame.MainFrame;
import Login.LoginPanel;
import Studente.AccountPanel;
import Università.FacoltàPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author te4o
 */
public class Test_01 {
    
    public static void main(String[] args) {
            
       CardLayout card = new CardLayout();
        
        JPanel container = new JPanel();
        container.setLayout(card);
        
        MainFrame f = new MainFrame("Login");
        
        LoginPanel login = new LoginPanel(card,container);
        
        AccountPanel account = new AccountPanel(card, container);
        
        FacoltàPanel facoltà = new FacoltàPanel(card, container, account);
        
        container.add(login,"1");
        container.add(facoltà,"2");
        container.add(account,"3");
        
        card.show(container, "0");

        f.add(container);
        f.setVisible(true);

    }
    
}


