/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Frame;

import Application.Vista.Grafica;
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
        
        ImageIcon loading = new ImageIcon(this.getClass().getResource("/immagini/loading.gif"));
        loadingFrame.add(new JLabel("", loading, JLabel.CENTER));
        
        loadingFrame.setUndecorated(true);
        loadingFrame.setSize(300, 300);
        
        //centrare frame al centro dello schermo
        int x = (int) (Grafica.posizione().getX() + 350 - loadingFrame.getWidth()/2);
        int y = (int) (Grafica.posizione().getY() + 280 - loadingFrame.getHeight()/2);
        loadingFrame.setLocation(x, y);
        loadingFrame.setVisible(true);
    }
    
    public void chiudi(){
        
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
