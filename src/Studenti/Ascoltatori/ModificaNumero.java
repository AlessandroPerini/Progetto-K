/*
* Ascoltatore dedicato alla modifica del proprio numero di telefono
*
* 
*/
package Studenti.Ascoltatori;

import Application.Controller.Applicazione;
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
public class ModificaNumero implements ActionListener{
    
    //dichiarazione oggetti
    private JTextField phone;
    private JButton cambiaNumero;
    
    //dichiarazione variabili
    private boolean numeroOK = false;
    private int nClick;
    
    public ModificaNumero(int nClick, JTextField phone, JButton cambiaNumero) {
        this.nClick = nClick;
        this.phone = phone;
        this.cambiaNumero = cambiaNumero;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nClick += 1;
        phone.setEditable(true);
        cambiaNumero.setIcon(new ImageIcon(this.getClass().getResource("/immagini/conferma.png")));

       
        
        if ( nClick == 2){
            if (phone.getText().matches("[0-9]+")) {
            numeroOK = true;
         }
            if(numeroOK){
               
                phone.setEditable(false);
                cambiaNumero.setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
                try {
                    if(!phone.getText().equals("")){
                        InsertQuery.updateTelefono(phone.getText());
                        Applicazione.guest.setTelefono(phone.getText());
                        phone.setText(Applicazione.guest.getTelefono());
                    }
                    else{
                        InsertQuery.updateTelefono("Numero non disponibile");
                        Applicazione.guest.setTelefono("Numero non disponibile");
                        phone.setText(Applicazione.guest.getTelefono());
                    }
                    JOptionPane.showMessageDialog(null, "Numero di telefono correttamente modificato", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                    nClick = 0;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Errore durante la modifica del numero di telefono", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                }
                 numeroOK = false;
            }else{
                    numeroOK = false;
                    nClick = 1;
                    JOptionPane.showMessageDialog(null, "Il numero non deve contenere lettere", "Impossibile completare l'operazione", JOptionPane.INFORMATION_MESSAGE);
               
            }
        }
    }
}
