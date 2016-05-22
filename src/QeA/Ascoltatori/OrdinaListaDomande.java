/*
* Ascoltatore dedicato all'ordinamento della lista delle domande.
* Possibile ordinamento in base al nome oppure ai like.
* Una volta ordinato, viene ricreato il pannello con la lista ordinata.
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import QeA.Domanda;
import QeA.Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Te4o
 */
public class OrdinaListaDomande implements ActionListener{
    
    //dichiarazione oggetti
    private JComboBox ordina;
    
    //dichiarazione variabili
    public static String ordineCorrente = "";
    
    private ListaDomandePanel domande;
    
    public OrdinaListaDomande(JComboBox ordina) {
        this.ordina = ordina;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(ordina.getSelectedItem().equals("Like")){
            Collections.sort(Applicazione.listaDomandeAttuali, new Comparator<Domanda>() {
                
                @Override
                public int compare(Domanda d1, Domanda d2) {
                    return Integer.compare(d2.getLike(), d1.getLike());
                }
            });
            ordineCorrente = "Like";
        }
        
        if(ordina.getSelectedItem().equals("Nome")){
            Collections.sort(Applicazione.listaDomandeAttuali, new Comparator<Domanda>() {
                
                @Override
                public int compare(Domanda d1, Domanda d2) {
                    return d1.getTitolo().compareTo(d2.getTitolo());
                }
            });
            ordineCorrente = "Nome";
        }
        
        domande = new ListaDomandePanel();
        Grafica.container.add(domande, "domande");
        Grafica.card.show(Grafica.container, "domande");
    }
    
    
}
