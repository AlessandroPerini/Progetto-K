/*
* Pannello dedicato alla visualizzazione della lista delle domande
*/
package QeA.Vista;

import QeA.Ascoltatori.GoToAggiungiDomanda;
import QeA.Ascoltatori.GoToDomanda;
import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import QeA.Ascoltatori.CercaDomande;
import QeA.Ascoltatori.OrdinaListaDomande;
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
public class ListaDomandePanel extends JPanel{
    
    //dichiarazione variaibli
    private int dimListaDomande;
    private String[] opzioni;
    private int size ;
    
    //dichiarazione oggetti
    private JLabel[] domande ,domandeNLike, domandeIcon, domandeLabel;
    private JButton addDomanda, searchButton, clearSearch;
    private JTextField searchField;
    private JLabel noDomande, ordinamento;
    private JComboBox<String> ordina;
    
    //dichiarazione pannelli
    private JPanel searchPanel, ordinaPanel, pannelloPrincipale, centro;
    private JScrollPane scrollPanelPrincipale;
    private TopPanel top ;
    
    //dichiarazione icone
    private Icon search, searchHover, searchPressed;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbcImg, gbc;
    
    //dichiarazione ascoltatori
    private CercaDomande cercaDomande;
    private OrdinaListaDomande ordinaListaDomande;
    private  GoToDomanda goToDomanda;
    private GoToAggiungiDomanda goToAggiungiDomanda;
    
    public ListaDomandePanel() {
        
        //inizializzazione variabili
        dimListaDomande = Applicazione.listaDomandeAttuali.size();
        opzioni = new String[]{"Like", "Nome"};
        size = Applicazione.listaDomandeAttuali.size();
        
        //inizializzazione pannelli
        top = new TopPanel("Domande '"+Applicazione.corsoAttuale.getNome()+"'");
        searchPanel = new JPanel();
        ordinaPanel = new JPanel(new GridBagLayout());
        pannelloPrincipale = new JPanel(new GridBagLayout());
        centro = new JPanel(new BorderLayout());
        gbcImg = new GridBagConstraints();
        gbc = new GridBagConstraints();
        scrollPanelPrincipale = new JScrollPane(centro,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        //inizializzazione icone
        search = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        searchHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        searchPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        
        //inizializzazione oggetti
        domande = new JLabel[dimListaDomande];
        domandeNLike = new JLabel[dimListaDomande];
        domandeIcon = new JLabel[dimListaDomande];
        domandeLabel = new JLabel[dimListaDomande];
        searchField = new JTextField(26);
        searchButton = new JButton(search);
        clearSearch = new JButton("", new ImageIcon(this.getClass().getResource("/immagini/clear.png")));
        ordina = new JComboBox<>(opzioni);
        ordinamento = new JLabel("Ordina per :");
        addDomanda = new JButton( new ImageIcon(this.getClass().getResource("/immagini/add.png")));
        
        //inizializzazione ascoltatori
        cercaDomande = new CercaDomande(searchField);
        goToDomanda = new GoToDomanda(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome());
        goToAggiungiDomanda = new GoToAggiungiDomanda();
        ordinaListaDomande = new OrdinaListaDomande(ordina);

        //creazione pannelli
        creaPannelloRicerca();
        creaPannelloOrdina();
        creaPannelloLista();
        creaPannelloPrincipale();
        
    }
    
    public void creaPannelloRicerca(){
        
        searchPanel.setBackground(Color.white);
        
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
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
        
        searchField.addKeyListener(cercaDomande);
        searchButton.addActionListener(cercaDomande);
        
        clearSearch.addActionListener((ActionEvent e) -> {
            searchField.setText("");
        });
        
        searchPanel.add(searchField);
        searchPanel.add(clearSearch);
        searchPanel.add(searchButton);
    }
    
    public void creaPannelloOrdina(){
        
        ordinaPanel.setBackground(Color.white);
        
        addDomanda.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/addHover.png")));
        addDomanda.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/addPressed.png")));
        addDomanda.setBackground(Color.white);
        addDomanda.setPreferredSize(new Dimension(40, 40));
        addDomanda.setBorder(new LineBorder(Color.white, 1, true));
        addDomanda.addActionListener(goToAggiungiDomanda);
        
        if(!OrdinaListaDomande.ordineCorrente.equals("")){
            ordina.setSelectedItem(OrdinaListaDomande.ordineCorrente);
        }
        
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
        
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addDomanda, gbc);
    }
    
    public void creaPannelloLista(){
        
        if(size == 0){
            noDomande = new JLabel();
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("domande")) {
                noDomande = new JLabel("Non ci sono domande relative a questo corso");
            }
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("domande cercate")) {
                noDomande = new JLabel("Nessuna domanda trovata");
            }
            noDomande.setFont(new Font("Century Gothic", Font.BOLD, 20));
            gbcImg.gridx = 0;
            gbcImg.gridy = 1;
            gbcImg.insets = new Insets(10, 0, 0, 10);
            gbcImg.anchor = GridBagConstraints.LINE_START;
            pannelloPrincipale.add(noDomande, gbcImg);
            
        }else{
            
            for (int i = 0; i < Applicazione.listaDomandeAttuali.size(); i++) {
                domandeLabel[i]= new JLabel();
                domande[i] = new JLabel(Applicazione.listaDomandeAttuali.get(i).getTitolo(), HEIGHT);
                domandeIcon[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotDomanda.png")));
                domande[i].setToolTipText(domande[i].getText());
                domande[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
                domande[i].setName("domande"+i);
                domande[i].setPreferredSize(new Dimension(120, 30));
                domande[i].addMouseListener(goToDomanda);
                domandeLabel[i].setLayout(new BoxLayout(domandeLabel[i], BoxLayout.X_AXIS));
                domandeLabel[i].setPreferredSize(new Dimension(220, 30));
                domandeLabel[i].add(domandeIcon[i]);
                domandeLabel[i].add(new JLabel("   "));
                domandeLabel[i].add(domande[i]);
                gbcImg.gridx = 0;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(17, 0, 0, 20);
                gbcImg.anchor = GridBagConstraints.LINE_END;
                pannelloPrincipale.add(domandeLabel[i], gbcImg);
                
                domandeNLike[i] = new JLabel(""+Applicazione.listaDomandeAttuali.get(i).getLike(), HEIGHT);
                domandeNLike[i].setIconTextGap(-180);
                domandeNLike[i].setFont(new Font("Century Gothic", Font.BOLD, 13));
                domandeNLike[i].setForeground(Color.black);
                gbcImg.gridx = 1;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(18, 0, 0, 5);
                gbcImg.anchor = GridBagConstraints.LINE_END;
                pannelloPrincipale.add(domandeNLike[i], gbcImg);
                
                domandeIcon[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")), HEIGHT);
                gbcImg.gridx = 2;
                gbcImg.gridy = i+1;
                gbcImg.insets = new Insets(10, 0, 0, 10);
                gbcImg.anchor = GridBagConstraints.LINE_START;
                pannelloPrincipale.add(domandeIcon[i], gbcImg);
            }
        }
    }
    
    public void creaPannelloPrincipale(){
        
        centro.setBackground(Color.white);
        centro.add(pannelloPrincipale, BorderLayout.CENTER);
        
        top.setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);
        setBackground(Color.white);
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanelPrincipale);
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 350));
        scrollPanelPrincipale.setBackground(Color.white);
        scrollPanelPrincipale.setVerticalScrollBar(new CustomScrollBar());
    }
}
