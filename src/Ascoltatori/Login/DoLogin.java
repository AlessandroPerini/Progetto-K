/*
* Ascoltatore che effetua il login alla pressione del bottone "login", effettuando
* la query di login che salva anche i dati dell'utente loggato
* (Controllo che i campi non siano vuoti e successivamente che le credenziali inserite siano corrette)
*/
package Ascoltatori.Login;

import Application.Applicazione;
import Database.LoginQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Te4o
 */
public class DoLogin implements ActionListener, KeyListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private static JTextField email;
    private static JPasswordField password;
    
    public DoLogin(JTextField email, JPasswordField password) {
        this.email = email;
        this.password = password;
    }
    
    public void doIt() throws Exception{
        
        if ((!email.getText().equals(""))&&(password.getPassword().length != 0)) {
            try {
                LoginQuery.login(email.getText()+"@universitadipavia.it", password.getPassword());
                if(applicazione.utenteLoggato){
                    String nomeCompleto = applicazione.guest.getNome()+" "+applicazione.guest.getCognome();
                    JOptionPane.showMessageDialog(null, "Benvenuto "+nomeCompleto+"!","Login avvenuto con successo" , JOptionPane.INFORMATION_MESSAGE);
                }
                else{JOptionPane.showMessageDialog(null, "Hai inserito email o password errata.", "Email o password errata.", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore connessione col database", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Inserisci prima email e password.","Parametro/i mancante/i" , JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            doIt();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Verificare la propria connessione internet", "Errore di rete", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                doIt();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Verificare la propria connessione internet", "Errore di rete", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
