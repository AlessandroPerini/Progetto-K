/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Appunto;
import Appunti.Vista.ListaAppuntiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JComboBox;

/**
 *
 * @author Te4o
 */
public class OrdinaListaAppunti implements ActionListener{
    
    private JComboBox ordina;
    public static String ordineCorrente = "";
    
    public OrdinaListaAppunti(JComboBox ordina) {
        this.ordina = ordina;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(ordina.getSelectedItem().equals("Valutazione")){
            Collections.sort(Applicazione.listaAppuntiAttuali, new Comparator<Appunto>() {
                
                @Override
                public int compare(Appunto a1, Appunto a2) {
                    return Float.compare(a2.getMedia(), a1.getMedia());
                }
            });
            ordineCorrente = "Valutazione";
        }
        
        if(ordina.getSelectedItem().equals("Nome")){
            Collections.sort(Applicazione.listaAppuntiAttuali, new Comparator<Appunto>() {
                
                @Override
                public int compare(Appunto a3, Appunto a4) {
                    return a3.getNome().compareTo(a4.getNome());
                }
            });
            ordineCorrente = "Nome";
        }
        
        ListaAppuntiPanel appunti = new ListaAppuntiPanel();
        Grafica.container.add(appunti, "appunti");
        Grafica.card.show(Grafica.container, "appunti");
    }
    
}
