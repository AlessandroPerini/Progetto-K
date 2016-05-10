/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Libri.Vista.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Te4o
 */
public class GoToLibro implements ActionListener{
    
    private String corso;
    private String facoltà;
    private int id;
    
    public GoToLibro(String corso, String facoltà, int id) {
        this.corso = corso;
        this.facoltà = facoltà;
        this.id = id;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        Applicazione.back.add("libro");
        Applicazione.libroAttuale.setTitolo(e.getActionCommand());
        
        try {
            InfoQuery.caricaInfoLibro(corso, facoltà, id);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            Applicazione.corsoAttuale.setNome(corso);
            
            LibroPanel libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento deli dati del libro");
        }
    }
    
}
