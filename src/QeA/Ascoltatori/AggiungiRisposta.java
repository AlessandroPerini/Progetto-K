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
    private int indice;
    private String x="";

    public AggiungiRisposta(JTextArea titolo, int indice) {
        this.titolo = titolo; 
        this.indice = indice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        InsertQuery.inserisciRisposta(titolo.getText());
        
        JOptionPane.showMessageDialog(null, "Risposta aggiunta correttamente.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaRisposte();

        ListeQuery.caricaRisposteDomanda();

        String s="";
         for(int i = 0;i < Applicazione.listaRisposteAttuali.size();i++){
          s= (Applicazione.listaRisposteAttuali.get(i).getTitolo());
          x = Applicazione.listaRisposteAttuali.get(i).setNickname();
        }
         
        GoToDomanda.getDomanda().setRisposte2(s,indice,x);
   
        Grafica.container.add(GoToDomanda.getDomanda(), "domanda");
        Grafica.card.show(Grafica.container, "domanda");
        x = "";
        titolo.setText("");
        
      
    }
}
