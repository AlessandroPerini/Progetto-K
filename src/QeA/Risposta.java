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
public class Risposta {
    
    private String titolo;
    private String domanda;
    private int id;
    private int like;

    public Risposta(String titolo, String domanda, int id, int like) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.id = id;
        this.like = like;
    }
 
}
