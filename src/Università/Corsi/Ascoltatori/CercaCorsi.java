/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Università.Corsi.Vista.ListaCorsiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class CercaCorsi implements ActionListener, KeyListener{
    
    private JTextField searchField;
    
    public CercaCorsi(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
    
        if(!searchField.getText().equals("")){
            Utils.Cerca.Corsi(searchField);

            Applicazione.back.add("corsi cercati");

            ListaCorsiPanel corsiCercati = new ListaCorsiPanel();

            Grafica.container.add(corsiCercati,"corsi cercati");
            Grafica.card.show(Grafica.container, "corsi cercati");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        cerca();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            cerca();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
