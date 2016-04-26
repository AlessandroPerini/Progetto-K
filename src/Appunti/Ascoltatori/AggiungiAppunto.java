/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Appunti.Vista.AggiungiAppuntoPanel;
import Appunti.Vista.ListaAppuntiPanel;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import Libri.Vista.AggiungiLibroPanel;
import Libri.Vista.ListaLibriPanel;
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
    
    private JTextArea nome;
    private JTextArea descrizione;

    public AggiungiAppunto(JTextArea nome, JTextArea descrizione) {
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

        ListaAppuntiPanel appunti = new ListaAppuntiPanel();
        Grafica.container.add(appunti, "appunti");
        Grafica.card.show(Grafica.container, "appunti");
        
        AggiungiAppuntoPanel.clearForm();
    }
}
