/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Header.Ascoltatori;

import Application.Controller.Applicazione;
import static Application.Controller.Applicazione.svuotaAppunti;
import static Application.Controller.Applicazione.svuotaCorsi;
import static Application.Controller.Applicazione.svuotaCorsiXAnno;
import static Application.Controller.Applicazione.svuotaDomande;
import static Application.Controller.Applicazione.svuotaFacoltà;
import static Application.Controller.Applicazione.svuotaLibri;
import static Application.Controller.Applicazione.svuotaListaFacoltàXRamo;
import static Application.Controller.Applicazione.svuotaMieiDati;
import static Application.Controller.Applicazione.svuotaPreferiti;
import static Application.Controller.Applicazione.svuotaRami;
import static Application.Controller.Applicazione.svuotaRecensioni;
import static Application.Controller.Applicazione.svuotaRisposte;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Login.LoginPanel;
import Preferiti.Vista.PreferitiPanel;
import Universita.Facolta.Vista.ListaFacoltàPanel;
import Utils.Ordina;
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
    
    private JComboBox menu;
    
    public Menù(JComboBox menu) {
        this.menu = menu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(menu.getSelectedItem().equals("Home")){
            
            try {
                svuotaCorsi();;
                svuotaFacoltà();
                svuotaLibri();
                svuotaDomande();
                svuotaAppunti();
                svuotaRisposte();
                svuotaMieiDati();
                svuotaListaFacoltàXRamo();
                svuotaRecensioni();
                svuotaRami();
                svuotaCorsiXAnno();
                svuotaPreferiti();
                
                ListeQuery.caricaFacoltà();
                
                ListeQuery.caricaRamiFacoltà();
                
                resetMenu();
                
                ListaFacoltàPanel facoltà = new ListaFacoltàPanel();
                
                Grafica.card.show(Grafica.container, "facoltà");
                Applicazione.back.add("facoltà");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante il caricamento delle facoltà", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(menu.getSelectedItem().equals("Account")){
            
            Grafica.card.show(Grafica.container, "account");
            Applicazione.back.add("account");
            Applicazione.svuotaMieiDati();
            
            resetMenu();
        }
        if(menu.getSelectedItem().equals("Preferiti")){
            
            Applicazione.back.add("preferiti");
            
            try {
                ListeQuery.caricaFacoltàPreferite();
                ListeQuery.caricaCorsiPreferiti();
                ListeQuery.caricaAppuntiPreferiti();
                ListeQuery.caricaLibriPreferiti();
                ListeQuery.caricaDomandePreferite();
                
                Ordina.ListePreferiti();

                PreferitiPanel preferitiPanel = new PreferitiPanel();
                Grafica.container.add(preferitiPanel, "preferiti");
                Grafica.card.show(Grafica.container, "preferiti");
                
                resetMenu();
                
            } catch (SQLException ex) {
                System.out.println("Errore durante il caricamento dei preferiti");
            }
            
        }
        if(menu.getSelectedItem().equals("Logout")){
            
            int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
            
            if(showConfirmDialog == 0 ){
                
                Grafica.card.show(Grafica.container, "login");
                LoginPanel.clearForm();
                Applicazione.logout();
                Applicazione.back.clear();
            }
            resetMenu();
        }
    }
    
    public void resetMenu() {
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
}

