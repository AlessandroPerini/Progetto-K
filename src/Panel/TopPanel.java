/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Controller.Applicazione;
import Libro.CaricaLibri;
import Login.LoginPanel;
import Università.Corsi.CaricaCorsi;
import Università.Facolta.CaricaFacoltà;
import java.awt.CardLayout;
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
    
    public TopPanel(final CardLayout card, final JPanel container, String t) {
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                if (Applicazione.back.get(Applicazione.back.size()-1).equals("corsi")) {
                    Applicazione.svuotaCorsi();
                }
                if (Applicazione.back.get(Applicazione.back.size()-1).equals("libri")) {
                    CaricaLibri.svuotaLibri();
                }
                Applicazione.back.remove(Applicazione.back.size()-1);
                card.show(container, Applicazione.back.get(Applicazione.back.size()-1));
            }
        });
        backButton.setPreferredSize(new Dimension(110, 40));
        
        JPanel empty = new JPanel();
        empty.setPreferredSize(new Dimension(110, 40));
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setPreferredSize(new Dimension(420, 40));
        
        String[] opzioni = new String[]{"Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        menu.setPreferredSize(new Dimension(110, 40));
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.getSelectedItem().equals("Account")){

                    card.show(container, "account");
                    Applicazione.back.add("account");
                    resetMenu();
                }
                if(menu.getSelectedItem().equals("Preferiti")){
                   
                }
                if(menu.getSelectedItem().equals("Logout")){
                
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
                
                    if(showConfirmDialog == 0 ){

                        card.show(container, "login");
                        LoginPanel.clearForm();
                        Applicazione.eliminaUtente();
                        Applicazione.svuotaCorsi();
                        CaricaFacoltà.svuotaFacoltà();
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
