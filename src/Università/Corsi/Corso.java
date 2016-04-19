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

    public Corso(String nome, int anno) {
        this.nome = nome;
        this.anno = anno;
    }

    public String getNome() {
        return nome;
    }

}
