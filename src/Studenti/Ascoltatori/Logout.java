/*
* Ascoltatore dedicato al logout dell'utente dall'applicazione
*
 */
package Studenti.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Login.Vista.LoginPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class Logout implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    @Override
    public void actionPerformed(ActionEvent e) {

        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);

        if(showConfirmDialog == 0 ){

            Grafica.card.show(Grafica.container, "login");
            LoginPanel.clearForm();
            applicazione.logout();
        }
    }
}
