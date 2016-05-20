package Utils.Vista;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.metal.MetalScrollBarUI;

/**
 *
 * @author te4o
 */
public class ScrollBarUI extends MetalScrollBarUI {
    
    private ImageIcon imageThumb, imageTrack;
    
    private JButton b = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    public ScrollBarUI () {
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
