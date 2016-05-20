/*
* Pannello dedicato alla visualizzazione delle informazioni dell'utente
* con la possibilità di modificare il nickname e il numero di telefono.
*
*/
package Studenti.Vista;

import Application.Controller.Applicazione;
import Studenti.Ascoltatori.CaricaIMieiDati;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Header.Vista.TopPanel;
import Studenti.Ascoltatori.Logout;
import Studenti.Ascoltatori.ModificaNickname;
import Studenti.Ascoltatori.ModificaNumero;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author te4o
 */
public class AccountPanel extends JPanel{
    
    //dichiarazione oggetti
    private static JLabel email;
    private static JTextField phone, nick;
    private JButton cambiaNumero, cambiaNickname, logout, iMieiDati;
    private JLabel emailLabel, nickLabel, phoneLabel;
    private ImageIcon buttonNormal, buttonHover, buttonPressed, logoutNormal, logoutHover, logoutPressed;
    private JPanel body, centro;
    private TopPanel top;
    private Logout logout2;
    private CaricaIMieiDati caricaIMieiDati;
    private ModificaNumero modificaNumero;
    private ModificaNickname modificaNickname;
    private GridBagConstraints gbc;
    
    //dichiarazione variabili
    private int nClickTel = 0;
    private int nClickNick = 0;
    
    public AccountPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel("Account");
        body = new JPanel(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        
        //inizializzazione icon
        buttonNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        buttonHover = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        buttonPressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        logoutHover = new ImageIcon(this.getClass().getResource("/immagini/deleteHover.png"));
        logoutNormal = new ImageIcon(this.getClass().getResource("/immagini/deleteNormal.png"));
        logoutPressed = new ImageIcon(this.getClass().getResource("/immagini/deletePressed.png"));
        
        //inizializzazione button - label
        logout = new JButton("LOGOUT",logoutNormal);
        iMieiDati = new JButton("MIE ATTIVITÀ",buttonNormal);
        emailLabel = new JLabel("Email: ");
        nickLabel = new JLabel("Nickname: ");
        phoneLabel = new JLabel("Telefono: ");
        nick = new JTextField(Applicazione.guest.getNickname());
        email = new JLabel(Applicazione.guest.getEmail());
        phone = new JTextField(Applicazione.guest.getTelefono());
        cambiaNumero = new JButton();
        cambiaNickname = new JButton();
        
        //inizializzazione ascoltatori
        logout2 = new Logout();
        caricaIMieiDati = new CaricaIMieiDati();
        modificaNumero = new ModificaNumero(nClickTel, phone, cambiaNumero);
        modificaNickname = new ModificaNickname(nClickNick, nick, cambiaNickname);
        
        //creazione bottoni
        creaBottone(logout, logoutHover, logoutPressed,"LOGOUT");
        creaBottone(iMieiDati, buttonHover, buttonPressed,"MIE ATTIVITÀ");

        logout.addActionListener(logout2);
        iMieiDati.addActionListener(caricaIMieiDati);
        
        settaggioComponenti();
        
        //body panel
        creaTextField(nick);
        creaTextField(phone);
        
        creaBottoneModifica(cambiaNumero);
        creaBottoneModifica(cambiaNickname);
        
        cambiaNumero.addActionListener(modificaNumero);
        cambiaNickname.addActionListener(modificaNickname);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(80, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(emailLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(80, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(email, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(nickLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(nick, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(30, -5, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(cambiaNickname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(phoneLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(phone, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(30, -5, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(cambiaNumero, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(60, -60, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(logout, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(60, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        body.add(iMieiDati, gbc);
        
        //end body panel
        
        add(top);
        add(body);
        
    }
    public void settaggioComponenti(){
        
        this.setBackground(Color.white);
        top.setBackground(Color.white);
 
        body.setBackground(Color.white);
        
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        email.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        
        nickLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        phoneLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
    }
    public void creaBottone(JButton button, ImageIcon hover, ImageIcon pressed, String text){
        
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setRolloverIcon(hover);
        button.setPressedIcon(pressed);
        button.setText(text);
        button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        button.setForeground(Color.white);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(110, 40));
    }
    
    public void creaTextField(JTextField field){
        
        field.setBackground(Color.white);
        field.setEditable(false);
        field.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        field.setColumns(14);
        field.setHorizontalAlignment(JTextField.CENTER);
    }
    public void creaBottoneModifica(JButton button){
        
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        button.setIcon(new ImageIcon(this.getClass().getResource("/immagini/modifica.png")));
        button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(30,30));
    }
    
}
