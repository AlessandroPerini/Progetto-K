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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author te4o
 */
public class PreferitiPanel extends JPanel{
    
    private JLabel[] facoltàPreferite = new JLabel[Applicazione.preferiti.getFacoltàPreferite().size()];
    private JLabel[] corsiPreferiti = new JLabel[Applicazione.preferiti.getCorsiPreferiti().size()];
    private JLabel[] appuntiPreferiti = new JLabel[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private JLabel [] libriPreferiti = new JLabel[Applicazione.preferiti.getLibriPreferiti().size()];
    private JLabel[] domandePreferite = new JLabel[Applicazione.preferiti.getDomandePreferite().size()];
    
    private JLabel[] facoltàPreferiteLab = new JLabel[Applicazione.preferiti.getFacoltàPreferite().size()];
    private JLabel[] corsiPreferitiLab = new JLabel[Applicazione.preferiti.getCorsiPreferiti().size()];
    private JLabel[] appuntiPreferitiLab = new JLabel[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private JLabel [] libriPreferitiLab = new JLabel[Applicazione.preferiti.getLibriPreferiti().size()];
    private JLabel[] domandePreferiteLab = new JLabel[Applicazione.preferiti.getDomandePreferite().size()];
    
    private JLabel[] facoltàPreferiteIco = new JLabel[Applicazione.preferiti.getFacoltàPreferite().size()];
    private JLabel[] corsiPreferitiIco = new JLabel[Applicazione.preferiti.getCorsiPreferiti().size()];
    private JLabel[] appuntiPreferitiIco = new JLabel[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private JLabel [] libriPreferitiIco = new JLabel[Applicazione.preferiti.getLibriPreferiti().size()];
    private JLabel[] domandePreferiteIco = new JLabel[Applicazione.preferiti.getDomandePreferite().size()];
    
    private GoToCorso[] goToCorso = new GoToCorso[Applicazione.preferiti.getCorsiPreferiti().size()];
    private GoToAppunto[] goToAppunto = new GoToAppunto[Applicazione.preferiti.getAppuntiPreferiti().size()];
    private GoToLibro[] goToLibro = new GoToLibro[Applicazione.preferiti.getLibriPreferiti().size()];
    private GoToDomanda[] goToDomanda = new GoToDomanda[Applicazione.preferiti.getDomandePreferite().size()];
    
    private int n = Applicazione.preferiti.getFacoltàPreferite().size()+Applicazione.preferiti.getCorsiPreferiti().size()+
            Applicazione.preferiti.getAppuntiPreferiti().size()+Applicazione.preferiti.getLibriPreferiti().size()+
            Applicazione.preferiti.getDomandePreferite().size(); //totale righe preferiti (escluse le label)
    
    private JButton facoltàPreferiteLabel, corsiPreferitiLabel, appuntiPreferitiLabel,
            libriPreferitiLabel, domandePreferiteLabel;
    private ImageIcon  search, searchPressed, searchHover;
    private JPanel panel, nord, centro, facPanel, corsiPanel, appPanel, libPanel, domPanel;
    private JScrollPane scrollPanel, scrollPanel1,scrollPanel2,scrollPanel3, scrollPanel4;
    private CardLayout cardLayout = new CardLayout();
    
    public PreferitiPanel() {
        TopPanel top = new TopPanel("Preferiti");
        top.setBackground(Color.white);
        this.setBackground(Color.white);
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        nord = new JPanel(new GridBagLayout());
        nord.setBackground(Color.white);
        centro = new JPanel();
        centro.setBackground(Color.white);
        centro.setLayout(cardLayout);
        facPanel = new JPanel(new GridBagLayout());
        facPanel.setBackground(Color.white);
        scrollPanel = new JScrollPane(facPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 400));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        corsiPanel = new JPanel(new GridBagLayout());
        corsiPanel.setBackground(Color.white);
        scrollPanel1 = new JScrollPane(corsiPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 400));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        appPanel = new JPanel(new GridBagLayout());
        appPanel.setBackground(Color.white);
        scrollPanel2 = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel2.setPreferredSize(new Dimension(650, 400));
        scrollPanel2.getVerticalScrollBar().setUnitIncrement(16);
        libPanel = new JPanel(new GridBagLayout());
        libPanel.setBackground(Color.white);
        scrollPanel3 = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel3.setPreferredSize(new Dimension(650, 400));
        scrollPanel3.getVerticalScrollBar().setUnitIncrement(16);
        domPanel = new JPanel(new GridBagLayout());
        domPanel.setBackground(Color.white);
        scrollPanel4 = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel4.setPreferredSize(new Dimension(650, 400));
        scrollPanel4.getVerticalScrollBar().setUnitIncrement(16);
        
        centro.add(scrollPanel,"facoltàPreferite");
        centro.add(scrollPanel1,"corsiPreferiti");
        centro.add(scrollPanel2,"appuntiPreferiti");
        centro.add(scrollPanel3,"libriPreferiti");
        centro.add(scrollPanel4,"domandePreferite");
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        search = new ImageIcon(this.getClass().getResource("/immagini/button2Normal.png"));
        
        facoltàPreferiteLabel = new JButton("Facoltà",search);
        
        facoltàPreferiteLabel.setPreferredSize(new Dimension(120,25));
        facoltàPreferiteLabel.setBorder(BorderFactory.createEmptyBorder());
        facoltàPreferiteLabel.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        facoltàPreferiteLabel.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        facoltàPreferiteLabel.setPressedIcon(searchPressed);
        
        facoltàPreferiteLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        facoltàPreferiteLabel.setForeground(Color.white);
        facoltàPreferiteLabel.setIconTextGap(-85);
        facoltàPreferiteLabel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "facoltàPreferite");
                facoltàPreferiteLabel.setIcon(searchHover);
                corsiPreferitiLabel.setIcon(search);
                libriPreferitiLabel.setIcon(search);
                domandePreferiteLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(facoltàPreferiteLabel, gbc);
        
        for (int i = 0; i < Applicazione.preferiti.getFacoltàPreferite().size(); i++) {
            facoltàPreferite[i] = new JLabel();
            facoltàPreferiteLab[i] = new JLabel();
            facoltàPreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotFacoltà.png")));
            facoltàPreferite[i].setText(Applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
            facoltàPreferite[i].setToolTipText(facoltàPreferite[i].getText());
            facoltàPreferiteLab[i].setLayout(new BoxLayout(facoltàPreferiteLab[i], BoxLayout.X_AXIS));
            facoltàPreferiteLab[i].setPreferredSize(new Dimension(220, 30));
            facoltàPreferite[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            facoltàPreferiteLab[i].add(facoltàPreferiteIco[i]);
            facoltàPreferiteLab[i].add(new JLabel("   "));
            facoltàPreferiteLab[i].add(facoltàPreferite[i]);
            facoltàPreferite[i].addMouseListener(caricaCorsi);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 5);
            gbcd.anchor = GridBagConstraints.CENTER;
            facPanel.add(facoltàPreferiteLab[i],gbcd);
        }
        
        corsiPreferitiLabel = new JButton("Corsi",search);
        
        corsiPreferitiLabel.setPreferredSize(new Dimension(120,25));
        corsiPreferitiLabel.setBorder(BorderFactory.createEmptyBorder());
        corsiPreferitiLabel.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        corsiPreferitiLabel.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        corsiPreferitiLabel.setPressedIcon(searchPressed);
        
        corsiPreferitiLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        corsiPreferitiLabel.setForeground(Color.white);
        corsiPreferitiLabel.setIconTextGap(-78);
        corsiPreferitiLabel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "corsiPreferiti");
                facoltàPreferiteLabel.setIcon(search);
                corsiPreferitiLabel.setIcon(searchHover);
                libriPreferitiLabel.setIcon(search);
                domandePreferiteLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(corsiPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getCorsiPreferiti().size(); i++) {
            corsiPreferiti[i] = new JLabel();
            corsiPreferitiLab[i] = new JLabel();
            corsiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotCorso.png")));
            corsiPreferiti[i].setText(Applicazione.preferiti.getCorsiPreferiti().get(i).getNome());
            corsiPreferiti[i].setToolTipText(corsiPreferiti[i].getText());
            corsiPreferitiLab[i].setLayout(new BoxLayout(corsiPreferitiLab[i], BoxLayout.X_AXIS));
            corsiPreferitiLab[i].setPreferredSize(new Dimension(220, 30));
            corsiPreferiti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            corsiPreferitiLab[i].add(corsiPreferitiIco[i]);
            corsiPreferitiLab[i].add(new JLabel("   "));
            corsiPreferitiLab[i].add(corsiPreferiti[i]);
            
            goToCorso[i] = new GoToCorso(Applicazione.preferiti.getCorsiPreferiti().get(i).getFacoltà());
            corsiPreferiti[i].addMouseListener(goToCorso[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 5);
            gbcd.anchor = GridBagConstraints.CENTER;
            corsiPanel.add(corsiPreferitiLab[i],gbcd);
        }
        
        appuntiPreferitiLabel = new JButton("Appunti",search);
        
        appuntiPreferitiLabel.setPreferredSize(new Dimension(120,25));
        appuntiPreferitiLabel.setBorder(BorderFactory.createEmptyBorder());
        appuntiPreferitiLabel.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        appuntiPreferitiLabel.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        appuntiPreferitiLabel.setPressedIcon(searchPressed);
        
        appuntiPreferitiLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        appuntiPreferitiLabel.setForeground(Color.white);
        appuntiPreferitiLabel.setIconTextGap(-85);
        appuntiPreferitiLabel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "appuntiPreferiti");
                facoltàPreferiteLabel.setIcon(search);
                corsiPreferitiLabel.setIcon(search);
                libriPreferitiLabel.setIcon(search);
                domandePreferiteLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(searchHover);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getAppuntiPreferiti().size(); i++) {
            
            
            appuntiPreferiti[i] = new JLabel();
            appuntiPreferitiLab[i] = new JLabel();
            appuntiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotAppunto.png")));
            appuntiPreferiti[i].setText(Applicazione.preferiti.getAppuntiPreferiti().get(i).getNome());
            appuntiPreferiti[i].setToolTipText(appuntiPreferiti[i].getText());
            appuntiPreferitiLab[i].setLayout(new BoxLayout(appuntiPreferitiLab[i], BoxLayout.X_AXIS));
            appuntiPreferitiLab[i].setPreferredSize(new Dimension(220, 30));
            appuntiPreferiti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            appuntiPreferitiLab[i].add(appuntiPreferitiIco[i]);
            appuntiPreferitiLab[i].add(new JLabel("   "));
            appuntiPreferitiLab[i].add(appuntiPreferiti[i]);
            goToAppunto[i] = new GoToAppunto(Applicazione.preferiti.getAppuntiPreferiti().get(i).getCorso(),
                    Applicazione.preferiti.getAppuntiPreferiti().get(i).getFacoltà());
            appuntiPreferiti[i].addMouseListener(goToAppunto[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            appPanel.add(appuntiPreferitiLab[i], gbcd);
        }
        
        libriPreferitiLabel = new JButton("Libri",search);
        
        libriPreferitiLabel.setPreferredSize(new Dimension(120,25));
        libriPreferitiLabel.setBorder(BorderFactory.createEmptyBorder());
        libriPreferitiLabel.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        libriPreferitiLabel.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        libriPreferitiLabel.setPressedIcon(searchPressed);
        
        libriPreferitiLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        libriPreferitiLabel.setForeground(Color.white);
        libriPreferitiLabel.setIconTextGap(-75);
        libriPreferitiLabel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "libriPreferiti");
                facoltàPreferiteLabel.setIcon(search);
                corsiPreferitiLabel.setIcon(search);
                libriPreferitiLabel.setIcon(searchHover);
                domandePreferiteLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getLibriPreferiti().size(); i++) {
            libriPreferiti[i] = new JLabel();
            libriPreferitiLab[i] = new JLabel();
            libriPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotLibro.png")));
            libriPreferiti[i].setText(Applicazione.preferiti.getLibriPreferiti().get(i).getTitolo());
            libriPreferiti[i].setToolTipText(libriPreferiti[i].getText());
            libriPreferitiLab[i].setLayout(new BoxLayout(libriPreferitiLab[i], BoxLayout.X_AXIS));
            libriPreferitiLab[i].setPreferredSize(new Dimension(220, 30));
            libriPreferiti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            libriPreferitiLab[i].add(libriPreferitiIco[i]);
            libriPreferitiLab[i].add(new JLabel("   "));
            libriPreferitiLab[i].add(libriPreferiti[i]);
            goToLibro[i] = new GoToLibro(Applicazione.preferiti.getLibriPreferiti().get(i).getCorso(),
                    Applicazione.preferiti.getLibriPreferiti().get(i).getFacoltà(),
                    Applicazione.preferiti.getLibriPreferiti().get(i).getID());
            libriPreferiti[i].addMouseListener(goToLibro[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            libPanel.add(libriPreferitiLab[i], gbcd );
        }
        
        domandePreferiteLabel = new JButton("Domande",search);
        domandePreferiteLabel.setPreferredSize(new Dimension(120,25));
        domandePreferiteLabel.setBorder(BorderFactory.createEmptyBorder());
        domandePreferiteLabel.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        domandePreferiteLabel.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        domandePreferiteLabel.setPressedIcon(searchPressed);
        domandePreferiteLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        domandePreferiteLabel.setForeground(Color.white);
        domandePreferiteLabel.setIconTextGap(-92);
        domandePreferiteLabel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "domandePreferite");
                facoltàPreferiteLabel.setIcon(search);
                corsiPreferitiLabel.setIcon(search);
                libriPreferitiLabel.setIcon(search);
                domandePreferiteLabel.setIcon(searchHover);
                appuntiPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteLabel, gbc);
        for (int i = 0; i < Applicazione.preferiti.getDomandePreferite().size(); i++) {
            domandePreferite[i] = new JLabel();
            domandePreferiteLab[i] = new JLabel();
            domandePreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotDomanda.png")));
            domandePreferite[i].setText(Applicazione.preferiti.getDomandePreferite().get(i).getTitolo());
            domandePreferite[i].setToolTipText(domandePreferite[i].getText());
            domandePreferiteLab[i].setLayout(new BoxLayout(domandePreferiteLab[i], BoxLayout.X_AXIS));
            domandePreferiteLab[i].setPreferredSize(new Dimension(220, 30));
            domandePreferite[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            domandePreferiteLab[i].add(domandePreferiteIco[i]);
            domandePreferiteLab[i].add(new JLabel("   "));
            domandePreferiteLab[i].add(domandePreferite[i]);
            goToDomanda[i] = new GoToDomanda(Applicazione.preferiti.getDomandePreferite().get(i).getCorso(),
                    Applicazione.preferiti.getDomandePreferite().get(i).getFacoltà());
            domandePreferite[i].addMouseListener(goToDomanda[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            domPanel.add(domandePreferiteLab[i], gbcd );
        }
        panel.add(nord,BorderLayout.NORTH);
        panel.add(centro,BorderLayout.CENTER);
         scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(panel);
    }
}
