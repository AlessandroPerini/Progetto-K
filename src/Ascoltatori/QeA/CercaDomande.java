/*
 * Ascoltatore dedicato alla ricerca di un determinato appunto
 * La ricerca viene effettuata in base al testo scritto in un'apposita casella
 * Se la ricerca va a buon fine, il pannello della lista degli appunti viene riaggiornato 
 * con solo gli appunti contenenti le parole chiavi della ricerca
 */
package Ascoltatori.QeA;

import Application.Applicazione;
import Grafica.Grafica;
import Grafica.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *
 * @author te4o
 */
public class CercaDomande implements ActionListener, KeyListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextField searchField;
    
    private ListaDomandePanel domandeCercate;
    
    public CercaDomande(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
    
        if(!searchField.getText().equals("")){
            Utility.Cerca.Domande(searchField);
            
            applicazione.back.remove(applicazione.back.size()-1);

            applicazione.back.add("domande cercate");

            domandeCercate = new ListaDomandePanel();

            Grafica.container.add(domandeCercate,"domande cercate");
            Grafica.card.show(Grafica.container, "domande cercate");
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
