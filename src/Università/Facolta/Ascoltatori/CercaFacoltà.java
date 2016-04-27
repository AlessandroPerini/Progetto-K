/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Università.Facolta.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Università.Facolta.Vista.ListaFacoltàPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class CercaFacoltà implements ActionListener, KeyListener{

    private JTextField searchField;
    
    public CercaFacoltà(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
    
        if(!searchField.getText().equals("")){
            Utils.Cerca.Facoltà(searchField);

            Applicazione.back.add("facoltà cercate");

            ListaFacoltàPanel facoltàCercate = new ListaFacoltàPanel();

            Grafica.container.add(facoltàCercate,"facoltà cercate");
            Grafica.card.show(Grafica.container, "facoltà cercate");
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
