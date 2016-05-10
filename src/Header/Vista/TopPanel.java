/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Header.Vista;

import Application.Controller.Applicazione;
import static Application.Controller.Applicazione.svuotaAppunti;
import static Application.Controller.Applicazione.svuotaCorsi;
import static Application.Controller.Applicazione.svuotaDomande;
import static Application.Controller.Applicazione.svuotaLibri;
import static Application.Controller.Applicazione.svuotaListaFacoltàXRamo;
import static Application.Controller.Applicazione.svuotaMieiDati;
import static Application.Controller.Applicazione.svuotaPreferiti;
import static Application.Controller.Applicazione.svuotaRami;
import static Application.Controller.Applicazione.svuotaRecensioni;
import static Application.Controller.Applicazione.svuotaRisposte;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Header.Ascoltatori.Back;
import Header.Ascoltatori.Menù;
import Login.LoginPanel;
import Preferiti.Facoltà.Vista.PreferitiPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
        Back back = new Back();
        backButton.addActionListener(back);
        backButton.setPreferredSize(new Dimension(110, 40));
        
        JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(110, 40));
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(420, 40));
        
        String[] opzioni = new String[]{"Home","Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        menu.setPreferredSize(new Dimension(110, 40));
        Menù menù = new Menù(menu);
        menu.addActionListener(menù);
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
