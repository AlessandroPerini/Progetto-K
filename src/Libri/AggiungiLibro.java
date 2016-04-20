/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri;

import Controller.Applicazione;
import Database.Query.*;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiLibro implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    private JTextArea titolo;
    private JTextArea descrizione;
    private JTextArea prezzo;

    public AggiungiLibro(CardLayout card, JPanel container, JTextArea titolo, JTextArea descrizione, JTextArea prezzo) {
        this.card = card;
        this.container = container;
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  
        Applicazione.back.add("libri");
        
        InsertQuery insertQuery = new InsertQuery();
        insertQuery.inserisciLibro(titolo.getText(), descrizione.getText(), Integer.parseInt(prezzo.getText()));
        
        Applicazione.svuotaLibri();
        
        ListeQuery listeQuery = new ListeQuery();
        listeQuery.caricaLibri();

        card.show(container, "libri");
 
    }
}
