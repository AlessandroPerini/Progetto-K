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
import Database.Query.ListeQuery;
import QeA.Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                
                JOptionPane.showMessageDialog(null, "Domanda eliminata correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                
                if(ControlloQuery.controlloDomandePreferite()==false){
                    DeleteQuery.eliminaDomandePreferite();
                }
                
                Applicazione.svuotaDomande();
                
                ListeQuery.caricaDomande();
                
                Applicazione.back.remove(Applicazione.back.size()-1);
                
                ListaDomandePanel domande = new ListaDomandePanel();
                Grafica.container.add(domande, "domande");
                Grafica.card.show(Grafica.container, "domande");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'eliminazione della domanda ", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}

