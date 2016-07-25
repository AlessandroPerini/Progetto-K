/*
 * Ascoltatore dedicato all'apertura del pannello per l'inserimento di una
 * nuova domanda. 
 */
package Ascoltatori.QeA;

import Application.Applicazione;
import Vista.Grafica;
import Vista.AggiungiDomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author danie
 */
public class GoToAggiungiDomanda implements ActionListener{

    private Applicazione applicazione = Applicazione.getInstance();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        applicazione.back.add("aggiungiDomanda");

        AggiungiDomandaPanel aggiungiDomandaPanel = new AggiungiDomandaPanel();
        Grafica.container.add(aggiungiDomandaPanel, "aggiungiDomanda");
        Grafica.card.show(Grafica.container, "aggiungiDomanda");
    }
    
}
