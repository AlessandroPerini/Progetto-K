/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Libri.Vista;

import Libri.Ascoltatori.GoToLibro;
import Libri.Ascoltatori.GoToAggiungiLibro;
import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.CercaLibri;
import java.awt.BorderLayout;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class ListaLibriPanel extends JPanel{
    
    private JLabel[] libri = new JLabel[Applicazione.listaLibriAttuali.size()];
    private JLabel[] libriIcon = new JLabel[Applicazione.listaLibriAttuali.size()];
    private JLabel[] libriLabel = new JLabel[Applicazione.listaLibriAttuali.size()];
    private JTextField searchField;
    private JLabel noLibri, ordinamento;
    private JButton addLibro, searchButton, clearSearch;
    private TopPanel top;
    private Icon search, searchHover, searchPressed;
    private JPanel panel, searchPanel, ordinaPanel ,borderPanel;

    public ListaLibriPanel() {
        
        setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        
        top = new TopPanel("Libri "+Applicazione.corsoAttuale.getNome());
        top.setBackground(Color.white);
        borderPanel = new JPanel(new BorderLayout());
        panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.white);
        ordinaPanel = new JPanel(new GridBagLayout());
        ordinaPanel.setBackground(Color.white);
        
        //pannello ricerca
        searchPanel = new JPanel();
        searchPanel.setBackground(Color.white);
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        
        search = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        searchButton = new JButton(search);
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setContentAreaFilled(false);
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        searchButton.setRolloverIcon(searchHover);
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        searchButton.setPressedIcon(searchPressed);
        searchButton.setText("CERCA");
        searchButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        searchButton.setForeground(Color.white);
        searchButton.setIconTextGap(-77);
        
        CercaLibri cercaLibri = new CercaLibri(searchField);
        
        searchField.addKeyListener(cercaLibri);
        searchButton.addActionListener(cercaLibri);
        
        clearSearch = new JButton("", new ImageIcon(this.getClass().getResource("/immagini/clear.png")));
        clearSearch.setBackground(Color.white);
        clearSearch.setBorder(new LineBorder(Color.white, 1, true));
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
        
        //pannello ordina
        ordinamento = new JLabel("Ordinamento alfabetico");
        ordinamento.setBackground(Color.white);
        ordinamento.setFont(new Font("Century Gothic", Font.BOLD, 13));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 220, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(ordinamento, gbc);
        
        addLibro = new JButton("", new ImageIcon(this.getClass().getResource("/immagini/add.png")));
        addLibro.setRolloverIcon(new ImageIcon(this.getClass().getResource("/immagini/addHover.png")));
        addLibro.setPressedIcon(new ImageIcon(this.getClass().getResource("/immagini/addPressed.png")));
        addLibro.setBackground(Color.white);
        addLibro.setPreferredSize(new Dimension(40, 40));
        addLibro.setBorder(new LineBorder(Color.white, 1, true));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addLibro, gbc);
        //fine pannello ordina
        
        GoToAggiungiLibro aggiungiLibro = new GoToAggiungiLibro();
        addLibro.addActionListener(aggiungiLibro);
        
        int size = Applicazione.listaLibriAttuali.size();
        
        if(size == 0){
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("libri")) {
                noLibri = new JLabel("Non ci sono libri relativi a questo corso.");
            }
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("libri cercati")) {
                noLibri = new JLabel("Nessun libro trovato.");
            }
            noLibri.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(noLibri);
            gbcd.gridx = 0;
            gbcd.gridy = 1;
            gbcd.insets = new Insets(170, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            panel.add(noLibri, gbcd);
            
        }else{
            for (int i = 0; i < Applicazione.listaLibriAttuali.size(); i++) {
                GoToLibro goToLibro = new GoToLibro(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome(), Applicazione.listaLibriAttuali.get(i).getID());
                libriLabel[i]= new JLabel();
                libri[i] = new JLabel(Applicazione.listaLibriAttuali.get(i).getTitolo());
                libri[i].setPreferredSize(new Dimension(120, 30));
                libriIcon[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotLibro.png")));
                libri[i].setToolTipText(Applicazione.listaLibriAttuali.get(i).getTitolo());
                libriLabel[i].setLayout(new BoxLayout(libriLabel[i], BoxLayout.X_AXIS));
                libriLabel[i].setPreferredSize(new Dimension(220, 30));
                libri[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
                libriLabel[i].add(libriIcon[i]);
                libriLabel[i].add(new JLabel("   "));
                libriLabel[i].add(libri[i]);
                
                libri[i].addMouseListener(goToLibro);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, -7, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                panel.add(libriLabel[i], gbcd);
             
            }
        }
        
        borderPanel.setBackground(Color.white);
        borderPanel.add(panel,BorderLayout.NORTH);
        JScrollPane scrollPanel = new JScrollPane(borderPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 350));
        
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanel);
    }
}
