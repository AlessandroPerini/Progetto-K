/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Studente.Ascoltatori;

import Studente.Vista.iMieiDatiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.GuestQuery;
import Utils.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author te4o
 */
public class CaricaIMieiDati implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            
            GuestQuery.caricaMieiAppunti();
            GuestQuery.caricaMieiLibri();
            GuestQuery.caricaMieDomande();
            
            Applicazione.back.add("i miei dati");
            
            Ordina.ListeMieiDati();
            
            iMieiDatiPanel mieiDatiPanel = new iMieiDatiPanel();
            Grafica.container.add(mieiDatiPanel, "i miei dati");
            Grafica.card.show(Grafica.container, "i miei dati");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
