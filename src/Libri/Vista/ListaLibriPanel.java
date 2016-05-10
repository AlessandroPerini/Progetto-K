/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Vista;

import Libri.Ascoltatori.GoToLibro;
import Libri.Ascoltatori.GoToAggiungiLibro;
import Application.Controller.Applicazione;
import Header.TopPanel;
import Libri.Ascoltatori.CercaLibri;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class ListaLibriPanel extends JPanel{
    
    private JButton[] libri = new JButton[Applicazione.listaLibriAttuali.size()];
    private JTextField searchField;
    private JLabel noLibri;
    
    private GoToLibro[] goToLibro = new GoToLibro[Applicazione.listaLibriAttuali.size()];

    public ListaLibriPanel() {
    
        TopPanel top = new TopPanel("Libri "+Applicazione.corsoAttuale.getNome());
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaLibriAttuali.size()+3, 1));
        
        //pannello ricerca
        JPanel searchPanel = new JPanel();
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        JButton searchButton = new JButton("Search");
        
        CercaLibri cercaLibri = new CercaLibri(searchField);
        searchField.addKeyListener(cercaLibri);
        searchButton.addActionListener(cercaLibri);

        JButton clearSearch = new JButton("x");
        clearSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchField.setText("");
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(clearSearch);
        searchPanel.add(searchButton);
        // fine pannello ricerca

        panel.add(searchPanel);
        
        JButton addLibro = new JButton("Aggiungi Libro");
        GoToAggiungiLibro aggiungiLibro = new GoToAggiungiLibro();
        addLibro.addActionListener(aggiungiLibro);
        
        panel.add(addLibro);
        
        int size = Applicazione.listaLibriAttuali.size();
        if(size == 0){
            noLibri = new JLabel("Non ci sono libri relativi a questo corso.");
            noLibri.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(noLibri);
        
        }else{
            for (int i = 0; i < Applicazione.listaLibriAttuali.size(); i++) {
                libri[i] = new JButton();
                libri[i].setText(Applicazione.listaLibriAttuali.get(i).getTitolo());
                goToLibro[i] = new GoToLibro(Applicazione.corsoAttuale.getNome(),
                                             Applicazione.facoltàAttuale.getNome(),
                                             Applicazione.listaLibriAttuali.get(i).getID());
                libri[i].addActionListener(goToLibro[i]);
                panel.add(libri[i]);
            }
        }
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    } 
}
