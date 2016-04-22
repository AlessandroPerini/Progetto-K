/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Database.MySql.InsertQuery;
import Database.MySql.ListeQuery;
import Libri.AggiungiLibroPanel;
import Libri.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiAppunto implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    private JTextArea nome;
    private JTextArea descrizione;

    public AggiungiAppunto(CardLayout card, JPanel container, JTextArea nome, JTextArea descrizione) {
        this.card = card;
        this.container = container;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InsertQuery insertQuery = new InsertQuery();
        insertQuery.inserisciAppunto(nome.getText(), descrizione.getText());
        
        Applicazione.svuotaAppunti();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaAppunti();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaAppuntiPanel appunti = new ListaAppuntiPanel(card, container);
        container.add(appunti, "appunti");
        card.show(container, "appunti");
        
        AggiungiAppuntoPanel.clearForm();
    }
}
