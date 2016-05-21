/*
* Ascoltatore posto sul bottone cerca nella ListaLibriPanel e serve appunto
* per rimodellare la lista dei libri a seconda della ricerca fatta
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
    
    private JTextField searchField;
    
    public CercaLibri(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
        
        if(!searchField.getText().equals("")){
            
            Cerca.Libri(searchField);
            
            Applicazione.back.remove(Applicazione.back.size()-1);
            Applicazione.back.add("libri cercati");
            
            ListaLibriPanel libriCercati = new ListaLibriPanel();
            
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
