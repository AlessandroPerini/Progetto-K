/*
* Ascoltatore dedicato all'eliminazione di un appunto
* L'appunto può essere eliminato solo da colui che lo ha caricato
* Una volta eliminato, verrà rimosso da dropbox, la lista degli appunti
* verrà aggiornata cosi come la lista dei preferiti.
*/
package Appunti.Ascoltatori;

import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.DeleteQuery;
import Database.Query.GuestQuery;
import Database.Query.ListeQuery;
import Dropbox.Elimina;
import Frame.GifFrame;
import Preferiti.Vista.PreferitiPanel;
import Studenti.Vista.iMieiDatiPanel;
import Utils.Azioni.Ordina;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class EliminaAppunto implements ActionListener{
    
    //dichiarazione oggetti
    private JButton bottone;
    private JButton bottone2;
    private GifFrame gif;
    
    private Elimina elimina;
    private PreferitiPanel preferitiPanel;
    private ListaAppuntiPanel appunti;
    private iMieiDatiPanel mieiDatiPanel;
    
    public EliminaAppunto(JButton bottone, JButton bottone2) {
        this.bottone = bottone;
        this.bottone2 = bottone2;
        this.gif = new GifFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Conferma", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            
            bottone.setEnabled(false);
            bottone2.setEnabled(false);
            
            gif.apri();
            
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            try {
                                DeleteQuery.eliminaAppunto();
                                
                                DeleteQuery.eliminaValutazioneAppunto();
                                
                                if(ControlloQuery.controlloAppuntiPreferiti()==false){
                                    DeleteQuery.eliminaAppuntiPreferiti();
                                }
                                
                                elimina = new Elimina();
                                elimina.del();
                                
                                if(Elimina.eliminaOk){
                                    
                                    gif.chiudi();
                                    
                                    JOptionPane.showMessageDialog(null, "Appunto eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    Applicazione.svuotaAppunti();
                                    
                                    ListeQuery.caricaAppunti();
                                    
                                    Applicazione.back.remove(Applicazione.back.size()-1);
                                    
                                    Ordina.Appunti();
                                    
                                    if(Applicazione.back.get(Applicazione.back.size()-1).equals("appunti")){
                                        
                                        appunti = new ListaAppuntiPanel();
                                        Grafica.container.add(appunti, "appunti");
                                        Grafica.card.show(Grafica.container, "appunti");
                                    }
                                    
                                    if(Applicazione.back.get(Applicazione.back.size()-1).equals("preferiti")){
                                        Applicazione.svuotaPreferiti();
                                        
                                        ListeQuery.caricaFacoltàPreferite();
                                        ListeQuery.caricaCorsiPreferiti();
                                        ListeQuery.caricaAppuntiPreferiti();
                                        ListeQuery.caricaLibriPreferiti();
                                        ListeQuery.caricaDomandePreferite();
                                        
                                        Ordina.ListePreferiti();
                                        
                                        preferitiPanel = new PreferitiPanel();
                                        Grafica.container.add(preferitiPanel, "preferiti");
                                        Grafica.card.show(Grafica.container, "preferiti");
                                    }
                                    
                                    if(Applicazione.back.get(Applicazione.back.size()-1).equals("i miei dati")){
                                        Applicazione.svuotaMieiDati();
                                        
                                        GuestQuery.caricaMieiAppunti();
                                        GuestQuery.caricaMieiLibri();
                                        GuestQuery.caricaMieDomande();
                                        
                                        Ordina.ListeMieiDati();
                                        
                                        mieiDatiPanel = new iMieiDatiPanel();
                                        Grafica.container.add(mieiDatiPanel, "i miei dati");
                                        Grafica.card.show(Grafica.container, "i miei dati");
                                        
                                    }
                                    
                                    bottone.setEnabled(true);
                                    bottone2.setEnabled(true);
                                }
                            } catch (SQLException ex) {
                                gif.chiudi();
                                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                            }
                            catch (DbxException ex) {
                                gif.chiudi();
                                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        
                    },10);
        }
    }
    
}
