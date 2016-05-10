/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Appunti.Appunto;
import Application.Controller.Applicazione;
import Libri.Libro;
import QeA.Domanda;
import QeA.Risposta;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import Valutazione.Valutazione;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class ListeQuery {
 
    public static void caricaFacoltà(){
        
        String selectFacoltà = "select * from facoltà";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectFacoltà);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nome = rs.getString("nome");
                    String ramo = rs.getString("ramo");
                    Facoltà facoltà = new Facoltà(nome, ramo);
                    Applicazione.listaFacoltàAttuali.add(facoltà);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaCorsi(){

        String selectCorsi = "select * from corsi where facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectCorsi);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàAttuale.getNome());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeCorso = rs.getString("nome");
                    int annoCorso = rs.getInt("anno");
                    String facoltàCorso = rs.getString("facoltà");
                    Corso corso = new Corso(nomeCorso, annoCorso, facoltàCorso);
                    Applicazione.listaCorsiAttuali.add(corso);
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaLibri(){

        String selectLibri = "select * from libri where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLibri);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàAttuale.getNome());
                ps1.setString(2, Applicazione.corsoAttuale.getNome());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeLibro = rs.getString("titolo");
                String descrizioneLibro = rs.getString("descrizione");
                int idLibro = rs.getInt("id");
                String emailLibro = rs.getString("studente");
                String telefonoLibro = rs.getString("telefono");
                int prezzoLibro = rs.getInt("prezzo");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                
                Libro libro = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro, prezzoLibro, corso, facoltà);
                Applicazione.listaLibriAttuali.add(libro);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaDomande(){

        String selectDomande = "select * from domande where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomande);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàAttuale.getNome());
                ps1.setString(2, Applicazione.corsoAttuale.getNome());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String titoloDomanda = rs.getString("titolo");
                String testoDomanda = rs.getString("domanda");
                String studenteDomanda = rs.getString("studente");
                int like = rs.getInt("like");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
               
                Domanda domanda = new Domanda(titoloDomanda, testoDomanda, studenteDomanda, like, corso, facoltà);
                Applicazione.listaDomandeAttuali.add(domanda);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaAppunti(){

        String selectAppunti = "select * from appunti where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectAppunti);
                ps1.clearParameters();
                ps1.setString(1, Applicazione.facoltàAttuale.getNome());
                ps1.setString(2, Applicazione.corsoAttuale.getNome());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeAppunto = rs.getString("nome");
                String descrizioneAppunto = rs.getString("descrizione");
                String emailAppunto = rs.getString("studente");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                
                Appunto appunto = new Appunto(nomeAppunto, descrizioneAppunto, emailAppunto, corso, facoltà);
                Applicazione.listaAppuntiAttuali.add(appunto);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

   public static void caricaRisposteDomanda() {
        String selectRisposteDomanda = "select * from risposte where domanda=?";
        String info = "";
        String nickname = "";
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectRisposteDomanda);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.domandaAttuale.getTitolo());
            
            ResultSet rs = ps1.executeQuery();
            
            while (rs.next()) {
                String domanda = rs.getString("domanda");
                String studente = rs.getString("studente");
                int like = rs.getInt("like");
                int dislike = rs.getInt("dislike");
                int id = rs.getInt("id");
                String risposta = rs.getString("risposta");
     
                Risposta rispsta = new Risposta(risposta, domanda, like, dislike,id, studente);
                Applicazione.listaRisposteAttuali.add(rispsta);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void caricaRamiFacoltà(){
        
        String sql = "select distinct ramo from facoltà";
        
        try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(sql);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String ramo = rs.getString("ramo");
                    
                    Applicazione.listaRamiFacoltà.add(ramo);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaFacoltà(String ramo){
        
        String selectFacoltà = "select * from facoltà where ramo =?";
        
        try{
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectFacoltà);
            ps1.clearParameters();
            ps1.setString(1, ramo);

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){

                String nome = rs.getString("nome");
                String ramo1 = rs.getString("ramo");
                Facoltà facoltà = new Facoltà(nome, ramo1);
                Applicazione.listaFacoltàXRamo.add(facoltà);

            }
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public static void caricaRecensioniAppunto(){
    
        String facoltàQuery = Applicazione.facoltàAttuale.getNome().replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoAttuale.getNome().replaceAll("'", "\\\\'");
        String appuntoQuery = Applicazione.appuntoAttuale.getNome().replaceAll("'", "\\\\'");
        
        String selectRecensioni = "select * from valutazioni where facoltà = ? and corso = ? and appunto = ?";
        
        try{
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectRecensioni);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.facoltàAttuale.getNome());
            ps1.setString(2, Applicazione.corsoAttuale.getNome());
            ps1.setString(3, Applicazione.appuntoAttuale.getNome());

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){

                String studente = rs.getString("studente");
                int punteggio = rs.getInt("punteggio");
                String commento = rs.getString("commento");
                Valutazione valutazione = new Valutazione(commento, punteggio, studente);
                Applicazione.listaValutazioniAttuali.add(valutazione);

            }
            }   catch (SQLException ex) {   
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public static void caricaFacoltàPreferite() {
        
        String selectFacoltàPreferite = "select * from facoltàPreferite where studente=?";
        
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectFacoltàPreferite);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getFacoltàPreferite().clear();
            while (rs.next()) {
                String nome = rs.getString("facoltà");
                String ramo = rs.getString("ramo");
                
                Applicazione.preferiti.getFacoltàPreferite().add(new Facoltà(nome, ramo));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void caricaCorsiPreferiti() {
        
        String selectCorsiPreferiti = "select * from corsiPreferiti where studente=?";
        
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectCorsiPreferiti);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getCorsiPreferiti().clear();
            while (rs.next()) {
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                int anno = rs.getInt("anno");
                
                Applicazione.preferiti.getCorsiPreferiti().add(new Corso(corso, anno, facoltà));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void caricaAppuntiPreferiti() {
        
        String selectAppuntiPreferiti = "select * from appuntiPreferiti where studentePref=?";
        
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectAppuntiPreferiti);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getAppuntiPreferiti().clear();
            while (rs.next()) {
                String appunto = rs.getString("appunto");
                String descrizione = rs.getString("descrizione");
                String studente = rs.getString("studenteApp");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                
                Applicazione.preferiti.getAppuntiPreferiti().add(new Appunto(appunto, descrizione, studente, corso, facoltà));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void caricaLibriPreferiti() {
        
        String selectLibriPreferiti = "select * from libriPreferiti where studentePref=?";
        
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectLibriPreferiti);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getLibriPreferiti().clear();
            while (rs.next()) {
                int id = rs.getInt("id");
                String libro = rs.getString("libro");
                String descrizione = rs.getString("descrizione");
                String telefono = rs.getString("telefono");
                int prezzo = rs.getInt("prezzo");
                String studente = rs.getString("studenteLib");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                
                Applicazione.preferiti.getLibriPreferiti().add(new Libro(libro, descrizione, id, telefono, studente, prezzo, corso, facoltà));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void caricaDomandePreferite() {
        
        String selectDomandePreferite = "select * from domandePreferite where studentePref=?";
        
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectDomandePreferite);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getDomandePreferite().clear();
            while (rs.next()) {
                String domanda = rs.getString("domanda");
                String descrizione = rs.getString("descrizione");
                int like = rs.getInt("like");
                String studente = rs.getString("studenteDom");
                String corso = rs.getString("corso");
                String facoltà = rs.getString("facoltà");
                
                Applicazione.preferiti.getDomandePreferite().add(new Domanda(domanda, descrizione, studente, like, corso, facoltà));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}