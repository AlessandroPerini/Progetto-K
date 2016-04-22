/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

import Controller.Applicazione;
import Database.MySql.DeleteQuery;
import Database.MySql.ListeQuery;
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

    private CardLayout card;
    private JPanel container;

    public EliminaLibro(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.eliminaLibro();
        
        JOptionPane.showMessageDialog(null, "Libro eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaLibri();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaLibri();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaLibriPanel libri = new ListaLibriPanel(card, container);
        container.add(libri, "libri");
        card.show(container, "libri");
        
    }
    
}
