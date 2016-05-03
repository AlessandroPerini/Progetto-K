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
import Database.Query.ControlloQuery;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        
        if(ControlloQuery.controlloNomeAppunto(nome.getText())){
            InsertQuery.inserisciAppunto(nome.getText(), descrizione.getText());
            
            Applicazione.svuotaAppunti();
        
            ListeQuery.caricaAppunti();

            Applicazione.back.remove(Applicazione.back.size()-1);

            ListaAppuntiPanel appunti = new ListaAppuntiPanel();
            Grafica.container.add(appunti, "appunti");
            Grafica.card.show(Grafica.container, "appunti");

            AggiungiAppuntoPanel.clearForm();
        }
        else{
            JOptionPane.showMessageDialog(null, "Un appunto con lo stesso nome è già presente all'interno di '"+Applicazione.facoltàPremuta+">"+Applicazione.corsoPremuto+"', verifica "
                    + "che non sia lo stesso e riprova cambiando nome.","Impossibile caricare appunto" , JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }
}
