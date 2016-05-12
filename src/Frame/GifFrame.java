/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author te4o
 */
public class GifFrame {
    
    public JFrame loadingFrame;

    public GifFrame() {
        this.loadingFrame = new JFrame();
    }

    public void apri(){
 
        loadingFrame = new JFrame("Loading ...");
        
        ImageIcon loading = new ImageIcon("files\\immagini\\loading.gif");
        loadingFrame.add(new JLabel("", loading, JLabel.CENTER));
        
        loadingFrame.setUndecorated(true);
        loadingFrame.setSize(300, 300);
        
        //centrare frame al centro dello schermo
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width-loadingFrame.getSize().width)/2;
        int y = (screenSize.height-loadingFrame.getSize().height)/2;
        loadingFrame.setLocation(x, y);
        //
        
        loadingFrame.setVisible(true);
    }
    
    public void chiudi(){
        
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
