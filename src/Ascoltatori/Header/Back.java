/*
 * Ascoltatore posto sul bottone back per tornare alla pagina precedente
 */
package Ascoltatori.Header;

import Application.Applicazione;
import Grafica.Grafica;
import Ascoltatori.Appunti.OrdinaListaAppunti;
import Grafica.ListaAppuntiPanel;
import Database.GuestQuery;
import Database.ListeQuery;
import Grafica.ListaLibriPanel;
import Grafica.PreferitiPanel;
import Ascoltatori.QeA.OrdinaListaDomande;
import Grafica.ListaDomandePanel;
import Grafica.AccountPanel;
import Utility.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Te4o
 */
public class Back implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private AccountPanel account; 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String paginaCorrente = applicazione.back.get(applicazione.back.size()-1);
        
        //comportamento specifico per il bottone back durante la ricerca
        if(paginaCorrente.equals("appunti cercati")) backRicercaAppunti();
        else if(paginaCorrente.equals("libri cercati")) backRicercaLibri();
        else if(paginaCorrente.equals("domande cercate")) backRicercaDomande();

        else{

            switch(paginaCorrente){
                case "corsi":applicazione.svuotaCorsi();
                    break;
                case "libri": applicazione.svuotaLibri();
                    break;
                case "domande": applicazione.svuotaDomande();
                    break;
                case "appunti": applicazione.svuotaAppunti();
                    break;
                case "i miei dati": applicazione.svuotaMieiDati();
                    break;
                case "recensioni": applicazione.svuotaRecensioni();
                    break;
                case "preferiti": applicazione.svuotaPreferiti();
                    break;
                case "appunto": backAppunto();
                    break;
                case "domanda": backDomanda();
                    break;
            }

            //comportamento specifico per il bottone back se si viene dalla pagina dei preferiti
            if(applicazione.back.get(applicazione.back.size()-2).equals("preferiti")) backDopoPreferiti();
            
            //comportamento specifico per il bottone back se si viene dalla pagina account
            if(applicazione.back.get(applicazione.back.size()-2).equals("account")) backDopoAccount();

            applicazione.back.remove(applicazione.back.size()-1);
            Grafica.card.show(Grafica.container, applicazione.back.get(applicazione.back.size()-1));
        }
    }
    
    public void backRicercaAppunti(){
    
        applicazione.svuotaAppunti();
        try {
            ListeQuery.caricaAppunti();
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento degli appunti");
        }
        applicazione.back.remove(applicazione.back.size()-1);
        applicazione.back.add("appunti");
        
        if(OrdinaListaAppunti.ordineCorrente.equals("Valutazione")||
                OrdinaListaAppunti.ordineCorrente.equals("")) Ordina.Appunti();
        if(OrdinaListaAppunti.ordineCorrente.equals("Nome")) Ordina.AppuntiAlfabetic();
        
        ListaAppuntiPanel appunti2 = new ListaAppuntiPanel();
        Grafica.container.add(appunti2, "appunti");
        Grafica.card.show(Grafica.container, "appunti");
    }
    
    public void backRicercaLibri(){
    
        applicazione.svuotaLibri();
        try {
            ListeQuery.caricaLibri();
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei libri");
        }
        applicazione.back.remove(applicazione.back.size()-1);
        applicazione.back.add("libri");
        Ordina.Appunti();
        ListaLibriPanel libri2 = new ListaLibriPanel();
        Grafica.container.add(libri2, "libri");
        Grafica.card.show(Grafica.container, "libri"); 
    }
    
    public void backRicercaDomande(){
    
        applicazione.svuotaDomande();
        try {
            ListeQuery.caricaDomande();
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento delle domande");
        }
        applicazione.back.remove(applicazione.back.size()-1);
        applicazione.back.add("domande");
        
        if(OrdinaListaDomande.ordineCorrente.equals("Like")||
                OrdinaListaDomande.ordineCorrente.equals("")) Ordina.Domande();
        if(OrdinaListaDomande.ordineCorrente.equals("Nome")) Ordina.DomandeAlfabetic();
        
        ListaDomandePanel domande2 = new ListaDomandePanel();
        Grafica.container.add(domande2, "domande");
        Grafica.card.show(Grafica.container, "domande");  
    }
    
    public void backAppunto(){
    
        applicazione.svuotaAppunti();
        try{
            ListeQuery.caricaAppunti();
        } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento degli appunti");
            }
        Ordina.Appunti();
        ListaAppuntiPanel appunti = new ListaAppuntiPanel();
        Grafica.container.add(appunti, "appunti");
    }
    
    public void backDomanda(){
    
        applicazione.svuotaRisposte();
        applicazione.svuotaDomande();
        try{
            ListeQuery.caricaDomande();
        } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento delle domande");
            }
        Ordina.Domande();
        ListaDomandePanel domande = new ListaDomandePanel();
        Grafica.container.add(domande, "domande");
    }
    
    public void backDopoPreferiti(){
    
        applicazione.svuotaPreferiti();
                
        try {
            ListeQuery.caricaTuttiPreferiti();

            PreferitiPanel preferitiPanel = new PreferitiPanel();
            Grafica.container.add(preferitiPanel, "preferiti");
            Grafica.card.show(Grafica.container, "preferiti");

        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei preferiti");
        }
    }
    
    public void backDopoAccount(){
    
         try {
            GuestQuery.ricaricaDatiUtente();
            } catch (SQLException ex) {
            System.out.println("Errore durante la sincronizzazione dei dati utente");;
        }

        account = new AccountPanel();
        Grafica.container.add(account,"account");
        Grafica.card.show(Grafica.container, "account");
    }
}
    

