/*
 * Ascoltatore dedicato all'apertura del pannello per l'inserimento di una
 * nuova domanda. 
 */
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import QeA.Vista.AggiungiDomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author danie
 */
public class GoToAggiungiDomanda implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("aggiungiDomanda");

        AggiungiDomandaPanel aggiungiDomandaPanel = new AggiungiDomandaPanel();
        Grafica.container.add(aggiungiDomandaPanel, "aggiungiDomanda");
        Grafica.card.show(Grafica.container, "aggiungiDomanda");
    }
    
}
