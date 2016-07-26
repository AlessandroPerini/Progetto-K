
package Frame;

import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * Frame principale dell'applicazione, nel quale i pannelli sono gestiti con un cardLayout
 */
public class MainFrame extends JFrame{

    public MainFrame(String t) throws HeadlessException {
    
        super(t);
        setSize(700, 560);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/immagini/logo.png")).getImage());
    }
    
}
