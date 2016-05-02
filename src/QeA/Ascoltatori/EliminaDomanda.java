/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Database.Query.ListeQuery;
import QeA.Vista.ListaDomandePanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class EliminaDomanda implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaDomanda();
        
        JOptionPane.showMessageDialog(null, "Domanda eliminata correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaDomande();
        
        ListeQuery.caricaDomande();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaDomandePanel domande = new ListaDomandePanel();
        Grafica.container.add(domande, "domande");
        Grafica.card.show(Grafica.container, "domande");
        
    }
    
}

