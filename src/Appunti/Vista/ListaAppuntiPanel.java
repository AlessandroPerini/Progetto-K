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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class ListaAppuntiPanel extends JPanel{
    
    private JButton[] appunti = new JButton[Applicazione.listaAppuntiAttuali.size()];
    private JTextField searchField;
    private JLabel noAppunti;
    private JLabel[] appuntiIco = new JLabel[Applicazione.listaAppuntiAttuali.size()];
    private JComboBox ordina;
    private JButton addAppunto, searchButton, clearSearch, ordinaButton;
    private TopPanel top;
    private JPanel panel, searchPanel, ordinaPanel;
    
    public ListaAppuntiPanel() {
        
        top = new TopPanel("Appunti "+Applicazione.corsoAttuale.getNome());
        
       // panel = new JPanel(new GridLayout(Applicazione.listaAppuntiAttuali.size()+4, 1));
        panel = new JPanel(new GridBagLayout());
        ordinaPanel = new JPanel(new GridBagLayout());
        //pannello ricerca
        searchPanel = new JPanel();
        searchField = new JTextField(30);
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));
        addAppunto = new JButton("Aggiungi Appunto");
        searchButton = new JButton("Search");
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbcd = new GridBagConstraints();
        CercaAppunti cercaAppunti = new CercaAppunti(searchField);
        searchField.addKeyListener(cercaAppunti);
        searchButton.addActionListener(cercaAppunti);
        
        clearSearch = new JButton("x");
        
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
        
        ordinaButton = new JButton("Ordina");
        
        OrdinaListaAppunti ordinaListaAppunti = new OrdinaListaAppunti(ordina);
        ordinaButton.addActionListener(ordinaListaAppunti);
        gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(5, 220, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	ordinaPanel.add(ordina, gbc);
        
        gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
        ordinaPanel.add(ordinaButton,gbc);
        
        gbc.gridx = 2;
	gbc.gridy = 0;
	gbc.insets = new Insets(5, 100, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addAppunto, gbc);
        // fine pannello ordina
        
        
        GoToAggiungiAppunto aggiungiAppunto = new GoToAggiungiAppunto();
        addAppunto.addActionListener(aggiungiAppunto);
        
        //panel.add(addAppunto);
        
        GoToAppunto goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        
        int size = Applicazione.listaAppuntiAttuali.size();
        
        if(size == 0){
            noAppunti = new JLabel("Non ci sono appunti relativi a questo corso.");
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            panel.add(noAppunti);
            
        }else{
            for (int i = 0; i < Applicazione.listaAppuntiAttuali.size(); i++) {
                appunti[i] = new JButton();
                appunti[i].setPreferredSize(new Dimension(200, 30));
                appunti[i].setText(Applicazione.listaAppuntiAttuali.get(i).getNome());
                appunti[i].setHorizontalTextPosition(SwingConstants.LEADING);
                appunti[i].setIconTextGap(50);
                
                
                
                float media = Applicazione.listaAppuntiAttuali.get(i).getMedia();
                
                if((media==0)){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\0-star-rating.png"));
                    
                }
                if((media>0)&&(media<=1)){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\1-star-rating.png"));
                    
                }
                if((media>1)&&(media<=2)){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\2-star-rating.png"));
                    
                }
                if((media>2)&&(media<=3)){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\3-star-rating.png"));
                    
                }
                if((media>3)&&(media<=4)){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\4-star-rating.png"));
                    
                }
                if(media>4){
                    appuntiIco[i] = new JLabel(new ImageIcon("files\\immagini\\5-star-rating.png"));
                    
                }
                
                appunti[i].addActionListener(goToAppunto);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 30, 0, 10);
                gbcd.anchor = GridBagConstraints.LINE_START;
                panel.add(appunti[i], gbcd);
                gbcd.gridx = 1;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, 30, 0, 10);
                gbcd.anchor = GridBagConstraints.LINE_START;
                panel.add(appuntiIco[i], gbcd);
                
            }
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanel);
    }
    
    
    
}
