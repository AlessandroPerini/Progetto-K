/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Utils;

import Application.Controller.Applicazione;
import Appunti.Appunto;
import QeA.Domanda;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author te4o
 */
public class Ordina {
    
    public static void Domande(){
        Collections.sort(Applicazione.listaDomandeAttuali, new Comparator<Domanda>() {
            
            @Override
            public int compare(Domanda d1, Domanda d2) {
                return Integer.compare(d2.getLike(), d1.getLike());
            }
        });
    }
    
    public static void Appunti(){
        Collections.sort(Applicazione.listaAppuntiAttuali, new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return Float.compare(a2.getMedia(), a1.getMedia());
            }
        });
    }
}
