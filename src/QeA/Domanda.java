/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

/**
 *
 * @author te4o
 */
public class Domanda { 
    
    private String titolo;
    private String domanda;
    private String studente;

    public Domanda(String titolo, String domanda, String studente) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.studente = studente;
    }

    public String getStudente() {
        return studente;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDomanda() {
        return domanda;
    }
    
    
    
}
