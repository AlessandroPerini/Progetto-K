/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Creator;

import Controller.Applicazione;
import Frame.MainFrame;
import Login.LoginPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;


/**
 *
 * @author te4o
 */
public class Starter {
    
    public static void main(String[] args) {
        
        Applicazione applicazione = new Applicazione();
        
        CardLayout card = new CardLayout();
        
        JPanel container = new JPanel();
        container.setLayout(card);
        
        MainFrame f = new MainFrame("Progetto K");
        
        LoginPanel login = new LoginPanel(card,container);
        
        container.add(login,"login");
        card.show(container, "login");

        f.add(container);
        f.setVisible(true);

    }
    
}


