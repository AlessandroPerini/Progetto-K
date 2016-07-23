/*
* Pannello dedicato alla visualizzazione di tutto ciò che l'utente
* ha messo come preferiti
*/
package Preferiti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.GoToLibro;
import QeA.Ascoltatori.GoToDomanda;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Corsi.Ascoltatori.GoToCorso;
import Utils.Vista.CustomScrollBar;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
    
    public Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione variabili
    private int dimFacoltàPreferite, dimCorsiPreferiti, dimAppuntiPreferiti,
            dimLibriPreferiti, dimDomandePreferite ;
    
    //sichiarazione array label
    private JLabel[] facoltàPreferite ,corsiPreferiti, appuntiPreferiti ,libriPreferiti,
            domandePreferite, facoltàPreferiteLab, corsiPreferitiLab, appuntiPreferitiLab,
            libriPreferitiLab, domandePreferiteLab, facoltàPreferiteIco, corsiPreferitiIco,
            appuntiPreferitiIco, libriPreferitiIco, domandePreferiteIco;
    
    //dichiarazione array ascoltatori
    private GoToCorso[] goToCorso ;
    private GoToAppunto goToAppunto ;
    private GoToLibro[] goToLibro ;
    private GoToDomanda goToDomanda ;
    
    //dichiarazione bottoni
    private JButton facoltàPreferiteButton, corsiPreferitiButton, appuntiPreferitiButton,
            libriPreferitiButton, domandePreferiteButton;
    
    //dichiarazione icone
    private ImageIcon  search, searchPressed, searchHover, searchSelected;
    
    //dichiarazione label
    private JLabel noFacoltà, noCorsi, noAppunti, noLibri, noDomande;
    
    //dichiarazione pannelli
    private TopPanel top;
    private JPanel panel, nord, centro, facPanel, corsiPanel, appPanel, libPanel, domPanel;
    private JScrollPane scrollPanelFacoltà, scrollPanelCorsi,scrollPanelApp,scrollPanelLibri, scrollPanelDomande;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc, gbcd;
    private CardLayout cardLayout;
    
    //dichiarazione ascoltatori
    private CaricaCorsi caricaCorsi;
    
    public PreferitiPanel() {
        
        //inizializzazione variabili
        dimFacoltàPreferite = applicazione.preferiti.getFacoltàPreferite().size();
        dimCorsiPreferiti = applicazione.preferiti.getCorsiPreferiti().size();
        dimAppuntiPreferiti = applicazione.preferiti.getAppuntiPreferiti().size();
        dimLibriPreferiti = applicazione.preferiti.getLibriPreferiti().size();
        dimDomandePreferite = applicazione.preferiti.getDomandePreferite().size();
        
        //inizializzazione panel
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
        scrollPanelFacoltà = new JScrollPane(facPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelCorsi = new JScrollPane(corsiPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelApp = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelLibri = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDomande = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //inizializzazione icone
        search = new ImageIcon(getClass().getResource("/immagini/button2Normal.png"));
        searchHover = new ImageIcon(getClass().getResource("/immagini/button2Hover.png"));
        searchPressed = new ImageIcon(getClass().getResource("/immagini/button2Pressed.png"));
        searchSelected = new ImageIcon(getClass().getResource("/immagini/button2Selected.png"));
        
        //inizializzazione bottoni - label
        facoltàPreferiteButton = new JButton("Facoltà",searchSelected);
        corsiPreferitiButton = new JButton("Corsi",search);
        appuntiPreferitiButton = new JButton("Appunti",search);
        libriPreferitiButton = new JButton("Libri",search);
        domandePreferiteButton = new JButton("Domande",search);
        noFacoltà = new JLabel("Non hai ancora nessuna facoltà preferita");
        noCorsi = new JLabel("Non hai ancora nessun corso preferito");
        noAppunti = new JLabel("Non hai ancora nessun appunto preferito");
        noLibri = new JLabel("Non hai ancora nessun libro preferito");
        noDomande = new JLabel("Non hai ancora nessuna domanda preferita");
        
        //inizializzazione array testo label
        facoltàPreferite = new JLabel[dimFacoltàPreferite];
        corsiPreferiti = new JLabel[dimCorsiPreferiti];
        appuntiPreferiti = new JLabel[dimAppuntiPreferiti];
        libriPreferiti = new JLabel[dimLibriPreferiti];
        domandePreferite = new JLabel[dimDomandePreferite];
        
        //inizializzazione array icona label
        facoltàPreferiteIco = new JLabel[dimFacoltàPreferite];
        corsiPreferitiIco = new JLabel[dimCorsiPreferiti];
        appuntiPreferitiIco = new JLabel[dimAppuntiPreferiti];
        libriPreferitiIco = new JLabel[dimLibriPreferiti];
        domandePreferiteIco = new JLabel[dimDomandePreferite];
        
        //inizializzazione array label generale
        facoltàPreferiteLab = new JLabel[dimFacoltàPreferite];
        corsiPreferitiLab = new JLabel[dimCorsiPreferiti];
        appuntiPreferitiLab = new JLabel[dimAppuntiPreferiti];
        libriPreferitiLab = new JLabel[dimLibriPreferiti];
        domandePreferiteLab = new JLabel[dimDomandePreferite];
        
        //inizializzazione ascoltatori
        goToCorso = new GoToCorso[dimCorsiPreferiti];
        goToLibro = new GoToLibro[dimLibriPreferiti];
        
        
        //inizializzazione variabili layout
        gbc = new GridBagConstraints();
        gbcd = new GridBagConstraints();
        
        //settaggi
        settaggioSfondiBianchi();
        
        setScrollPanePanel(scrollPanelFacoltà);
        setScrollPanePanel(scrollPanelCorsi);
        setScrollPanePanel(scrollPanelApp);
        setScrollPanePanel(scrollPanelLibri);
        setScrollPanePanel(scrollPanelDomande);
        
        centro.setLayout(cardLayout);
        centro.add(scrollPanelFacoltà,"facoltàPreferite");
        centro.add(scrollPanelCorsi,"corsiPreferiti");
        centro.add(scrollPanelApp,"appuntiPreferiti");
        centro.add(scrollPanelLibri,"libriPreferiti");
        centro.add(scrollPanelDomande,"domandePreferite");
        
        setButtonCharacteristic(facoltàPreferiteButton);
        setButtonCharacteristic(corsiPreferitiButton);
        setButtonCharacteristic(appuntiPreferitiButton);
        setButtonCharacteristic(libriPreferitiButton);
        setButtonCharacteristic(domandePreferiteButton);
        //fine settaggi
        
        //creazione pannelli
        creaPannelloFacoltàPreferite();
        creaPannelloCorsiPreferiti();
        creaPannelloAppuntiPreferiti();
        creaPannelloLibriPreferiti();
        creaPannelloDomandePreferite();
        
        creaPannelloPrincipale();
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
    
    public void settaggioSfondiBianchi(){
        
        top.setBackground(Color.white);
        setBackground(Color.white);
        panel.setBackground(Color.white);
        nord.setBackground(Color.white);
        centro.setBackground(Color.white);
        facPanel.setBackground(Color.white);
        corsiPanel.setBackground(Color.white);
        appPanel.setBackground(Color.white);
        libPanel.setBackground(Color.white);
        domPanel.setBackground(Color.white);
    }
    
    public void setScrollPanePanel(JScrollPane scroll){
        
        scroll.setPreferredSize(new Dimension(650, 400));
        scroll.setBackground(Color.white);
        scroll.setVerticalScrollBar(new CustomScrollBar());
        
    }
    
    public void setLabelCharacteristic(int i, JLabel[] principale, JLabel[] label, JLabel[] ico, String text){
        
        label[i].setText(text);
        label[i].setToolTipText(label[i].getText());
        label[i].setPreferredSize(new Dimension(200, 30));
        label[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
        principale[i].setLayout(new BoxLayout(principale[i], BoxLayout.X_AXIS));
        principale[i].setPreferredSize(new Dimension(240, 30));
        
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
    
    public void creaPannelloFacoltàPreferite(){
        
        facoltàPreferiteButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(centro, "facoltàPreferite");
            setIconListener(searchSelected, search, search, search, search);
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(facoltàPreferiteButton, gbc);
        
        if(dimFacoltàPreferite == 0){
            
            noFacoltà.setFont(new Font("Century Gothic", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            facPanel.add(noFacoltà, gbcd);
            
        }else{
            
            for (int i = 0; i < dimFacoltàPreferite; i++) {
                facoltàPreferite[i] = new JLabel();
                facoltàPreferiteLab[i] = new JLabel();
                facoltàPreferiteIco[i] = new JLabel(new ImageIcon(getClass().getResource("/immagini/dotFacoltà.png")));
                setLabelCharacteristic(i, facoltàPreferiteLab, facoltàPreferite, facoltàPreferiteIco, applicazione.preferiti.getFacoltàPreferite().get(i).getNome());
                caricaCorsi = new CaricaCorsi(facoltàPreferite[i]);
                facoltàPreferiteLab[i].addMouseListener(caricaCorsi);
                
                facoltàPreferite[i].addMouseListener(caricaCorsi);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 5);
                gbcd.anchor = GridBagConstraints.CENTER;
                facPanel.add(facoltàPreferiteLab[i],gbcd);
            }
        }
    }
    
    public void creaPannelloCorsiPreferiti(){
        
        corsiPreferitiButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(centro, "corsiPreferiti");
            setIconListener(search, searchSelected, search, search, search);
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(corsiPreferitiButton, gbc);
        
        if(dimCorsiPreferiti == 0){
            
            noCorsi.setFont(new Font("Century Gothic", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            corsiPanel.add(noCorsi, gbcd);
            
        }else{
            for (int i = 0; i < dimCorsiPreferiti; i++) {
                corsiPreferiti[i] = new JLabel();
                corsiPreferitiLab[i] = new JLabel();
                corsiPreferitiIco[i] = new JLabel(new ImageIcon(getClass().getResource("/immagini/dotCorso.png")));
                setLabelCharacteristic(i, corsiPreferitiLab, corsiPreferiti, corsiPreferitiIco,applicazione.preferiti.getCorsiPreferiti().get(i).getNome());
                
                goToCorso[i] = new GoToCorso(applicazione.preferiti.getCorsiPreferiti().get(i).getFacoltà(),corsiPreferiti[i]);
                corsiPreferitiLab[i].addMouseListener(goToCorso[i]);
                corsiPreferiti[i].addMouseListener(goToCorso[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 5);
                gbcd.anchor = GridBagConstraints.CENTER;
                corsiPanel.add(corsiPreferitiLab[i],gbcd);
            }
        }
    }
    
    public void creaPannelloAppuntiPreferiti(){
        
        appuntiPreferitiButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(centro, "appuntiPreferiti");
            setIconListener(search, search, searchSelected, search, search);
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiButton, gbc);
        
        if(dimAppuntiPreferiti == 0){
            
            noAppunti.setFont(new Font("Century Gothic", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            appPanel.add(noAppunti, gbcd);
            
        }else{
            for (int i = 0; i < dimAppuntiPreferiti; i++) {
                
                appuntiPreferiti[i] = new JLabel();
                appuntiPreferitiLab[i] = new JLabel();
                appuntiPreferitiIco[i] = new JLabel(new ImageIcon(getClass().getResource("/immagini/dotAppunto.png")));
                
                setLabelCharacteristic(i, appuntiPreferitiLab, appuntiPreferiti, appuntiPreferitiIco, applicazione.preferiti.getAppuntiPreferiti().get(i).getNome());
                goToAppunto = new GoToAppunto(applicazione.preferiti.getAppuntiPreferiti().get(i).getCorso(),
                        applicazione.preferiti.getAppuntiPreferiti().get(i).getFacoltà(),appuntiPreferiti[i]);
                appuntiPreferitiLab[i].addMouseListener(goToAppunto);
                appuntiPreferiti[i].addMouseListener(goToAppunto);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                appPanel.add(appuntiPreferitiLab[i], gbcd);
            }
        }
    }
    
    public void creaPannelloLibriPreferiti(){
        
        libriPreferitiButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(centro, "libriPreferiti");
            setIconListener(search, search, search, searchSelected, search);
        });
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiButton, gbc);
        
        if(dimLibriPreferiti == 0){
            
            noLibri.setFont(new Font("Century Gothic", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            libPanel.add(noLibri, gbcd);
            
        }else{
            for (int i = 0; i < dimLibriPreferiti; i++) {
                libriPreferiti[i] = new JLabel();
                libriPreferitiLab[i] = new JLabel();
                libriPreferitiIco[i] = new JLabel(new ImageIcon(getClass().getResource("/immagini/dotLibro.png")));
                setLabelCharacteristic(i, libriPreferitiLab, libriPreferiti, libriPreferitiIco, applicazione.preferiti.getLibriPreferiti().get(i).getTitolo());
                
                goToLibro[i] = new GoToLibro(applicazione.preferiti.getLibriPreferiti().get(i).getCorso(),
                        applicazione.preferiti.getLibriPreferiti().get(i).getFacoltà(),
                        applicazione.preferiti.getLibriPreferiti().get(i).getID(), libriPreferiti[i]);
                libriPreferitiLab[i].addMouseListener(goToLibro[i]);
                libriPreferiti[i].addMouseListener(goToLibro[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                libPanel.add(libriPreferitiLab[i], gbcd );
            }
        }
    }
    
    public void creaPannelloDomandePreferite(){
        
        domandePreferiteButton.addActionListener((ActionEvent e) -> {
            cardLayout.show(centro, "domandePreferite");
            setIconListener(search, search, search, search, searchSelected);
        });
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteButton, gbc);
        
        if(dimDomandePreferite == 0){
            
            noDomande.setFont(new Font("Century Gothic", Font.BOLD, 20));
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            domPanel.add(noDomande, gbcd);
            
        }else{
            for (int i = 0; i < dimDomandePreferite; i++) {
                domandePreferite[i] = new JLabel();
                domandePreferiteLab[i] = new JLabel();
                domandePreferiteIco[i] = new JLabel(new ImageIcon(getClass().getResource("/immagini/dotDomanda.png")));
                setLabelCharacteristic(i, domandePreferiteLab, domandePreferite, domandePreferiteIco, applicazione.preferiti.getDomandePreferite().get(i).getTitolo());
                
                goToDomanda = new GoToDomanda(applicazione.preferiti.getDomandePreferite().get(i).getCorso(),
                        applicazione.preferiti.getDomandePreferite().get(i).getFacoltà(),domandePreferite[i]);
                
                domandePreferiteLab[i].addMouseListener(goToDomanda);
                domandePreferite[i].addMouseListener(goToDomanda);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                domPanel.add(domandePreferiteLab[i], gbcd );
            }
        }
    }
    
    public void creaPannelloPrincipale(){
    
        panel.add(nord,BorderLayout.NORTH);
        panel.add(centro,BorderLayout.CENTER);
        
        add(top);
        add(panel);
    }
}

