 /*
 * Pannello dedicato alla visualizzazione della domanda e delle 
 * relative rispose. Possibilità di mettere Like alla domanda e Like - DisLike alla risposta.
 * L'utente a sua volta può rispondere alla domanda.
 */
package QeA.Vista;

import QeA.Ascoltatori.EliminaDomanda;
import QeA.Ascoltatori.AggiungiRisposta;
import Application.Controller.Applicazione;
import Database.Query.InfoQuery;
import Database.Query.ControlloQuery;
import Header.Vista.TopPanel;
import Preferiti.Ascoltatori.AggiungiDomandaPreferita;
import Preferiti.Ascoltatori.RimuoviDomandaPreferita;
import QeA.Ascoltatori.AggiungiLike;
import QeA.Ascoltatori.AggiungiLikeRisposta;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author cl410688
 */
public class DomandaPanel extends JPanel{

    private JButton rispondi, elimina, likeDomanda, likeRisposta, dislikeRisposta, preferitiOn,
            preferitiOff;
    private TopPanel top;
    private JPanel panel, pannelloRisposta, pannelloLike, pannelloDislike, preferitiPanel, descrizionePanel, rispostePanel, rispostaPanel;
    private JLabel email, NlikeDomanda, nomeRisposta, numeroLikeRisposta,numeroDislikeRisposta;
    private JTextArea descrizione, rispondiArea,risposte2;
    private JScrollPane scrollPanelDescrizione, scrollPannelloPrincipale, scrollPanelRisposte, scrollPanelRIspondiArea, scrollPanel5;   
    private GridBagConstraints gbcRisposte;
    private ImageIcon rispondiNormal, rispondiHover, rispondiPressed, eliminaNormal,eliminaHover, eliminaPressed;
    private GridBagConstraints gbc;
    
    //dichiarazione variabili
    private static int i;
    private int valoreLike;
    private int likelike, dislikelike;;
    
    //dichiarazione ascoltatori
    private AggiungiDomandaPreferita aggiungiDomandaPreferita;
    private RimuoviDomandaPreferita rimuoviDomandaPreferito;
    private AggiungiLike aggiungiLike;
    private EliminaDomanda eliminaDomanda;
    private AggiungiRisposta risposta;
    private AggiungiLikeRisposta alr;
    
    public DomandaPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel(Applicazione.domandaAttuale.getTitolo());      
        panel = new JPanel();
        preferitiPanel = new JPanel();
        rispostaPanel = new JPanel();
        rispostePanel = new JPanel();
        descrizionePanel = new JPanel();
        pannelloRisposta = new JPanel(new GridBagLayout());     
        gbcRisposte = new GridBagConstraints(); 
        gbc = new GridBagConstraints();
        pannelloDislike = new JPanel();
        pannelloLike = new JPanel();

