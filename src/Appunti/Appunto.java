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
    private String corso;
    private String facoltà;

    public Appunto(String nome, String descrizione, String studente, String corso, String facoltà) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.studente = studente;
        this.corso = corso;
        this.facoltà = facoltà;
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

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
