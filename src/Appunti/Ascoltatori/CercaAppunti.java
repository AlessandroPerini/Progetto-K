
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.ListaAppuntiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * Ascoltatore dedicato alla ricerca di un determinato appunto
 * La ricerca viene effettuata in base al testo scritto in un apposita'casella
 * Se la ricerca va a buon fine, il pannello della lista degli appunti viene riaggiornato 
 * con solo gli appunti contenenti le parole chiavi della ricerca
 */
public class CercaAppunti implements ActionListener, KeyListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private JTextField searchField;
    
    private ListaAppuntiPanel appuntiCercati;
    
    public CercaAppunti(JTextField searchField){
        this.searchField = searchField;
    }
    
    public void cerca(){
    
        if(!searchField.getText().equals("")){
            
            Utils.Azioni.Cerca.Appunti(searchField);

            applicazione.back.remove(applicazione.back.size()-1);
            
            applicazione.back.add("appunti cercati");

            appuntiCercati = new ListaAppuntiPanel();
            Grafica.container.add(appuntiCercati,"appunti cercati");
            Grafica.card.show(Grafica.container, "appunti cercati");
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
