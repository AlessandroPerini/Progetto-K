/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Studente.Ascoltatori;

import Application.Controller.Applicazione;
import Database.Query.ControlloQuery;
import Database.Query.InsertQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Te4o
 */
public class ModificaNickname implements ActionListener{
    
    private int nClick;
    private JTextField nick;
    private JButton cambiaNickname;
    
    public ModificaNickname(int nClick, JTextField nick, JButton cambiaNumero) {
        this.nClick = nClick;
        this.nick = nick;
        this.cambiaNickname = cambiaNumero;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nClick += 1;
        nick.setEditable(true);
        cambiaNickname.setIcon(new ImageIcon(this.getClass().getResource("/immagini/conferma.png")));
        boolean ok = false;
        
        if ( nClick == 2){
            nick.setEditable(false);
            cambiaNickname.setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
            try {
                if(nick.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Nickname non valido", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if(!nick.getText().equals(Applicazione.guest.getNickname())){
                        if(ControlloQuery.controlloNickname(nick.getText())){
                            InsertQuery.updateNickname(nick.getText());
                            Applicazione.guest.setNickname(nick.getText());
                            nick.setText(Applicazione.guest.getNickname());
                            ok = true;
                        }
                        else{
                            nick.setText(Applicazione.guest.getNickname());
                            JOptionPane.showMessageDialog(null, "Nickname già presente", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                nClick = 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante la modifica del nickname", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            if (ok) {
                JOptionPane.showMessageDialog(null, "Nickname correttamente modificato", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                
            }
        }
    }
}
