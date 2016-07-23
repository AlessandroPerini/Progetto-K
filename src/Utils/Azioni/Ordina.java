/*
* Classe con i metodi statici per l'ordinamento di liste di oggetti
*/
package Utils.Azioni;

import Application.Controller.Applicazione;
import Appunti.Appunto;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author te4o
 */
public class Ordina {
    
    private static Applicazione applicazione = Applicazione.getInstance();
    
    public static void Domande(){
        Collections.sort(applicazione.listaDomandeAttuali, new Comparator<Domanda>() {
            
            @Override
            public int compare(Domanda d1, Domanda d2) {
                return Integer.compare(d2.getLike(), d1.getLike());
            }
        });
    }
    
    public static void DomandeAlfabetic(){
        Collections.sort(applicazione.listaDomandeAttuali, new Comparator<Domanda>() {
            
            @Override
            public int compare(Domanda d1, Domanda d2) {
                return d1.getTitolo().toLowerCase().compareTo(d2.getTitolo().toLowerCase());
            }
        });
    }
    
    public static void Appunti(){
        Collections.sort(applicazione.listaAppuntiAttuali, new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return Float.compare(a2.getMedia(), a1.getMedia());
            }
        });
    }
    
    public static void AppuntiAlfabetic(){
        Collections.sort(applicazione.listaAppuntiAttuali, new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a3, Appunto a4) {
                return a3.getNome().toLowerCase().compareTo(a4.getNome().toLowerCase());
            }
        });
    }
    
    public static void Libri(){
        Collections.sort(applicazione.listaLibriAttuali, new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void CorsiXAnno(){
        Collections.sort(applicazione.listaCorsiXAnno, new Comparator<Corso>() {
            
            @Override
            public int compare(Corso c1, Corso c2) {
                return c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase());
            }
        });
    }
    
    public static void Rami(){
        Collections.sort(applicazione.listaRamiFacoltà, new Comparator<String>() {
            
            @Override
            public int compare(String f1, String f2) {
                return f1.toUpperCase().compareTo(f2.toUpperCase());
            }
        });
    }
    
    public static void FacoltàPreferite(){
        Collections.sort(applicazione.preferiti.getFacoltàPreferite(), new Comparator<Facoltà>() {
            
            @Override
            public int compare(Facoltà f1, Facoltà f2) {
                return f1.getNome().toUpperCase().compareTo(f2.getNome().toUpperCase());
            }
        });
    }
    
    public static void CorsiPreferiti(){
        Collections.sort(applicazione.preferiti.getCorsiPreferiti(), new Comparator<Corso>() {
            
            @Override
            public int compare(Corso c1, Corso c2) {
                return c1.getNome().toUpperCase().compareTo(c2.getNome().toUpperCase());
            }
        });
    }
    
    public static void AppuntiPreferiti(){
        Collections.sort(applicazione.preferiti.getAppuntiPreferiti(), new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return a1.getNome().toUpperCase().compareTo(a2.getNome().toUpperCase());
            }
        });
    }
    
    public static void LibriPreferiti(){
        Collections.sort(applicazione.preferiti.getLibriPreferiti(), new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void DomandePreferite(){
        Collections.sort(applicazione.preferiti.getDomandePreferite(), new Comparator<Domanda>() {
            
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
        Collections.sort(applicazione.appuntiGuest, new Comparator<Appunto>() {
            
            @Override
            public int compare(Appunto a1, Appunto a2) {
                return a1.getNome().toUpperCase().compareTo(a2.getNome().toUpperCase());
            }
        });
    }
    
    public static void MieiLibri(){
        Collections.sort(applicazione.libriGuest, new Comparator<Libro>() {
            
            @Override
            public int compare(Libro l1, Libro l2) {
                return l1.getTitolo().toUpperCase().compareTo(l2.getTitolo().toUpperCase());
            }
        });
    }
    
    public static void MieDomande(){
        Collections.sort(applicazione.domandeGuest, new Comparator<Domanda>() {
            
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
