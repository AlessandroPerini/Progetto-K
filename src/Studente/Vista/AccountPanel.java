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
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author te4o
 */
public class AccountPanel extends JPanel{
    
    private static JLabel email;
    private static JTextField phone, nick;
    private JButton backButton, preferiti, cambiaNumero, cambiaNickname;
    private JLabel title;
    private int nClickTel = 0;
    private int nClickNick = 0;
    private Icon backNormal, backHover, backPressed;
    private JPanel body, emailRow, nickRow, phoneRow, centro;
    
    public AccountPanel() {
        
        setPreferredSize(new Dimension(700, 450));
        
        //top panel
        JPanel top = new JPanel();
        this.setBackground(Color.white);
        top.setBackground(Color.white);

        backNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        backButton = new JButton(backNormal);
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        backButton.setRolloverIcon(backHover);
        backPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        backButton.setPressedIcon(backPressed);
        backButton.setText("<   BACK");
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        backButton.setForeground(Color.white);
        backButton.setIconTextGap(-85);
        Back back = new Back();
        backButton.addActionListener(back);
        backButton.setPreferredSize(new Dimension(110, 40));     
        
        preferiti = new JButton("PREFERITI");
        preferiti.setForeground(Color.white);
        preferiti.setBorder(BorderFactory.createEmptyBorder());
        preferiti.setContentAreaFilled(false);
        backHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        preferiti.setRolloverIcon(backHover);
        backPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        preferiti.setPressedIcon(backPressed);
        preferiti.setIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png")));
        preferiti.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        preferiti.setIconTextGap(-85);
        preferiti.setPreferredSize(new Dimension(110, 40));
        GoToPreferiti goToPreferiti = new GoToPreferiti();
        preferiti.addActionListener(goToPreferiti);
        
        title = new JLabel("Account");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 35));
        title.setPreferredSize(new Dimension(420, 40));
        
        top.add(backButton);
        top.add(title);
        top.add(preferiti);
        //end top panel
        
        //body panel
        body = new JPanel((new GridLayout(5, 1, 0, 20)));
        body.setBackground(Color.white);
        
        emailRow = new JPanel();
        emailRow.setBackground(Color.white);
        nickRow = new JPanel();
        nickRow.setBackground(Color.white);
        phoneRow = new JPanel();
        phoneRow.setBackground(Color.white);
        
        Icon logoutNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        JButton logout = new JButton("LOGOUT",logoutNormal);
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setContentAreaFilled(false);
        Icon logoutHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        logout.setRolloverIcon(logoutHover);
        Icon logoutPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        logout.setPressedIcon(logoutPressed);
        logout.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        logout.setForeground(Color.white);
        logout.setIconTextGap(-81);
        logout.setPreferredSize(new Dimension(110, 40));
        Logout logout2 = new Logout();
        logout.addActionListener(logout2);
        
        JPanel logoutPanel = new JPanel();
        logoutPanel.setBackground(Color.white);
        logoutPanel.add(logout);
        
        JButton iMieiDati = new JButton("MIE ATTIVITÀ");
        iMieiDati.setForeground(Color.white);
        iMieiDati.setBorder(BorderFactory.createEmptyBorder());
        iMieiDati.setContentAreaFilled(false);
        iMieiDati.setRolloverIcon(backHover);
        iMieiDati.setPressedIcon(backPressed);
        iMieiDati.setIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png")));
        iMieiDati.setRolloverIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png")));
        iMieiDati.setPressedIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png")));
        
        iMieiDati.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        iMieiDati.setIconTextGap(-95);
        iMieiDati.setPreferredSize(new Dimension(110, 40));
        CaricaIMieiDati caricaIMieiDati = new CaricaIMieiDati();
        iMieiDati.addActionListener(caricaIMieiDati);
        
        JPanel iMieiDatiPanel = new JPanel();
        iMieiDatiPanel.setBackground(Color.white);
        iMieiDatiPanel.add(iMieiDati);
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------");
        
        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        email = new JLabel(Applicazione.guest.getEmail());
        email.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        
        JLabel nickLabel = new JLabel("Nickname: ");
        nickLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        nick = new JTextField(Applicazione.guest.getNickname());
        nick.setBackground(Color.white);
        nick.setEditable(false);
        nick.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        nick.setColumns(12);
        nick.setHorizontalAlignment(JTextField.CENTER);
        
        JLabel phoneLabel = new JLabel("Telefono: ");
        phoneLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        phone = new JTextField(Applicazione.guest.getTelefono());
        phone.setEditable(false);
        phone.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        phone.setColumns(10);
        phone.setBackground(Color.white);
        phone.setHorizontalAlignment(JTextField.CENTER);
        
        cambiaNumero = new JButton();
        cambiaNumero.setBorder(BorderFactory.createEmptyBorder());
        cambiaNumero.setContentAreaFilled(false);
        cambiaNumero.setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
        cambiaNumero.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        cambiaNumero.setIconTextGap(-85);
        cambiaNumero.setPreferredSize(new Dimension(30,30));
        ModificaNumero modificaNumero = new ModificaNumero(nClickTel, phone, cambiaNumero);
        cambiaNumero.addActionListener(modificaNumero);

        cambiaNickname = new JButton();
        cambiaNickname .setBorder(BorderFactory.createEmptyBorder());
        cambiaNickname .setContentAreaFilled(false);
        cambiaNickname .setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
        cambiaNickname .setFont(new Font("Century Gothic", Font.PLAIN, 15));
        cambiaNickname .setIconTextGap(-85);
        cambiaNickname .setPreferredSize(new Dimension(30,30));
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
