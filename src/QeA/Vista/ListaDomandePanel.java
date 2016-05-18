/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Vista;

import QeA.Ascoltatori.GoToAggiungiDomanda;
import QeA.Ascoltatori.GoToDomanda;
import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import QeA.Ascoltatori.CercaDomande;
import QeA.Ascoltatori.OrdinaListaDomande;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class ListaDomandePanel extends JPanel{
    
    private JLabel[] domande = new JLabel[Applicazione.listaDomandeAttuali.size()];
    private JLabel[] domandeNLike = new JLabel[Applicazione.listaDomandeAttuali.size()];
    private JLabel[] domandeIco = new JLabel[Applicazione.listaDomandeAttuali.size()];
    private JButton addDomanda, searchButton, clearSearch;
    private JTextField searchField;
    private JLabel noDomande, ordinamento;
    private JComboBox ordina;
    private JPanel searchPanel, ordinaPanel, panel, centro;
    private Icon search, searchHover, searchPressed;
    
    public ListaDomandePanel() {
        
        this.setBackground(Color.white);
        TopPanel top = new TopPanel("Domande ");
        top.setBackground(Color.white);
        ordinaPanel = new JPanel(new GridBagLayout());
        panel = new JPanel(new GridBagLayout());
        centro = new JPanel(new BorderLayout());
        centro.setBackground(Color.white);
        panel.setBackground(Color.white);
        
        GridBagConstraints gbcImg = new GridBagConstraints();
        GridBagConstraints gbc = new GridBagConstraints();
        
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
        
        CercaDomande cercaDomande = new CercaDomande(searchField);
        searchField.addKeyListener(cercaDomande);
        searchButton.addActionListener(cercaDomande);
        
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
        ordinaPanel.setBackground(Color.white);
        String[] opzioni = new String[]{"Like", "Nome"};
        ordina = new JComboBox(opzioni);
        if(!OrdinaListaDomande.ordineCorrente.equals("")){
            ordina.setSelectedItem(OrdinaListaDomande.ordineCorrente);
        }
        
        ordinamento = new JLabel("Ordina per :");
        OrdinaListaDomande ordinaListaDomande = new OrdinaListaDomande(ordina);
        ordina.addActionListener(ordinaListaDomande);
        
        ordina.setBackground(Color.white);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 220, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(ordinamento, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        ordinaPanel.add(ordina,gbc);
        
        addDomanda = new JButton("Aggiungi\n Domanda");
        addDomanda = new JButton("", new ImageIcon(this.getClass().getResource("/immagini/add.png")));
        addDomanda.setRolloverIcon(new ImageIcon(this.getClass().getResource("/immagini/addHover.png")));
        addDomanda.setPressedIcon(new ImageIcon(this.getClass().getResource("/immagini/addPressed.png")));
        addDomanda.setBackground(Color.white);
        addDomanda.setPreferredSize(new Dimension(40, 40));
        addDomanda.setBorder(new LineBorder(Color.white, 1, true));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addDomanda, gbc);
        // fine pannello ordina
        
        GoToDomanda goToDomanda = new GoToDomanda(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        GoToAggiungiDomanda goToAggiungiDomanda = new GoToAggiungiDomanda();
        
        addDomanda.addActionListener(goToAggiungiDomanda);
        
        int size = Applicazione.listaDomandeAttuali.size();
        if(size == 0){
            noDomande = new JLabel();
            noDomande.setText("Non ci sono domande relative a questo corso.");
            noDomande.setFont(new Font("Century Gothic", Font.BOLD, 20));
            gbcImg.gridx = 0;
            gbcImg.gridy = 1;
            gbcImg.insets = new Insets(10, 0, 0, 10);
            gbcImg.anchor = GridBagConstraints.LINE_START;
            panel.add(noDomande, gbcImg);
            
        }else{
            
            for (int i = 0; i < Applicazione.listaDomandeAttuali.size(); i++) {
                domande[i] = new JLabel(Applicazione.listaDomandeAttuali.get(i).getTitolo(), HEIGHT);
                domande[i].setToolTipText(domande[i].getText());
                domande[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
                domande[i].setName("domande"+i);
                domande[i].setPreferredSize(new Dimension(220, 30));
                domande[i].addMouseListener(goToDomanda);
                gbcImg.gridx = 0;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(17, 0, 0, 20);
                gbcImg.anchor = GridBagConstraints.LINE_END;
                panel.add(domande[i], gbcImg);
                
                domandeNLike[i] = new JLabel(""+Applicazione.listaDomandeAttuali.get(i).getLike(), HEIGHT);
                domandeNLike[i].setIconTextGap(-200);
                
                domandeNLike[i].setFont(new Font("Century Gothic", Font.BOLD, 13));
                domandeNLike[i].setForeground(Color.blue);
                gbcImg.gridx = 1;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(17, 0, 0, -21);
                gbcImg.anchor = GridBagConstraints.LINE_END;
                panel.add(domandeNLike[i], gbcImg);
                
                domandeIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")), HEIGHT);
                gbcImg.gridx = 2;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(10, 0, 0, 10);
                gbcImg.anchor = GridBagConstraints.LINE_START;
                panel.add(domandeIco[i], gbcImg);
            }
        }
        
        
        centro.add(panel, BorderLayout.CENTER);
        JScrollPane scrollPanel = new JScrollPane(centro,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 350));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        scrollPanel.setBackground(Color.white);
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanel);
    }
    
}
