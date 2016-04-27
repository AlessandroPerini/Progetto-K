/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Login;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Studente.Vista.AccountPanel;
import Università.Facolta.Ascoltatori.CaricaFacoltà;
import Università.Facolta.Vista.ListaFacoltàPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author Te4o
 */
public class LoginPanel extends JPanel{
    
    private static JTextField email = new JTextField();
    private static JPasswordField password = new JPasswordField();
    private JLabel emailLabel, passwordLabel, at, line,img;

    private JPanel down, centro, main, up;
    private JButton login;
    
    public LoginPanel(){   
        
        main = new JPanel(new GridLayout(3, 1));
        up = new JPanel(new GridLayout(2, 1, 0, 30));
        centro = new JPanel(new GridBagLayout());
        
        GridBagConstraints gbcImg = new GridBagConstraints();
        down = new JPanel();
     
        JLabel title = new JLabel("Progetto K");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subTitle = new JLabel("Benvenuto! Effettua il login con le credenziali dell'ateneo.");
        subTitle.setFont(new Font("Arial", Font.PLAIN, 25));
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);

        downBuild();
          //prima riga colonna 0
        img= new JLabel(new ImageIcon("files\\immagini\\login.png"),JLabel.RIGHT);
        gbcImg.gridx = 0;
	gbcImg.gridy = 0;
	gbcImg.insets = new Insets(30, 0, 0, 10);
	gbcImg.anchor = GridBagConstraints.LINE_END;
	centro.add(img, gbcImg);
        // prima riga colonna 1
        gbcImg.gridx = 1;
	gbcImg.gridy = 0;
	gbcImg.insets = new Insets(30, 0, 0, 10);
	gbcImg.anchor = GridBagConstraints.LINE_START;
	centro.add(down, gbcImg);
        
        CaricaFacoltà caricaFacoltà = new CaricaFacoltà();
        DoLogin doLogin = new DoLogin(email, password); 
       
        login.addActionListener(caricaFacoltà);
        login.addActionListener(doLogin);  
        
        up.add(title);
        up.add(subTitle);
 
        main.add(up);
        main.add(centro);
   
        email.addKeyListener(doLogin);
        email.addKeyListener(caricaFacoltà);
        password.addKeyListener(doLogin);
        password.addKeyListener(caricaFacoltà);
        login.addKeyListener(doLogin);
        login.addKeyListener(caricaFacoltà);
        
        add(main);
    }

    public static void clearForm(){
        
        email.setText("");
        password.setText("");
    }
    
    public void downBuild(){
        
        down.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        //prima riga - colonna 0
        
        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 18));
	gbc.gridx = 0;
	gbc.gridy = 0;
	gbc.insets = new Insets(5, 20, 0, 10);
	gbc.anchor = GridBagConstraints.CENTER;
	down.add(emailLabel, gbc);
        
        //seconda riga colonna 0
        email = new JTextField();
        email.setColumns(15);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setFont(new Font("Arial", Font.PLAIN, 15));
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.insets = new Insets(10, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	down.add(email, gbc);
        //seconda riga - colonna 1
        
        at = new JLabel("@universitadipavia.it");
        at.setFont(new Font("Arial", Font.PLAIN, 15));
	gbc.gridx = 1;
	gbc.gridy = 1;
	gbc.insets = new Insets(5, 0, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_START;
	down.add(at, gbc);
        
        //terza riga colonna 0
        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 18));
	gbc.gridx = 0;
	gbc.gridy = 2;
	gbc.insets = new Insets(10, 20, 0, 10);
	gbc.anchor = GridBagConstraints.CENTER;
	down.add(passwordLabel, gbc);
        
         //quarta riga 
        password = new JPasswordField();
        password.setColumns(15);
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setHorizontalAlignment(SwingConstants.CENTER);
	gbc.gridx = 0;
	gbc.gridy = 3;
	gbc.insets = new Insets(10, 30, 0, 10);
	gbc.anchor = GridBagConstraints.LINE_END;
	down.add(password, gbc);
        
        //quinta riga 
        
        ImageIcon bottone = new ImageIcon("files\\immagini\\bottone.png"); 
        login = new JButton(bottone);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setContentAreaFilled(false);
        login.setText("Login");

        login.setIconTextGap(-65);
	gbc.gridx = 0;
	gbc.gridy = 4;
	gbc.insets = new Insets(10, 20, 0, 10);
	gbc.anchor = GridBagConstraints.CENTER;
	down.add(login, gbc);
        
        
    }

}