
package QeA;

/**
* Classe contenente la struttura di una domanda:
* attributi, costruttore, metodi get - set
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

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Domanda{" + "titolo=" + titolo + ", domanda=" + domanda + ", studente=" + studente + ", like=" + like + ", corso=" + corso + ", facolt\u00e0=" + facoltà + '}';
    }
    
    
    
}
