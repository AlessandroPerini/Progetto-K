/*
*  Lista con tutti gli appunti relativi al corso selezionato.
*  Oltre alla lista, è presente un pannello di ricerca di un determinato appunto.
*  Per ogni appunto viene visualizzata anche la valutazione di esso
*/
package Appunti.Vista;

import Appunti.Ascoltatori.GoToAppunto;
import Appunti.Ascoltatori.GoToAggiungiAppunto;
import Application.Controller.Applicazione;
import Appunti.Ascoltatori.CercaAppunti;
import Appunti.Ascoltatori.OrdinaListaAppunti;
import Header.Vista.TopPanel;
import Utils.Vista.CustomScrollBar;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
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
    
    //dichiarazione oggetti
    private JLabel[] appunti;
    private JLabel[] appuntiIcon ;
    private JLabel[] appuntiLabel ;
    private JLabel[] appuntiIcoValutazione ;
    private JTextField searchField;
    private JLabel noAppunti, ordinamento; 
    private JComboBox<String> ordina;
    private JButton addAppunto, searchButton, clearSearch;
    private TopPanel top;
    private Icon search, searchHover, searchPressed, clear, add, addHover, addPressed;
    private JPanel listaPanel, searchPanel, ordinaPanel,borderPanel;
    private GridBagConstraints gbc, gbcd;
    private JScrollPane scrollPanel;
    
    //dichiarazione ascoltatori
    private CercaAppunti cercaAppunti;
    private OrdinaListaAppunti ordinaListaAppunti;
    private GoToAggiungiAppunto aggiungiAppunto;
    private GoToAppunto goToAppunto;
    
    //dichiarazioni variabili
    private String[] opzioni ;
    private int dimListaAppunti;
    private int size ;
    public ListaAppuntiPanel() {
        
        //inizializzazione variabili
        dimListaAppunti = Applicazione.listaAppuntiAttuali.size();
        opzioni = new String[]{"Valutazione", "Nome"};
        size = Applicazione.listaAppuntiAttuali.size();
        
        //inizializzazione pannelli
        top = new TopPanel("Appunti "+Applicazione.corsoAttuale.getNome());
        borderPanel = new JPanel(new BorderLayout());
        listaPanel = new JPanel(new GridBagLayout());
        searchPanel = new JPanel();
        ordinaPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbcd = new GridBagConstraints();
        
        //inizializzazione icone
        search = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        add = new ImageIcon(this.getClass().getResource("/immagini/add.png"));
        addHover = new ImageIcon(this.getClass().getResource("/immagini/addHover.png"));
        addPressed = new ImageIcon(this.getClass().getResource("/immagini/addPressed.png"));
        clear = new ImageIcon(this.getClass().getResource("/immagini/clear.png"));
        
        //inizializzazione bottoni - label - textfield
        scrollPanel = new JScrollPane(borderPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        addAppunto = new JButton("", add);
        clearSearch = new JButton("",clear);
        searchButton = new JButton(search);
        searchField = new JTextField(30);
        appunti = new JLabel[dimListaAppunti];
        appuntiIcon = new JLabel[dimListaAppunti];
        appuntiLabel = new JLabel[dimListaAppunti];
        appuntiIcoValutazione = new JLabel[dimListaAppunti];
        ordina = new JComboBox<>(opzioni);
        
        settaggioComponenti();
        
        cercaAppunti = new CercaAppunti(searchField);
        searchField.addKeyListener(cercaAppunti);
        searchButton.addActionListener(cercaAppunti);

        clearSearch.addActionListener((ActionEvent e) -> {
            searchField.setText("");
        });
        
        searchPanel.add(searchField);
        searchPanel.add(clearSearch);
        searchPanel.add(searchButton);
           
        //pannello ordina
        if(!OrdinaListaAppunti.ordineCorrente.equals("")){
            ordina.setSelectedItem(OrdinaListaAppunti.ordineCorrente);
        }
        
        ordinamento = new JLabel("Ordina per: ");
        ordinamento.setBackground(Color.white);
        
        ordinaListaAppunti = new OrdinaListaAppunti(ordina);
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
   
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addAppunto, gbc);
        // fine pannello ordina
        
        aggiungiAppunto = new GoToAggiungiAppunto();
        addAppunto.addActionListener(aggiungiAppunto);
        
        goToAppunto = new GoToAppunto(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        
        if(size == 0){
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("appunti")) {
                
                noAppunti = new JLabel("Non ci sono appunti relativi a questo corso");
            }
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("appunti cercati")) {
                
                noAppunti = new JLabel("Nessun appunto trovato");
            }
            noAppunti.setFont(new Font("Arial", Font.BOLD, 20));
            listaPanel.add(noAppunti);
            gbcd.gridx = 0;
            gbcd.gridy = 1;
            gbcd.insets = new Insets(170, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            listaPanel.add(noAppunti, gbcd);
            
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
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/0-star-rating.png")));
                    
                }
                if((media>0)&&(media<=1)){
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/1-star-rating.png")));
                    
                }
                if((media>1)&&(media<=2)){
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/2-star-rating.png")));
                    
                }
                if((media>2)&&(media<=3)){
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/3-star-rating.png")));
                    
                }
                if((media>3)&&(media<=4)){
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/4-star-rating.png")));
                    
                }
                if(media>4){
                    
                    appuntiIcoValutazione[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/5-star-rating.png")));
                    
                }
                
                appunti[i].addMouseListener(goToAppunto);
                
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, -7, 0, 10);
                gbcd.anchor = GridBagConstraints.NORTHEAST;
                
                listaPanel.add(appuntiLabel[i], gbcd);
                
                gbcd.gridx = 1;
                gbcd.gridy = i;
                
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 150, 0, 10);
                gbc.anchor = GridBagConstraints.FIRST_LINE_END;
                
                gbc.gridy = 0;
                gbc.insets = new Insets(5, 150, 0, 10);
                gbc.anchor = GridBagConstraints.LINE_END;
                
                listaPanel.add(appuntiIcoValutazione[i], gbcd);
                
            }
        }
   
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanel);
    }
    
    public void settaggioComponenti(){
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        listaPanel.setBackground(Color.white);
        ordinaPanel.setBackground(Color.white);      
        searchPanel.setBackground(Color.white);
        
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Arial", Font.PLAIN, 20));  
        
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setContentAreaFilled(false);
        searchButton.setRolloverIcon(searchHover);
        searchButton.setPressedIcon(searchPressed);
        searchButton.setText("CERCA");
        searchButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        searchButton.setForeground(Color.white);
        searchButton.setHorizontalTextPosition(JButton.CENTER);
        searchButton.setVerticalTextPosition(JButton.CENTER);
        
        clearSearch.setBackground(Color.white);
        clearSearch.setBorder(new LineBorder(Color.white, 1, true));
        
        addAppunto.setRolloverIcon(addHover);
        addAppunto.setPressedIcon(addPressed);
        addAppunto.setBackground(Color.white);
        addAppunto.setPreferredSize(new Dimension(40, 40));
        addAppunto.setBorder(new LineBorder(Color.white, 1));
        
        borderPanel.setBackground(Color.white);
        borderPanel.add(listaPanel,BorderLayout.NORTH);
        
        scrollPanel.setPreferredSize(new Dimension(650, 350));
        scrollPanel.setBackground(Color.white);
        scrollPanel.setBorder(new LineBorder(Color.white));
        scrollPanel.setVerticalScrollBar(new CustomScrollBar());
    }
    
    
}

