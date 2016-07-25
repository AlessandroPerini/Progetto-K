/*
* Pannello per la scelta tra appunti, libri o domande relative a un corso
*/
package Vista;

import Ascoltatori.Appunti.CaricaAppunti;
import Application.Applicazione;
import Database.ControlloQuery;
import Ascoltatori.Libri.CaricaLibri;
import Vista.TopPanel;
import Ascoltatori.Preferiti.AggiungiCorsoPreferito;
import Ascoltatori.Preferiti.RimuoviCorsoPreferito;
import Ascoltatori.QeA.CaricaDomande;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class CorsoPanel extends JPanel{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione pannelli
    private TopPanel top;
    private JPanel pannelloPrincipale, centro, topPref, doppioTop;
    
    //dichiarazione bottoni
    private JButton appunti, libri, qea, preferitiOn, preferitiOff;
    
    //dichiarazione label
    private JLabel appuntiLab;
    private JLabel libriLab;
    private JLabel qeaLab;
    
    //dichiarazione ascoltatori
    private CaricaDomande caricaDomande;
    private CaricaAppunti caricaAppunti;
    private CaricaLibri caricaLibri;
    private AggiungiCorsoPreferito aggiungiCorsoPreferito;
    private RimuoviCorsoPreferito rimuoviCorsoPreferito;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbcImg;
    
    public CorsoPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel(applicazione.corsoAttuale.getNome());
        topPref = new JPanel();
        doppioTop = new JPanel(new GridLayout(2, 1, 0, 5));
        pannelloPrincipale = new JPanel(new GridBagLayout());
        centro = new JPanel(new BorderLayout());
        
        //inizializzazione bottoni
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        
        //inizializzazione label
        appuntiLab = new JLabel("Appunti");
        libriLab = new JLabel("Libri");
        qeaLab = new JLabel("Q&A");
        
        //inizializzazione ascoltatori
        caricaLibri = new CaricaLibri();
        caricaDomande = new CaricaDomande();
        caricaAppunti = new CaricaAppunti();
        aggiungiCorsoPreferito = new AggiungiCorsoPreferito();
        rimuoviCorsoPreferito = new RimuoviCorsoPreferito();
        
        //inizializzazione variabili layout
        gbcImg = new GridBagConstraints();

        //creazione pannelli
        creaPannelloPreferiti();
        creaOggetti();
        creaPannelloPrincipale();
 
    }
    
    public void creaPannelloPreferiti(){

        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));

        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));

        preferitiOff.addActionListener(aggiungiCorsoPreferito);
        preferitiOn.addActionListener(rimuoviCorsoPreferito);
        
        try {
            if (ControlloQuery.controlloCorsoPreferito()) {
                topPref.add(preferitiOff);
            }
            else {
                topPref.add(preferitiOn);
            }
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del corso preferito");
        }
    }
    
    public void creaOggetti(){

        appuntiLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 0;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 30, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(appuntiLab,gbcImg);

        libriLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 1;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(libriLab,gbcImg);
  
        qeaLab.setFont(new Font("Century Gothic", Font.BOLD, 20));
        gbcImg.gridx = 2;
        gbcImg.gridy = 1;
        gbcImg.insets = new Insets(50, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.CENTER;
        pannelloPrincipale.add(qeaLab,gbcImg);

        appunti = new JButton(new ImageIcon(getClass().getResource("/immagini/appunti.png")));
        appunti.setPreferredSize(new Dimension(166, 200));
        gbcImg.gridx = 0;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 50, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;
        pannelloPrincipale.add(appunti,gbcImg);

        libri = new JButton(new ImageIcon(getClass().getResource("/immagini/libri.png")));
        libri.setPreferredSize(new Dimension(166, 215));
        gbcImg.gridx = 1;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 35, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;
        pannelloPrincipale.add(libri, gbcImg);
    
        qea = new JButton(new ImageIcon(getClass().getResource("/immagini/qea.png")));
        qea.setPreferredSize(new Dimension(200, 200));
        gbcImg.gridx = 2;
        gbcImg.gridy = 2;
        gbcImg.insets = new Insets(10, 20, 0, 10);
        gbcImg.anchor = GridBagConstraints.NORTH;
        pannelloPrincipale.add(qea,gbcImg);
        
        //aggiunta ascoltatori alle immagini(bottoni)
        libri.addActionListener(caricaLibri);
        qea.addActionListener(caricaDomande);
        appunti.addActionListener(caricaAppunti);
        
        //settaggio sfondo e bordo immagini(bottoni)
        libri.setBackground(Color.white);
        libri.setBorder(new LineBorder(Color.white, 1, true));
        appunti.setBackground(Color.white);
        appunti.setBorder(new LineBorder(Color.white, 1, true));
        qea.setBackground(Color.white);
        qea.setBorder(new LineBorder(Color.white, 1, true));
    }
    
    public void creaPannelloPrincipale(){
    
        centro.add(pannelloPrincipale, BorderLayout.CENTER);
        
        doppioTop.add(top);
        doppioTop.add(topPref);
        
        centro.setBackground(Color.white);
        pannelloPrincipale.setBackground(Color.white);
        doppioTop.setBackground(Color.white);
        topPref.setBackground(Color.white);
        top.setBackground(Color.white);
        setBackground(Color.white);

        add(doppioTop);
        add(pannelloPrincipale);
    }
    
}
