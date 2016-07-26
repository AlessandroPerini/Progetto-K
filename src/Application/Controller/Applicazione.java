

package Application.Controller;

import Appunti.Appunto;
import Database.Connection.ConnessioneDB;
import Libri.Libro;
import Preferiti.Preferiti;
import QeA.Domanda;
import QeA.Risposta;
import Studenti.Studente;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import Valutazioni.Valutazione;
import java.sql.Connection;
import java.util.ArrayList;

/**
 * Questo è il controller facade del progetto, colui che gestisce tutti i dati e le strutture principali
 * utilizzati dalle classi: la connessione al database, i dati dell'utente loggato
 * e le liste di appunti, libri e domande.
 * Riceve i dati modificati dalla logica applicativa e li rende disponibile alla grafica.
 */

public class Applicazione {
    
    private static Applicazione instance;  
    public Connection DBconnection;
    public boolean erroreConnessione = false;
    
    private Applicazione(){
        try {
            ConnessioneDB connessioneDB = ConnessioneDB.getInstance();
            DBconnection = connessioneDB.connect();
        } catch (Exception ex) {
            erroreConnessione = true;
        }
    }
    
    /**
     * Assicura che la classe sia singleton.
     * Se la classe non è ancora stata istanziata, il metodo crea l'istanza e la restituisce.
     * Se invece l'istanza è gia stata creata, la restituisce semplicemente.
     * 
     */
    public static synchronized Applicazione getInstance(){
    
        if(instance == null){ 
            instance = new Applicazione(); }
        return instance;
    }
        
    public Studente guest;
    public boolean utenteLoggato = false;
    public ArrayList<String> back = new ArrayList<>();
    
    public ArrayList<Corso> listaCorsiAttuali = new ArrayList<>();
    public ArrayList<Facoltà> listaFacoltàAttuali = new ArrayList<>();
    public ArrayList<Libro> listaLibriAttuali = new ArrayList<>();
    public ArrayList<Domanda> listaDomandeAttuali = new ArrayList<>();
    public ArrayList<Appunto> listaAppuntiAttuali = new ArrayList<>();
    public ArrayList<Risposta> listaRisposteAttuali = new ArrayList<>();
    public ArrayList<Facoltà> listaFacoltàXRamo = new ArrayList<>();
    public ArrayList<String> listaRamiFacoltà = new ArrayList<>();
    public ArrayList<Corso> listaCorsiXAnno= new ArrayList<>();
    public ArrayList<Valutazione> listaValutazioniAttuali = new ArrayList<>();
    
    public Preferiti preferiti = new Preferiti();
    
    public Facoltà facoltàAttuale = new Facoltà("", "");
    public Corso corsoAttuale = new Corso("", 0, "");
    public Libro libroAttuale = new Libro("", "", 0, "", "", 0, "", "");
    public Domanda domandaAttuale = new  Domanda("", "", "", 0, "", "");
    public Appunto appuntoAttuale = new Appunto("", "", "", "", "", 0);
    
    public ArrayList<Appunto> appuntiGuest = new ArrayList<>();
    public ArrayList<Libro> libriGuest = new ArrayList<>();
    public ArrayList<Domanda> domandeGuest = new ArrayList<>();
    
    /**
     * Crea un'istanza guest di tipo Studente con i parametri ricevuti e la inserisce in guest.
     * @param email 
     * @param password 
     * @param telefono 
     * @param nickname
     *
     */
    public void inizializzaUtente(String email, String password, String telefono, String nickname){
        
        guest = new Studente(email, password, telefono, nickname);
        guest.setNome();
        guest.setCognome();
        
        utenteLoggato = true;
    }
    
    /**
     * Ricrea un'istanza vuota di Studente e la inserisce in guest.
     * Poi setta la variabile booleana utenteLoggato a false.
     */
    public void eliminaUtente(){
        guest = new Studente("", "","", "");
        utenteLoggato = false;
    }
    
    public void svuotaCorsi() {
        listaCorsiAttuali.clear();
    }
    
    public void svuotaFacoltà() {
        listaFacoltàAttuali.clear();
    }
    
    public void svuotaLibri() {
        listaLibriAttuali.clear();
    }
    
    public void svuotaDomande() {
        listaDomandeAttuali.clear();
    }
    
    public void svuotaAppunti() {
        listaAppuntiAttuali.clear();
    }
    
    public void svuotaRisposte() {
        listaRisposteAttuali.clear();
    }
    
    public void svuotaMieiDati() {
        appuntiGuest.clear();
        libriGuest.clear();
        domandeGuest.clear();
    }
    
    public void svuotaListaFacoltàXRamo(){
        listaFacoltàXRamo.clear();
    }
    
    public void svuotaRami(){
        listaRamiFacoltà.clear();
    }
    
    public void svuotaCorsiXAnno(){
        listaCorsiXAnno.clear();
    }
    
    public void svuotaRecensioni(){
        listaValutazioniAttuali.clear();
    }
    
    public void svuotaPreferiti(){
        preferiti.getAppuntiPreferiti().clear();
        preferiti.getCorsiPreferiti().clear();
        preferiti.getLibriPreferiti().clear();
        preferiti.getFacoltàPreferite().clear();
        preferiti.getCorsiPreferiti().clear();
    }
    
    public void svuotaTutteLeListe(){

        svuotaCorsi();
        svuotaFacoltà();
        svuotaLibri();
        svuotaDomande();
        svuotaAppunti();
        svuotaRisposte();
        svuotaMieiDati();
        svuotaListaFacoltàXRamo();
        svuotaRecensioni();
        svuotaRami();
        svuotaCorsiXAnno();
        svuotaPreferiti();
    }
    
    /**
     * Metodo necessario per l'operazione di logout dall'applicazione.
     * Elimina l'utente loggato e svuota tutte le liste relative.
     * 
     */
    public void logout(){
        
        eliminaUtente();
        svuotaTutteLeListe();
    }
    
}
