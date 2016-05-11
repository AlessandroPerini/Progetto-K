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
import QeA.Vista.DomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author adrian
 */
public class AggiungiRisposta implements ActionListener{
    
    private JTextArea titolo;
    private String nome="";
    
    public AggiungiRisposta(JTextArea titolo) {
        this.titolo = titolo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(!titolo.getText().equals("")){
            if(titolo.getText().length()<500){
                try {
                    InsertQuery.inserisciRisposta(titolo.getText());
                    
                    Applicazione.svuotaRisposte();
                    
                    ListeQuery.caricaRisposteDomanda();
                    
                    String s="";
                    for(int i = 0;i < Applicazione.listaRisposteAttuali.size();i++){
                        s= (Applicazione.listaRisposteAttuali.get(i).getTitolo());
                        nome = Applicazione.listaRisposteAttuali.get(i).getNickname();
                    }
                                      
                    GoToDomanda.getDomanda().setRisposte2(s,DomandaPanel.getI(),nome);
                    DomandaPanel.setI(DomandaPanel.getI()+1);
                    
                    Grafica.container.add(GoToDomanda.getDomanda(), "domanda");
                    Grafica.card.show(Grafica.container, "domanda");
                    nome = "";
                    titolo.setText("");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta della risposta", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Risposta(max 500 caratteri) troppo lunga", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Risposta non valida", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
