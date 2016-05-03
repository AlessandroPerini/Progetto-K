/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author adrian
 */
public class AggiungiLike implements ActionListener{

    private JButton like;

    public AggiungiLike(JButton like) {
        this.like = like; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        InsertQuery.inserisciLikeDomanda();
        
        JOptionPane.showMessageDialog(null, "Aggiunto.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);
        like.setEnabled(false);
        Applicazione.svuotaRisposte();

        ListeQuery.caricaRisposteDomanda();

        String s="";
         for(int i = 0;i < Applicazione.listaRisposteAttuali.size();i++){
          s= (s+Applicazione.listaRisposteAttuali.get(i).toString());
        }
        GoToDomanda.getDomanda().risposte2.setText(s);
   
        Grafica.container.add(GoToDomanda.getDomanda(), "domanda");
        Grafica.card.show(Grafica.container, "domanda");
        
        
      
    }
}
