/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

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
public class EliminaLibro implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaLibro();
        
        JOptionPane.showMessageDialog(null, "Libro eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaLibri();
        
        ListeQuery.caricaLibri();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaLibriPanel libri = new ListaLibriPanel();
        Grafica.container.add(libri, "libri");
        Grafica.card.show(Grafica.container, "libri");
        
    }
    
}
