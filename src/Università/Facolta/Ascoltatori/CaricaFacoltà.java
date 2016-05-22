/*
* Ascoltatore in cui vengono caricate tutte le facoltà dopo aver effettuato il login
*/
package Università.Facolta.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Università.Facolta.Vista.ListaFacoltàPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class CaricaFacoltà implements ActionListener, KeyListener{
    
    private ListaFacoltàPanel facoltà; 
    
    public void carica(){
        
        if(Applicazione.utenteLoggato){
            
            try {
                ListeQuery.caricaFacoltà();
                ListeQuery.caricaRamiFacoltà();
                
                Applicazione.back.add("facoltà");
                
                facoltà = new ListaFacoltàPanel();
                
                Grafica.container.add(facoltà,"facoltà");
                Grafica.card.show(Grafica.container, "facoltà");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante il caricamento delle facoltà", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        carica();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            carica();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
