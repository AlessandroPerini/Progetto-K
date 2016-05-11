/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Database.Query.InfoQuery;
import Database.Query.InsertQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class Vota implements ActionListener{
    
    private JTextArea commento;
    private JSlider punteggio;
    
    public Vota(JTextArea commento, JSlider punteggio) {
        this.commento = commento;
        this.punteggio = punteggio;
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
                    
                    AppuntoPanel appunto = new AppuntoPanel();
                    
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
