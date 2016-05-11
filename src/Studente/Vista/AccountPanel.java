/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Studente.Vista;

import Application.Controller.Applicazione;
import Studente.Ascoltatori.CaricaIMieiDati;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Header.Ascoltatori.Back;
import Studente.Ascoltatori.GoToPreferiti;
import Studente.Ascoltatori.Logout;
import Studente.Ascoltatori.ModificaNickname;
import Studente.Ascoltatori.ModificaNumero;

/**
 *
 * @author te4o
 */
public class AccountPanel extends JPanel{
    
    private static JLabel email;
    private static JTextField phone, nick;
    private JButton back, preferiti, cambiaNumero, cambiaNickname;
    private JLabel title;
    int nClickTel = 0;
    int nClickNick = 0;
    public AccountPanel() {
        
        setPreferredSize(new Dimension(700, 450));
        
        //top panel
        JPanel top = new JPanel();

        back = new JButton("Back");
        Back back2 = new Back();
        back.addActionListener(back2);
        back.setPreferredSize(new Dimension(110, 40));
        
        preferiti = new JButton("★Preferiti★");
        preferiti.setPreferredSize(new Dimension(110, 40));
        GoToPreferiti goToPreferiti = new GoToPreferiti();
        preferiti.addActionListener(goToPreferiti);
        
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
        Logout logout2 = new Logout();
        logout.addActionListener(logout2);
        
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
        
        nick = new JTextField(Applicazione.guest.getNickname());
        nick.setEditable(false);
        nick.setFont(new Font("Arial", Font.PLAIN, 18));
        nick.setMinimumSize(new Dimension(20, 0));
        
        JLabel phoneLabel = new JLabel("Telefono: ");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 20));
        
        phone = new JTextField(Applicazione.guest.getTelefono());
        phone.setEditable(false);
        phone.setFont(new Font("Arial", Font.PLAIN, 18));
        phone.setMinimumSize(new Dimension(20, 0));
        
        cambiaNumero = new JButton("Modifica");
        ModificaNumero modificaNumero = new ModificaNumero(nClickTel, phone, cambiaNumero);
        cambiaNumero.addActionListener(modificaNumero);
        
        cambiaNickname = new JButton("Modifica");
        ModificaNickname modificaNickname = new ModificaNickname(nClickNick, nick, cambiaNickname);
        cambiaNickname.addActionListener(modificaNickname);
        
        emailRow.add(emailLabel);
        emailRow.add(email);
        
        nickRow.add(nickLabel);
        nickRow.add(nick);
        nickRow.add(cambiaNickname);
        
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
