
package Libri;

/**
* Classe contentenete la struttura di un libro:
* attributi, costruttore, metodi get - set
*/
public class Libro {
    
    private String titolo;
    private String descrizione;
    private int id;
    private String studente;
    private String telefono;
    private int prezzo;
    private String corso;
    private String facoltà;

    public Libro(String titolo, String descrizione, int id, String studente, String telefono, int prezzo, String corso, String facoltà) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.id = id;
        this.studente = studente;
        this.telefono = telefono;
        this.prezzo = prezzo;
        this.corso = corso;
        this.facoltà = facoltà;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getID() {
        return id;
    }

    public String getStudente() {
        return studente;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPrezzo() {
        return prezzo;
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

    
    
    
    

