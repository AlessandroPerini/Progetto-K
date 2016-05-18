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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    private JButton backButton, preferiti, cambiaNumero, cambiaNickname, logout,iMieiDati;
    private JLabel title, emailLabel, nickLabel, phoneLabel;
    private int nClickTel = 0;
    private int nClickNick = 0;
    private Icon backNormal, backHover, backPressed;
    private JPanel body, emailRow, nickRow, phoneRow, centro, top, logoutPanel, iMieiDatiPanel;
    private Back back;
    private GoToPreferiti goToPreferiti;
    private Icon logoutNormal, logoutHover, logoutPressed;
    private Logout logout2;
    private CaricaIMieiDati caricaIMieiDati;
    private ModificaNumero modificaNumero;
    private ModificaNickname modificaNickname;
    private GridBagConstraints gbc;
    
    public AccountPanel() {
        
        top = new JPanel();
        body = new JPanel(new GridBagLayout());
        emailRow = new JPanel();
        nickRow = new JPanel();
        phoneRow = new JPanel();
        logoutPanel = new JPanel();
        iMieiDatiPanel = new JPanel();
        
        gbc = new GridBagConstraints();

        this.setBackground(Color.white);
        top.setBackground(Color.white);
        
        //dichiarazione icon
        backHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        backPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        backNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        logoutHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        logoutNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        logoutPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        
        //dichiarazione button - label
        backButton = new JButton(backNormal);
        logout = new JButton("LOGOUT",logoutNormal);
        preferiti = new JButton("PREFERITI");
        title = new JLabel("Account");
        iMieiDati = new JButton("MIE ATTIVITÀ");
        emailLabel = new JLabel("Email: ");
        nickLabel = new JLabel("Nickname: ");
        phoneLabel = new JLabel("Telefono: ");
        nick = new JTextField(Applicazione.guest.getNickname());
        email = new JLabel(Applicazione.guest.getEmail());
        
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        
        backButton.setRolloverIcon(backHover);
        
        backButton.setPressedIcon(backPressed);
        backButton.setText("<   BACK");
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        backButton.setForeground(Color.white);
        backButton.setIconTextGap(-85);
        
        back = new Back();
        backButton.addActionListener(back);
        backButton.setPreferredSize(new Dimension(110, 40));     
          
        preferiti.setForeground(Color.white);
        preferiti.setBorder(BorderFactory.createEmptyBorder());
        preferiti.setContentAreaFilled(false);
        
        preferiti.setRolloverIcon(backHover);
        
        preferiti.setPressedIcon(backPressed);
        preferiti.setIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png")));
        preferiti.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        preferiti.setIconTextGap(-85);
        preferiti.setPreferredSize(new Dimension(110, 40));
        goToPreferiti = new GoToPreferiti();
        preferiti.addActionListener(goToPreferiti);
        
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 35));
        title.setPreferredSize(new Dimension(420, 40));
        
        top.add(backButton);
        top.add(title);
        top.add(preferiti);
        //end top panel
        
        //body panel
       
        body.setBackground(Color.white);
        emailRow.setBackground(Color.white);
        nickRow.setBackground(Color.white); 
        phoneRow.setBackground(Color.white);
        
       
         
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.setContentAreaFilled(false);
        
        logout.setRolloverIcon(logoutHover);
        logout.setPressedIcon(logoutPressed);
        logout.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        logout.setForeground(Color.white);
        logout.setIconTextGap(-81);
        logout.setPreferredSize(new Dimension(110, 40));
        logout2 = new Logout();
        logout.addActionListener(logout2);
        
        
        logoutPanel.setBackground(Color.white);
        logoutPanel.add(logout);
        
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
        
        caricaIMieiDati = new CaricaIMieiDati();
        iMieiDati.addActionListener(caricaIMieiDati);
        
        
        iMieiDatiPanel.setBackground(Color.white);
        iMieiDatiPanel.add(iMieiDati);
        
        JLabel line = new JLabel("-----------------------------------------------------------------------------------------"
               + "-------------------------------------------------------------------------");
        
        
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        
        email.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        
        
        nickLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        
        nick.setBackground(Color.white);
        nick.setEditable(false);
        nick.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        nick.setColumns(14);
        nick.setHorizontalAlignment(JTextField.CENTER);
        
        
        phoneLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        phone = new JTextField(Applicazione.guest.getTelefono());
        phone.setEditable(false);
        phone.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        phone.setColumns(12);
        phone.setBackground(Color.white);
        phone.setHorizontalAlignment(JTextField.CENTER);
        
        cambiaNumero = new JButton();
        cambiaNumero.setBorder(BorderFactory.createEmptyBorder());
        cambiaNumero.setContentAreaFilled(false);
        cambiaNumero.setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
        cambiaNumero.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        cambiaNumero.setIconTextGap(-85);
        cambiaNumero.setPreferredSize(new Dimension(30,30));
        modificaNumero = new ModificaNumero(nClickTel, phone, cambiaNumero);
        cambiaNumero.addActionListener(modificaNumero);

        cambiaNickname = new JButton();
        cambiaNickname .setBorder(BorderFactory.createEmptyBorder());
        cambiaNickname .setContentAreaFilled(false);
        cambiaNickname .setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
        cambiaNickname .setFont(new Font("Century Gothic", Font.PLAIN, 15));
        cambiaNickname .setIconTextGap(-85);
        cambiaNickname .setPreferredSize(new Dimension(30,30));
        modificaNickname = new ModificaNickname(nClickNick, nick, cambiaNickname);
        cambiaNickname.addActionListener(modificaNickname);
        
        emailRow.add(emailLabel);
        emailRow.add(email);
        
        nickRow.add(nickLabel);
        nickRow.add(nick);
        nickRow.add(cambiaNickname);
        
        phoneRow.add(phoneLabel);
        phoneRow.add(phone);
        phoneRow.add(cambiaNumero);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(100, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(emailRow, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(nickRow, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(phoneRow, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(30, -90, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(logoutPanel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(30, -170, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(iMieiDatiPanel, gbc);
        
        //end body panel
        
        add(top);
        add(body);
       
        
    }
    
    
}
