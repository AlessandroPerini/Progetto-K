package Utils;


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

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author te4o
 */
public  class CustomScrollbarUI extends MetalScrollBarUI {
    
    private ImageIcon imageThumb, imageTrack;
    
    private JButton b = new JButton() {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(0, 0);
        }
    };
    
    public CustomScrollbarUI () {
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
        /*
        JButton decreaseButton = new JButton(new ImageIcon(this.getClass().getResource("/immagini/barTopButton.png")));
        decreaseButton.setPreferredSize(new Dimension(12,12));
        decreaseButton.setBackground(new Color(238,238,238));
        decreaseButton.setBorder(new LineBorder(new Color(238,238,238)));
        return decreaseButton;
        */
        return b;
    }
    
    @Override
    protected JButton createIncreaseButton(int orientation) {
        /*
        JButton increaseButton = new JButton(new ImageIcon(this.getClass().getResource("/immagini/barDownButton.png")));
        increaseButton.setPreferredSize(new Dimension(12,12));
        increaseButton.setBackground(new Color(238,238,238));
        increaseButton.setBorder(new LineBorder(new Color(238,238,238)));
        return increaseButton;
        */
        return b;
    }
    
    private static class WrapImage {
        
        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                    w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }
    
}
