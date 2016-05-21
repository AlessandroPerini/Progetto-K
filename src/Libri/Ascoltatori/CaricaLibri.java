/*
* Ascoltatore posto sull'immagine(bottone) "libro" nel CorsoPanel
* e serve appunto a caricare i libri relativi a quel corso
*/
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
 *
 * @author Te4o
 */
public class CaricaLibri implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            ListeQuery.caricaLibri();
            
            Applicazione.back.add("libri");
            
            Ordina.Libri();
            
            ListaLibriPanel libri = new ListaLibriPanel();
            Grafica.container.add(libri, "libri");
            Grafica.card.show(Grafica.container, "libri");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei libri");
        }
        
    }
    
}
