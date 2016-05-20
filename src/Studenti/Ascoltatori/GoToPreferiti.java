/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studenti.Ascoltatori;

import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Preferiti.Vista.PreferitiPanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class GoToPreferiti implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            ListeQuery.caricaFacoltàPreferite();
            ListeQuery.caricaCorsiPreferiti();
            ListeQuery.caricaAppuntiPreferiti();
            ListeQuery.caricaLibriPreferiti();
            ListeQuery.caricaDomandePreferite();
            
            Ordina.ListePreferiti();

            PreferitiPanel preferitiPanel = new PreferitiPanel();
            Grafica.container.add(preferitiPanel, "preferiti");
            Grafica.card.show(Grafica.container, "preferiti");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }

    }
}
