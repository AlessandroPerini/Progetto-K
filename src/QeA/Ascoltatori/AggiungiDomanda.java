/*
* Ascoltatore dedicato al caricamento di una nuova domanda all'interno
* del corso
*/
package QeA.Ascoltatori;

import Database.Query.InsertQuery;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.ListeQuery;
import QeA.Vista.AggiungiDomandaPanel;
import QeA.Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiDomanda implements ActionListener{
    
    //dichiarazione
    private JTextArea titolo;
    private JTextArea descrizione;
    
    ListaDomandePanel domande;
    
    public AggiungiDomanda(JTextArea titolo, JTextArea descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if((!titolo.getText().equals(""))&&(!descrizione.getText().equals(""))){
            if((titolo.getText().length()<100)&&(descrizione.getText().length()<500)){
                try {
                    if(ControlloQuery.controlloTitoloDomanda(titolo.getText())){
                        
                        try {
                            InsertQuery.inserisciDomanda(titolo.getText(), descrizione.getText());
                            
                            JOptionPane.showMessageDialog(null, "Domanda aggiunta correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                            
                            Applicazione.svuotaDomande();
                            
                            ListeQuery.caricaDomande();
                            
                            Applicazione.back.remove(Applicazione.back.size()-1);
                            
                            domande = new ListaDomandePanel();
                            Grafica.container.add(domande, "domande");
                            Grafica.card.show(Grafica.container, "domande");
                            
                            AggiungiDomandaPanel.clearForm();
                            
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta della domanda", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Una domanda con lo stesso titolo è già presente all'interno \ndi '"+Applicazione.facoltàAttuale.getNome()+">"+Applicazione.corsoAttuale.getNome()+"', verifica "
                                + "che non sia \nla stessa e riprova cambiando titolo.","Impossibile caricare domanda" , JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println("Errore durante il controllo del titolo della domanda");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Titolo(max 100 caratteri) e/o descrizione(max 500 caratteri) troppo lunghi", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Titolo e/o descrizione non validi", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
}
