/*
* Frame contenente la gif di caricamento
*/
package Grafica;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author te4o
 */
public class GifFrame {
    
    //dichiarazione oggetti
    public JFrame loadingFrame;

    public GifFrame() {
        this.loadingFrame = new JFrame();
    }

    public void apri(){
 
        loadingFrame = new JFrame("Loading ...");
        
        loadingFrame.add(new JLabel("", new ImageIcon(this.getClass().getResource("/Grafica/immagini/loading.gif")), JLabel.CENTER));

        loadingFrame.setUndecorated(true);
        loadingFrame.setSize(196, 196);

        //centrare frame al centro del MainFrame
        int x = (int) (Grafica.posizione().getX() + 350 - loadingFrame.getWidth()/2);
        int y = (int) (Grafica.posizione().getY() + 280 - loadingFrame.getHeight()/2);
        loadingFrame.setLocation(x, y);
        
        loadingFrame.setAlwaysOnTop(true);
        loadingFrame.setVisible(true);
    }
    
    public void chiudi(){
        
        loadingFrame.setVisible(false);
        loadingFrame.dispose();
    }
}
