    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

/**
 *
 * @author cl418646
 */
public class Libro {
    
    private String titolo;
    private String descrizione;
    private int ID;
    private String studente;
    private String telefono;
    private int prezzo;


    public Libro(String titolo, String descrizione, int ID, String telefono, String studente, int prezzo) {

        this.titolo = titolo;
        this.descrizione = descrizione;
        this.ID = ID;
        this.studente = studente;
        this.telefono = telefono;
        this.prezzo = prezzo;
  
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getID() {
        return ID;
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

    
    
}

    
    
    
    

