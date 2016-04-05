/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class LetterLabel extends JLabel{

    public LetterLabel(String s) {
        setText(s);
        setHorizontalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.BOLD, 20));
    }
    
}
