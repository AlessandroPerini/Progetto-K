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
                ps1.setString(1, Applicazione.facoltàPremuta);

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
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeLibro = rs.getString("titolo");
                String descrizioneLibro = rs.getString("descrizione");
                String idLibro = rs.getString("id");
                String emailLibro = rs.getString("studente");
                String telefonoLibro = rs.getString("telefono");
                int prezzoLibro = rs.getInt("prezzo");
                
                Libro libro = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro, prezzoLibro);
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
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String titoloDomanda = rs.getString("titolo");
                String testoDomanda = rs.getString("domanda");
                String studenteDomanda = rs.getString("studente");
               
                Domanda domanda = new Domanda(titoloDomanda, testoDomanda, studenteDomanda);
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
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeAppunto = rs.getString("nome");
                String descrizioneAppunto = rs.getString("descrizione");
                String emailAppunto = rs.getString("studente");
                
                Appunto appunto = new Appunto(nomeAppunto, descrizioneAppunto, emailAppunto);
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
                String risposta = rs.getString("risposta");
     
                Risposta rispsta = new Risposta(risposta, domanda, like, dislike, studente);
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
    
        String facoltàQuery = Applicazione.facoltàPremuta.replaceAll("'", "\\\\'");
        String corsoQuery = Applicazione.corsoPremuto.replaceAll("'", "\\\\'");
        String appuntoQuery = Applicazione.appuntoAttuale.getNome().replaceAll("'", "\\\\'");
        
        String selectRecensioni = "select * from valutazioni where facoltà = '"+facoltàQuery+"' and corso = '"+corsoQuery+"' and appunto='"+appuntoQuery+"'";
        
        try{
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectRecensioni);

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
        String selectInfoDomanda = "select * from facolt\u00e0Preferite where studente=?";
        try {
            PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectInfoDomanda);
            ps1.clearParameters();
            ps1.setString(1, Applicazione.guest.getEmail());
            
            ResultSet rs = ps1.executeQuery();
            
            Applicazione.preferiti.getFacoltàPreferite().clear();
            while (rs.next()) {
                String nome = rs.getString("facolt\u00e0");
                String ramo = rs.getString("ramo");
                
                Applicazione.preferiti.getFacoltàPreferite().add(new Facoltà(nome, ramo));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}