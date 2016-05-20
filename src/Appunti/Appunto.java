/*
* Classe contentenete la struttura di un Appunto:
* attributi, costruttore, metodi get - set
* 
*/
package Appunti;

/**
 *
 * @author cl418646
 */
public class Appunto {
    
    private String nome;
    private String descrizione;
    private String studente;
    private String corso;
    private String facoltà;
    private float media;
    
    public Appunto(String nome, String descrizione, String studente, String corso, String facoltà, float media) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.studente = studente;
        this.corso = corso;
        this.facoltà = facoltà;
        this.media = media;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getDescrizione() {
        return descrizione;
    }
    
    public String getStudente() {
        return studente;
    }
    
    public String getCorso() {
        return corso;
    }
    
    public String getFacoltà() {
        return facoltà;
    }
    
    public float getMedia() {
        return media;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMedia(float media) {
        this.media = media;
    }

}
