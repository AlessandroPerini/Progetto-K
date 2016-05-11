/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Vista;

import Frame.MainFrame;
import Login.LoginPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class Grafica {
    
    public static CardLayout card;
    public static JPanel container;
    
    public Grafica(){
        
        card = new CardLayout();
        
        container = new JPanel();
        container.setLayout(card);
        
        MainFrame mainFrame = new MainFrame("UNI Per Voi");
        
        LoginPanel login = new LoginPanel();
        
        container.add(login,"login");
        card.show(container, "login");

        mainFrame.add(container);
        mainFrame.setVisible(true);
    }
}
