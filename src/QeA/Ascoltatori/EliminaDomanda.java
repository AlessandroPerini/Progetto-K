/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.DeleteQuery;
import Database.Query.GuestQuery;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import Preferiti.Vista.PreferitiPanel;
import QeA.Vista.ListaDomandePanel;
import Studenti.Vista.iMieiDatiPanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class EliminaDomanda implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            try {
                DeleteQuery.eliminaDomanda();
                DeleteQuery.eliminaTuttiLikeDomanda();
                if(!Applicazione.listaRisposteAttuali.isEmpty()){
                    DeleteQuery.eliminaRisposteDomanda();
                    DeleteQuery.eliminaTuttiLikeRisposta();
                }
                
                JOptionPane.showMessageDialog(null, "Domanda eliminata correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                
                if(ControlloQuery.controlloDomandePreferite()==false){
                    DeleteQuery.eliminaDomandePreferite();
                }
                
                Applicazione.svuotaDomande();
                
                ListeQuery.caricaDomande();
                
                Applicazione.back.remove(Applicazione.back.size()-1);
                
                Ordina.Domande();

                if(Applicazione.back.get(Applicazione.back.size()-1).equals("domande")){
                    ListaDomandePanel domande = new ListaDomandePanel();
                Grafica.container.add(domande, "domande");
                Grafica.card.show(Grafica.container, "domande");
                }
                
                if(Applicazione.back.get(Applicazione.back.size()-1).equals("preferiti")){
                    Applicazione.svuotaPreferiti();
                    
                    ListeQuery.caricaFacoltàPreferite();
                    ListeQuery.caricaCorsiPreferiti();
                    ListeQuery.caricaAppuntiPreferiti();
                    ListeQuery.caricaLibriPreferiti();
                    ListeQuery.caricaDomandePreferite();
                    
                    Ordina.ListePreferiti();
                    
                    PreferitiPanel preferitiPanel = new PreferitiPanel();
                    Grafica.container.add(preferitiPanel, "preferiti");
                    Grafica.card.show(Grafica.container, "preferiti");
                }
                
                if(Applicazione.back.get(Applicazione.back.size()-1).equals("i miei dati")){
                    Applicazione.svuotaMieiDati();
                    
                    GuestQuery.caricaMieiAppunti();
                    GuestQuery.caricaMieiLibri();
                    GuestQuery.caricaMieDomande();
                    
                    Ordina.ListeMieiDati();
                    
                    iMieiDatiPanel mieiDatiPanel = new iMieiDatiPanel();
                    Grafica.container.add(mieiDatiPanel, "i miei dati");
                    Grafica.card.show(Grafica.container, "i miei dati");
                    
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione della domanda ", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

