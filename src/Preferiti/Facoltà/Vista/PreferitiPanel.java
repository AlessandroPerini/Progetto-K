/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Vista;

import Application.Controller.Applicazione;
import Header.TopPanel;
import Studente.Ascoltatori.GoToAppuntoGuest;
import Studente.Ascoltatori.GoToDomandaGuest;
import Studente.Ascoltatori.GoToLibroGuest;
import Università.Corsi.Ascoltatori.CaricaCorsi;
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
public class PreferitiPanel extends JPanel{
    
    private JButton[] facoltàPreferite = new JButton[Applicazione.preferiti.getFacoltàPreferite().size()];
    
    private int n = Applicazione.preferiti.getFacoltàPreferite().size(); //totale righe

    public PreferitiPanel() {
        
        TopPanel top = new TopPanel("Preferiti");
        
        JPanel panel = new JPanel(new GridLayout(n+1, 1));
        
        JLabel facoltàPreferiteLabel = new JLabel("Facoltà Preferite");
        
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        panel.add(facoltàPreferiteLabel);
        
        for (int i = 0; i < Applicazione.preferiti.getFacoltàPreferite().size(); i++) {
            facoltàPreferite[i] = new JButton();
            facoltàPreferite[i].setText(Applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
            facoltàPreferite[i].addMouseListener(caricaCorsi);
            panel.add(facoltàPreferite[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
}
