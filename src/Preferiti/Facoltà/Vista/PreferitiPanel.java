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
import Universita.Corsi.Ascoltatori.CaricaCorsi;
import Universita.Corsi.Ascoltatori.GoToCorso;
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
    
    private int dimFacoltàPreferite = Applicazione.preferiti.getFacoltàPreferite().size();
    private int dimCorsiPreferiti = Applicazione.preferiti.getCorsiPreferiti().size();
    private int dimAppuntiPreferiti = Applicazione.preferiti.getAppuntiPreferiti().size();
    private int dimLibriPreferiti = Applicazione.preferiti.getLibriPreferiti().size();
    private int dimDomandePreferite = Applicazione.preferiti.getDomandePreferite().size();
    
    private JLabel[] facoltàPreferite = new JLabel[dimFacoltàPreferite];
    private JLabel[] corsiPreferiti = new JLabel[dimCorsiPreferiti];
    private JLabel[] appuntiPreferiti = new JLabel[dimAppuntiPreferiti];
    private JLabel[] libriPreferiti = new JLabel[dimLibriPreferiti];
    private JLabel[] domandePreferite = new JLabel[dimDomandePreferite];
    
    private JLabel[] facoltàPreferiteLab = new JLabel[dimFacoltàPreferite];
    private JLabel[] corsiPreferitiLab = new JLabel[dimCorsiPreferiti];
    private JLabel[] appuntiPreferitiLab = new JLabel[dimAppuntiPreferiti];
    private JLabel [] libriPreferitiLab = new JLabel[dimLibriPreferiti];
    private JLabel[] domandePreferiteLab = new JLabel[dimDomandePreferite];
    
    private JLabel[] facoltàPreferiteIco = new JLabel[dimFacoltàPreferite];
    private JLabel[] corsiPreferitiIco = new JLabel[dimCorsiPreferiti];
    private JLabel[] appuntiPreferitiIco = new JLabel[dimAppuntiPreferiti];
    private JLabel [] libriPreferitiIco = new JLabel[dimLibriPreferiti];
    private JLabel[] domandePreferiteIco = new JLabel[dimDomandePreferite];
    
    private GoToCorso[] goToCorso = new GoToCorso[dimCorsiPreferiti];
    private GoToAppunto[] goToAppunto = new GoToAppunto[dimAppuntiPreferiti];
    private GoToLibro[] goToLibro = new GoToLibro[dimLibriPreferiti];
    private GoToDomanda[] goToDomanda = new GoToDomanda[dimDomandePreferite];
    
    
    private JButton facoltàPreferiteButton, corsiPreferitiButton, appuntiPreferitiButton,
            libriPreferitiButton, domandePreferiteButton;
    private ImageIcon  search, searchPressed, searchHover, searchSelected;
    private JLabel noFacoltà, noCorsi, noAppunti, noLibri, noDomande;
    private JPanel panel, nord, centro, facPanel, corsiPanel, appPanel, libPanel, domPanel;
    private JScrollPane scrollPanel, scrollPanel1,scrollPanel2,scrollPanel3, scrollPanel4;
    private GridBagConstraints gbc, gbcd;
    private CardLayout cardLayout;
    private TopPanel top;
    private CaricaCorsi caricaCorsi;
    
    public PreferitiPanel() {
        
        //dichiarazione panel
        top = new TopPanel("Preferiti");
        panel = new JPanel(new BorderLayout());
        nord = new JPanel(new GridBagLayout());
        centro = new JPanel();
        facPanel = new JPanel(new GridBagLayout());
        corsiPanel = new JPanel(new GridBagLayout());
        appPanel = new JPanel(new GridBagLayout());
        libPanel = new JPanel(new GridBagLayout());
        domPanel = new JPanel(new GridBagLayout());
        cardLayout = new CardLayout();
        
        //dichiarazione scroll
        scrollPanel = new JScrollPane(facPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1 = new JScrollPane(corsiPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel2 = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel3 = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel4 = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //dichiarazione icone
        search = new ImageIcon(this.getClass().getResource("/immagini/button2Normal.png"));
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        searchSelected = new ImageIcon(this.getClass().getResource("/immagini/button2Selected.png"));
        
        //dichiarazione bottoni - label
        facoltàPreferiteButton = new JButton("Facoltà",search);
        corsiPreferitiButton = new JButton("Corsi",search);
        appuntiPreferitiButton = new JButton("Appunti",search);
        libriPreferitiButton = new JButton("Libri",search);
        domandePreferiteButton = new JButton("Domande",search);
        noFacoltà = new JLabel("Non hai ancora nessuna facoltà preferita");
        noCorsi = new JLabel("Non hai ancora nessun corso preferito.");
        noAppunti = new JLabel("Non hai ancora nessun appunto preferito");
        noLibri = new JLabel("Non hai ancora nessun libro preferito");
        noDomande = new JLabel("Non hai ancora nessuna domanda preferita");
        
        //dichiarazione gbc
        gbc = new GridBagConstraints();
        gbcd = new GridBagConstraints();
        
        //dichiarazione actionListener
        caricaCorsi = new CaricaCorsi();
        
        setPanelWhite();
        setScrollPanePanel();
        
        centro.setLayout(cardLayout);
        centro.add(scrollPanel,"facoltàPreferite");
        centro.add(scrollPanel1,"corsiPreferiti");
        centro.add(scrollPanel2,"appuntiPreferiti");
        centro.add(scrollPanel3,"libriPreferiti");
        centro.add(scrollPanel4,"domandePreferite");
        
        setButtonCharacteristic(facoltàPreferiteButton);
        setButtonCharacteristic(corsiPreferitiButton);
        setButtonCharacteristic(appuntiPreferitiButton);
        setButtonCharacteristic(libriPreferitiButton);
        setButtonCharacteristic(domandePreferiteButton);
        
        
        facoltàPreferiteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "facoltàPreferite");
                setIconListener(searchSelected, search, search, search, search);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(facoltàPreferiteButton, gbc);
        
        if(dimFacoltàPreferite == 0){
            
            noFacoltà.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            facPanel.add(noFacoltà, gbcd);
            
        }else{
            
            for (int i = 0; i < dimFacoltàPreferite; i++) {
                facoltàPreferite[i] = new JLabel();
                facoltàPreferiteLab[i] = new JLabel();
                facoltàPreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotFacoltà.png")));
                setLabelCharacteristic(i, facoltàPreferiteLab, facoltàPreferite, facoltàPreferiteIco, Applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
                
                facoltàPreferite[i].addMouseListener(caricaCorsi);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 5);
                gbcd.anchor = GridBagConstraints.CENTER;
                facPanel.add(facoltàPreferiteLab[i],gbcd);
            }
        }
        corsiPreferitiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "corsiPreferiti");
                setIconListener(search, searchSelected, search, search, search);
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(corsiPreferitiButton, gbc);
        
        if(dimCorsiPreferiti == 0){
            
            noCorsi.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            corsiPanel.add(noCorsi, gbcd);
            
        }else{
            for (int i = 0; i < dimCorsiPreferiti; i++) {
                corsiPreferiti[i] = new JLabel();
                corsiPreferitiLab[i] = new JLabel();
                corsiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotCorso.png")));
                setLabelCharacteristic(i, corsiPreferitiLab, corsiPreferiti, corsiPreferitiIco,Applicazione.preferiti.getCorsiPreferiti().get(i).getNome());
                
                goToCorso[i] = new GoToCorso(Applicazione.preferiti.getCorsiPreferiti().get(i).getFacoltà());
                corsiPreferiti[i].addMouseListener(goToCorso[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 5);
                gbcd.anchor = GridBagConstraints.CENTER;
                corsiPanel.add(corsiPreferitiLab[i],gbcd);
            }
        }
        
        
        appuntiPreferitiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "appuntiPreferiti");
                setIconListener(search, search, searchSelected, search, search);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiButton, gbc);
        
        if(dimAppuntiPreferiti == 0){
            
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            appPanel.add(noAppunti, gbcd);
            
        }else{
            for (int i = 0; i < dimAppuntiPreferiti; i++) {
                
                appuntiPreferiti[i] = new JLabel();
                appuntiPreferitiLab[i] = new JLabel();
                appuntiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotAppunto.png")));
                
                setLabelCharacteristic(i, appuntiPreferitiLab, appuntiPreferiti, appuntiPreferitiIco, Applicazione.preferiti.getAppuntiPreferiti().get(i).getNome());
                goToAppunto[i] = new GoToAppunto(Applicazione.preferiti.getAppuntiPreferiti().get(i).getCorso(),
                        Applicazione.preferiti.getAppuntiPreferiti().get(i).getFacoltà());
                appuntiPreferiti[i].addMouseListener(goToAppunto[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                appPanel.add(appuntiPreferitiLab[i], gbcd);
            }
        }
        
        libriPreferitiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "libriPreferiti");
                setIconListener(search, search, search, searchSelected, search);
            }
        });
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiButton, gbc);
        
        if(dimLibriPreferiti == 0){
            
            noLibri.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            libPanel.add(noLibri, gbcd);
            
        }else{
            for (int i = 0; i < dimLibriPreferiti; i++) {
                libriPreferiti[i] = new JLabel();
                libriPreferitiLab[i] = new JLabel();
                libriPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotLibro.png")));
                setLabelCharacteristic(i, libriPreferitiLab, libriPreferiti, libriPreferitiIco, Applicazione.preferiti.getLibriPreferiti().get(i).getTitolo());
                
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
        }
        
        domandePreferiteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "domandePreferite");
                setIconListener(search, search, search, search, searchSelected);
                
            }
        });
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteButton, gbc);
        
        if(dimDomandePreferite == 0){
            
            noDomande.setFont(new Font("Arial", Font.BOLD, 20));
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            domPanel.add(noDomande, gbcd);
            
        }else{
            for (int i = 0; i < dimDomandePreferite; i++) {
                domandePreferite[i] = new JLabel();
                domandePreferiteLab[i] = new JLabel();
                domandePreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotDomanda.png")));
                setLabelCharacteristic(i, domandePreferiteLab, domandePreferite, domandePreferiteIco, Applicazione.preferiti.getDomandePreferite().get(i).getTitolo());
                
                goToDomanda[i] = new GoToDomanda(Applicazione.preferiti.getDomandePreferite().get(i).getCorso(),
                        Applicazione.preferiti.getDomandePreferite().get(i).getFacoltà());
                domandePreferite[i].addMouseListener(goToDomanda[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                domPanel.add(domandePreferiteLab[i], gbcd );
            }
        }
        panel.add(nord,BorderLayout.NORTH);
        panel.add(centro,BorderLayout.CENTER);
        
        add(top);
        add(panel);
    }
    
    public void setPanelWhite(){
        top.setBackground(Color.white);
        this.setBackground(Color.white);
        panel.setBackground(Color.white);
        nord.setBackground(Color.white);
        centro.setBackground(Color.white);
        facPanel.setBackground(Color.white);
        corsiPanel.setBackground(Color.white);
        appPanel.setBackground(Color.white);
        libPanel.setBackground(Color.white);
        domPanel.setBackground(Color.white);
    }
    
    public void setScrollPanePanel(){
        
        scrollPanel.setPreferredSize(new Dimension(650, 400));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        scrollPanel1.setPreferredSize(new Dimension(650, 400));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        scrollPanel2.setPreferredSize(new Dimension(650, 400));
        scrollPanel2.getVerticalScrollBar().setUnitIncrement(16);
        
        scrollPanel3.setPreferredSize(new Dimension(650, 400));
        scrollPanel3.getVerticalScrollBar().setUnitIncrement(16);
        
        scrollPanel4.setPreferredSize(new Dimension(650, 400));
        scrollPanel4.getVerticalScrollBar().setUnitIncrement(16);
    }
    
    public void setButtonCharacteristic(JButton button){
        
        button.setPreferredSize(new Dimension(120,25));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setRolloverIcon(searchHover);
        button.setPressedIcon(searchPressed);
        button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        button.setForeground(Color.white);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
    }
    
    public void setLabelCharacteristic(int i, JLabel[] principale, JLabel[] label, JLabel[] ico, String text){
        
        label[i].setText(text);
        label[i].setToolTipText(label[i].getText());
        label[i].setPreferredSize(new Dimension(120, 30));
        label[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
        principale[i].setLayout(new BoxLayout(principale[i], BoxLayout.X_AXIS));
        principale[i].setPreferredSize(new Dimension(220, 30));
        
        principale[i].add(ico[i]);
        principale[i].add(new JLabel("   "));
        principale[i].add(label[i]);
        
    }
    
    public void setIconListener(ImageIcon search, ImageIcon search1, ImageIcon search2, ImageIcon search3, ImageIcon search4){
        facoltàPreferiteButton.setIcon(search);
        corsiPreferitiButton.setIcon(search1);
        appuntiPreferitiButton.setIcon(search2);
        libriPreferitiButton.setIcon(search3);
        domandePreferiteButton.setIcon(search4);
    }
}