        //inizializzazione bottoni - label - scollPanel
        preferitiOn = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOn.png")));
        preferitiOff = new JButton(new ImageIcon(this.getClass().getResource("/immagini/preferitiOff.png")));
        rispondiNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        rispondiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        rispondiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        eliminaNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        eliminaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        eliminaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));

        scrollPannelloPrincipale = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        email = new JLabel("<html><b>Caricata da: </b>"+Applicazione.domandaAttuale.getStudente()+"</html>");
        descrizione = new JTextArea(Applicazione.domandaAttuale.getDomanda(),5,25);
        scrollPanelDescrizione = new JScrollPane();
        likeDomanda = new JButton(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
        NlikeDomanda = new JLabel();
        scrollPanelRisposte = new JScrollPane(pannelloRisposta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rispondiArea = new JTextArea(4,20);
        scrollPanelRIspondiArea = new JScrollPane();
        rispondi = new JButton(rispondiNormal);
        elimina = new JButton(eliminaNormal);
        nomeRisposta = new JLabel();
        risposte2 = new JTextArea(4,15);
        numeroLikeRisposta = new JLabel(""+likelike);
        numeroDislikeRisposta = new JLabel(""+dislikelike);
  
        //inizializzazione ascoltatori
        aggiungiDomandaPreferita = new AggiungiDomandaPreferita();
        rimuoviDomandaPreferito = new RimuoviDomandaPreferita();
        aggiungiLike = new AggiungiLike(likeDomanda, NlikeDomanda);
        risposta = new AggiungiRisposta(rispondiArea);
        eliminaDomanda = new EliminaDomanda();
        
        try {
            if (ControlloQuery.controlloDomandaPreferita()) {
                preferitiPanel.add(preferitiOff);
            }
            else {
                preferitiPanel.add(preferitiOn);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo dell'appunto preferito");
        }//fine zona preferito
        
        this.build();
   
        add(top);
        add(preferitiPanel);
        add(scrollPannelloPrincipale);
    }
    
    public void build(){
        
        setBackground(Color.white);
        top.setBackground(Color.white);
        
        rispostaPanel.setBorder(BorderFactory.createTitledBorder("Inserisci qui una risposta"));

        panel.setBackground(Color.white);

        preferitiPanel.setBackground(Color.white);
        preferitiPanel.setPreferredSize(new Dimension(650, 35));

        rispostePanel.setBackground(Color.white);
        rispostaPanel.setBackground(Color.white);

        preferitiOn.setBackground(Color.white);
        preferitiOn.setBorder(new LineBorder(Color.white, 1, true));
        
        preferitiOff.setBackground(Color.white);
        preferitiOff.setBorder(new LineBorder(Color.white, 1, true));
        panel.setLayout(new GridBagLayout());
                        
        email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(10, 0, 0, 0);
	gbc.anchor = GridBagConstraints.CENTER;
	panel.add(email, gbc);
        
        descrizionePanel.setBackground(Color.white);
        descrizionePanel.setBorder(BorderFactory.createTitledBorder("Descrizione"));
        
        descrizione.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        descrizione.setBackground(new Color(239,242,243));
        descrizione.setEditable(false);
        descrizione.setLineWrap(true);
        descrizione.setWrapStyleWord(true);
        
        scrollPanelDescrizione.setViewportView(descrizione);
        scrollPanelDescrizione.setWheelScrollingEnabled(true);
        scrollPanelDescrizione.setVerticalScrollBar(new CustomScrollBar());
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.insets = new Insets(10, 0, 0, 0);
	gbc.anchor = GridBagConstraints.CENTER;
        descrizionePanel.add(scrollPanelDescrizione);
	panel.add(descrizionePanel, gbc);

        //like
        likeDomanda.setBackground(Color.white);
        likeDomanda.setPreferredSize(new Dimension(30, 30));
        likeDomanda.setBorder(new LineBorder(Color.white, 1));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.insets = new Insets(10, 0, 0, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(likeDomanda, gbc);
        try {
            if(!ControlloQuery.controlloLikeDomanda()){
                likeDomanda.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbupON.png")));
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del like della domanda");
        }
        
        NlikeDomanda.setText(Applicazione.domandaAttuale.getLike()+" likes");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 100, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(NlikeDomanda, gbc);

        likeDomanda.addActionListener(aggiungiLike);
        //fine zona like
        

        for(i = 0; i < Applicazione.listaRisposteAttuali.size(); i++){    

            setRisposte2(Applicazione.listaRisposteAttuali.get(i).getTitolo(), i, Applicazione.listaRisposteAttuali.get(i).getNickname());
        
        }

        scrollPanelRisposte.setPreferredSize(new Dimension(480 , 250));
        scrollPanelRisposte.getVerticalScrollBar().setUnitIncrement(10);
        scrollPanelRisposte.setWheelScrollingEnabled(true);
        scrollPanelRisposte.setVerticalScrollBar(new CustomScrollBar());
	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.insets = new Insets(10, 0, 0, 0);
	gbc.anchor = GridBagConstraints.CENTER;
        rispostePanel.setBorder(BorderFactory.createTitledBorder("Risposte"));
        rispostePanel.add(scrollPanelRisposte);
	panel.add(rispostePanel, gbc);
        
        rispondiArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        rispondiArea.setLineWrap(true);
        rispondiArea.setWrapStyleWord(true);
        
        scrollPanelRIspondiArea.setViewportView(rispondiArea);
        scrollPanelRIspondiArea.setWheelScrollingEnabled(true);
        scrollPanelRIspondiArea.setBorder(new LineBorder(Color.white));
        scrollPanelRIspondiArea.setVerticalScrollBar(new CustomScrollBar());
	gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(10, 0, 30, 0);
	gbc.anchor = GridBagConstraints.CENTER;
        rispostaPanel.setBorder(BorderFactory.createTitledBorder("Inserisci qui una risposta"));
        rispostaPanel.add(scrollPanelRIspondiArea);
	panel.add(rispostaPanel, gbc);
        
        rispondi.setBorder(BorderFactory.createEmptyBorder());
        rispondi.setContentAreaFilled(false);
        rispondiHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        rispondi.setRolloverIcon(rispondiHover);
        rispondiPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        rispondi.setPressedIcon(rispondiPressed);
        rispondi.setText("RISPONDI");
        rispondi.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        rispondi.setForeground(Color.white);
        rispondi.setIconTextGap(-85);
        rispondi.setPreferredSize(new Dimension(110, 40));
        gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(10, 400, 30, 0);
	gbc.anchor = GridBagConstraints.CENTER;
        
        rispondi.addActionListener(risposta);
	panel.add(rispondi, gbc);
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            elimina.setBorder(BorderFactory.createEmptyBorder());
            elimina.setContentAreaFilled(false);
            eliminaHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
            elimina.setRolloverIcon(eliminaHover);
            eliminaPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
            elimina.setPressedIcon(eliminaPressed);
            elimina.setText("ELIMINA");
            elimina.setFont(new Font("Century Gothic", Font.PLAIN, 15));
            elimina.setForeground(Color.white);
            elimina.setIconTextGap(-81);
            elimina.setPreferredSize(new Dimension(110, 40));
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.insets = new Insets(0, 0, 30, 0);
            gbc.anchor = GridBagConstraints.CENTER;
            elimina.addActionListener(eliminaDomanda);
            panel.add(elimina, gbc);
        }
    }

    public void setNomeRisposta(JLabel nomeRisposta) {
        this.nomeRisposta = nomeRisposta;
    }

    public void setRisposte2(String risposta, int i, String nome) {
        try {
            valoreLike = ControlloQuery.controlloLikeRisposta(Applicazione.listaRisposteAttuali.get(i).getId());
        } catch (SQLException ex) {
            Logger.getLogger(DomandaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
            nomeRisposta = new JLabel();
            nomeRisposta.setFont(new Font("Century Gothic", Font.BOLD, 13));
            nomeRisposta.setText(nome);
            gbcRisposte.gridx = 0;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, 5, 0, 10);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(this.nomeRisposta, gbcRisposte);

            risposte2 = new JTextArea(4,15);
            risposte2.setFont(new Font("Century Gothic", Font.PLAIN, 13));
            risposte2.setText(risposta);
            risposte2.setEditable(false);
            risposte2.setLineWrap(true);
            risposte2.setWrapStyleWord(true);
            scrollPanel5 = new JScrollPane(risposte2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPanel5.setWheelScrollingEnabled(true);
            scrollPanel5.setVerticalScrollBar(new CustomScrollBar());
            gbcRisposte.gridx = 1;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(10, 5, 10, 10);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(scrollPanel5, gbcRisposte);
            
            pannelloDislike = new JPanel();
            pannelloLike = new JPanel();
            
            //all interno dell pannello like
            
            try {
                likelike = InfoQuery.likeRisposta(Applicazione.listaRisposteAttuali.get(i).getId(), 1);
                numeroLikeRisposta = new JLabel(""+likelike);
                pannelloLike.add(numeroLikeRisposta);
                likeRisposta = new JButton();
                if(valoreLike==0){
                 
                    likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
                }else{
                    if(valoreLike==1){
                        
                        likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbupON.png")));
                    }else{
                        
                        likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
                    }
                    
                }
               
                likeRisposta.setName("like");
                likeRisposta.setBackground(new Color(239,242,243));
                likeRisposta.setPreferredSize(new Dimension(30, 30));
                likeRisposta.setBorder(new LineBorder(new Color(239,242,243), 1));
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei like della risposta");
            }
            
            pannelloLike.add(likeRisposta);
                     
            gbcRisposte.gridx = 3;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, 5, 0, 0);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(pannelloLike, gbcRisposte);
            
            //all interno dell pannello dislike
            
            try {
                dislikelike = InfoQuery.likeRisposta(Applicazione.listaRisposteAttuali.get(i).getId(), -1);
            
                numeroDislikeRisposta = new JLabel(""+dislikelike);
                pannelloDislike.add(numeroDislikeRisposta);
                dislikeRisposta = new JButton();
                if(valoreLike==0){
                    dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdown.png")));
                }else{
                    if(valoreLike==1){
                        dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdown.png")));
                    }else{
                        dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdownON.png")));
                    }
                    
                }
               
                dislikeRisposta.setName("dislike");
                dislikeRisposta.setBackground(new Color(239,242,243));
                dislikeRisposta.setPreferredSize(new Dimension(30, 30));
                dislikeRisposta.setBorder(new LineBorder(new Color(239,242,243), 1));
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei like della risposta");
            }
            
            pannelloDislike.add(dislikeRisposta);
            alr = new AggiungiLikeRisposta(i,Applicazione.listaRisposteAttuali.get(i).getId(), numeroLikeRisposta, numeroDislikeRisposta, likeRisposta, dislikeRisposta);
            likeRisposta.addMouseListener(alr);
            dislikeRisposta.addMouseListener(alr);
            gbcRisposte.gridx = 4;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, -5, 0, 0);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(pannelloDislike, gbcRisposte);
             
            scrollPannelloPrincipale.setPreferredSize(new Dimension(650, 400));
            scrollPannelloPrincipale.setBackground(Color.white);
            scrollPannelloPrincipale.setBorder(new LineBorder(Color.white));
            scrollPannelloPrincipale.setVerticalScrollBar(new CustomScrollBar());
    }

    public static void setI(int i) {
        DomandaPanel.i = i;
    }

    public static int getI() {
        return i;
    }
    
}
    



