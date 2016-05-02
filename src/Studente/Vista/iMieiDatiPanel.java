/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Vista;

import Application.Controller.Applicazione;
import Panel.TopPanel;
import Studente.Ascoltatori.GoToAppuntoGuest;
import Studente.Ascoltatori.GoToDomandaGuest;
import Studente.Ascoltatori.GoToLibroGuest;
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
    
    public iMieiDatiPanel() {
        
        TopPanel top = new TopPanel("I Miei Dati");
        
        JPanel panel = new JPanel(new GridLayout(n+3, 1));
        
        JLabel appuntiLabel = new JLabel("Appunti");
        JLabel libriLabel = new JLabel("Libri");
        JLabel domandeLabel = new JLabel("Domande");
        
        GoToAppuntoGuest goToAppuntoGuest = new GoToAppuntoGuest();
        panel.add(appuntiLabel);
        for (int i = 0; i < Applicazione.appuntiGuest.size(); i++) {
            appunti[i] = new JButton();
            appunti[i].setText(Applicazione.appuntiGuest.get(i).getNome());
            appunti[i].addActionListener(goToAppuntoGuest);
            panel.add(appunti[i]);
        }

        GoToLibroGuest goToLibroGuest = new GoToLibroGuest();
        panel.add(libriLabel);
        for (int i = 0; i < Applicazione.libriGuest.size(); i++) {
            libri[i] = new JButton();
            libri[i].setText(Applicazione.libriGuest.get(i).getTitolo());
            libri[i].addActionListener(goToLibroGuest);
            panel.add(libri[i]);
        }
        
        GoToDomandaGuest goToDomandaGuest = new GoToDomandaGuest();
        panel.add(domandeLabel);
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            domande[i] = new JButton();
            domande[i].setText(Applicazione.domandeGuest.get(i).getTitolo());
            domande[i].addActionListener(goToDomandaGuest);
            panel.add(domande[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}


