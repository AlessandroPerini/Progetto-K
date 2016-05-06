/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Header;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import Login.LoginPanel;
import Preferiti.Facoltà.Vista.PreferitiPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{

    private JComboBox menu;
    
    public TopPanel(String t) {
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
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
                                            lQuery1.caricaFacoltà();
                        break;
                    case "corsi cercati": Applicazione.svuotaCorsi();
                                          ListeQuery lQuery2 = new ListeQuery();
                                          lQuery2.caricaCorsi();
                        break;
                    case "preferiti": Applicazione.svuotaPreferiti();
                        break;
                }
                
                Applicazione.back.remove(Applicazione.back.size()-1);
                Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
            }
        });
        backButton.setPreferredSize(new Dimension(110, 40));
        
        JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(110, 40));
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(420, 40));
        
        String[] opzioni = new String[]{"Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        menu.setPreferredSize(new Dimension(110, 40));
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.getSelectedItem().equals("Account")){

                    Grafica.card.show(Grafica.container, "account");
                    Applicazione.back.add("account");
                    resetMenu();
                }
                if(menu.getSelectedItem().equals("Preferiti")){
                   
                    Applicazione.back.add("preferiti");
                    ListeQuery.caricaFacoltàPreferite();
                    PreferitiPanel preferitiPanel = new PreferitiPanel();
                    Grafica.container.add(preferitiPanel, "preferiti");
                    Grafica.card.show(Grafica.container, "preferiti");
                    
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
        });
        resetMenu();
        
        if (Applicazione.back.get(Applicazione.back.size()-1).equals("facoltà")) {add(empty);}
        else{add(backButton);}
        add(title);
        add(menu);
      
    }

    public void resetMenu() {
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
 
}
