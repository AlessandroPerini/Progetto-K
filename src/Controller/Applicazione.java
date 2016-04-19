/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Appunti.Appunto;
import Libri.Libro;
import QeA.Domanda;
import Studente.Studente;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.util.ArrayList;

/**
 *
 * @author te4o
 */
public class Applicazione {

        
    public static ArrayList<String> back = new ArrayList<>();
    public static boolean utenteLoggato = false;
    
    private static Studente guest;
    
    public static String facoltàPremuta;
    public static String corsoPremuto;
    public static String libroPremuto;
    public static String domandaPremuta;
    public static String appuntoPremuto;
    
    public static ArrayList<Corso> listaCorsiAttuali = new ArrayList<>();
    public static ArrayList<Facoltà> listaFacoltàAttuali = new ArrayList<>();
    public static ArrayList<Libro> ListaLibriAttuali = new ArrayList<>();
    public static ArrayList<Domanda> ListaDomandeAttuali = new ArrayList<>();
    public static ArrayList<Appunto> ListaAppuntiAttuali = new ArrayList<>();
    
    public static Libro libroAttuale;
    public static Domanda domandaAttuale;
    public static Appunto appuntoAttuale;
    
    public Applicazione(ArrayList<Corso> corsiAttuali) {
        this.listaCorsiAttuali = corsiAttuali;
    }

    public static void inizializzaUtente(String email, String password, int punti, String telefono){
    
        guest = new Studente(email, password, punti, telefono);
        guest.setNickname();
        guest.setNome();
        guest.setCognome();
        
        utenteLoggato = true;
    }
    
    public static void eliminaUtente(){
        guest = new Studente("", "", 0, "");
        utenteLoggato = false;
    }
    
    public static void svuotaCorsi() {
        listaCorsiAttuali.clear();
    }
    
    public static void svuotaFacoltà() {
        listaFacoltàAttuali.clear();
    }
    
    public static void svuotaLibri() {
        ListaLibriAttuali.clear();
    }
    
    public static void svuotaDomande() {
        ListaDomandeAttuali.clear();
    }
    
    public static Studente getGuest() {
        return guest;
    }
 

}
