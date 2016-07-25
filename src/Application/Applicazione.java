/*
* Questo è il controller del progetto, colui che gestisce tutti i dati principali
* utilizzati dalle classi: la connessione al database, i dati dell'utente loggato
* e gestisce le liste di appunti, libri e domande.
*/
package Application;

import Entità.Domanda;
import Entità.Appunto;
import Entità.Valutazione;
import Entità.Studente;
import Entità.Libro;
import Entità.Facoltà;
import Entità.Risposta;
import Entità.Corso;
import Entità.Preferiti;
import Database.ConnessioneDB;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author te4o
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
    
    public void inizializzaUtente(String email, String password, String telefono, String nickname){
        
        guest = new Studente(email, password, telefono, nickname);
        guest.setNome();
        guest.setCognome();
        
        utenteLoggato = true;
    }
    
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
    
    public void logout(){
        
        eliminaUtente();
        svuotaTutteLeListe();
    }
    
}
