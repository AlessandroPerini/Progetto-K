/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import static Application.Controller.Applicazione.svuotaListaFacoltàXRamo;
import Database.Query.ListeQuery;
import Header.Vista.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private JLabel[] facoltà = new JLabel[Applicazione.listaFacoltàAttuali.size()];
    private JPanel[] pannelli = new JPanel[Applicazione.listaRamiFacoltà.size()];
    private JScrollPane[] scrollP = new JScrollPane[Applicazione.listaRamiFacoltà.size()];
   
    private TitledBorder[] titoloBordo = new TitledBorder[Applicazione.listaRamiFacoltà.size()];
    private JPanel panel;
    private TopPanel top;
        
    private JButton searchButton, clearSearch;

        public ListaFacoltàPanel() {
            this.setBackground(Color.white);
            top = new TopPanel("Facoltà");

            panel = new JPanel(new GridLayout(5, 2, 5, 5));
            panel.setBackground(Color.white);
            top.setBackground(Color.white);

            CaricaCorsi caricaCorsi = new CaricaCorsi();

            for (int i = 0; i < Applicazione.listaRamiFacoltà.size(); i++) {

                try {
                    ListeQuery.caricaFacoltà(Applicazione.listaRamiFacoltà.get(i));
                     } catch (SQLException ex) {
                    Logger.getLogger(ListaFacoltàPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pannelli[i] = new JPanel(new GridLayout(Applicazione.listaFacoltàXRamo.size()+1, 1, 0, 5));
                pannelli[i].setBackground(Color.white);
                
                scrollP[i] = new JScrollPane();
                titoloBordo[i] = new TitledBorder(Applicazione.listaRamiFacoltà.get(i));
                
                titoloBordo[i].setTitleFont(new Font("Arial", Font.BOLD, 17));
                titoloBordo[i].setTitleColor(new Color(0,85,118));
                pannelli[i].setBorder(titoloBordo[i]);

                for (int j = 0; j < Applicazione.listaFacoltàXRamo.size(); j++) {
                    facoltà[j] = new JLabel();
                    facoltà[j].setPreferredSize(new Dimension(150, 20));
                    facoltà[j].setFont(new Font("Century Ghotic", Font.PLAIN, 14));
                    facoltà[j].setText(Applicazione.listaFacoltàXRamo.get(j).getNome());
                    facoltà[j].setName("facoltà"+j);
                    facoltà[j].addMouseListener(caricaCorsi);
                    pannelli[i].add(facoltà[j]);
                }
                
                JScrollBar scrollBar = new JScrollBar();
                scrollBar.setBackground(Color.white);
                scrollBar.setPreferredSize(new Dimension(0, 20));
                scrollP[i]= new JScrollPane(pannelli[i],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollP[i].setPreferredSize(new Dimension(30, 210));
                scrollP[i].setBorder(new LineBorder(Color.white, 1, true));
                scrollP[i].getVerticalScrollBar().setUnitIncrement(16);
                scrollP[i].setVerticalScrollBar(scrollBar);
                scrollP[i].setBackground(Color.white);
                panel.add(scrollP[i]);
                svuotaListaFacoltàXRamo();
                
            }

            JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPanel.setPreferredSize(new Dimension(650, 450));
            scrollPanel.setBackground(Color.white);
            scrollPanel.setBorder(new LineBorder(Color.white, 1, true));
            scrollPanel.getVerticalScrollBar().setUnitIncrement(16);

            add(top);
            add(scrollPanel);
           
        }
    
}
    

