/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Ascoltatori;

import Application.Controller.Applicazione;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Te4o
 */
public class ModificaNumero implements ActionListener{
    
    private int nClick;
    private JTextField phone;
    private JButton cambiaNumero;

    public ModificaNumero(int nClick, JTextField phone, JButton cambiaNumero) {
        this.nClick = nClick;
        this.phone = phone;
        this.cambiaNumero = cambiaNumero;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        nClick += 1;
        phone.setEditable(true);
        cambiaNumero.setText("Conferma");

        if ( nClick == 2){
            phone.setEditable(false);
            cambiaNumero.setText("Modifica");
            try {
                InsertQuery.updateTelefono(phone.getText());

                Applicazione.guest.setTelefono(phone.getText());
                JOptionPane.showMessageDialog(null, "Numero di telefono correttamente modificato", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                nClick = 0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante la modifica del numero di telefono", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
