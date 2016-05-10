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
    private int like;
    private String corso;
    private String facoltà;

    public Domanda(String titolo, String domanda, String studente, int like, String corso, String facoltà) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.studente = studente;
        this.like = like;
        this.corso = corso;
        this.facoltà = facoltà;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDomanda() {
        return domanda;
    }

    public String getStudente() {
        return studente;
    }

    public int getLike() {
        return like;
    }

    public String getCorso() {
        return corso;
    }

    public String getFacoltà() {
        return facoltà;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    
}
