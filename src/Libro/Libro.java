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
    private int ID;
    private String telefono;
    private String email;
    private int prezzo;

    public Libro(String titolo, String descrizione, int ID, String telefono, String email, int prezzo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.ID = ID;
        this.telefono = telefono;
        this.email = email;
        this.prezzo = prezzo;
    }

    public int getPrezzo() {
        return prezzo;
    }

  

    public String getTitolo() {
        return titolo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getID() {
        return ID;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
    
    
}

    
    
    
    

