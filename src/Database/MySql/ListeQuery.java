/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.MySql;

import Appunti.Appunto;
import Controller.Applicazione;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.CaricaCorsi;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
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
    
    public void caricaFacoltà(){
        
        String selectFacoltà = "select * from facoltà";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectFacoltà);

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
    
    public void caricaCorsi(){

        String selectCorsi = "select * from corsi where facoltà=?";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectCorsi);
                ps1.setString(1, Applicazione.facoltàPremuta);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeCorso = rs.getString("nome");
                    int annoCorso = rs.getInt("anno");
                    Corso corso = new Corso(nomeCorso, annoCorso);
                    Applicazione.listaCorsiAttuali.add(corso);
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void caricaLibri(){

        String selectLibri = "select * from libri where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectLibri);
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
                Applicazione.ListaLibriAttuali.add(libro);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void caricaDomande(){

        String selectDomande = "select * from domande where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectDomande);
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String titoloDomanda = rs.getString("titolo");
                String testoDomanda = rs.getString("domanda");
                String studenteDomanda = rs.getString("studente");
                int likeDomanda = rs.getInt("like");
               
                Domanda domanda = new Domanda(titoloDomanda, likeDomanda, testoDomanda, studenteDomanda);
                Applicazione.ListaDomandeAttuali.add(domanda);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void caricaAppunti(){

        String selectAppunti = "select * from appunti where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = Applicazione.connection.prepareStatement(selectAppunti);
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeAppunto = rs.getString("nome");
                String descrizioneAppunto = rs.getString("descrizione");
                int mediaAppunto = rs.getInt("media");
                String emailAppunto = rs.getString("studente");
                
                Appunto appunto = new Appunto(nomeAppunto, descrizioneAppunto, mediaAppunto, emailAppunto);
                Applicazione.ListaAppuntiAttuali.add(appunto);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}