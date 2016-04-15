/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import Login.LoginPanel;
import Università.CaricaCorsi;
import Università.CaricaFacoltà;
import Utils.DatiTemporanei;
import Utils.CheckLogin;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{

    private JComboBox menu;
    
    public TopPanel(final CardLayout card, final JPanel container, String t, boolean isFacoltà, final boolean isCorsi) {
        
        //this.back = back;
        
        setLayout(new GridLayout(1, 3, 150, 0));
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                DatiTemporanei.back.remove(DatiTemporanei.back.size()-1);
                card.show(container, DatiTemporanei.back.get(DatiTemporanei.back.size()-1));
                if (isCorsi) {
                    CaricaCorsi.svuotaCorsi();
                }
            }
        });
        
        JPanel empty = new JPanel();
        
        JLabel title = new JLabel(t);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        
        String[] opzioni = new String[]{"Account","Preferiti","Logout"};
        menu = new JComboBox(opzioni);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(menu.getSelectedItem().equals("Account")){

                    card.show(container, "account");
                    DatiTemporanei.back.add("account");
                    resetMenu();
                }
                if(menu.getSelectedItem().equals("Preferiti")){
                   
                }
                if(menu.getSelectedItem().equals("Logout")){
                
                    int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
                
                    if(showConfirmDialog == 0 ){

                        card.show(container, "login");
                        LoginPanel.clearForm();
                        CheckLogin.deleteGuest();
                        CaricaCorsi.svuotaCorsi();
                        CaricaFacoltà.svuotaFacoltà();
                        DatiTemporanei.back.clear();
                    }
                    resetMenu();
                }
            }
        });
        resetMenu();
        
        if(isFacoltà){add(empty);}
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
