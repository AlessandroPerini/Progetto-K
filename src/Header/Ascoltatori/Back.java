/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Header.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Preferiti.Facoltà.Vista.PreferitiPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class Back implements ActionListener{
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        switch(Applicazione.back.get(Applicazione.back.size()-1)){
            case "corsi": Applicazione.svuotaCorsi();
            break;
            case "libri": Applicazione.svuotaLibri();
            break;
            case "domande": Applicazione.svuotaDomande();
            break;
            case "appunti": Applicazione.svuotaAppunti();
            break;
            case "domanda": Applicazione.svuotaRisposte();
            break;
            case "i miei dati": Applicazione.svuotaMieiDati();
            break;
            case "recensioni": Applicazione.svuotaRecensioni();
            break;
            case "facoltà cercate": Applicazione.svuotaFacoltà();
            ListeQuery lQuery1 = new ListeQuery();
            {
                try {
                    lQuery1.caricaFacoltà();
                } catch (SQLException ex) {
                    System.out.println("Errore durante il caricamento delle facoltà");
                }
            }
            break;
            case "corsi cercati": Applicazione.svuotaCorsi();
            ListeQuery lQuery2 = new ListeQuery();
            {
                try {
                    lQuery2.caricaCorsi();
                } catch (SQLException ex) {
                    System.out.println("Errore durante il caricamento dei corsi");
                }
            }
            break;
            case "preferiti": Applicazione.svuotaPreferiti();
            break;
        }
        if(Applicazione.back.get(Applicazione.back.size()-2).equals("preferiti")){
            Applicazione.svuotaPreferiti();

            try {
                ListeQuery.caricaFacoltàPreferite();

                ListeQuery.caricaCorsiPreferiti();
                ListeQuery.caricaAppuntiPreferiti();
                ListeQuery.caricaLibriPreferiti();
                ListeQuery.caricaDomandePreferite();

                PreferitiPanel preferitiPanel = new PreferitiPanel();
                Grafica.container.add(preferitiPanel, "preferiti");
                Grafica.card.show(Grafica.container, "preferiti");

            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei preferiti");
            }

        }

        Applicazione.back.remove(Applicazione.back.size()-1);
        Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
    }
}
    

