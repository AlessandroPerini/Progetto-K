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
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

   private JButton facoltàPreferiteLabel, corsiPreferitiLabel, appuntiPreferitiLabel,
           libriPreferitiLabel, domandePreferiteLabel;
   private JPanel panel, nord, centro, facPanel, corsiPanel, appPanel, libPanel, domPanel;
   private CardLayout cardLayout = new CardLayout();
   
    public PreferitiPanel() {
        TopPanel top = new TopPanel("Preferiti");
        
        panel = new JPanel(new BorderLayout());
        nord = new JPanel(new GridBagLayout());
        centro = new JPanel();
        centro.setLayout(cardLayout);
        facPanel = new JPanel(new GridBagLayout());
        corsiPanel = new JPanel(new GridBagLayout());
        appPanel = new JPanel(new GridBagLayout());
        libPanel = new JPanel(new GridBagLayout());
        domPanel = new JPanel(new GridBagLayout());
        
        centro.add(facPanel,"facoltàPreferite");
        centro.add(corsiPanel,"corsiPreferiti");
        centro.add(appPanel,"appuntiPreferiti");
        centro.add(libPanel,"libriPreferiti");
        centro.add(domPanel,"domandePreferite");
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        facoltàPreferiteLabel = new JButton("Facoltà Preferite");
         facoltàPreferiteLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "facoltàPreferite");
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(facoltàPreferiteLabel, gbc);
        
        for (int i = 0; i < Applicazione.preferiti.getFacoltàPreferite().size(); i++) {
            facoltàPreferite[i] = new JButton();
            facoltàPreferite[i].setText(Applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
            facoltàPreferite[i].addMouseListener(caricaCorsi);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 5);
            gbcd.anchor = GridBagConstraints.CENTER;
            facPanel.add(facoltàPreferite[i],gbcd);
        }
        
        corsiPreferitiLabel = new JButton("Corsi Preferiti");
         corsiPreferitiLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "corsiPreferiti");
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(corsiPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getCorsiPreferiti().size(); i++) {
            corsiPreferiti[i] = new JButton();
            corsiPreferiti[i].setText(Applicazione.preferiti.getCorsiPreferiti().get(i).getNome());
            goToCorso[i] = new GoToCorso(Applicazione.preferiti.getCorsiPreferiti().get(i).getFacoltà());
            corsiPreferiti[i].addMouseListener(goToCorso[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 5);
            gbcd.anchor = GridBagConstraints.CENTER;
            corsiPanel.add(corsiPreferiti[i],gbcd);
        }
        
        appuntiPreferitiLabel = new JButton("Appunti Preferiti");
         appuntiPreferitiLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "appuntiPreferiti");
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getAppuntiPreferiti().size(); i++) {
            appuntiPreferiti[i] = new JButton();
            appuntiPreferiti[i].setText(Applicazione.preferiti.getAppuntiPreferiti().get(i).getNome());
            goToAppunto[i] = new GoToAppunto(Applicazione.preferiti.getAppuntiPreferiti().get(i).getCorso(),
                                             Applicazione.preferiti.getAppuntiPreferiti().get(i).getFacoltà());
            appuntiPreferiti[i].addMouseListener(goToAppunto[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            appPanel.add(appuntiPreferiti[i], gbcd);
        }
        
        libriPreferitiLabel = new JButton("Libri Preferiti");
         libriPreferitiLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "libriPreferiti");
            }
        });
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getLibriPreferiti().size(); i++) {
            libriPreferiti[i] = new JButton();
            libriPreferiti[i].setText(Applicazione.preferiti.getLibriPreferiti().get(i).getTitolo());
            goToLibro[i] = new GoToLibro(Applicazione.preferiti.getLibriPreferiti().get(i).getCorso(),
                                         Applicazione.preferiti.getLibriPreferiti().get(i).getFacoltà(),
                                         Applicazione.preferiti.getLibriPreferiti().get(i).getID());
            libriPreferiti[i].addActionListener(goToLibro[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            libPanel.add(libriPreferiti[i], gbcd );
        }
        
        domandePreferiteLabel = new JButton("Domande Preferiti");
         domandePreferiteLabel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "domandePreferite");
            }
        });
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getDomandePreferite().size(); i++) {
            domandePreferite[i] = new JButton();
            domandePreferite[i].setText(Applicazione.preferiti.getDomandePreferite().get(i).getTitolo());
            goToDomanda[i] = new GoToDomanda(Applicazione.preferiti.getDomandePreferite().get(i).getCorso(),
                                             Applicazione.preferiti.getDomandePreferite().get(i).getFacoltà());
            domandePreferite[i].addMouseListener(goToDomanda[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            domPanel.add(domandePreferite[i], gbcd );
        }
        panel.add(nord,BorderLayout.NORTH);
        panel.add(centro,BorderLayout.CENTER);
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
}
