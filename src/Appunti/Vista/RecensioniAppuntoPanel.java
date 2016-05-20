/*
* Pannello dedicato alla visualizzazione delle recensioni riguardanti l'appunto selezionato
* Per ogni recensione viene visualizzata la mail di chi l' ha fatta e il relativo
* punteggio.
*/
package Appunti.Vista;

import Application.Controller.Applicazione;
import Appunti.Ascoltatori.GoToAppunto;
import Header.Vista.TopPanel;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Te4o
 */
public class RecensioniAppuntoPanel extends JPanel{
    
    //dichiarazione oggetti
    private JPanel[] recensioni ;
    private JLabel[] emailRecensioni ;
    private JLabel[] punteggioRecensioni ;
    private JTextArea[] commentoRecensioni ;
    private JPanel[] emailPunteggio ;
    private JScrollPane[] scrollPanel ;
    private JLabel noRecensioni;
    private GridBagConstraints gbc, gbc2;
    private TopPanel top;
    private JPanel panel;
    private JScrollPane scrollPanelPrincipale;
    
    //dichiarazione ascoltatori
    private GoToAppunto goToAppunto;
    
    //dichiarazione variabili
    private int dimListaValutazioni;
    private int size ;
    
    public RecensioniAppuntoPanel() {
        
        //inizializzazione variabili
        dimListaValutazioni = Applicazione.listaValutazioniAttuali.size();
        size = Applicazione.listaValutazioniAttuali.size();
        
        //inizializzazione pannelli
        recensioni = new JPanel[dimListaValutazioni];
        top = new TopPanel("Recensioni "+Applicazione.appuntoAttuale.getNome());
        emailPunteggio = new JPanel[dimListaValutazioni];  
        panel = new JPanel(new GridBagLayout());
        scrollPanel = new JScrollPane[dimListaValutazioni];
        gbc = new GridBagConstraints();
        gbc2 = new GridBagConstraints();
        
        //inizializzazione bottoni - label - textfield
        scrollPanelPrincipale = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        emailRecensioni = new JLabel[dimListaValutazioni];
        punteggioRecensioni = new JLabel[dimListaValutazioni];
        commentoRecensioni = new JTextArea[dimListaValutazioni];
        
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        panel.setBackground(Color.white);
        
        goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());

        if( size == 0){
            
            noRecensioni = new JLabel("Non ci sono recensioni relative a questi appunti");
            panel.add(noRecensioni);
            
        }else{
            for (int i = 0; i < Applicazione.listaValutazioniAttuali.size(); i++) {
                
                recensioni[i] = new JPanel(new GridBagLayout());
                recensioni[i].setPreferredSize(new Dimension(600,80));
                recensioni[i].setBackground(Color.white);
                
                emailPunteggio[i] = new JPanel(new GridBagLayout());
                emailPunteggio[i].setPreferredSize(new Dimension(300,80));
                emailPunteggio[i].setBackground(Color.white);
                
                setBackground(Color.white);
                
                emailRecensioni[i] = new JLabel();
                emailRecensioni[i].setFont(new Font("Century Gothic", Font.PLAIN, 15));
                emailRecensioni[i].setBackground(Color.white);
                
                punteggioRecensioni[i] = new JLabel();
                punteggioRecensioni[i].setFont(new Font("Century Gothic", Font.PLAIN, 15));
                punteggioRecensioni[i].setBackground(Color.white);
                
                commentoRecensioni[i] = new JTextArea();
                commentoRecensioni[i].setFont(new Font("Century Gothic", Font.PLAIN, 13));
                commentoRecensioni[i].setForeground(Color.BLACK);
                commentoRecensioni[i].setBackground(new Color(227,239,243));
                
                scrollPanel[i] = new JScrollPane(commentoRecensioni[i], JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollPanel[i].setPreferredSize(new Dimension(150, 70));
                commentoRecensioni[i].setLineWrap(true);
                commentoRecensioni[i].setWrapStyleWord(true);
                commentoRecensioni[i].setEditable(false);
                scrollPanel[i].setVerticalScrollBar(new CustomScrollBar());
                       
                emailRecensioni[i].setText(Applicazione.listaValutazioniAttuali.get(i).getStudente());
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.anchor = GridBagConstraints.LINE_START;
                emailPunteggio[i].add(emailRecensioni[i], gbc);
                
                punteggioRecensioni[i].setText("Punteggio: "+
                        Integer.toString(Applicazione.listaValutazioniAttuali.get(i).getPunteggio())+" / 5");
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.anchor = GridBagConstraints.LINE_START;
                emailPunteggio[i].add(punteggioRecensioni[i], gbc);
                
                gbc2.gridx = 0;
                gbc2.gridy = 0;
                gbc2.insets = new Insets(0, 0, 0, 0);
                gbc2.anchor = GridBagConstraints.LINE_START;
                recensioni[i].add(emailPunteggio[i], gbc2);
                
                commentoRecensioni[i].setText(Applicazione.listaValutazioniAttuali.get(i).getCommento());
                commentoRecensioni[i].setEditable(false);
                commentoRecensioni[i].setLineWrap(true);
                commentoRecensioni[i].setWrapStyleWord(true);
                gbc2.gridx = 1;
                gbc2.gridy = 0;
                gbc2.insets = new Insets(0, 0, 0, 0);
                gbc2.anchor = GridBagConstraints.CENTER;
                recensioni[i].add(scrollPanel[i], gbc2);
                
                gbc.gridx = 0;
                gbc.gridy = i;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.anchor = GridBagConstraints.CENTER;
                panel.add(recensioni[i], gbc);
            }
        }
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 450));
        scrollPanelPrincipale.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanelPrincipale);
    }
    
}
