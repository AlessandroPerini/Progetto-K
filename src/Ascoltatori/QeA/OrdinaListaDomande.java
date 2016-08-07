/*
* Ascoltatore dedicato all'ordinamento della lista delle domande.
* Possibile ordinamento in base al nome oppure ai like.
* Una volta ordinato, viene ricreato il pannello con la lista ordinata.
*/
package Ascoltatori.QeA;

import Vista.Grafica;
import Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
            utility.Ordina.Domande();
            ordineCorrente = "Like";
        }
        
        if(ordina.getSelectedItem().equals("Nome")){
            utility.Ordina.DomandeAlfabetic();
            ordineCorrente = "Nome";
        }
        
        domande = new ListaDomandePanel();
        Grafica.container.add(domande, "domande");
        Grafica.card.show(Grafica.container, "domande");
    }
    
    
}
