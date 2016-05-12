/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Utils;

import Application.Controller.Applicazione;
import Appunti.Appunto;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.Corso;
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
    
    public static void Libri(){
        Collections.sort(Applicazione.listaLibriAttuali, new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().compareTo(l2.getTitolo());
            }
        });
    }
    
    public static void CorsiXAnno(){
        Collections.sort(Applicazione.listaCorsiXAnno, new Comparator<Corso>() {
            
            @Override
            public int compare(Corso c1, Corso c2) {
                return c1.getNome().compareTo(c2.getNome());
            }
        });
    }
    
}
