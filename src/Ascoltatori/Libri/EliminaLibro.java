/*
* Ascoltatore dedicato all'eliminazione di un libro
* Il libro può essere eliminato solo da colui che lo ha caricato
* Una volta eliminato la lista degli appunti
* verrà aggiornata cosi come la lista dei preferiti.
*/
package Ascoltatori.Libri;

import Application.Applicazione;
import Grafica.Grafica;
import Database.ControlloQuery;
import Database.DeleteQuery;
import Database.GuestQuery;
import Database.ListeQuery;
import Grafica.ListaLibriPanel;
import Grafica.PreferitiPanel;
import Grafica.iMieiDatiPanel;
import Utility.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class EliminaLibro implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private ListaLibriPanel libri;
    private PreferitiPanel preferitiPanel; 
    private iMieiDatiPanel mieiDatiPanel; 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Conferma", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            try {
                DeleteQuery.eliminaLibro();
                
                if(ControlloQuery.controlloLibriPreferiti()==false){
                    DeleteQuery.eliminaLibriPreferiti();
                }
                
                JOptionPane.showMessageDialog(null, "Libro eliminato correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                
                applicazione.svuotaLibri();
                
                ListeQuery.caricaLibri();
                
                applicazione.back.remove(applicazione.back.size()-1);
                
                Ordina.Libri();
                
                if(applicazione.back.get(applicazione.back.size()-1).equals("libri")){
                    libri = new ListaLibriPanel();
                    Grafica.container.add(libri, "libri");
                    Grafica.card.show(Grafica.container, "libri");
                }
                
                if(applicazione.back.get(applicazione.back.size()-1).equals("preferiti")){
                    applicazione.svuotaPreferiti();
                    
                    ListeQuery.caricaTuttiPreferiti();
                    
                    Ordina.ListePreferiti();
                    
                    preferitiPanel = new PreferitiPanel();
                    Grafica.container.add(preferitiPanel, "preferiti");
                    Grafica.card.show(Grafica.container, "preferiti");
                }
                
                if(applicazione.back.get(applicazione.back.size()-1).equals("i miei dati")){
                    applicazione.svuotaMieiDati();
                    
                    GuestQuery.caricaTuttiMieiDati();
                    
                    Ordina.ListeMieiDati();
                    
                    mieiDatiPanel = new iMieiDatiPanel();
                    Grafica.container.add(mieiDatiPanel, "i miei dati");
                    Grafica.card.show(Grafica.container, "i miei dati");
                    
                }
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del libro", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
