/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Universita.Facolta;

/**
 *
 * @author te4o
 */
public class Facoltà {
    
    private String nome;
    private String ramo;

    public Facoltà(String nome, String ramo) {
        this.nome = nome;
        this.ramo = ramo;
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
