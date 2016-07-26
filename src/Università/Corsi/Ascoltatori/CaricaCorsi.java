
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
* Ascoltatore che selezionata la facoltà in ListaFacoltàPanel va alla ListaCorsiPanel relativa.
*/
public class CaricaCorsi implements MouseListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione variabili
    private String nomeFacoltà;
    private ListaCorsiPanel corsi;
    private JLabel label;

    public CaricaCorsi(JLabel label) {
        this.label = label;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        applicazione.back.add("corsi");

        JLabel label = (JLabel)e.getComponent();
        nomeFacoltà = label.getText();

        applicazione.facoltàAttuale.setNome(nomeFacoltà);
        try {
            InfoQuery.caricaInfoFacoltà();
            ListeQuery.caricaCorsi();
            
            corsi = new ListaCorsiPanel();
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
        label.setForeground(new Color(3,201,169));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        label.setForeground(null);
    }
    
}
