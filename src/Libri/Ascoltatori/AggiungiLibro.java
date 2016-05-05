/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

import Database.Query.InsertQuery;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.AggiungiLibroPanel;
import Libri.Vista.ListaLibriPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiLibro implements ActionListener{

    private JTextArea titolo;
    private JTextArea descrizione;
    private JSpinner prezzo;
    private JCheckBox telefono;
    private String tel;

    public AggiungiLibro(JTextArea titolo, JTextArea descrizione, JSpinner prezzo, JCheckBox telefono) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.telefono = telefono;
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(telefono.isSelected()){
            tel = Applicazione.guest.getTelefono();
        }else{
            tel ="Numero non disponibile!";
        }
        
        InsertQuery.inserisciLibro(titolo.getText(), descrizione.getText(), (Integer)prezzo.getValue(),tel);
        
        JOptionPane.showMessageDialog(null, "Libro aggiunto correttamente.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);

        Applicazione.svuotaLibri();
        
        ListeQuery.caricaLibri();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaLibriPanel libri = new ListaLibriPanel();
        Grafica.container.add(libri, "libri");
        Grafica.card.show(Grafica.container, "libri");
        
        AggiungiLibroPanel.clearForm();
    }
}
