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
    private String email;
    private int id;
    private int like;
    private int dislike;
    private String nickname;

    public Risposta(String titolo, String domanda, int like, int dislike,int id, String email, String nickname) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.id = id;
        this.dislike = dislike;
        this.like = like;
        this.email = email;
        this.nickname = nickname;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getDomanda() {
        return domanda;
    }
   
}
