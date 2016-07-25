/*
 * Ascoltatore dedicato all'apertura del pannello per l'inserimento di un nuovo
 * libro.
 *
 */
package Ascoltatori.Libri;

import Application.Applicazione;
import Vista.Grafica;
import Vista.AggiungiLibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class GoToAggiungiLibro implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private AggiungiLibroPanel aggiungiLibroPanel;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        applicazione.back.add("aggiungiLibro");

        aggiungiLibroPanel = new AggiungiLibroPanel();
        Grafica.container.add(aggiungiLibroPanel, "aggiungiLibro");
        Grafica.card.show(Grafica.container, "aggiungiLibro");
    }
    
}
