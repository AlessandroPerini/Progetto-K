/*
* Classe contentenete la struttura di una risposta:
* attributi, costruttore, metodi get - set
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
    private String nickname;

    public Risposta(String titolo, String domanda, int id, String email, String nickname) {
        this.titolo = titolo;
        this.domanda = domanda;
        this.id = id;
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
