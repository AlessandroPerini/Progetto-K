/*
* Ascoltatore che effettua l'azione quando viene premuto il pulsante "conferma"
* all'interno del frame ValutaAppuntoFrame
* (Controlla che il commento sia non vuoto e valida e inserisce la valutazione)
*/
package Valutazioni.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Database.Query.InfoQuery;
import Database.Query.InsertQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class VotaAppunto implements ActionListener{
    
    //dichiarazione oggetti
    private JTextArea commento;
    private JSlider punteggio;
    private JFrame valutaFrame;
    
    private AppuntoPanel appunto; 
    
    public VotaAppunto(JTextArea commento, JSlider punteggio, JFrame valutaFrame) {
        this.commento = commento;
        this.punteggio = punteggio;
        this.valutaFrame = valutaFrame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (!commento.getText().equals("")) {
            if(((commento.getText().length())<500)){
                try {
                    InsertQuery.inserisciValutazione(commento, punteggio);
                    
                    float newMedia = InfoQuery.mediaAppunto();
                    
                    Applicazione.appuntoAttuale.setMedia(newMedia);
                    
                    InsertQuery.updateMedia(newMedia);
                    
                    JOptionPane.showMessageDialog(null, "Valutazione aggiunta correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    
                    valutaFrame.dispose();
                    valutaFrame.setVisible(false);
                    
                    appunto = new AppuntoPanel();
                    
                    Grafica.container.add(appunto, "appunto");
                    Grafica.card.show(Grafica.container, "appunto");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante la votazione", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Commento(max 500 caratteri) troppo lungo", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Commento non valido", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
