/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Te4o
 */
public class MainFrame extends JFrame{

    public MainFrame(String t) throws HeadlessException {
    
        super(t);
        setBounds(500, 200, 700, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
    
}
