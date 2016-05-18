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
import Universita.Corsi.Corso;
import Universita.Facolta.Facoltà;
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
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void CorsiXAnno(){
        Collections.sort(Applicazione.listaCorsiXAnno, new Comparator<Corso>() {
            
            @Override
            public int compare(Corso c1, Corso c2) {
                return c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase());
            }
        });
    }
    
    public static void FacoltàPreferite(){
        Collections.sort(Applicazione.preferiti.getFacoltàPreferite(), new Comparator<Facoltà>() {
            
            @Override
            public int compare(Facoltà f1, Facoltà f2) {
                return f1.getNome().toUpperCase().compareTo(f2.getNome().toUpperCase());
            }
        });
    }
    
    public static void CorsiPreferiti(){
        Collections.sort(Applicazione.preferiti.getCorsiPreferiti(), new Comparator<Corso>() {
            
            @Override
            public int compare(Corso c1, Corso c2) {
                return c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase());
            }
        });
    }
    
    public static void AppuntiPreferiti(){
        Collections.sort(Applicazione.preferiti.getAppuntiPreferiti(), new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return a1.getNome().toUpperCase().compareTo(a2.getNome().toUpperCase());
            }
        });
    }
    
    public static void LibriPreferiti(){
        Collections.sort(Applicazione.preferiti.getLibriPreferiti(), new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void DomandePreferite(){
        Collections.sort(Applicazione.preferiti.getDomandePreferite(), new Comparator<Domanda>() {
            
            @Override
            public int compare(Domanda d1, Domanda d2) {
                return d1.getTitolo().toUpperCase().compareTo(d2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void ListePreferiti(){
        
        FacoltàPreferite();
        CorsiPreferiti();
        AppuntiPreferiti();
        LibriPreferiti();
        DomandePreferite();
    }
    
    public static void MieiAppunti(){
        Collections.sort(Applicazione.appuntiGuest, new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return a1.getNome().toUpperCase().compareTo(a2.getNome().toUpperCase());
            }
        });
    }
    
    public static void MieiLibri(){
        Collections.sort(Applicazione.libriGuest, new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void MieDomande(){
        Collections.sort(Applicazione.domandeGuest, new Comparator<Domanda>() {
            
            @Override
            public int compare(Domanda d1, Domanda d2) {
                return d1.getTitolo().toUpperCase().compareTo(d2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void ListeMieiDati(){
        
        MieiAppunti();
        MieiLibri();
        MieDomande();
    }
}
