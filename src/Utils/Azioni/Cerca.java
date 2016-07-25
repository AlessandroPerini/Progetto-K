/*
 * Classe con i metodi statici per la ricerca all'interno di una lista di oggetti
 */
package Utils.Azioni;

import Application.Controller.Applicazione;
import Appunti.Appunto;
import Libri.Libro;
import QeA.Domanda;

import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class Cerca {

    private static Applicazione applicazione = Applicazione.getInstance();
    
    public static void Appunti(JTextField testoRicerca){
    
        Appunto[] appuntiCercati = new Appunto[applicazione.listaAppuntiAttuali.size()];

        for (int i = 0; i < applicazione.listaAppuntiAttuali.size(); i++) {
            if (applicazione.listaAppuntiAttuali.get(i).getNome().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                appuntiCercati[i] = applicazione.listaAppuntiAttuali.get(i);
            }
        }
        applicazione.listaAppuntiAttuali.clear();
        for (int i = 0; i < appuntiCercati.length; i++) {
            if (appuntiCercati[i] != null) {
                applicazione.listaAppuntiAttuali.add(appuntiCercati[i]);
            }
        }
    }
    
    public static void Libri(JTextField testoRicerca){
    
        Libro[] libriCercati = new Libro[applicazione.listaLibriAttuali.size()];

        for (int i = 0; i < applicazione.listaLibriAttuali.size(); i++) {
            if (applicazione.listaLibriAttuali.get(i).getTitolo().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                libriCercati[i] = applicazione.listaLibriAttuali.get(i);
            }
        }
        applicazione.listaLibriAttuali.clear();
        for (int i = 0; i < libriCercati.length; i++) {
            if (libriCercati[i] != null) {
                applicazione.listaLibriAttuali.add(libriCercati[i]);
            }
        }
    }
    
    public static void Domande(JTextField testoRicerca){
    
        Domanda[] domandeCercate = new Domanda[applicazione.listaDomandeAttuali.size()];

        for (int i = 0; i < applicazione.listaDomandeAttuali.size(); i++) {
            if (applicazione.listaDomandeAttuali.get(i).getTitolo().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                domandeCercate[i] = applicazione.listaDomandeAttuali.get(i);
            }
        }
        applicazione.listaDomandeAttuali.clear();
        for (int i = 0; i < domandeCercate.length; i++) {
            if (domandeCercate[i] != null) {
                applicazione.listaDomandeAttuali.add(domandeCercate[i]);
            }
        }
    }
    
   
}
