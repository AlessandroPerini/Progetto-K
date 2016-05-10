 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Vista;

import QeA.Ascoltatori.EliminaDomanda;
import QeA.Ascoltatori.AggiungiRisposta;
import Application.Controller.Applicazione;
import Database.Query.InfoQuery;
import Database.Query.ControlloQuery;
import Header.TopPanel;
import Preferiti.Facoltà.Ascoltatori.AggiungiDomandaPreferita;
import Preferiti.Facoltà.Ascoltatori.RimuoviDomandaPreferita;
import QeA.Ascoltatori.AggiungiLike;
import QeA.Ascoltatori.AggiungiLikeRisposta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author cl410688
 */
public class DomandaPanel extends JPanel{

    private JButton rispondi, elimina, like2, likeRisposta, dislikeRisposta;
    private TopPanel top;
    private JPanel panel,pannelloRisposta,pannelloLike, pannelloDislike;
    private JLabel titolo, titolo2, descrizione, like, email, email2, risposte,rispondiLabel, Nlike, nomeRisposta, numeroLikeRisposta,numeroDislikeRisposta;
    private JTextArea descrizione2, rispondiArea;
    private JTextArea risposte2 ;
    private JScrollPane scrollPanel, scrollPanel1, scrollPanel3, scrollPanel4, scrollPanel5;
    private AggiungiRisposta risposta;
    private GridBagConstraints gbcRisposte;
    private int i;
   
