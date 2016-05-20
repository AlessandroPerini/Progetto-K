/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import QeA.Vista.DomandaPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class GoToDomanda implements MouseListener{
    
    private static DomandaPanel domanda;
    private String nomeDomanda;
    
    private String corso;
    private String facoltà;
    
    public GoToDomanda(String corso, String facoltà) {
        this.corso = corso;
        this.facoltà = facoltà;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        Applicazione.back.add("domanda");
        
        JLabel label = (JLabel)e.getComponent();
        nomeDomanda = label.getText();
        
        String parts[] = nomeDomanda.split("          ");
        nomeDomanda = parts[0];
        
        Applicazione.domandaAttuale.setTitolo(nomeDomanda);
        
        try {
            InfoQuery.caricaInfoDomanda(corso, facoltà);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            Applicazione.corsoAttuale.setNome(corso);
            
            ListeQuery.caricaRisposteDomanda();
            
            domanda = new DomandaPanel();
            
            Grafica.container.add(domanda, "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
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
    
    public static DomandaPanel getDomanda() {
        return domanda;
    }
    
    
}
