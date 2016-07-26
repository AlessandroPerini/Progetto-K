
package Utils.Vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 * Creazione di una ScrollBar personalizzata che utilizziamo più volte 
 * all'interno dell'interfaccia grafica. 
 * Contiene solo metodi di personalizzazione grafica.
 */
public class CustomScrollBar extends JScrollBar{

    public CustomScrollBar() {
        
        setBackground(Color.white);
        setPreferredSize(new Dimension(13, 0));
        setUI(new scrollBarLayout());
        setUnitIncrement(16);
    }  
    
}

class scrollBarLayout extends MetalScrollBarUI {
    
    private ImageIcon imageThumb, imageTrack;
    
    private JButton b = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    public scrollBarLayout () {
        imageThumb = new ImageIcon(this.getClass().getResource("/immagini/barThumb.png"));
        imageTrack = new ImageIcon(this.getClass().getResource("/immagini/barTrack.png"));
    }
    
    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        g.setColor(Color.blue);
        ((Graphics2D) g).drawImage(imageThumb.getImage(),
                r.x, r.y, 13, r.height, null);
    }
    
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
        
        ((Graphics2D) g).drawImage(imageTrack.getImage(),
                r.x+4, r.y, 6, r.height, null);
    }
    
    @Override
    protected JButton createDecreaseButton(int orientation) {
        return b;
    }
    
    @Override
    protected JButton createIncreaseButton(int orientation) {
        return b;
    }
    
}
