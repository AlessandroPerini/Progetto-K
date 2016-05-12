/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.DeleteQuery;
import Database.Query.ListeQuery;
import Dropbox.Elimina;
import Frame.GifFrame;
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
    
    private JButton bottone;
    private JButton bottone2;
    private GifFrame gif;
    
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
                                if(ControlloQuery.controlloAppuntiPreferiti()==false){
                                    DeleteQuery.eliminaAppuntiPreferiti();
                                }
                                
                                Elimina elimina = new Elimina();
                                elimina.del();
                                
                                if(Elimina.eliminaOk){
                                    
                                    gif.chiudi();
                                    
                                    JOptionPane.showMessageDialog(null, "Appunto eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    Applicazione.svuotaAppunti();
                                    ListeQuery.caricaAppunti();
                                    
                                    Applicazione.back.remove(Applicazione.back.size()-1);
                                    
                                    ListaAppuntiPanel appunti = new ListaAppuntiPanel();
                                    Grafica.container.add(appunti, "appunti");
                                    Grafica.card.show(Grafica.container, "appunti");
                                    
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
