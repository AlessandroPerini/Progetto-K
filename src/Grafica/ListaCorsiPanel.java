/*
* Pannello con la lista dei corsi della facoltà selezionata
*/
package Grafica;

import Ascoltatori.Corsi.GoToCorso;
import Application.Applicazione;
import Database.ControlloQuery;
import Database.ListeQuery;
import Ascoltatori.Preferiti.AggiungiCorsoPreferito;
import Ascoltatori.Preferiti.AggiungiFacoltàPreferita;
import Ascoltatori.Preferiti.RimuoviCorsoPreferito;
import Ascoltatori.Preferiti.RimuoviFacoltàPreferita;
import Utility.Ordina;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author te4o
 */
public class ListaCorsiPanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione array oggetti
    private JLabel[] corsi = new JLabel[applicazione.listaCorsiAttuali.size()];
    private JPanel[] panels = new JPanel[3];
    private JPanel[] innerPanels = new JPanel[3];
    private JScrollPane[] scrollP = new JScrollPane[3];
    private TitledBorder[] titoloBordo = new TitledBorder[applicazione.listaRamiFacoltà.size()];
    
    //dichiarazione pannelli
    private JPanel panelloPrincipale, topPref;
    private TopPanel top;
    
    //dichiarazione bottoni
    private JButton  preferitiOn, preferitiOff;
    
    //dichiarazione ascoltatori
    private AggiungiCorsoPreferito aggiungiCorsoPreferito;
    private RimuoviCorsoPreferito rimuoviCorsoPreferito;
    private GoToCorso goToCorso;
    
    public ListaCorsiPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel(applicazione.facoltàAttuale.getNome());
        panelloPrincipale = new JPanel(new GridLayout(1, 3, 10, 0));
        topPref = new JPanel();
        
        //inizializzazione bottoni
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/Grafica/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/Grafica/immagini/preferitiOff.png")));
        
        //inizializzazione ascoltatori
        aggiungiCorsoPreferito = new AggiungiCorsoPreferito();
        rimuoviCorsoPreferito = new RimuoviCorsoPreferito();
     
        //creazione pannelli
        creaPannelloPreferiti();
        creaPannelliCorsi();
        creaPannelloPrincipale();
    }
    
    public void creaPannelloPreferiti(){
        
        JButton preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/Grafica/immagini/preferitiOn.png")));
        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        JButton preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/Grafica/immagini/preferitiOff.png")));
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        
        AggiungiFacoltàPreferita aggiungiFacoltàPreferita = new AggiungiFacoltàPreferita();
        preferitiOff.addActionListener(aggiungiFacoltàPreferita);
        
        RimuoviFacoltàPreferita rimuoviFacoltàPreferita = new RimuoviFacoltàPreferita();
        preferitiOn.addActionListener(rimuoviFacoltàPreferita);
        
        try {
            if (ControlloQuery.controlloFacoltàPreferita()) {
                topPref.add(preferitiOff);
            }
            else {
                topPref.add(preferitiOn);
            }
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo della facoltà preferita");
        }
    }
    
    public void creaPannelliCorsi(){
        
        for (int i = 0; i < 3; i++) {
            
            try {
                ListeQuery.caricaCorsi(i+1);
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei corsi per anno");
            }
            
            Ordina.CorsiXAnno();
            
            //dichiarazione pannelli
            panels[i] = new JPanel(new GridLayout(applicazione.listaCorsiXAnno.size()+1, 1, 0, 15));
            innerPanels[i] = new JPanel();
            scrollP[i] = new JScrollPane();
            titoloBordo[i] = new TitledBorder(""+(i+1)+"° Anno");
            
            titoloBordo[i].setTitleFont(new Font("Century Gothic", Font.BOLD, 17));
            titoloBordo[i].setTitleColor(new Color(0,85,118));
            innerPanels[i].setBorder(titoloBordo[i]);
            
            for (int j = 0; j < applicazione.listaCorsiXAnno.size(); j++) {
                //dichiarazione label
                corsi[j] = new JLabel();
                goToCorso = new GoToCorso(applicazione.facoltàAttuale.getNome(),  corsi[j]);
                
                corsi[j].setPreferredSize(new Dimension(150, 20));
                corsi[j].setFont(new Font("Century Gothic", Font.PLAIN, 14));
                corsi[j].setText(applicazione.listaCorsiXAnno.get(j).getNome());
                corsi[j].setToolTipText(applicazione.listaCorsiXAnno.get(j).getNome());
                corsi[j].setName("corso"+j);
                
                corsi[j].addMouseListener(goToCorso);
                panels[i].add(corsi[j]);
            }
            
            JScrollBar scrollBar = new JScrollBar();
            scrollBar.setPreferredSize(new Dimension(0, 20));
            scrollP[i]= new JScrollPane(panels[i],JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollP[i].setPreferredSize(new Dimension(200, 270));
            scrollP[i].setBorder(new LineBorder(Color.white, 1, true));
            scrollP[i].getVerticalScrollBar().setUnitIncrement(16);
            scrollP[i].setVerticalScrollBar(scrollBar);
            
            scrollP[i].setBackground(Color.white);
            panels[i].setBackground(Color.white);
            innerPanels[i].setBackground(Color.white);
            
            innerPanels[i].add(scrollP[i]);
            panelloPrincipale.add(innerPanels[i]);
            
            applicazione.svuotaCorsiXAnno();
        }
        
    }
    
    public void creaPannelloPrincipale(){
        
        top.setBackground(Color.white);
        panelloPrincipale.setBackground(Color.white);
        topPref.setBackground(Color.white);
        setBackground(Color.white);
        
        add(top);
        add(topPref);
        add(panelloPrincipale);
    }
    
}
