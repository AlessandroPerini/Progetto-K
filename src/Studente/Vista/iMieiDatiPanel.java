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
    
    private int dimAppunti =  Applicazione.appuntiGuest.size();
    private int dimLibri = Applicazione.domandeGuest.size();
    private int dimDomande = Applicazione.libriGuest.size();
    
    private JLabel[] appuntiPreferiti = new JLabel[dimAppunti];
    private JLabel[] libriPreferiti = new JLabel[dimLibri];
    private JLabel[] domandePreferite = new JLabel[dimDomande];

    private JLabel[] appuntiPreferitiLab = new JLabel[dimAppunti];
    private JLabel [] libriPreferitiLab = new JLabel[dimLibri];
    private JLabel[] domandePreferiteLab = new JLabel[dimDomande];

    private JLabel[] appuntiPreferitiIco = new JLabel[dimAppunti];
    private JLabel [] libriPreferitiIco = new JLabel[dimLibri];
    private JLabel[] domandePreferiteIco = new JLabel[dimDomande];

    private GoToAppunto[] goToAppunto = new GoToAppunto[dimAppunti];
    private GoToLibro[] goToLibro = new GoToLibro[dimLibri];
    private GoToDomanda[] goToDomanda = new GoToDomanda[dimDomande];
    
    private JButton  appuntiPreferitiButton,
            libriPreferitiButton, domandePreferiteButton;
    private JPanel panel, nord, centro, appPanel, libPanel, domPanel;
    private JScrollPane scrollPanel, scrollPanel2, scrollPanel3;
    private ImageIcon  search, searchPressed, searchHover;
    private GridBagConstraints gbc, gbcd;
    private CardLayout cardLayout = new CardLayout();
    private TopPanel top;
    private CaricaCorsi caricaCorsi;
    
    public iMieiDatiPanel() {
        //dichiarazione panel
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
        
        //dichiarazione scrollPanel
        scrollPanel = new JScrollPane(appPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel2 = new JScrollPane(libPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel3 = new JScrollPane(domPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //dichiarazione icone
        search = new ImageIcon(this.getClass().getResource("/immagini/button2Normal.png"));
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/button2Hover.png"));
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/button2Pressed.png"));
        
        //dichiarazione bottoni

        appuntiPreferitiButton = new JButton("Appunti",search);
        libriPreferitiButton = new JButton("Libri",search);
        domandePreferiteButton = new JButton("Domande",search);
        
        setPanelWhite();
        setScrollPanePanel();
        
        centro.add(scrollPanel,"appuntiPreferiti");
        centro.add(scrollPanel2,"libriPreferiti");
        centro.add(scrollPanel3,"domandePreferite");
        
        setButtonCharacteristic(appuntiPreferitiButton);
        setButtonCharacteristic(libriPreferitiButton);
        setButtonCharacteristic(domandePreferiteButton);
        
        caricaCorsi = new CaricaCorsi();
    
        appuntiPreferitiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "appuntiPreferiti");
                 setIconListener(searchHover,search, search );
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(appuntiPreferitiButton, gbc);
        for (int i = 0; i < dimAppunti; i++) {

            appuntiPreferiti[i] = new JLabel();
            appuntiPreferitiLab[i] = new JLabel();
            appuntiPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
         
            setLabelCharacteristic(i, appuntiPreferitiLab, appuntiPreferiti, appuntiPreferitiIco, Applicazione.appuntiGuest.get(i).getNome());

            goToAppunto[i] = new GoToAppunto(Applicazione.appuntiGuest.get(i).getCorso(),
                    Applicazione.appuntiGuest.get(i).getFacoltà());
            appuntiPreferiti[i].addMouseListener(goToAppunto[i]);
            gbcd.gridx = 0;
            gbcd.gridy = i;
            gbcd.insets = new Insets(5, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.CENTER;
            appPanel.add(appuntiPreferitiLab[i], gbcd);
        }
      
        libriPreferitiButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "libriPreferiti");
               setIconListener(search,searchHover, search);
                
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(libriPreferitiButton, gbc);
        for (int i = 0; i < dimLibri; i++) {
            
            libriPreferiti[i] = new JLabel();
            libriPreferitiLab[i] = new JLabel();
            libriPreferitiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
       
            setLabelCharacteristic(i, libriPreferitiLab, libriPreferiti, libriPreferitiIco, Applicazione.libriGuest.get(i).getTitolo());

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
     
        domandePreferiteButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centro, "domandePreferite");
              setIconListener(search, search, searchHover);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        nord.add(domandePreferiteButton, gbc);
        for (int i = 0; i < Applicazione.domandeGuest.size(); i++) {
            domandePreferite[i] = new JLabel();
            domandePreferiteLab[i] = new JLabel();
            domandePreferiteIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/freccia.png")));
  
            setLabelCharacteristic(i, domandePreferiteLab, domandePreferite, domandePreferiteIco, Applicazione.domandeGuest.get(i).getTitolo());

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
        
        scrollPanel.setPreferredSize(new Dimension(650, 400));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
 
        scrollPanel2.setPreferredSize(new Dimension(650, 400));
        scrollPanel2.getVerticalScrollBar().setUnitIncrement(16);
   
        scrollPanel3.setPreferredSize(new Dimension(650, 400));
        scrollPanel3.getVerticalScrollBar().setUnitIncrement(16);
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
            label[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
            principale[i].setLayout(new BoxLayout(principale[i], BoxLayout.X_AXIS));
            principale[i].setPreferredSize(new Dimension(220, 30));          
            principale[i].add(ico[i]);
            principale[i].add(label[i]);
            
    }
           public void setIconListener(ImageIcon search, ImageIcon search1, ImageIcon search2){
                
                appuntiPreferitiButton.setIcon(search);
                libriPreferitiButton.setIcon(search1);
                domandePreferiteButton.setIcon(search2);
                
    }
}
