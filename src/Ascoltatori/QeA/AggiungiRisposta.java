/*
* Ascoltatore dedicato al caricamento di una nuova rispota alla domanda attuale
*/
package Ascoltatori.QeA;

import Application.Applicazione;
import Vista.Grafica;
import Database.InsertQuery;
import Database.ListeQuery;
import Vista.DomandaPanel;
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
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextArea titolo;
    
    //dichiarazione variabili
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
                    
                    applicazione.svuotaRisposte();
                    
                    ListeQuery.caricaRisposteDomanda();
                    
                    String s="";
                    for(int i = 0;i < applicazione.listaRisposteAttuali.size();i++){
                        s= (applicazione.listaRisposteAttuali.get(i).getTitolo());
                        nome = applicazione.listaRisposteAttuali.get(i).getNickname();
                    }
                                      
                    GoToDomanda.getDomanda().setRisposte(s,DomandaPanel.getI(),nome);
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