    public DomandaPanel() {
        
        top = new TopPanel(Applicazione.domandaAttuale.getTitolo());      
        
        panel = new JPanel();
        
        this.build();

        scrollPanel1 = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel1.setPreferredSize(new Dimension(650, 450));
        scrollPanel1.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel1);
    }
    
    public void build(){
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
                
        gbcRisposte = new GridBagConstraints(); 
        
        //preferito
        JButton preferitiOn = new JButton(new ImageIcon("files\\immagini\\preferitiOn.png"));
        JButton preferitiOff = new JButton(new ImageIcon("files\\immagini\\preferitiOff.png"));
        
        AggiungiDomandaPreferita aggiungiDomandaPreferita = new AggiungiDomandaPreferita();
        preferitiOff.addActionListener(aggiungiDomandaPreferita);
        
        RimuoviDomandaPreferita rimuoviDomandaPreferita = new RimuoviDomandaPreferita();
        preferitiOn.addActionListener(rimuoviDomandaPreferita);
        
        try {
            if (ControlloQuery.controlloDomandaPreferita()) {
                panel.add(preferitiOff);
            }
            else {
                panel.add(preferitiOn);
            }
      
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo della domanda preferita");
        }//fine zona preferito
        
        //prima riga - colonna 0
        this.email = new JLabel("Email:");
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.email, gbc);
        
        //colonna 1
        System.out.println(Applicazione.domandaAttuale.getStudente());
        this.email2 = new JLabel(Applicazione.domandaAttuale.getStudente());
	gbc.gridx = 1;
	gbc.gridy = 0;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.email2, gbc);
        
        //seconda riga - colonna 0
        
        this.titolo = new JLabel("Titolo:");
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.titolo, gbc);
        
        //colonna 1
        this.titolo2 = new JLabel(Applicazione.domandaAttuale.getTitolo());
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.titolo2, gbc);
        
         //seconda riga - colonna 0
        
        this.descrizione = new JLabel("Descrizione:");
	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.descrizione, gbc);
        
        //colonna 1
        System.out.println(Applicazione.domandaAttuale.getDomanda());
        this.descrizione2 = new JTextArea(Applicazione.domandaAttuale.getDomanda(),5,25);
        descrizione2.setEditable(false);
        descrizione2.setLineWrap(true);
        descrizione2.setWrapStyleWord(true);
        
        this.scrollPanel = new JScrollPane();
        scrollPanel.setViewportView(descrizione2);
        scrollPanel.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel, gbc);
        
        // quarta riga - colonna 0
        
        this.like= new JLabel("Like:");
	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.insets = new Insets(15, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.like, gbc);
        
        // quarta riga - colonna 1   
        this.like2 = new JButton("Like");
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.insets = new Insets(15, 30, 0, 10);
            gbc.anchor = GridBagConstraints.LINE_START;
            panel.add(this.like2, gbc);
        try {
            if(!ControlloQuery.controlloLikeDomanda()){
                like2.setEnabled(false);
            }else{
                like2.setEnabled(true);
            }
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del like della domanda");
        }
        
        // quarta riga - colonna 1
        this.Nlike = new JLabel();
        try {
            Nlike.setText(InfoQuery.likeDomanda()+" likes");
         
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.insets = new Insets(15, 100, 0, 10);
            gbc.anchor = GridBagConstraints.LINE_START;
            panel.add(this.Nlike, gbc);
            }catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei like della domanda");
        }
            
        AggiungiLike aggiungiLike = new AggiungiLike(like2, Nlike);
        like2.addActionListener(aggiungiLike);
        //fine zona like
        
        this.risposte = new JLabel("Risposte Date:");
        gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.risposte, gbc);
    
        
        pannelloRisposta = new JPanel(new GridBagLayout());
        

        for(i = 0; i < Applicazione.listaRisposteAttuali.size(); i++){    

            setRisposte2(Applicazione.listaRisposteAttuali.get(i).getTitolo(), i, Applicazione.listaRisposteAttuali.get(i).setNickname());
        
        }

        scrollPanel3 = new JScrollPane(pannelloRisposta,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel3.setPreferredSize(new Dimension(480 , 250));
        scrollPanel3.getVerticalScrollBar().setUnitIncrement(10);
        scrollPanel3.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 4;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel3, gbc);
        
        this.rispondiLabel = new JLabel("Risposta:");
        gbc.gridx = 0;
	gbc.gridy = 5;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	panel.add(this.rispondiLabel, gbc);
        
        this.rispondiArea = new JTextArea(5,25);
        rispondiArea.setLineWrap(true);
        rispondiArea.setWrapStyleWord(true);
        
        this.scrollPanel4 = new JScrollPane();
        scrollPanel4.setViewportView(rispondiArea);
        scrollPanel4.setWheelScrollingEnabled(true);
	gbc.gridx = 1;
	gbc.gridy = 5;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	panel.add(this.scrollPanel4, gbc);
        
        this.rispondi = new JButton("Rispondi");
        gbc.gridx = 1;
	gbc.gridy = 6;
	gbc.insets = new Insets(15, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
        
        risposta = new AggiungiRisposta(rispondiArea,i);
        rispondi.addActionListener(risposta);
	panel.add(this.rispondi, gbc);
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            EliminaDomanda eliminaDomanda = new EliminaDomanda();
            this.elimina = new JButton("Elimina");
            elimina.setBackground(new Color(249,123,123));
            gbc.gridx = 1;
            gbc.gridy = 7;
            gbc.insets = new Insets(5, 30, 0, 10);
            gbc.anchor = GridBagConstraints.LINE_START;
            elimina.addActionListener(eliminaDomanda);
            panel.add(this.elimina, gbc);
        }
    }

    public void setNomeRisposta(JLabel nomeRisposta) {
        this.nomeRisposta = nomeRisposta;
    }

    public void setRisposte2(String risposta, int i, String nome) {
            nomeRisposta = new JLabel();
            this.nomeRisposta.setText(nome);
            gbcRisposte.gridx = 0;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, 1, 0, 10);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(this.nomeRisposta, gbcRisposte);

            this.risposte2 = new JTextArea(4,15);
            risposte2.setText(risposta);
            risposte2.setEditable(false);
            risposte2.setLineWrap(true);
            risposte2.setWrapStyleWord(true);
            this.scrollPanel5 = new JScrollPane();
            scrollPanel5.setViewportView(risposte2);
            scrollPanel5.setWheelScrollingEnabled(true);
            gbcRisposte.gridx = 1;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, -7, 0, 10);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(this.scrollPanel5, gbcRisposte);
            //all interno dell pannello like
            this.pannelloDislike = new JPanel();
            this.pannelloLike = new JPanel();
            int likelike=InfoQuery.likeRisposta(Applicazione.listaRisposteAttuali.get(i).getId(), 1);
            this.numeroLikeRisposta = new JLabel(""+likelike);
            pannelloLike.add(numeroLikeRisposta);
            this.likeRisposta = new JButton("Like");
            
            
            pannelloLike.add(likeRisposta);
                     
            gbcRisposte.gridx = 3;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, -17, 0, 0);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(this.pannelloLike, gbcRisposte);
            //all interno dell pannello dislike
            int dislikelike=InfoQuery.likeRisposta(Applicazione.listaRisposteAttuali.get(i).getId(), -1);
            this.numeroDislikeRisposta = new JLabel(""+dislikelike);
            pannelloDislike.add(numeroDislikeRisposta);
            this.dislikeRisposta = new JButton("Dislike");
        
            pannelloDislike.add(dislikeRisposta);
            AggiungiLikeRisposta alr = new AggiungiLikeRisposta(Applicazione.listaRisposteAttuali.get(i).getId(),numeroLikeRisposta,numeroDislikeRisposta);
            likeRisposta.addActionListener(alr);
            dislikeRisposta.addActionListener(alr);
            gbcRisposte.gridx = 4;
            gbcRisposte.gridy = i;
            gbcRisposte.insets = new Insets(15, -5, 0, 0);
            gbcRisposte.anchor = GridBagConstraints.LINE_START;
            pannelloRisposta.add(this.pannelloDislike, gbcRisposte);
  
    }
   
 
    
}
    



