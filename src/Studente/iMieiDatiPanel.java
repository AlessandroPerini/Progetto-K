/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente;

import Appunti.GoToAppunto;
import Controller.Applicazione;
import Libri.GoToLibro;
import Panel.TopPanel;
import QeA.GoToDomanda;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author te4o
 */
public class iMieiDatiPanel extends JPanel{
    
    private JButton[] appunti = new JButton[Applicazione.appuntiGuest.size()];
    private JButton[] libri = new JButton[Applicazione.libriGuest.size()];
    private JButton[] domande = new JButton[Applicazione.domandeGuest.size()];
    
    private int n = Applicazione.appuntiGuest.size()+Applicazione.libriGuest.size()+Applicazione.domandeGuest.size();
    
    public iMieiDatiPanel(CardLayout card, JPanel container) {
        
        TopPanel top = new TopPanel(card, container, "I Miei Dati");
        
        JPanel panel = new JPanel(new GridLayout(n+3, 1));
        
        JLabel appuntiLabel = new JLabel("Appunti");
        JLabel libriLabel = new JLabel("Libri");
        JLabel domandeLabel = new JLabel("Domande");
        
        GoToAppunto goToAppunto = new GoToAppunto(card, container);
        panel.add(appuntiLabel);
        for (int i = 0; i < Applicazione.appuntiGuest.size(); i++) {
            appunti[i] = new JButton();
            appunti[i].setText(Applicazione.appuntiGuest.get(i).getNome());
            appunti[i].addActionListener(goToAppunto);
            panel.add(appunti[i]);
        }

        GoToLibro goToLibro = new GoToLibro(card, container);
        panel.add(libriLabel);
        for (int i = 0; i < Applicazione.libriGuest.size(); i++) {
            libri[i] = new JButton();
            libri[i].setText(Applicazione.libriGuest.get(i).getTitolo());
            libri[i].addActionListener(goToLibro);
            panel.add(libri[i]);
        }
        
        GoToDomanda goToDomanda = new GoToDomanda(card, container);
        panel.add(domandeLabel);
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            domande[i] = new JButton();
            domande[i].setText(Applicazione.domandeGuest.get(i).getTitolo());
            domande[i].addMouseListener(goToDomanda);
            panel.add(domande[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 410));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}


