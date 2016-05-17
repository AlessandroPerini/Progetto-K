/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Appunti.Vista.AppuntoPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Te4o
 */
public class GoToAppunto implements MouseListener{
    
    private String corso;
    private String facoltà;
    private String text;
    
    public GoToAppunto(String corso, String facoltà) {
        this.corso = corso;
        this.facoltà = facoltà;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            
            Applicazione.back.add("appunto");
            
            if(e.getComponent() instanceof JLabel) {
                JLabel label = (JLabel)e.getComponent();
                text = label.getText();
            }
            if(e.getComponent() instanceof JButton) {
                JButton button = (JButton)e.getComponent();
                text = button.getText();
                
            }
            
            String parts[] = text.split("          ");
            text = parts[0];
            
            Applicazione.appuntoAttuale.setNome(text);
            
            InfoQuery.caricaInfoAppunto(corso, facoltà);
            
            Applicazione.corsoAttuale.setNome(corso);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            
            AppuntoPanel appunto = new AppuntoPanel();
            Grafica.container.add(appunto, "appunto");
            Grafica.card.show(Grafica.container, "appunto");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei dati dell'appunto");
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().setForeground(new Color(3,201,169));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        e.getComponent().setForeground(Color.black);
    }
    
}
