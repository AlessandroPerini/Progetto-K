/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Header.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.ListaAppuntiPanel;
import Database.Query.ListeQuery;
import Libri.Vista.ListaLibriPanel;
import Preferiti.Vista.PreferitiPanel;
import QeA.Vista.ListaDomandePanel;
import Utils.Azioni.Ordina;
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

        String paginaCorrente = Applicazione.back.get(Applicazione.back.size()-1);
        
        if((!paginaCorrente.equals("appunti cercati"))&&(!paginaCorrente.equals("libri cercati"))&&(!paginaCorrente.equals("domande cercate"))){

            switch(paginaCorrente){
                case "corsi": Applicazione.svuotaCorsi();
                    break;
                case "libri": Applicazione.svuotaLibri();
                    break;
                case "domande": Applicazione.svuotaDomande();
                    break;
                case "appunti": Applicazione.svuotaAppunti();
                    break;
                case "i miei dati": Applicazione.svuotaMieiDati();
                    break;
                case "recensioni": Applicazione.svuotaRecensioni();
                    break;
                case "facoltà cercate": Applicazione.svuotaFacoltà();
                                        try {
                                            ListeQuery.caricaFacoltà();
                                        } catch (SQLException ex) {
                                            System.out.println("Errore durante il caricamento delle facoltà");
                                        }
                    break;
                case "corsi cercati":   Applicazione.svuotaCorsi();
                                        try {
                                            ListeQuery.caricaCorsi();
                                        } catch (SQLException ex) {
                                            System.out.println("Errore durante il caricamento dei corsi");
                                        }

                    break;
                case "preferiti": Applicazione.svuotaPreferiti();
                    break;
                case "appunto": Applicazione.svuotaAppunti();
                                try{
                                    ListeQuery.caricaAppunti();
                                } catch (SQLException ex) {
                                        System.out.println("Errore durante il caricamento degli appunti");
                                    }
                                Ordina.Appunti();
                                ListaAppuntiPanel appunti = new ListaAppuntiPanel();
                                Grafica.container.add(appunti, "appunti");
                    break;
                case "domanda": Applicazione.svuotaRisposte();
                                Applicazione.svuotaDomande();
                                try{
                                    ListeQuery.caricaDomande();
                                } catch (SQLException ex) {
                                        System.out.println("Errore durante il caricamento delle domande");
                                    }
                                Ordina.Domande();
                                ListaDomandePanel domande = new ListaDomandePanel();
                                Grafica.container.add(domande, "domande");
                    break;
                case "libro": Ordina.Domande();            
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
        
        else if(paginaCorrente.equals("appunti cercati")){
            Applicazione.svuotaAppunti();
            try {
                ListeQuery.caricaAppunti();
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento degli appunti");
            }
            Applicazione.back.remove(Applicazione.back.size()-1);
            Applicazione.back.add("appunti");
            Ordina.Appunti();
            ListaAppuntiPanel appunti2 = new ListaAppuntiPanel();
            Grafica.container.add(appunti2, "appunti");
            Grafica.card.show(Grafica.container, "appunti");        

        }
        else if(paginaCorrente.equals("libri cercati")){
            Applicazione.svuotaLibri();
            try {
                ListeQuery.caricaLibri();
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei libri");
            }
            Applicazione.back.remove(Applicazione.back.size()-1);
            Applicazione.back.add("libri");
            Ordina.Appunti();
            ListaLibriPanel libri2 = new ListaLibriPanel();
            Grafica.container.add(libri2, "libri");
            Grafica.card.show(Grafica.container, "libri");        

        }
        else if(paginaCorrente.equals("domande cercate")){
            Applicazione.svuotaAppunti();
            try {
                ListeQuery.caricaDomande();
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento delle domande");
            }
            Applicazione.back.remove(Applicazione.back.size()-1);
            Applicazione.back.add("domande");
            Ordina.Appunti();
            ListaDomandePanel domande2 = new ListaDomandePanel();
            Grafica.container.add(domande2, "domande");
            Grafica.card.show(Grafica.container, "domande");        

        }
    
    }
}
    

