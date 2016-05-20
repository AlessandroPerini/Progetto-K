/*
* Classe contentenete la struttura di uno facoltà:
* attributi, costruttore, metodi get - set
*/
package Università.Facolta;

/**
 *
 * @author te4o
 */
public class Facoltà {
    
    private String nome;
    private String ramo;

    public Facoltà(String nome, String ramo) {
        this.nome = nome;
        this.ramo = ramo;
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
