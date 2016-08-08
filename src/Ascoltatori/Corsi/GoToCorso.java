/*
* Ascoltatore che selezionato un corso da ListaCorsiPanel va al CorsoPanel relativo
*/
package Ascoltatori.Corsi;

import Application.Applicazione;
import Grafica.Grafica;
import Database.InfoQuery;
import Grafica.CorsoPanel;
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
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione variabili
    private String facoltà;
    private String nomeCorso;
    private JLabel label;
    private CorsoPanel corso;
    
    public GoToCorso(String facoltà,JLabel label) {
        this.facoltà = facoltà;
        this.label=label;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            
            JLabel label = (JLabel)e.getComponent();
            nomeCorso = label.getText();

            applicazione.corsoAttuale.setNome(nomeCorso);
            
            InfoQuery.caricaInfoCorso(facoltà);
            
            applicazione.facoltàAttuale.setNome(facoltà);
            
            applicazione.back.add("corso");
            
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
       label.setForeground(new Color(3,201,169));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        label.setForeground(null);
    }
    
}
