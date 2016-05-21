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
    private JPanel panel;
    private TopPanel top;
    private JScrollPane scrollPanel;
    
    //dichiarazione bottoni
    private JButton searchButton, clearSearch;
    
    //dichiarazione ascoltatori
    private CaricaCorsi caricaCorsi;

    public ListaFacoltàPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel("Facoltà"); top.setBackground(Color.white);
        panel = new JPanel(new GridLayout(5, 2, 5, 5)); panel.setBackground(Color.white);
                
        //inizializzazione ascoltatori
        caricaCorsi = new CaricaCorsi();

        //inizializzazione scrollPanel
        scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //creazione pannelli
        creaPannelli();
        creaScrollPanel();
 
        add(top);
        add(scrollPanel);

    }
    
    public void creaPannelli(){
    
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
            panel.add(innerPanels[i]);
            
            Applicazione.svuotaListaFacoltàXRamo();

        }
    
    }
    
    public void creaScrollPanel(){
    
        setBackground(Color.white);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.setBackground(Color.white);
        scrollPanel.setBorder(new LineBorder(Color.white));
        scrollPanel.setVerticalScrollBar(new CustomScrollBar());
    }
}
    

