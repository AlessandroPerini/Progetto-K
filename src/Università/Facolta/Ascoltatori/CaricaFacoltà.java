/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Università.Facolta.Vista.ListaFacoltàPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Te4o
 */
public class CaricaFacoltà implements ActionListener, KeyListener{
    
    public void carica(){
        
        if(Applicazione.utenteLoggato){
            
                ListeQuery dQuery = new ListeQuery();
                dQuery.caricaFacoltà();
                
                Applicazione.back.add("facoltà");
                
                ListaFacoltàPanel facoltà = new ListaFacoltàPanel(Applicazione.listaFacoltàAttuali);
                
                Grafica.container.add(facoltà,"facoltà");
                Grafica.card.show(Grafica.container, "facoltà");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        carica();    
    }

    @Override
    public void keyTyped(KeyEvent e) {  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            carica();
        }   
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
 
}
