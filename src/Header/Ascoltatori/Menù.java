
package Header.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.GuestQuery;
import Database.Query.ListeQuery;
import Login.Vista.LoginPanel;
import Preferiti.Vista.PreferitiPanel;
import Studenti.Vista.AccountPanel;
import Università.Facolta.Vista.ListaFacoltàPanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
* Ascoltatore per la gestione del menù JComboBox in alto a destra, utile per la navigazione
* all'interno dell'applicazione
*/
public class Menù implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JComboBox menu;
    private String selezione;
    
    private ListaFacoltàPanel facoltà;
    private AccountPanel account; 
    private PreferitiPanel preferiti; 
    
    public Menù(JComboBox menu) {
        this.menu = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //inizializzazione variabili
        selezione = menu.getSelectedItem().toString();
        
        switch(selezione){
            
            case "Home": home();
            break;
            case "Account": account();
            break;
            case "Preferiti": preferiti();
            break;
            case "Logout": logout();
            break;
        }
        
        resetMenu();
    }
    
    /**
     * Azione eseguita alla selezione di "home" nel menù.
     * Serve a tornare alla lista delle facoltà iniziali.
     */
    public void home(){
        
        try {
            applicazione.svuotaTutteLeListe();
            
            ListeQuery.caricaFacoltà();
            ListeQuery.caricaRamiFacoltà();
            
            applicazione.back.add("facoltà");
            
            facoltà = new ListaFacoltàPanel();
            Grafica.card.show(Grafica.container, "facoltà");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento delle facoltà", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Azione eseguita alla selezione di "account" nel menù.
     * Serve ad andare alla pagina di gestione dell'account.
     */
    public void account(){
        
        try {
            GuestQuery.ricaricaDatiUtente();
            } catch (SQLException ex) {
            System.out.println("Errore durante la sincronizzazione dei dati utente");;
        }
            
        applicazione.svuotaMieiDati();

        applicazione.back.add("account");

        account = new AccountPanel();
        Grafica.container.add(account,"account");
        Grafica.card.show(Grafica.container, "account");

    }
    
    /**
     * Azione eseguita alla selezione di "preferiti" nel menù.
     * Serve ad andare alla pagina di gestione dei propri preferiti.
     */
    public void preferiti(){
        
        try {
            ListeQuery.caricaTuttiPreferiti();
            
            Ordina.ListePreferiti();
            
            applicazione.back.add("preferiti");
            
            preferiti = new PreferitiPanel();
            Grafica.container.add(preferiti, "preferiti");
            Grafica.card.show(Grafica.container, "preferiti");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei preferiti");
        }
    }
    
    /**
     * Azione eseguita alla selezione di "logout" nel menù.
     * Serve ad effettuare il logout.
     */
    public void logout(){
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            
            Grafica.card.show(Grafica.container, "login");
            LoginPanel.clearForm();
            applicazione.logout();
            applicazione.back.clear();
        }
    }
    
    /**
     * Lascia come opzione selezionata nel menù sempre la scritta "Menù" (ragioni estetiche)
     */
    public void resetMenu() {
        
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
}

