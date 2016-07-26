
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
* Ascoltatore dedicato al caricamento di tutti i libri relativi 
* al corso selezionato
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
