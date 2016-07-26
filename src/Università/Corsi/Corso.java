
package Università.Corsi;

/**
* Classe contentenete la struttura di un corso:
* attributi, costruttore, metodi get - set
*/
public class Corso {
    
    private String nome;
    private int anno;
    private String facoltà;

    public Corso(String nome, int anno, String facoltà) {
        this.nome = nome;
        this.anno = anno;
        this.facoltà = facoltà;
    }

    public String getNome() {
        return nome;
    }

    public int getAnno() {
        return anno;
    }
   
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFacoltà() {
        return facoltà;
    }
    
}
