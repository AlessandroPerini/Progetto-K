/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi;

/**
 *
 * @author te4o
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
    
}
