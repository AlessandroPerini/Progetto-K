/*
* Pannello contenente la lista di tutte le facoltà presenti
* raggruppate per ramo 
*/
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import Database.Query.ListeQuery;
import Header.Vista.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
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
public class ListaFacoltàPanel extends JPanel{

    //dichiarazione array oggetti
    private JLabel[] facoltà = new JLabel[Applicazione.listaFacoltàAttuali.size()];
    private JPanel[] panels = new JPanel[Applicazione.listaRamiFacoltà.size()];
    private JPanel[] innerPanels = new JPanel[Applicazione.listaRamiFacoltà.size()];
    private JScrollPane[] scrollP = new JScrollPane[Applicazione.listaRamiFacoltà.size()];
    private TitledBorder[] titoloBordo = new TitledBorder[Applicazione.listaRamiFacoltà.size()];
    
    //dichiarazione pannelli
    private JPanel panelloPrincipale;
    private TopPanel top;
    private JScrollPane scrollPanelPrincipale;
    
    //dichiarazione bottoni
    private JButton searchButton, clearSearch;
    
    //dichiarazione ascoltatori
    private CaricaCorsi caricaCorsi;

    public ListaFacoltàPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel("Facoltà"); top.setBackground(Color.white);
        panelloPrincipale = new JPanel(new GridLayout(5, 2, 5, 5)); panelloPrincipale.setBackground(Color.white);
                
        //inizializzazione ascoltatori
     

        //inizializzazione scrollPanel
        scrollPanelPrincipale = new JScrollPane(panelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //creazione pannelli
        creaPannelliFacoltà();
        creaScrollPanelloPrincipale();

    }
    
    public void creaPannelliFacoltà(){
    
        for (int i = 0; i < Applicazione.listaRamiFacoltà.size(); i++) {

            try {
                ListeQuery.caricaFacoltà(Applicazione.listaRamiFacoltà.get(i));
                 } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento delle facoltà per ramo");
            }
            
            //inizializzazione pannelli
            panels[i] = new JPanel(new GridLayout(Applicazione.listaFacoltàXRamo.size()+1, 1, 0, 10));
            innerPanels[i] = new JPanel();
            scrollP[i] = new JScrollPane();
            titoloBordo[i] = new TitledBorder(Applicazione.listaRamiFacoltà.get(i));

            titoloBordo[i].setTitleFont(new Font("Century Gothic", Font.BOLD, 17));
            titoloBordo[i].setTitleColor(new Color(0,85,118));
            innerPanels[i].setBorder(titoloBordo[i]);

            for (int j = 0; j < Applicazione.listaFacoltàXRamo.size(); j++) {
                //inizializzazione label
                facoltà[j] = new JLabel();
                caricaCorsi = new CaricaCorsi(  facoltà[j]);
                facoltà[j].setPreferredSize(new Dimension(150, 20));
                facoltà[j].setFont(new Font("Century Gothic", Font.PLAIN, 14));
                facoltà[j].setText(Applicazione.listaFacoltàXRamo.get(j).getNome());
                facoltà[j].setName("facoltà"+j);
                facoltà[j].addMouseListener(caricaCorsi);
                panels[i].add(facoltà[j]);
            }

            JScrollBar scrollBar = new JScrollBar();
            scrollBar.setPreferredSize(new Dimension(0, 20));
            scrollP[i]= new JScrollPane(panels[i],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollP[i].setPreferredSize(new Dimension(252, 182));
            scrollP[i].setBorder(new LineBorder(Color.white, 1, true));
            scrollP[i].getVerticalScrollBar().setUnitIncrement(24);
            scrollP[i].setVerticalScrollBar(scrollBar);
            
            scrollP[i].setBackground(Color.white);
            innerPanels[i].setBackground(Color.white);
            panels[i].setBackground(Color.white);
            
            innerPanels[i].add(scrollP[i]);
            panelloPrincipale.add(innerPanels[i]);
            
            Applicazione.svuotaListaFacoltàXRamo();

        }
    
    }
    
    public void creaScrollPanelloPrincipale(){
    
        setBackground(Color.white);
       
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 450));
        scrollPanelPrincipale.setBackground(Color.white);
        scrollPanelPrincipale.setBorder(new LineBorder(Color.white));
        scrollPanelPrincipale.setVerticalScrollBar(new CustomScrollBar());
        
        add(top);
        add(scrollPanelPrincipale);
    }
}
    

