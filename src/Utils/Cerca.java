/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Application.Controller.Applicazione;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class Cerca {
    
    public static void Facoltà(JTextField testoRicerca){
    
        Facoltà[] facoltàCercate = new Facoltà[Applicazione.listaFacoltàAttuali.size()];
        
        for (int i = 0; i < facoltàCercate.length; i++) {
            facoltàCercate[i] = null;
        }
        for (int i = 0; i < Applicazione.listaFacoltàAttuali.size(); i++) {
            if (Applicazione.listaFacoltàAttuali.get(i).getNome().toLowerCase().contains(testoRicerca.getText().toLowerCase())) {
                facoltàCercate[i] = Applicazione.listaFacoltàAttuali.get(i);
            }
        }
        Applicazione.listaFacoltàAttuali.clear();
        for (int i = 0; i < facoltàCercate.length; i++) {
            if (facoltàCercate[i] != null) {
                Applicazione.listaFacoltàAttuali.add(facoltàCercate[i]);
            }
        }
    }
    
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
}
