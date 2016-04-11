/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università;

import Panel.TopPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author te4o
 */
public class FacoltàPanel extends JPanel{

    private static final int N = 36; //36

    public FacoltàPanel(CardLayout card, JPanel container, JPanel accountPanel) {
    
        TopPanel top = new TopPanel(card, container, "FACOLTA'");
        
        JPanel panel = new JPanel(new GridLayout(N, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);
        
        JButton favourites = new JButton("*** Favourites ***");

        LetterLabel a = new LetterLabel("A");
        LetterLabel b = new LetterLabel("B");
        LetterLabel c = new LetterLabel("C");
            JButton chirurgia = new JButton("Chirurgia");
        LetterLabel d = new LetterLabel("D");
        LetterLabel e = new LetterLabel("E");
            JButton economia = new JButton("Economia");
        LetterLabel f = new LetterLabel("F");
            JButton farmacia = new JButton("Farmacia");
            JButton filosofia = new JButton("Filosofia");
        LetterLabel g = new LetterLabel("G");
            JButton giurisprudenza = new JButton("Giurisprudenza");
        LetterLabel h = new LetterLabel("H");
        LetterLabel i = new LetterLabel("I");
            JButton ingegneria = new JButton("Ingegneria");
        LetterLabel l = new LetterLabel("L");
            JButton lettere = new JButton("Lettere");
        LetterLabel m = new LetterLabel("M");
            JButton medicina = new JButton("Medicina");
            JButton musicologia = new JButton("Musicologia");
        LetterLabel n = new LetterLabel("N");
        LetterLabel o = new LetterLabel("O");
        LetterLabel p = new LetterLabel("P");
        LetterLabel q = new LetterLabel("Q");
        LetterLabel r = new LetterLabel("R");
        LetterLabel s = new LetterLabel("S");
            JButton scienzeFisiche = new JButton("Scienze Fisiche");
            JButton scienzeMatematiche = new JButton("Scienze Matematiche");
            JButton scienzeNaturali = new JButton("Scienze Naturali");
            JButton scienzePolitiche = new JButton("Scienze Politiche");
        LetterLabel t = new LetterLabel("T");
        LetterLabel u = new LetterLabel("U");
        LetterLabel v = new LetterLabel("V");
        LetterLabel z = new LetterLabel("Z");
        
        panel.add(searchPanel);
        panel.add(favourites);
        
        panel.add(a);
        panel.add(b);
        panel.add(c);
            panel.add(chirurgia);
        panel.add(d);
        panel.add(e);
            panel.add(economia);
        panel.add(f);
            panel.add(farmacia);
            panel.add(filosofia);
        panel.add(g);
            panel.add(giurisprudenza);
        panel.add(h);
        panel.add(i);
            panel.add(ingegneria);
        panel.add(l);
            panel.add(lettere);
        panel.add(m);
            panel.add(medicina);
            panel.add(musicologia);
        panel.add(n);
        panel.add(o);
        panel.add(p);
        panel.add(q);
        panel.add(r);
        panel.add(s);
            panel.add(scienzeFisiche);
            panel.add(scienzeMatematiche);
            panel.add(scienzeNaturali);
            panel.add(scienzePolitiche);
        panel.add(t);
        panel.add(u);
        panel.add(v);
        panel.add(z);
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
    

