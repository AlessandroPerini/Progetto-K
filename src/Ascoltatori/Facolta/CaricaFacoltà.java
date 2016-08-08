/*
* Ascoltatore in cui vengono caricate tutte le facoltà dopo aver effettuato il login
*/
package Ascoltatori.Facolta;

import Application.Applicazione;
import Grafica.Grafica;
import Database.ListeQuery;
import Grafica.ListaFacoltàPanel;
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
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private ListaFacoltàPanel facoltà; 
    
    public void carica(){
        
        if(applicazione.utenteLoggato){
            
            try {
                ListeQuery.caricaFacoltà();
                ListeQuery.caricaRamiFacoltà();
                
                applicazione.back.add("facoltà");

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
