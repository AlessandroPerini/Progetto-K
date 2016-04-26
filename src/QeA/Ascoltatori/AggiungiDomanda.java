/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA.Ascoltatori;

import Database.Query.InsertQuery;
import Application.Controller.Applicazione;
import Database.Query.ListeQuery;
import QeA.Vista.AggiungiDomandaPanel;
import QeA.Vista.ListaDomandePanel;
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
public class AggiungiDomanda implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    private JTextArea titolo;
    private JTextArea descrizione;

    public AggiungiDomanda(CardLayout card, JPanel container, JTextArea titolo, JTextArea descrizione) {
        this.card = card;
        this.container = container;
        this.titolo = titolo;
        this.descrizione = descrizione;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InsertQuery insertQuery = new InsertQuery();
        insertQuery.inserisciDomanda(titolo.getText(), descrizione.getText());
        
        Applicazione.svuotaDomande();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaDomande();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaDomandePanel domande = new ListaDomandePanel(card, container);
        container.add(domande, "domande");
        card.show(container, "domande");
        
        AggiungiDomandaPanel.clearForm();
    }
}
