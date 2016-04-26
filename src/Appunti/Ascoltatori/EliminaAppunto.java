/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.DeleteQuery;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class EliminaAppunto implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.eliminaAppunto();
        
        JOptionPane.showMessageDialog(null, "Appunto eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaAppunti();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaAppunti();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaAppuntiPanel appunti = new ListaAppuntiPanel();
        Grafica.container.add(appunti, "appunti");
        Grafica.card.show(Grafica.container, "appunti");
        
    }
    
}
