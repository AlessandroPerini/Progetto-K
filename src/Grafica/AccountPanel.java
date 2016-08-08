/*
* Pannello dedicato alla visualizzazione delle informazioni dell'utente
* con la possibilità di modificare il nickname e il numero di telefono.
*
*/
package Grafica;

import Application.Applicazione;
import Ascoltatori.Studenti.CaricaIMieiDati;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Ascoltatori.Studenti.Logout;
import Ascoltatori.Studenti.ModificaNickname;
import Ascoltatori.Studenti.ModificaNumero;
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
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione label - textfield- bottoni
    private JLabel emailLabel, nicknameLabel, telefonoLabel;
    private static JLabel email;
    private static JTextField telefono, nickname;
    private JButton cambiaNumero, cambiaNickname, logout, iMieiDati;    
    
    //dichiarazione icone
    private ImageIcon buttonNormal, buttonHover, buttonPressed, logoutNormal, logoutHover, logoutPressed;
    
    //dichiarazione pannelli
    private JPanel body, centro;
    private TopPanel top;
    
    //dichiarazione ascoltatori
    private Logout logout1;
    private CaricaIMieiDati caricaIMieiDati;
    private ModificaNumero modificaNumero;
    private ModificaNickname modificaNickname;
    
    //dichiarazione variabili layout
    private GridBagConstraints gbc;
    
    //dichiarazione variabili
    private int nClickTel = 0;
    private int nClickNick = 0;
    
    public AccountPanel() {
        
        //inizializzazione pannelli
        top = new TopPanel("Account");
        body = new JPanel(new GridBagLayout());
        
        //inizializzazione variabili layout
        gbc = new GridBagConstraints();
        
        //inizializzazione icone
        buttonNormal = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonNormal.png"));
        buttonHover = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonHover.png"));
        buttonPressed = new ImageIcon(this.getClass().getResource("/Grafica/immagini/buttonPressed.png"));
        logoutHover = new ImageIcon(this.getClass().getResource("/Grafica/immagini/deleteHover.png"));
        logoutNormal = new ImageIcon(this.getClass().getResource("/Grafica/immagini/deleteNormal.png"));
        logoutPressed = new ImageIcon(this.getClass().getResource("/Grafica/immagini/deletePressed.png"));
        
        //inizializzazione bottoni - label - textfield
        logout = new JButton("LOGOUT",logoutNormal);
        iMieiDati = new JButton("MIE ATTIVITÀ",buttonNormal);
        emailLabel = new JLabel("Email: ");
        nicknameLabel = new JLabel("Nickname: ");
        telefonoLabel = new JLabel("Telefono: ");
        nickname = new JTextField(applicazione.guest.getNickname());
        email = new JLabel(applicazione.guest.getEmail());
        telefono = new JTextField(applicazione.guest.getTelefono());
        cambiaNumero = new JButton();
        cambiaNickname = new JButton();
        
        //inizializzazione ascoltatori
        logout1 = new Logout();
        caricaIMieiDati = new CaricaIMieiDati();
        modificaNumero = new ModificaNumero(nClickTel, telefono, cambiaNumero);
        modificaNickname = new ModificaNickname(nClickNick, nickname, cambiaNickname);
        
        //creazione bottoni
        creaBottone(logout, logoutHover, logoutPressed,"LOGOUT");
        creaBottone(iMieiDati, buttonHover, buttonPressed,"MIE ATTIVITÀ");
        creaBottoneModifica(cambiaNumero);
        creaBottoneModifica(cambiaNickname);
        
        //creazione textfield
        creaTextField(nickname);
        creaTextField(telefono);
        
        //associazione ascoltatori -> bottoni
        logout.addActionListener(logout1);
        iMieiDati.addActionListener(caricaIMieiDati);
        cambiaNumero.addActionListener(modificaNumero);
        cambiaNickname.addActionListener(modificaNickname);

        //creazione componenti - pannelli
        creaComponenti();
        creaPannelloCentrale();
        creaPannelloPrincipale();        
        
    }
    
    public void creaComponenti(){
        
        setBackground(Color.white);
        top.setBackground(Color.white);
 
        body.setBackground(Color.white);
        
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        email.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        
        nicknameLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
        
        telefonoLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
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
        button.setIcon(new ImageIcon(this.getClass().getResource("/Grafica/immagini/modifica.png")));
        button.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setPreferredSize(new Dimension(30,30));
    }
    
    public void creaPannelloCentrale(){
    
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
        gbc.insets = new Insets(40, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(nicknameLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(40, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(nickname, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.insets = new Insets(40, -5, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(cambiaNickname, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(40, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(telefonoLabel, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.insets = new Insets(40, 10, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        body.add(telefono, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.insets = new Insets(40, -5, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(cambiaNumero, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(70, -60, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        body.add(logout, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.insets = new Insets(70, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        body.add(iMieiDati, gbc);
        
    }
    
    public void creaPannelloPrincipale(){
    
        add(top);
        add(body);
    }
}
