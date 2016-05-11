/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author te4o
 */
public class GifFrame {
    
    public static JFrame loadingFrame = new JFrame();
    
    public static void apri(){
        
        loadingFrame = new JFrame("Loading ...");
        loadingFrame.setLocationRelativeTo(null);
        
        ImageIcon loading = new ImageIcon("files\\immagini\\loading.gif");
        loadingFrame.add(new JLabel("", loading, JLabel.CENTER));
        
        loadingFrame.setUndecorated(true);
        loadingFrame.setSize(300, 300);
        
        loadingFrame.setVisible(true);
    }
    
    public static void chiudi(){
        
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
