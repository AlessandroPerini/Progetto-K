/*
* Pannello contenete la lista dei libri relativi al corso selezionato
* Contiene anche una ricerca dei libri stessi
* I libri sono ordinati alfabeticamente
* Vi è infine un bottone che porta al form per l'aggiunta di un nuovo libro
*/
package Libri.Vista;

import Libri.Ascoltatori.GoToLibro;
import Libri.Ascoltatori.GoToAggiungiLibro;
import Application.Controller.Applicazione;
import Header.Vista.TopPanel;
import Libri.Ascoltatori.CercaLibri;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    
    //dichiarazione array label
    private JLabel[] libri = new JLabel[Applicazione.listaLibriAttuali.size()];
    private JLabel[] libriIcon = new JLabel[Applicazione.listaLibriAttuali.size()];
    private JLabel[] libriLabel = new JLabel[Applicazione.listaLibriAttuali.size()];
    
    //dichiarazione label - textfield - bottoni
    private JTextField searchField;
    private JLabel noLibri, ordinamento;
    private JButton addLibro, searchButton, clearSearch;
    
    //dichiarazione pannelli
    private TopPanel top;
    private JPanel panelloPrincipale, searchPanel, ordinaPanel;
    private JScrollPane scrollPanelPrincipale;
    
    //dichiarazione ascoltatori
    private CercaLibri cercaLibri;
    private GoToAggiungiLibro goToAggiungiLibro;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc, gbcd;
    
    //dichiarazione variabili
    private int nLibri;
    
    public ListaLibriPanel() {
        
        //inizializzazione label - textfield - bottoni
        ordinamento = new JLabel("Ordinamento alfabetico");
        searchField = new JTextField(26);
        searchButton = new JButton(new ImageIcon(getClass().getResource("/immagini/buttonNormal.png")));
        clearSearch = new JButton("", new ImageIcon(getClass().getResource("/immagini/clear.png")));
        addLibro = new JButton("", new ImageIcon(getClass().getResource("/immagini/add.png")));
        
        //inizializzazione pannelli
        top = new TopPanel("Libri '"+Applicazione.corsoAttuale.getNome()+"'");
        panelloPrincipale = new JPanel(new GridBagLayout());
        searchPanel = new JPanel();
        ordinaPanel = new JPanel(new GridBagLayout());
        scrollPanelPrincipale = new JScrollPane(panelloPrincipale,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        //inizializzazione ascoltatori
        goToAggiungiLibro = new GoToAggiungiLibro();
        cercaLibri = new CercaLibri(searchField);
        
        //inizializzazione variabili layout
        gbc = new GridBagConstraints();
        gbcd = new GridBagConstraints();
        
        //inizializzazione variabili
        nLibri = Applicazione.listaLibriAttuali.size();
        
        //creazione pannelli
        creaPannelloRicerca();
        creaPannelloOrdina();
        creaPannelloLista();
        creaPannelloPrincipale();
        
    }
    
    public void creaPannelloRicerca(){
        
        searchField.setHorizontalAlignment(SwingConstants.CENTER);
        searchField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        
        searchButton.setBorder(BorderFactory.createEmptyBorder());
        searchButton.setContentAreaFilled(false);
        searchButton.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/buttonHover.png")));
        searchButton.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/buttonPressed.png")));
        searchButton.setText("CERCA");
        searchButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        searchButton.setForeground(Color.white);
        searchButton.setIconTextGap(-77);
        
        searchField.addKeyListener(cercaLibri);
        searchButton.addActionListener(cercaLibri);
        
        clearSearch.setBackground(Color.white);
        clearSearch.setBorder(new LineBorder(Color.white, 1, true));
        clearSearch.addActionListener((ActionEvent e) -> {
            searchField.setText("");
        });
        
        searchPanel.setBackground(Color.white);
        
        searchPanel.add(searchField);
        searchPanel.add(clearSearch);
        searchPanel.add(searchButton);
    }
    
    public void creaPannelloOrdina(){
        
        ordinamento.setBackground(Color.white);
        ordinamento.setFont(new Font("Century Gothic", Font.BOLD, 13));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 220, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(ordinamento, gbc);
        
        addLibro.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/addHover.png")));
        addLibro.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/addPressed.png")));
        addLibro.setBackground(Color.white);
        addLibro.setPreferredSize(new Dimension(40, 40));
        addLibro.setBorder(new LineBorder(Color.white, 1, true));
        addLibro.addActionListener(goToAggiungiLibro);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 150, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        ordinaPanel.add(addLibro, gbc);
        
        ordinaPanel.setBackground(Color.white);
        
    }
    
    public void creaPannelloLista(){
        
        if(nLibri == 0){
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("libri")) {
                noLibri = new JLabel("Non ci sono libri relativi a questo corso");
            }
            if (Applicazione.back.get(Applicazione.back.size()-1).equals("libri cercati")) {
                noLibri = new JLabel("Nessun libro trovato");
            }
            noLibri.setFont(new Font("Century Gothic", Font.BOLD, 20));
            panelloPrincipale.add(noLibri);
            gbcd.gridx = 0;
            gbcd.gridy = 1;
            gbcd.insets = new Insets(170, 0, 0, 10);
            gbcd.anchor = GridBagConstraints.LINE_START;
            panelloPrincipale.add(noLibri, gbcd);
            
        }else{
            for (int i = 0; i < Applicazione.listaLibriAttuali.size(); i++) {
                GoToLibro goToLibro = new GoToLibro(Applicazione.corsoAttuale.getNome(), Applicazione.facoltàAttuale.getNome(), Applicazione.listaLibriAttuali.get(i).getID());
                libriLabel[i]= new JLabel();
                libri[i] = new JLabel(Applicazione.listaLibriAttuali.get(i).getTitolo());
                libri[i].setPreferredSize(new Dimension(200, 30));
                libriIcon[i] = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/dotLibro.png")));
                libri[i].setToolTipText(Applicazione.listaLibriAttuali.get(i).getTitolo());
                libriLabel[i].setLayout(new BoxLayout(libriLabel[i], BoxLayout.X_AXIS));
                libriLabel[i].setPreferredSize(new Dimension(240, 30));
                libri[i].setFont(new Font("Century Gothic", Font.BOLD, 15));
                libriLabel[i].add(libriIcon[i]);
                libriLabel[i].add(new JLabel("   "));
                libriLabel[i].add(libri[i]);
                
                libri[i].addMouseListener(goToLibro);
                gbcd.gridx = 0;
                gbcd.gridy = i;
                gbcd.insets = new Insets(5, -7, 0, 10);
                gbcd.anchor = GridBagConstraints.CENTER;
                panelloPrincipale.add(libriLabel[i], gbcd);
                
            }
        }
    }
    
    public void creaPannelloPrincipale(){
        
        scrollPanelPrincipale.setPreferredSize(new Dimension(650, 350));
        scrollPanelPrincipale.setBackground(Color.white);
        scrollPanelPrincipale.setVerticalScrollBar(new CustomScrollBar());
        
        setBackground(Color.white);
        panelloPrincipale.setBackground(Color.white);
        top.setBackground(Color.white);
        
        add(top);
        add(searchPanel);
        add(ordinaPanel);
        add(scrollPanelPrincipale);
    }
}
