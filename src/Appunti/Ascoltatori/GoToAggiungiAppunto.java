/*
 * Ascoltatore dedicato all'apertura del pannello per l'inserimento di un nuovo
 * appunto. 
 *
 */
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Appunti.Vista.AggiungiAppuntoPanel;
import Application.Vista.Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author te4o
 */
public class GoToAggiungiAppunto implements ActionListener{
    
    public Applicazione applicazione = Applicazione.getInstance();
    private AggiungiAppuntoPanel aggiungiAppuntoPanel;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        applicazione.back.add("aggiungiAppunto");

        aggiungiAppuntoPanel = new AggiungiAppuntoPanel();
        
        Grafica.container.add(aggiungiAppuntoPanel, "aggiungiAppunto");
        Grafica.card.show(Grafica.container, "aggiungiAppunto");
    }
    
}
