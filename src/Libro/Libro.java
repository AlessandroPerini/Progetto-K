    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libro;

/**
 *
 * @author cl418646
 */
public class Libro {
    
    private String titolo;
    private String descrizione;
    private String ID;
    private String email;
    private String telefono;
    private int prezzo;

    public Libro(String titolo, String descrizione, String ID, String email, String telefono, int prezzo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.ID = ID;
        this.email = email;
        this.telefono = telefono;
        this.prezzo = prezzo;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getPrezzo() {
        return prezzo;
    }  
    
}
