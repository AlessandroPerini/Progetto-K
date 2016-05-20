/*
*Pannello dedicato alla visualizzazione dei dati caricati dall'utente:
* lista degli appunti da lui caricati, lista dei libri, e lista delle domande
* da lui poste
*/

package Studenti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.GoToLibro;
import QeA.Ascoltatori.GoToDomanda;
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
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class iMieiDatiPanel extends JPanel{
    //dichiarazione variabili
    private int dimAppunti,dimLibri, dimDomande ;
    
    //dichiarazione oggetti
    
    private JLabel[] mieiAppunti, mieiLibri, mieDomande, mieiAppuntiLab ,mieiLibriLab, mieDomandeLab,
                        mieiAppuntiIco ,mieiLibriIco, mieDomandeIco;

    private GoToAppunto[] goToAppunto;
    private GoToLibro[] goToLibro;
    private GoToDomanda[] goToDomanda;
    
    private JButton  mieiAppuntiButton, mieiLibriButton, mieDomandeButton;            
    private JPanel panel, nord, centro, appPanel, libPanel, domPanel;
    private JScrollPane scrollPanelAppunti, scrollPanelLibri, scrollPanelDomande;
    private ImageIcon  search, searchPressed, searchHover, searchSelected;
    private GridBagConstraints gbc, gbcd;
    private JLabel  noAppunti, noLibri, noDomande;
    private CardLayout cardLayout = new CardLayout();
    private TopPanel top;
    
    public iMieiDatiPanel() {
        
        // inizializzazine variabili
        dimAppunti =  Applicazione.appuntiGuest.size();
        dimLibri = Applicazione.libriGuest.size();
        dimDomande = Applicazione.domandeGuest.size();
    
        //inizializzazione pannelli
        top = new TopPanel("Le Mie Attività");
        panel = new JPanel(new BorderLayout());
        nord = new JPanel(new GridBagLayout());
        centro = new JPanel();
        centro.setLayout(cardLayout);
        appPanel = new JPanel(new GridBagLayout());
        libPanel = new JPanel(new GridBagLayout());
        domPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbcd = new GridBagConstraints();
        
        //inizializzazione scrollPanel
        scrollPanelAppunti = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelLibri = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanelDomande = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //inizializzazione icone
        search = new ImageIcon(this.getClass().getResource("/immagini/button2Normal.png"));
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        searchSelected = new ImageIcon(this.getClass().getResource("/immagini/button2Selected.png"));
        
        //inizializzazione bottoni - label
        noLibri = new JLabel("Non hai ancora caricato nessun libro");
        noAppunti = new JLabel("Non hai ancora aggiunto nessun appunto");
        noDomande = new JLabel("Non hai ancora inserito nessuna domanda");
        mieiAppuntiButton = new JButton("Appunti",searchSelected);
        mieiLibriButton = new JButton("Libri",search);
        mieDomandeButton = new JButton("Domande",search);
        
        mieiAppunti = new JLabel[dimAppunti];
        mieiLibri = new JLabel[dimLibri];
        mieDomande = new JLabel[dimDomande];

        mieiAppuntiLab = new JLabel[dimAppunti];
        mieiLibriLab = new JLabel[dimLibri];
        mieDomandeLab = new JLabel[dimDomande];

        mieiAppuntiIco = new JLabel[dimAppunti];
        mieiLibriIco = new JLabel[dimLibri];
        mieDomandeIco = new JLabel[dimDomande];
        
        //inizializzazine ascoltatori
        goToAppunto = new GoToAppunto[dimAppunti];
        goToLibro = new GoToLibro[dimLibri];
        goToDomanda = new GoToDomanda[dimDomande];
        
        setPanelWhite();
        setScrollPanePanel();
        
        centro.add(scrollPanelAppunti,"appuntiPreferiti");
        centro.add(scrollPanelLibri,"libriPreferiti");
        centro.add(scrollPanelDomande,"domandePreferite");
        
        setButtonCharacteristic(mieiAppuntiButton);
        setButtonCharacteristic(mieiLibriButton);
        setButtonCharacteristic(mieDomandeButton);

    
        mieiAppuntiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "appuntiPreferiti");
                 setIconListener(searchSelected, search, search );
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(mieiAppuntiButton, gbc);
        if(dimAppunti == 0){
            
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            appPanel.add(noAppunti, gbcd);
            
        }else{
            for (int i = 0; i < dimAppunti; i++) {

                mieiAppunti[i] = new JLabel();
                mieiAppuntiLab[i] = new JLabel();
                mieiAppuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotAppunto.png")));

                setLabelCharacteristic(i, mieiAppuntiLab, mieiAppunti, mieiAppuntiIco, Applicazione.appuntiGuest.get(i).getNome());

                goToAppunto[i] = new GoToAppunto(Applicazione.appuntiGuest.get(i).getCorso(),
                        Applicazione.appuntiGuest.get(i).getFacoltà());
                mieiAppunti[i].addMouseListener(goToAppunto[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                appPanel.add(mieiAppuntiLab[i], gbcd);
            }
        }
      
        mieiLibriButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "libriPreferiti");
               setIconListener(search, searchSelected, search);
                
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(mieiLibriButton, gbc);
        
        if(dimLibri == 0){
            
            noLibri.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            libPanel.add(noLibri, gbcd);
            
        }else{
            for (int i = 0; i < dimLibri; i++) {

                mieiLibri[i] = new JLabel();
                mieiLibriLab[i] = new JLabel();
                mieiLibriIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotLibro.png")));

                setLabelCharacteristic(i, mieiLibriLab, mieiLibri, mieiLibriIco, Applicazione.libriGuest.get(i).getTitolo());

                goToLibro[i] = new GoToLibro(Applicazione.libriGuest.get(i).getCorso(),
                        Applicazione.libriGuest.get(i).getFacoltà(),
                        Applicazione.libriGuest.get(i).getID());
                mieiLibri[i].addMouseListener(goToLibro[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                libPanel.add(mieiLibriLab[i], gbcd );
            }
        }
     
        mieDomandeButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "domandePreferite");
              setIconListener(search, search, searchSelected);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(mieDomandeButton, gbc);
        
        if(dimDomande == 0){
            noDomande.setFont(new Font("Arial", Font.BOLD, 20));
            
            gbcd.gridx = 0;
            gbcd.gridy = 0;
            gbcd.insets = new Insets(10, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            domPanel.add(noDomande, gbcd);
            
        }else{
            for (int i = 0; i < dimDomande; i++) {
                mieDomande[i] = new JLabel();
                mieDomandeLab[i] = new JLabel();
                mieDomandeIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotDomanda.png")));
                setLabelCharacteristic(i, mieDomandeLab, mieDomande, mieDomandeIco, Applicazione.domandeGuest.get(i).getTitolo());

                goToDomanda[i] = new GoToDomanda(Applicazione.domandeGuest.get(i).getCorso(),
                        Applicazione.domandeGuest.get(i).getFacoltà());
                mieDomande[i].addMouseListener(goToDomanda[i]);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 0, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                domPanel.add(mieDomandeLab[i], gbcd );
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
        appPanel.setBackground(Color.white);
        libPanel.setBackground(Color.white);
        domPanel.setBackground(Color.white);
    }
    
    public void setScrollPanePanel(){
        
        scrollPanelAppunti.setPreferredSize(new Dimension(650, 400));
        scrollPanelAppunti.setBackground(Color.white);
        scrollPanelAppunti.setBorder(new LineBorder(Color.white));
        scrollPanelAppunti.setVerticalScrollBar(new CustomScrollBar());
 
        scrollPanelLibri.setPreferredSize(new Dimension(650, 400));
        scrollPanelLibri.setBackground(Color.white);
        scrollPanelLibri.setBorder(new LineBorder(Color.white));
        scrollPanelLibri.setVerticalScrollBar(new CustomScrollBar());
   
        scrollPanelDomande.setPreferredSize(new Dimension(650, 400));
        scrollPanelDomande.setBackground(Color.white);
        scrollPanelDomande.setBorder(new LineBorder(Color.white));
        scrollPanelDomande.setVerticalScrollBar(new CustomScrollBar());
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
        
    public void setIconListener(ImageIcon search, ImageIcon search1, ImageIcon search2){
                
        mieiAppuntiButton.setIcon(search);
        mieiLibriButton.setIcon(search1);
        mieDomandeButton.setIcon(search2);
                
    }
}


