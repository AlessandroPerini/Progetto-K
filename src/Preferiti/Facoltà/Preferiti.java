/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà;

import Appunti.Appunto;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.util.ArrayList;

/**
 *
 * @author te4o
 */
public class Preferiti {
    
    private ArrayList<Facoltà> facoltàPreferite;
    private ArrayList<Corso> corsiPreferiti;
    private ArrayList<Appunto> appuntiPreferiti;
    private ArrayList<Libro> libriPreferiti;
    private ArrayList<Domanda> domandePreferite;

    public Preferiti() {
        this.facoltàPreferite = new ArrayList<>();
        this.corsiPreferiti = new ArrayList<>();
        this.appuntiPreferiti = new ArrayList<>();
        this.libriPreferiti = new ArrayList<>();
        this.domandePreferite = new ArrayList<>();
    }

    public ArrayList<Facoltà> getFacoltàPreferite() {
        return facoltàPreferite;
    }

    public void setFacoltàPreferite(ArrayList<Facoltà> facoltàPreferite) {
        this.facoltàPreferite = facoltàPreferite;
    }

    public ArrayList<Corso> getCorsiPreferiti() {
        return corsiPreferiti;
    }

    public void setCorsiPreferiti(ArrayList<Corso> corsiPreferiti) {
        this.corsiPreferiti = corsiPreferiti;
    }

    public ArrayList<Appunto> getAppuntiPreferiti() {
        return appuntiPreferiti;
    }

    public void setAppuntiPreferiti(ArrayList<Appunto> appuntiPreferiti) {
        this.appuntiPreferiti = appuntiPreferiti;
    }

    public ArrayList<Libro> getLibriPreferiti() {
        return libriPreferiti;
    }

    public void setLibriPreferiti(ArrayList<Libro> libriPreferiti) {
        this.libriPreferiti = libriPreferiti;
    }

    public ArrayList<Domanda> getDomandePreferite() {
        return domandePreferite;
    }

    public void setDomandePreferite(ArrayList<Domanda> domandePreferite) {
        this.domandePreferite = domandePreferite;
    }
    
    
 
}
