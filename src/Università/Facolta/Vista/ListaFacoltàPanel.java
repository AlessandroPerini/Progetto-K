/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Vista;

import Application.Controller.Applicazione;
import static Application.Controller.Applicazione.svuotaListaFacoltàXRamo;
import Database.Query.ListeQuery;
import Panel.TopPanel;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

/**
 *
 * @author te4o
 */
public class ListaFacoltàPanel extends JPanel{

    private JLabel[] facoltà = new JLabel[Applicazione.listaFacoltàAttuali.size()];
    private JPanel[] pannelli = new JPanel[Applicazione.ramiFacoltà.size()];
    private JScrollPane[] scrollP = new JScrollPane[Applicazione.ramiFacoltà.size()];
   
    private TitledBorder[] titoloBordo = new TitledBorder[Applicazione.ramiFacoltà.size()];
    private JPanel panel;
    private TopPanel top;
        
    private JButton searchButton, clearSearch;

        public ListaFacoltàPanel() {

            top = new TopPanel("Facoltà");

            panel = new JPanel(new GridLayout(5,2));

            CaricaCorsi caricaCorsi = new CaricaCorsi();

             for (int i = 0; i < Applicazione.ramiFacoltà.size(); i++) {

                ListeQuery.caricaFacoltà(Applicazione.ramiFacoltà.get(i));
                pannelli[i] = new JPanel(new GridLayout(Applicazione.listaFacoltàXRamo.size()+1, 1));
                scrollP[i] = new JScrollPane();
                titoloBordo[i] = new TitledBorder(Applicazione.ramiFacoltà.get(i));
                titoloBordo[i].setTitleFont(new Font("Arial", Font.BOLD, 15));
                titoloBordo[i].setTitleColor(Color.RED);
                pannelli[i].setBorder(titoloBordo[i]);

                for (int j = 0; j < Applicazione.listaFacoltàXRamo.size(); j++) {
                    facoltà[j] = new JLabel();
                    facoltà[j].setText(Applicazione.listaFacoltàXRamo.get(j));

                    facoltà[j].setName("facoltà"+j);
                    facoltà[j].addMouseListener(caricaCorsi);
                    pannelli[i].add(facoltà[j]);
            }
                JScrollBar scrollBar = new JScrollBar();
                scrollBar.setPreferredSize(new Dimension(0, 20));
                scrollP[i]= new JScrollPane(pannelli[i],JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollP[i].setPreferredSize(new Dimension(30, 210));
                scrollP[i].getVerticalScrollBar().setUnitIncrement(5);
                scrollP[i].setVerticalScrollBar(scrollBar);

                panel.add(scrollP[i]);
                svuotaListaFacoltàXRamo();
             }

            JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPanel.setPreferredSize(new Dimension(650, 450));
            scrollPanel.getVerticalScrollBar().setUnitIncrement(16);

            add(top);
            add(scrollPanel);
        }
    
}
    

