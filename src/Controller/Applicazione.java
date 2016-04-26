/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Appunti.Appunto;
import Database.Connection.ConnessioneDB;
import Libri.Libro;
import QeA.Domanda;
import Studente.Studente;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author te4o
 */
public class Applicazione {

    public static Connection connection = new ConnessioneDB().connect();
        
    public static ArrayList<String> back = new ArrayList<>();
    public static boolean utenteLoggato = false;
    
    public static Studente guest;
    
    public static String facoltàPremuta;
    public static String corsoPremuto;
    
    public static ArrayList<Corso> listaCorsiAttuali = new ArrayList<>();
    public static ArrayList<Facoltà> listaFacoltàAttuali = new ArrayList<>();
    public static ArrayList<Libro> ListaLibriAttuali = new ArrayList<>();
    public static ArrayList<Domanda> ListaDomandeAttuali = new ArrayList<>();
    public static ArrayList<Appunto> ListaAppuntiAttuali = new ArrayList<>();
    public static ArrayList<String> risposteAttuali = new ArrayList<>();  
    
    public static Libro libroAttuale = new Libro("", "", "", "", "", 0);
    public static Domanda domandaAttuale = new  Domanda("", 0, "", "");
    public static Appunto appuntoAttuale = new Appunto("", "", 0, "");
    
    public static ArrayList<Appunto> appuntiGuest = new ArrayList<>();
    public static ArrayList<Libro> libriGuest = new ArrayList<>();
    public static ArrayList<Domanda> domandeGuest = new ArrayList<>();

    public static void inizializzaUtente(String email, String password, String telefono){
    
        guest = new Studente(email, password, telefono);
        guest.setNickname();
        guest.setNome();
        guest.setCognome();
        
        utenteLoggato = true;
    }
    
    public static void eliminaUtente(){
        guest = new Studente("", "","");
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
    
    public static void svuotaAppunti() {
        ListaAppuntiAttuali.clear();
    }
    
    public static void svuotaRisposte() {
        risposteAttuali.clear();
    }
    
    public static void svuotaMieiDati() {
        appuntiGuest.clear();
        libriGuest.clear();
        domandeGuest.clear();
    }

}
