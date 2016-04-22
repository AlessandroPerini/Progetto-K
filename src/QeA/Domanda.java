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
    private int like;
    private String domanda;
    private String studente;

    public Domanda(String titolo, int like, String domanda, String studente) {
        this.titolo = titolo;
        this.like = like;
        this.domanda = domanda;
        this.studente = studente;
    }

    public String getStudente() {
        return studente;
    }


    public String getTitolo() {
        return titolo;
    }

    public int getLike() {
        return like;
    }

    public String getDomanda() {
        return domanda;
    }
    
    
    
}
