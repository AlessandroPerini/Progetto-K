/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Login;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import static Application.Vista.Grafica.card;
import static Application.Vista.Grafica.container;
import Database.Query.LoginQuery;
import Studente.Vista.AccountPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Te4o
 */
public class DoLogin implements ActionListener, KeyListener{
    
    private static JTextField email;
    private static JPasswordField password;
    
    public DoLogin(JTextField email, JPasswordField password) {
        this.email = email;
        this.password = password;
    }
    
    public static void doIt(){
        
        if ((!email.getText().equals(""))&&(!password.getText().equals(""))) {
            try {
                LoginQuery.login(email.getText()+"@universitadipavia.it", password.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore connessione col database", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            
            if(Applicazione.utenteLoggato){
                String nomeCompleto = Applicazione.guest.getNome()+" "+Applicazione.guest.getCognome();
                JOptionPane.showMessageDialog(null, "Benvenuto "+nomeCompleto+"!","Login avvenuto con succensso" , JOptionPane.INFORMATION_MESSAGE);
                AccountPanel account = new AccountPanel();
                Grafica.container.add(account,"account");
            }
            else{JOptionPane.showMessageDialog(null, "Hai inserito email o password errata.", "Email o password errata.", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Inserisci prima email e password.","Parametro/i mancante/i" , JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        doIt();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            doIt();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
