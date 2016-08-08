/*
 * Frame generale dell'applicazione
 */
package Grafica;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Te4o
 */
public class MainFrame extends JFrame{

    public MainFrame(String t) throws HeadlessException {
    
        super(t);
        setSize(700, 560);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/Grafica/immagini/logo.png")).getImage());
    }
    
}
