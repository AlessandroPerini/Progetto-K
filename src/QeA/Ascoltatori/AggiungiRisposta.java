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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author adrian
 */
public class AggiungiRisposta implements ActionListener{

    private JTextArea titolo;

    public AggiungiRisposta(JTextArea titolo) {
        this.titolo = titolo; 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InsertQuery.inserisciRisposta(titolo.getText());
        
        JOptionPane.showMessageDialog(null, "Risposta aggiunta correttamente.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaRisposte();

        ListeQuery.caricaRisposteDomanda();

        Applicazione.back.remove(Applicazione.back.size()-1);
        String s="";
         for(int i = 0;i < Applicazione.risposteAttuali.size();i++){
          s= (s+Applicazione.risposteAttuali.get(i));
        }
        GoToDomanda.getDomanda().risposte2.setText(s);
   
        Grafica.container.add(GoToDomanda.getDomanda(), "domande");
        Grafica.card.show(Grafica.container, "domande");
        
        titolo.setText("");
        
      
    }
}
