/*
* Ascoltatore che selezionato un corso da ListaCorsiPanel va al CorsoPanel relativo
*/
package Università.Corsi.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Università.Corsi.Vista.CorsoPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class GoToCorso implements MouseListener{
    
    //dichiarazione variabili
    private String facoltà;
    private String nomeCorso;
    
    private CorsoPanel corso;
    
    public GoToCorso(String facoltà) {
        this.facoltà = facoltà;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            
            JLabel label = (JLabel)e.getComponent();
            nomeCorso = label.getText();

            Applicazione.corsoAttuale.setNome(nomeCorso);
            
            InfoQuery.caricaInfoCorso(facoltà);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            
            Applicazione.back.add("corso");
            
            corso = new CorsoPanel();
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
        e.getComponent().setForeground(null);
    }
    
}
