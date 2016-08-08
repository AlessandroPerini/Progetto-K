/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ascoltatori.Appunti;

import Application.Applicazione;
import Grafica.AggiungiAppuntoPanel;
import Grafica.Grafica;
import Grafica.OCRPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author aless
 */
public class GoToOCRPanel implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private OCRPanel ocrPanel;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        applicazione.back.add("ocr");

        ocrPanel = new OCRPanel();
        
        Grafica.container.add(ocrPanel, "ocr");
        Grafica.card.show(Grafica.container, "ocr");
    }
}
