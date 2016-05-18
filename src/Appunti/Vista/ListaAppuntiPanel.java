/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Vista;

import Appunti.Ascoltatori.GoToAppunto;
import Appunti.Ascoltatori.GoToAggiungiAppunto;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.CercaAppunti;
import Appunti.Ascoltatori.OrdinaListaAppunti;
import Header.Vista.TopPanel;
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
public class ListaAppuntiPanel extends JPanel{
    
    private JLabel[] appunti = new JLabel[Applicazione.listaAppuntiAttuali.size()];
    private JLabel[] appuntiIcon = new JLabel[Applicazione.listaAppuntiAttuali.size()];
    private JLabel[] appuntiLabel = new JLabel[Applicazione.listaAppuntiAttuali.size()];
    private JTextField searchField;
    private JLabel noAppunti, ordinamento;
    private JLabel[] appuntiIco = new JLabel[Applicazione.listaAppuntiAttuali.size()];
    private JComboBox ordina;
    private JButton addAppunto, searchButton, clearSearch;
    private TopPanel top;
    private Icon search, searchHover, searchPressed;
    private JPanel panel, searchPanel, ordinaPanel,borderPanel;
    
    public ListaAppuntiPanel() {
        
        setBackground(Color.white);
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        
        top = new TopPanel("Appunti "+Applicazione.corsoAttuale.getNome());
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
        
        CercaAppunti cercaAppunti = new CercaAppunti(searchField);
        
        searchField.addKeyListener(cercaAppunti);
        searchButton.addActionListener(cercaAppunti);
        
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
        String[] opzioni = new String[]{"Valutazione", "Nome"};
        ordina = new JComboBox(opzioni);
        if(!OrdinaListaAppunti.ordineCorrente.equals("")){
            ordina.setSelectedItem(OrdinaListaAppunti.ordineCorrente);
        }
        
        ordinamento = new JLabel("Ordina per: ");
        ordinamento.setBackground(Color.white);
        
        OrdinaListaAppunti ordinaListaAppunti = new OrdinaListaAppunti(ordina);
        ordina.addActionListener(ordinaListaAppunti);
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
        
        addAppunto = new JButton("", new ImageIcon(this.getClass().getResource("/immagini/add.png")));
        addAppunto.setRolloverIcon(new ImageIcon(this.getClass().getResource("/immagini/addHover.png")));
        addAppunto.setPressedIcon(new ImageIcon(this.getClass().getResource("/immagini/addPressed.png")));
        addAppunto.setBackground(Color.white);
        addAppunto.setPreferredSize(new Dimension(40, 40));
        addAppunto.setBorder(new LineBorder(Color.white, 1, true));
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addAppunto, gbc);
        // fine pannello ordina
        
        GoToAggiungiAppunto aggiungiAppunto = new GoToAggiungiAppunto();
        addAppunto.addActionListener(aggiungiAppunto);
        
        GoToAppunto goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        
        int size = Applicazione.listaAppuntiAttuali.size();
        
        if(size == 0){
            noAppunti = new JLabel("Non ci sono appunti relativi a questo corso.");
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(noAppunti);
            gbcd.gridx = 0;
            gbcd.gridy = 1;
            gbcd.insets = new Insets(170, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            panel.add(noAppunti, gbcd);
            
        }else{
            for (int i = 0; i < Applicazione.listaAppuntiAttuali.size(); i++) {
                appuntiLabel[i]= new JLabel();
                appuntiIcon[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotAppunto.png")));
                appunti[i] = new JLabel(Applicazione.listaAppuntiAttuali.get(i).getNome());
                appunti[i].setToolTipText(appunti[i].getText());
                appunti[i].setPreferredSize(new Dimension(120, 30));
                appuntiLabel[i].setLayout(new BoxLayout(appuntiLabel[i], BoxLayout.X_AXIS));
                appuntiLabel[i].setPreferredSize(new Dimension(220, 30));
                appunti[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
                appuntiLabel[i].add(appuntiIcon[i]);
                appuntiLabel[i].add(new JLabel("   "));
                appuntiLabel[i].add(appunti[i]);

                float media = Applicazione.listaAppuntiAttuali.get(i).getMedia();
                
                if((media==0)){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/0-star-rating.png")));
                    
                }
                if((media>0)&&(media<=1)){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/1-star-rating.png")));
                    
                }
                if((media>1)&&(media<=2)){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/2-star-rating.png")));
                    
                }
                if((media>2)&&(media<=3)){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/3-star-rating.png")));
                    
                }
                if((media>3)&&(media<=4)){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/4-star-rating.png")));
                    
                }
                if(media>4){
                    appuntiIco[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/5-star-rating.png")));
                    
                }
                
                appunti[i].addMouseListener(goToAppunto);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, -7, 0, 10);
                gbcd.anchor = GridBagConstraints.NORTHEAST;
                panel.add(appuntiLabel[i], gbcd);
                gbcd.gridx = 1;
                gbcd.gridy = i;
                
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 150, 0, 10);
                gbc.anchor = GridBagConstraints.FIRST_LINE_END;
                
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 150, 0, 10);
                gbc.anchor = GridBagConstraints.LINE_END;
                
                panel.add(appuntiIco[i], gbcd);
                
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

