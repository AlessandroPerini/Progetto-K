/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Studente.Studente;
import Università.Corsi.Corso;
import java.util.ArrayList;

/**
 *
 * @author te4o
 */
public class Applicazione {

    public static String facoltàCorrente;
    public static String corsoCorrente;
    public static ArrayList<String> back = new ArrayList<>();
    public static boolean utenteLoggato = false;
    
    public static ArrayList<Corso> corsiAttuali = new ArrayList<>();
    private static Studente guest;

    public Applicazione(ArrayList<Corso> corsiAttuali) {
        this.corsiAttuali = corsiAttuali;
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
        corsiAttuali.clear();
    }
    
    public static Studente getGuest() {
        return guest;
    }

    public static ArrayList<Corso> getCorsiAttuali() {
        return corsiAttuali;
    }

}
