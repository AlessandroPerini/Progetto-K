/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente.Vista;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Login.LoginPanel;
import Studente.Ascoltatori.CaricaIMieiDati;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Ascoltatori.CaricaFacoltà;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Database.Query.InsertQuery;
import java.sql.NClob;

/**
 *
 * @author te4o
 */
public class AccountPanel extends JPanel{
    
    private static JLabel email;
    private static JLabel nick;
    private static JTextField phone;
    private JButton cambiaNumero, back, preferiti;
    private JLabel title;
    int nClick = 0; 
    public AccountPanel() {
    
        setPreferredSize(new Dimension(700, 450));
        
        //top panel
        JPanel top = new JPanel();
        
        
        back = new JButton("Back");
        back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        Applicazione.back.remove(Applicazione.back.size()-1);
                        Grafica.card.show(Grafica.container, Applicazione.back.get(Applicazione.back.size()-1));
                    }
                });
        back.setPreferredSize(new Dimension(110, 40));

        preferiti = new JButton("★Preferiti★");
        preferiti.setPreferredSize(new Dimension(110, 40));

        title = new JLabel("Account");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setPreferredSize(new Dimension(420, 40));

        top.add(back);
        top.add(title);
        top.add(preferiti);
        //end top panel
        
        //body panel
        JPanel body = new JPanel((new GridLayout(5, 1, 0, 20)));
        
        JPanel emailRow = new JPanel();
        JPanel nickRow = new JPanel();
        JPanel phoneRow = new JPanel();
        
        JButton logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(120, 75));
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int showConfirmDialog = JOptionPane.showConfirmDialog(null, "Sei sicuro?", "Logout", JOptionPane.YES_NO_OPTION);
                
                if(showConfirmDialog == 0 ){

                    Grafica.card.show(Grafica.container, "login");
                    LoginPanel.clearForm();
                    Applicazione.logout();
                }
            }
        });
        
        JPanel logoutPanel = new JPanel();
        logoutPanel.add(logout);
        
        JButton iMieiDati = new JButton("Mie Attività");
        iMieiDati.setPreferredSize(new Dimension(120, 75));
        CaricaIMieiDati caricaIMieiDati = new CaricaIMieiDati();
        iMieiDati.addActionListener(caricaIMieiDati);
        
        JPanel iMieiDatiPanel = new JPanel();
        iMieiDatiPanel.add(iMieiDati);
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------");

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 20));

        email = new JLabel(Applicazione.guest.getEmail());
        email.setFont(new Font("Arial", Font.PLAIN, 18));

        JLabel nickLabel = new JLabel("Nickname: ");
        nickLabel.setFont(new Font("Arial", Font.BOLD, 20));

        nick = new JLabel(Applicazione.guest.getNickname());
        nick.setFont(new Font("Arial", Font.PLAIN, 18));
        
        JLabel phoneLabel = new JLabel("Telefono: ");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));

        phone = new JTextField(Applicazione.guest.getTelefono());
        phone.setEditable(false);
        phone.setFont(new Font("Arial", Font.PLAIN, 18));
        InsertQuery iQuery = new InsertQuery();
        
        cambiaNumero = new JButton("Modifica");
        cambiaNumero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nClick += 1;
                phone.setEditable(true);
                cambiaNumero.setText("Conferma");
              if ( nClick == 2){
                  phone.setEditable(false);
                  cambiaNumero.setText("Modifica");
                  iQuery.updateTelefono(phone.getText());
                  JOptionPane.showMessageDialog(null, "Numero di telefono cambiato!", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);
                  nClick = 0;
              }
            }
        });

        emailRow.add(emailLabel);
        emailRow.add(email);

        nickRow.add(nickLabel);
        nickRow.add(nick);
        
        phoneRow.add(phoneLabel);
        phoneRow.add(phone);
        phoneRow.add(cambiaNumero);
        
        body.add(line);
        body.add(emailRow);
        body.add(nickRow);
        body.add(phoneRow);
        //end body panel
        
        add(top);
        add(body);
        add(logoutPanel);
        add(iMieiDatiPanel);
        
    }

    
}
