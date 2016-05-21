/*
* Acoltatore posto sulle label della ListaLibriPanel che serve ad andare
* alla pagina con le info relative al libro premuto
*/
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Libri.Vista.LibroPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;

/**
 *
 * @author Te4o
 */
public class GoToLibro implements MouseListener{
    
    private String corso;
    private String facoltà;
    private int id;
    private String nomeLibro;
    
    public GoToLibro(String corso, String facoltà, int id) {
        this.corso = corso;
        this.facoltà = facoltà;
        this.id = id;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        try {
            Applicazione.back.add("libro");
            
            JLabel label = (JLabel)e.getComponent();
            nomeLibro = label.getText();
            
            Applicazione.libroAttuale.setTitolo(nomeLibro);
            
            InfoQuery.caricaInfoLibro(corso, facoltà, id);
            
            Applicazione.facoltàAttuale.setNome(facoltà);
            Applicazione.corsoAttuale.setNome(corso);
            
            LibroPanel libro = new LibroPanel();
            Grafica.container.add(libro, "libro");
            Grafica.card.show(Grafica.container, "libro");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento deli dati del libro");
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
