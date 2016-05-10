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

    public Risposta(String titolo, String domanda, int like, int dislike,int id, String email) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.id = id;
        this.dislike = dislike;
        this.like = like;
        this.email = email;
    }

     public String setNickname() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String nome = parts[0];
        String cognome = parts[1].charAt(0)+"";
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1);
        return  nome+" "+cognome+".";
    }

    public String getTitolo() {
        return titolo;
    }

    public int getId() {
        return id;
    }
    
    
    
     
    
    
    
    
 
}
