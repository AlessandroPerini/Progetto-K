/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.TopPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class RecensioniAppuntoPanel extends JPanel{

    private JPanel[] recensioni = new JPanel[Applicazione.listaValutazioniAttuali.size()];
    private JLabel[] emailRecensioni = new JLabel[Applicazione.listaValutazioniAttuali.size()];
    private JLabel[] punteggioRecensioni = new JLabel[Applicazione.listaValutazioniAttuali.size()];
    private JTextArea[] commentoRecensioni = new JTextArea[Applicazione.listaValutazioniAttuali.size()];
    private JLabel noRecensioni;
    public RecensioniAppuntoPanel() {
    
        TopPanel top = new TopPanel("Recensioni "+Applicazione.corsoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaValutazioniAttuali.size()+1, 1));

        GoToAppunto goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        int size = Applicazione.listaValutazioniAttuali.size();
        if( size == 0){
            noRecensioni = new JLabel("Non ci sono recensioni relative a questi appunti");
            panel.add(noRecensioni);
        }else{
            for (int i = 0; i < Applicazione.listaValutazioniAttuali.size(); i++) {
            recensioni[i] = new JPanel(new GridLayout(1, 3, 5, 0));
            emailRecensioni[i] = new JLabel();
            punteggioRecensioni[i] = new JLabel();
            commentoRecensioni[i] = new JTextArea();
            
            emailRecensioni[i].setText(Applicazione.listaValutazioniAttuali.get(i).getStudente());
            punteggioRecensioni[i].setText(Integer.toString(Applicazione.listaValutazioniAttuali.get(i).getPunteggio()));
            commentoRecensioni[i].setText(Applicazione.listaValutazioniAttuali.get(i).getCommento());
            
            commentoRecensioni[i].setEditable(false);
            commentoRecensioni[i].setLineWrap(true);
            commentoRecensioni[i].setWrapStyleWord(true);
            
            recensioni[i].add(emailRecensioni[i]);
            recensioni[i].add(punteggioRecensioni[i]);
            recensioni[i].add(commentoRecensioni[i]);
            
            panel.add(recensioni[i]);
        }
        }
        
        
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
