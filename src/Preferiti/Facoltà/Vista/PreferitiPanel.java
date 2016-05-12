/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.GoToLibro;
import QeA.Ascoltatori.GoToDomanda;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Corsi.Ascoltatori.GoToCorso;
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
    private JButton[] corsiPreferiti = new JButton[Applicazione.preferiti.getCorsiPreferiti().size()];
    private JButton[] appuntiPreferiti = new JButton[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private JButton[] libriPreferiti = new JButton[Applicazione.preferiti.getLibriPreferiti().size()];
    private JButton[] domandePreferite = new JButton[Applicazione.preferiti.getDomandePreferite().size()];
    
    private GoToCorso[] goToCorso = new GoToCorso[Applicazione.preferiti.getCorsiPreferiti().size()];
    private GoToAppunto[] goToAppunto = new GoToAppunto[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private GoToLibro[] goToLibro = new GoToLibro[Applicazione.preferiti.getLibriPreferiti().size()];
    private GoToDomanda[] goToDomanda = new GoToDomanda[Applicazione.preferiti.getDomandePreferite().size()];
    
    private int n = Applicazione.preferiti.getFacoltàPreferite().size()+Applicazione.preferiti.getCorsiPreferiti().size()+
                    Applicazione.preferiti.getAppuntiPreferiti().size()+Applicazione.preferiti.getLibriPreferiti().size()+
                    Applicazione.preferiti.getDomandePreferite().size(); //totale righe preferiti (escluse le label)

    public PreferitiPanel() {
        TopPanel top = new TopPanel("Preferiti");
        
        JPanel panel = new JPanel(new GridLayout(n+5, 1));

        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        JLabel facoltàPreferiteLabel = new JLabel("Facoltà Preferite");
        panel.add(facoltàPreferiteLabel);
        for (int i = 0; i < Applicazione.preferiti.getFacoltàPreferite().size(); i++) {
            facoltàPreferite[i] = new JButton();
            facoltàPreferite[i].setText(Applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
            facoltàPreferite[i].addMouseListener(caricaCorsi);
            panel.add(facoltàPreferite[i]);
        }
        
        JLabel corsiPreferitiLabel = new JLabel("Corsi Preferiti");
        panel.add(corsiPreferitiLabel);
        for (int i = 0; i < Applicazione.preferiti.getCorsiPreferiti().size(); i++) {
            corsiPreferiti[i] = new JButton();
            corsiPreferiti[i].setText(Applicazione.preferiti.getCorsiPreferiti().get(i).getNome());
            goToCorso[i] = new GoToCorso(Applicazione.preferiti.getCorsiPreferiti().get(i).getFacoltà());
            corsiPreferiti[i].addMouseListener(goToCorso[i]);
            panel.add(corsiPreferiti[i]);
        }
        
        JLabel appuntiPreferitiLabel = new JLabel("Appunti Preferiti");
        panel.add(appuntiPreferitiLabel);
        for (int i = 0; i < Applicazione.preferiti.getAppuntiPreferiti().size(); i++) {
            appuntiPreferiti[i] = new JButton();
            appuntiPreferiti[i].setText(Applicazione.preferiti.getAppuntiPreferiti().get(i).getNome());
            goToAppunto[i] = new GoToAppunto(Applicazione.preferiti.getAppuntiPreferiti().get(i).getCorso(),
                                             Applicazione.preferiti.getAppuntiPreferiti().get(i).getFacoltà());
            appuntiPreferiti[i].addMouseListener(goToAppunto[i]);
            panel.add(appuntiPreferiti[i]);
        }
        
        JLabel libriPreferitiLabel = new JLabel("Libri Preferiti");
        panel.add(libriPreferitiLabel);
        for (int i = 0; i < Applicazione.preferiti.getLibriPreferiti().size(); i++) {
            libriPreferiti[i] = new JButton();
            libriPreferiti[i].setText(Applicazione.preferiti.getLibriPreferiti().get(i).getTitolo());
            goToLibro[i] = new GoToLibro(Applicazione.preferiti.getLibriPreferiti().get(i).getCorso(),
                                         Applicazione.preferiti.getLibriPreferiti().get(i).getFacoltà(),
                                         Applicazione.preferiti.getLibriPreferiti().get(i).getID());
            libriPreferiti[i].addActionListener(goToLibro[i]);
            panel.add(libriPreferiti[i]);
        }
        
        JLabel domandePreferiteLabel = new JLabel("Domande Preferiti");
        panel.add(domandePreferiteLabel);
        for (int i = 0; i < Applicazione.preferiti.getDomandePreferite().size(); i++) {
            domandePreferite[i] = new JButton();
            domandePreferite[i].setText(Applicazione.preferiti.getDomandePreferite().get(i).getTitolo());
            goToDomanda[i] = new GoToDomanda(Applicazione.preferiti.getDomandePreferite().get(i).getCorso(),
                                             Applicazione.preferiti.getDomandePreferite().get(i).getFacoltà());
            domandePreferite[i].addMouseListener(goToDomanda[i]);
            panel.add(domandePreferite[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
}
