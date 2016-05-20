/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    @Override
    public void actionPerformed(ActionEvent e) {

        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);

        if(showConfirmDialog == 0 ){

            Grafica.card.show(Grafica.container, "login");
            LoginPanel.clearForm();
            Applicazione.logout();
        }
    }
}
