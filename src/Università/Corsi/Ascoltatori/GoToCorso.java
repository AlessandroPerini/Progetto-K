/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class GoToCorso implements MouseListener{
    
    private String facoltà;
    private String text;
    
    public GoToCorso(String facoltà) {
        this.facoltà = facoltà;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            
            if(e.getComponent() instanceof JLabel) {
                JLabel label = (JLabel)e.getComponent();
                text = label.getText();
            }
            
            if(e.getComponent() instanceof JButton) {
                JButton button = (JButton)e.getComponent();
                text = button.getText();
            }
            
            Applicazione.corsoAttuale.setNome(text);
            
            InfoQuery.caricaInfoCorso(facoltà);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            
            Applicazione.back.add("corso");
            
            CorsoPanel corso = new CorsoPanel();
            Grafica.container.add(corso, "corso");
            Grafica.card.show(Grafica.container, "corso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
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
