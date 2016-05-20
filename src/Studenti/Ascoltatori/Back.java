/*
 * Ascoltatore dedicato al Back, ovver alla posibilità di tornare alla pagina 
 * precedentemente visualizzata
 */
package Studenti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class Back implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {

        Applicazione.back.remove(Applicazione.back.size()-1);
        Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
    }
}
