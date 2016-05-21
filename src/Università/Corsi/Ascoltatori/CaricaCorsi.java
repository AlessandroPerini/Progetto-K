/*
* Ascoltatore che selezionata la facoltà in ListaFacoltàPanel va alla ListaCorsiPanel relativa
*/
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import Università.Corsi.Vista.ListaCorsiPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class CaricaCorsi implements MouseListener{
    
    //dichiarazione variabili
    private String nomeFacoltà;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        Applicazione.back.add("corsi");

        JLabel label = (JLabel)e.getComponent();
        nomeFacoltà = label.getText();

        Applicazione.facoltàAttuale.setNome(nomeFacoltà);
        try {
            InfoQuery.caricaInfoFacoltà();
            ListeQuery.caricaCorsi();
            
            ListaCorsiPanel corsi = new ListaCorsiPanel();
            Grafica.container.add(corsi, "corsi");
            Grafica.card.show(Grafica.container, "corsi");
            
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
        e.getComponent().setForeground(null);
    }
    
}
