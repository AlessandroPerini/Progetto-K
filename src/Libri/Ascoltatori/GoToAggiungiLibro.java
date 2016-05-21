/*
* Ascoltatore posto nella ListaLibriPanel sul bottone "+"
* che serve ad andare alla pagina per aggiungere un nuovo libro 
*/
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Libri.Vista.AggiungiLibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class GoToAggiungiLibro implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiLibro");

        AggiungiLibroPanel aggiungiLibroPanel = new AggiungiLibroPanel();
        Grafica.container.add(aggiungiLibroPanel, "aggiungiLibro");
        Grafica.card.show(Grafica.container, "aggiungiLibro");
    }
    
}
