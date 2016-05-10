/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiDomanda implements ActionListener{
    
    private JTextArea titolo;
    private JTextArea descrizione;
    
    public AggiungiDomanda(JTextArea titolo, JTextArea descrizione) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            if(ControlloQuery.controlloTitoloDomanda(titolo.getText())){
                
                try {
                    InsertQuery.inserisciDomanda(titolo.getText(), descrizione.getText());
                    
                    JOptionPane.showMessageDialog(null, "Domanda aggiunta correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    
                    
                    Applicazione.svuotaDomande();
                    
                    ListeQuery.caricaDomande();
                    
                    Applicazione.back.remove(Applicazione.back.size()-1);
                    
                    ListaDomandePanel domande = new ListaDomandePanel();
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
}
