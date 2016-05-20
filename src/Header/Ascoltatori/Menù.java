/*
* Ascoltatore per la gestione del menù JComboBox in alto a destra
*/
package Header.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Login.Vista.LoginPanel;
import Preferiti.Vista.PreferitiPanel;
import Università.Facolta.Vista.ListaFacoltàPanel;
import Utils.Azioni.Ordina;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class Menù implements ActionListener{
    
    //dichiarazione oggetti
    private JComboBox menu;
    private String selezione;
    
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
    
    public void home(){
        
        try {
            Applicazione.svuotaTutteLeListe();
            
            ListeQuery.caricaFacoltà();
            ListeQuery.caricaRamiFacoltà();

            ListaFacoltàPanel facoltà = new ListaFacoltàPanel();
            Grafica.card.show(Grafica.container, "facoltà");
            Applicazione.back.add("facoltà");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento delle facoltà", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void account(){
        
        Grafica.card.show(Grafica.container, "account");
        Applicazione.back.add("account");
        Applicazione.svuotaMieiDati();

    }
    
    public void preferiti(){

        try {
            ListeQuery.caricaTuttiPreferiti();
            
            Ordina.ListePreferiti();
            
            PreferitiPanel preferitiPanel = new PreferitiPanel();
            Grafica.container.add(preferitiPanel, "preferiti");
            Grafica.card.show(Grafica.container, "preferiti");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il caricamento dei preferiti");
        }
    }
    
    public void logout(){
        
        int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
        
        if(showConfirmDialog == 0 ){
            
            Grafica.card.show(Grafica.container, "login");
            LoginPanel.clearForm();
            Applicazione.logout();
            Applicazione.back.clear();
        }
    }
    
    public void resetMenu() {
        
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
}

