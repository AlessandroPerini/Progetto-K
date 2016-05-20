/*
* Pannello login. E' il primo pannello ad essere visualizzato, ed è appunto
* quello in cui è possibile effettuale il login.
*/
package Login.Vista;

import Login.Ascoltatori.DoLogin;
import Università.Facolta.Ascoltatori.CaricaFacoltà;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Te4o
 */
public class LoginPanel extends JPanel{
    
    //dichiarazione oggetti
    private static JTextField email;
    private static JPasswordField password;
    private JLabel emailLabel, passwordLabel, at, img, title, subTitle;
    private JPanel main, top, inserimentoDati, centro;
    private JButton login;
    private ImageIcon bottoneNormal, bottoneHover, bottonePressed;
    private GridBagConstraints gbc, gbcImg, gbcImgUp;
    
    //dichiarazione ascoltatori
    private CaricaFacoltà caricaFacoltà;
    private DoLogin doLogin;
    
    public LoginPanel(){
        
        //inizializzazione pannelli
        main = new JPanel(new GridLayout(3, 1));
        top = new JPanel(new GridBagLayout());
        centro = new JPanel(new GridBagLayout());
        inserimentoDati = new JPanel(new GridBagLayout());
        
        //inizializzazione immagini bottoni
        bottoneNormal = new ImageIcon(this.getClass().getResource("/immagini/buttonNormal.png"));
        bottoneHover = new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png"));
        bottonePressed = new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png"));
        
        //inizializzazione oggetti
        title = new JLabel(new ImageIcon(getClass().getResource("/immagini/titolo.png")));
        subTitle = new JLabel("Benvenuto! Effettua il login con le credenziali dell'ateneo.");
        emailLabel = new JLabel("Email");
        at = new JLabel("@universitadipavia.it");
        passwordLabel = new JLabel("Password");
        email = new JTextField("");
        password = new JPasswordField("");
        img = new JLabel(new ImageIcon(this.getClass().getResource("/immagini/loginIcon.png")),JLabel.RIGHT);
        login = new JButton(bottoneNormal);
        
        //inizializzazione variabili di layout
        gbc = new GridBagConstraints();
        gbcImgUp = new GridBagConstraints();
        gbcImg= new GridBagConstraints();
        
        //inizializzazione ascoltatori
        caricaFacoltà = new CaricaFacoltà();
        doLogin = new DoLogin(email, password);
        
        //creazione pannelli
        creaPannelloTop();//contiene titolo e sottotitolo
        creaPannelloInserimentoDati();//contiene le label, le textField e il botoone login
        creaPannelloCentrale();//contiene l'immagine login e il pannello per l'inserimento dei dati
        
        main.setBackground(Color.white);
        
        main.add(top);
        main.add(centro);
        
        setBackground(Color.white);
        
        add(main);
    }
    
    public void creaPannelloTop(){
        
        top.setBackground(Color.white);
        
        title.setPreferredSize(new Dimension(600, 150));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        gbcImgUp.gridx = 0;
        gbcImgUp.gridy = 0;
        gbcImgUp.insets = new Insets(30, 0, 0, 25);
        gbcImgUp.anchor = GridBagConstraints.CENTER;
        top.add(title, gbcImgUp);
        
        subTitle.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        subTitle.setHorizontalAlignment(SwingConstants.CENTER);
        gbcImgUp.gridx = 0;
        gbcImgUp.gridy = 1;
        gbcImgUp.insets = new Insets(30, 0, 0, 10);
        gbcImgUp.anchor = GridBagConstraints.CENTER;
        top.add(subTitle, gbcImgUp);
    }
    
    public void creaPannelloInserimentoDati(){

        inserimentoDati.setBackground(Color.white);
        
        emailLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 30, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        inserimentoDati.add(emailLabel, gbc);
        
        email.setColumns(15);
        email.setHorizontalAlignment(SwingConstants.CENTER);
        email.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 25, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        inserimentoDati.add(email, gbc);
        
        at.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 0, 10);
        gbc.anchor = GridBagConstraints.LINE_START;
        inserimentoDati.add(at, gbc);
        
        passwordLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 30, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        inserimentoDati.add(passwordLabel, gbc);
        
        password.setColumns(15);
        password.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        password.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(10, 25, 20, 10);
        gbc.anchor = GridBagConstraints.LINE_END;
        inserimentoDati.add(password, gbc);
        
        login.setBorder(BorderFactory.createEmptyBorder());
        login.setContentAreaFilled(false);
        login.setRolloverIcon(bottoneHover);
        login.setPressedIcon(bottonePressed);
        login.setText("LOGIN   >");
        login.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        login.setForeground(Color.white);
        
        //Ascoltatori alla pressione del tasto Invio sulle textfield e sul botton
        email.addKeyListener(doLogin);
        email.addKeyListener(caricaFacoltà);
        password.addKeyListener(doLogin);
        password.addKeyListener(caricaFacoltà);
        login.addKeyListener(doLogin);
        login.addKeyListener(caricaFacoltà);
        
        //ascoltatori sul bottone login
        login.addActionListener(caricaFacoltà);
        login.addActionListener(doLogin);
        
        login.setIconTextGap(-85);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.insets = new Insets(10, 25, 0, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        inserimentoDati.add(login, gbc);
        
    }
    
    public void creaPannelloCentrale(){
        centro.setBackground(Color.white);
        
        gbcImg.gridx = 0;
        gbcImg.gridy = 0;
        gbcImg.insets = new Insets(30, 50, 30, 10);
        gbcImg.anchor = GridBagConstraints.LINE_END;
        centro.add(img, gbcImg);
        
        gbcImg.gridx = 1;
        gbcImg.gridy = 0;
        gbcImg.insets = new Insets(30, 0, 0, 10);
        gbcImg.anchor = GridBagConstraints.LINE_START;
        centro.add(inserimentoDati, gbcImg);
    }
    
    public static void clearForm(){
        
        email.setText("");
        password.setText("");
    }
    
}