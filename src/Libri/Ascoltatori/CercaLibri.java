/*
 * Ascoltatore dedicato alla ricerca di un determinato libro
 * La ricerca viene effettuata in base al testo scritto in un apposita'casella
 * Se la ricerca va a buon fine, il pannello della lista dei libri viene riaggiornato 
 * con solo i libri contenenti le parole chiavi della ricerca
 */
package Libri.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Libri.Vista.ListaLibriPanel;
import Utils.Azioni.Cerca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class CercaLibri implements ActionListener, KeyListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextField searchField;
    
    private ListaLibriPanel libriCercati;
    
    public CercaLibri(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
        
        if(!searchField.getText().equals("")){
            
            Cerca.Libri(searchField);
            
            applicazione.back.remove(applicazione.back.size()-1);
            applicazione.back.add("libri cercati");
            
            libriCercati = new ListaLibriPanel();
            
            Grafica.container.add(libriCercati,"libri cercati");
            Grafica.card.show(Grafica.container, "libri cercati");
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
