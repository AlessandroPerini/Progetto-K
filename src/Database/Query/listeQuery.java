/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Controller.Applicazione;
import Database.Connection.ConnessioneDB;
import Libro.Libro;
import Università.Corsi.CaricaCorsi;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class listeQuery {
    
    private Connection connection = new ConnessioneDB().connect();
    
    public void caricaFacoltà(){
        
        String selectFacoltà = "select * from facoltà";
        
        try{
                PreparedStatement ps1 = connection.prepareStatement(selectFacoltà);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nome = rs.getString("nome");
                    String ramo = rs.getString("ramo");
                    Facoltà facoltà = new Facoltà(nome, ramo);
                    Applicazione.facoltàAttuali.add(facoltà);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void caricaCorsi(){

        String selectCorsi = "select * from corsi where facoltà=?";
        
        try{
                PreparedStatement ps1 = connection.prepareStatement(selectCorsi);
                ps1.setString(1, Applicazione.facoltàCorrente);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeCorso = rs.getString("nome");
                    int annoCorso = rs.getInt("anno");
                    Corso corso = new Corso(nomeCorso, annoCorso);
                    Applicazione.corsiAttuali.add(corso);
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public void caricaLibri(){

        String selectLibri = "select * from libri where facoltà=? and corso=?";
        
        try{
                PreparedStatement ps1 = connection.prepareStatement(selectLibri);
                ps1.setString(1, Applicazione.facoltàCorrente);
                ps1.setString(2, Applicazione.corsoCorrente);

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                String nomeLibro = rs.getString("titolo");
                String descrizioneLibro = rs.getString("descrizione");
                String idLibro = rs.getString("id");
                String emailLibro = rs.getString("studente");
                String telefonoLibro = rs.getString("telefono");
                int prezzoLibro = rs.getInt("prezzo");
                
                Libro libro = new Libro(nomeLibro, descrizioneLibro, idLibro, emailLibro, telefonoLibro, prezzoLibro);
                Applicazione.libriAttuali.add(libro);
                
                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    
}
