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

import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class Cerca {
    
    public static void Corsi(JTextField testoRicerca){
    
        Corso[] corsiCercati = new Corso[Applicazione.listaCorsiAttuali.size()];
        
        for (int i = 0; i < corsiCercati.length; i++) {
            corsiCercati[i] = null;
        }
        for (int i = 0; i < Applicazione.listaCorsiAttuali.size(); i++) {
            if (Applicazione.listaCorsiAttuali.get(i).getNome().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                corsiCercati[i] = Applicazione.listaCorsiAttuali.get(i);
            }
        }
        Applicazione.listaCorsiAttuali.clear();
        for (int i = 0; i < corsiCercati.length; i++) {
            if (corsiCercati[i] != null) {
                Applicazione.listaCorsiAttuali.add(corsiCercati[i]);
            }
        }
    }
    
    public static void Appunti(JTextField testoRicerca){
    
        Appunto[] appuntiCercati = new Appunto[Applicazione.listaAppuntiAttuali.size()];

        for (int i = 0; i < Applicazione.listaAppuntiAttuali.size(); i++) {
            if (Applicazione.listaAppuntiAttuali.get(i).getNome().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                appuntiCercati[i] = Applicazione.listaAppuntiAttuali.get(i);
            }
        }
        Applicazione.listaAppuntiAttuali.clear();
        for (int i = 0; i < appuntiCercati.length; i++) {
            if (appuntiCercati[i] != null) {
                Applicazione.listaAppuntiAttuali.add(appuntiCercati[i]);
            }
        }
    }
    
    public static void Libri(JTextField testoRicerca){
    
        Libro[] libriCercati = new Libro[Applicazione.listaLibriAttuali.size()];

        for (int i = 0; i < Applicazione.listaLibriAttuali.size(); i++) {
            if (Applicazione.listaLibriAttuali.get(i).getTitolo().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                libriCercati[i] = Applicazione.listaLibriAttuali.get(i);
            }
        }
        Applicazione.listaLibriAttuali.clear();
        for (int i = 0; i < libriCercati.length; i++) {
            if (libriCercati[i] != null) {
                Applicazione.listaLibriAttuali.add(libriCercati[i]);
            }
        }
    }
    
    public static void Domande(JTextField testoRicerca){
    
        Domanda[] domandeCercate = new Domanda[Applicazione.listaDomandeAttuali.size()];

        for (int i = 0; i < Applicazione.listaDomandeAttuali.size(); i++) {
            if (Applicazione.listaDomandeAttuali.get(i).getTitolo().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                domandeCercate[i] = Applicazione.listaDomandeAttuali.get(i);
            }
        }
        Applicazione.listaDomandeAttuali.clear();
        for (int i = 0; i < domandeCercate.length; i++) {
            if (domandeCercate[i] != null) {
                Applicazione.listaDomandeAttuali.add(domandeCercate[i]);
            }
        }
    }
    
   
}
