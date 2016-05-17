package Studente.Vista;


import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.GoToLibro;
import QeA.Ascoltatori.GoToDomanda;

import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
public class iMieiDatiPanel extends JPanel{
    

    private JLabel[] appuntiPreferiti = new JLabel[Applicazione.appuntiGuest.size()];
    private JLabel [] libriPreferiti = new JLabel[Applicazione.libriGuest.size()];
    private JLabel[] domandePreferite = new JLabel[Applicazione.domandeGuest.size()];
    
 
    private JLabel[] appuntiPreferitiLab = new JLabel[Applicazione.appuntiGuest.size()];
    private JLabel [] libriPreferitiLab = new JLabel[Applicazione.libriGuest.size()];
    private JLabel[] domandePreferiteLab = new JLabel[Applicazione.domandeGuest.size()];
    

    private JLabel[] appuntiPreferitiIco = new JLabel[Applicazione.appuntiGuest.size()];
    private JLabel [] libriPreferitiIco = new JLabel[Applicazione.libriGuest.size()];
    private JLabel[] domandePreferiteIco = new JLabel[Applicazione.domandeGuest.size()];
    

    private GoToAppunto[] goToAppunto = new GoToAppunto[Applicazione.appuntiGuest.size()];
    private GoToLibro[] goToLibro = new GoToLibro[Applicazione.libriGuest.size()];
    private GoToDomanda[] goToDomanda = new GoToDomanda[Applicazione.domandeGuest.size()];
    
    private JButton  appuntiPreferitiLabel,
            libriPreferitiLabel, domandePreferiteLabel;
    private JPanel panel, nord, centro, appPanel, libPanel, domPanel;
   private JScrollPane scrollPanel, scrollPanel2, scrollPanel3;
   private ImageIcon  search, searchPressed, searchHover;
    private CardLayout cardLayout = new CardLayout();
    
    public iMieiDatiPanel() {
        TopPanel top = new TopPanel("Le Mie Attività");
        top.setBackground(Color.white);
        this.setBackground(Color.white);
        panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.white);
        nord = new JPanel(new GridBagLayout());
        nord.setBackground(Color.white);
        centro = new JPanel();
        centro.setBackground(Color.white);
        centro.setLayout(cardLayout);
        
        appPanel = new JPanel(new GridBagLayout());
        appPanel.setBackground(Color.white);
        scrollPanel = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 400));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        libPanel = new JPanel(new GridBagLayout());
        libPanel.setBackground(Color.white);
        scrollPanel2 = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel2.setPreferredSize(new Dimension(650, 400));
        scrollPanel2.getVerticalScrollBar().setUnitIncrement(16);
        domPanel = new JPanel(new GridBagLayout());
        domPanel.setBackground(Color.white);
        scrollPanel3 = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel3.setPreferredSize(new Dimension(650, 400));
        scrollPanel3.getVerticalScrollBar().setUnitIncrement(16);
        
      
        centro.add(scrollPanel,"appuntiPreferiti");
        centro.add(scrollPanel2,"libriPreferiti");
        centro.add(scrollPanel3,"domandePreferite");
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        CaricaCorsi caricaCorsi = new CaricaCorsi();
        
        
       search = new ImageIcon(this.getClass().getResource("/immagini/button2Normal.png"));
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
                appuntiPreferitiLabel.setIcon(searchPressed);
                domandePreferiteLabel.setIcon(search);
                libriPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.appuntiGuest.size(); i++) {
            
            
            appuntiPreferiti[i] = new JLabel();
            appuntiPreferitiLab[i] = new JLabel();
            appuntiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
            appuntiPreferiti[i].setText(Applicazione.appuntiGuest.get(i).getNome());
            appuntiPreferitiLab[i].setLayout(new BoxLayout(appuntiPreferitiLab[i], BoxLayout.X_AXIS));
            appuntiPreferitiLab[i].setPreferredSize(new Dimension(220, 30));
            appuntiPreferiti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            appuntiPreferitiLab[i].add(appuntiPreferitiIco[i]);
            appuntiPreferitiLab[i].add(appuntiPreferiti[i]);
               goToAppunto[i] = new GoToAppunto(Applicazione.appuntiGuest.get(i).getCorso(),
                    Applicazione.appuntiGuest.get(i).getFacoltà());
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
                libriPreferitiLabel.setIcon(searchPressed);
                domandePreferiteLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(search);
  
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiLabel, gbc);
        for (int i = 0; i < Applicazione.libriGuest.size(); i++) {
            libriPreferiti[i] = new JLabel();
            libriPreferitiLab[i] = new JLabel();
            libriPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
            libriPreferiti[i].setText(Applicazione.libriGuest.get(i).getTitolo());
            libriPreferitiLab[i].setLayout(new BoxLayout(libriPreferitiLab[i], BoxLayout.X_AXIS));
            libriPreferitiLab[i].setPreferredSize(new Dimension(220, 30));
            libriPreferiti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            libriPreferitiLab[i].add(libriPreferitiIco[i]);
            libriPreferitiLab[i].add(libriPreferiti[i]);
            goToLibro[i] = new GoToLibro(Applicazione.libriGuest.get(i).getCorso(),
                    Applicazione.libriGuest.get(i).getFacoltà(),
                    Applicazione.libriGuest.get(i).getID());
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
                domandePreferiteLabel.setIcon(searchPressed);
                libriPreferitiLabel.setIcon(search);
                appuntiPreferitiLabel.setIcon(search);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteLabel, gbc);
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            domandePreferite[i] = new JLabel();
            domandePreferiteLab[i] = new JLabel();
            domandePreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
            domandePreferite[i].setText(Applicazione.domandeGuest.get(i).getTitolo());
            domandePreferiteLab[i].setLayout(new BoxLayout(domandePreferiteLab[i], BoxLayout.X_AXIS));
            domandePreferiteLab[i].setPreferredSize(new Dimension(220, 30));
            domandePreferite[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            domandePreferiteLab[i].add(domandePreferiteIco[i]);
            domandePreferiteLab[i].add(domandePreferite[i]);
            goToDomanda[i] = new GoToDomanda(Applicazione.domandeGuest.get(i).getCorso(),
             Applicazione.domandeGuest.get(i).getFacoltà());
            domandePreferite[i].addMouseListener(goToDomanda[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            domPanel.add(domandePreferiteLab[i], gbcd );
        }
        panel.add(nord,BorderLayout.NORTH);
        panel.add(centro,BorderLayout.CENTER);
        
        
        add(top);
        add(panel);
    }
}
