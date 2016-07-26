
package Studenti.Ascoltatori;

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
* Ascoltatore dedicato alla modifica del proprio nickname.
*
*/
public class ModificaNickname implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextField nick;
    private JButton cambiaNickname;
    
    //dichirazione variabili
    private int nClick;
    
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
                    if(!nick.getText().equals(applicazione.guest.getNickname())){
                        if(ControlloQuery.controlloNickname(nick.getText())){
                            InsertQuery.updateNickname(nick.getText());
                            applicazione.guest.setNickname(nick.getText());
                            nick.setText(applicazione.guest.getNickname());
                            ok = true;
                        }
                        else{
                            nick.setText(applicazione.guest.getNickname());
                            JOptionPane.showMessageDialog(null, "Nickname già presente", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        }
                    }    
                }
                nick.setText(applicazione.guest.getNickname());
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
