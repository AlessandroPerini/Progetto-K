/*
 * Qui viene creata la grafica: il frame generale con al suo interno
 * un container con un layout di tipo CardLayout per la gestione
 * dei pannelli da visualizzare.
*/
package Application.Vista;

import Frame.MainFrame;
import Login.LoginPanel;
import java.awt.CardLayout;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class Grafica {
    
    //dichiarazione oggetti
    public static CardLayout card;
    public static JPanel container;
    public static MainFrame mainFrame;
    
    public Grafica(){
        
        //inizializzazione oggetti
        mainFrame  = new MainFrame("UNI Per Voi");
        card = new CardLayout();
        container = new JPanel();
        LoginPanel login = new LoginPanel();
        
        container.setLayout(card);
        container.add(login,"login");
        card.show(container, "login");
        
        mainFrame.add(container);
        mainFrame.setVisible(true);
        
    }
    
    public static Point posizione(){
        
        return mainFrame.getLocation();
    }
}
