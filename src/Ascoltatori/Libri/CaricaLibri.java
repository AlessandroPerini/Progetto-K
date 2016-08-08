/*
* Ascoltatore dedicato al caricamento di tutti i libri relativi 
* al corso selezionato
*/
package Ascoltatori.Libri;

import Application.Applicazione;
import Grafica.Grafica;
import Database.ListeQuery;
import Grafica.ListaLibriPanel;
import utilityaaa.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class CaricaLibri implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();

    private ListaLibriPanel libri;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaLibri();
            
            applicazione.back.add("libri");
            
            Ordina.Libri();
            
            libri = new ListaLibriPanel();
            Grafica.container.add(libri, "libri");
            Grafica.card.show(Grafica.container, "libri");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei libri");
        }
        
    }
    
}
