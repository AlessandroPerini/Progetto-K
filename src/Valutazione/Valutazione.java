/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Valutazione;

/**
 *
 * @author cl418646
 */
public class Valutazione {
    
    private String commento;
    private int punteggio;
    private String studente;

    public Valutazione(String commento, int punteggio, String studente) {
        this.commento = commento;
        this.punteggio = punteggio;
        this.studente = studente;
    }

    public String getCommento() {
        return commento;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public String getStudente() {
        return studente;
    }

   
    
}
