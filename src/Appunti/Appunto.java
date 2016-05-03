/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

    public Appunto(String nome, String descrizione, String studente) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.studente = studente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getStudente() {
        return studente;
    }

   
    
}
