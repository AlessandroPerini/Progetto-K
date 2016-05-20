/*
* Pannello posto in alto ad ogni pagina, contiente il tasto back sulla sinistra, il titolo
* nel centro e il menù sulla destra.
*/
package Header.Vista;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Header.Ascoltatori.Back;
import Header.Ascoltatori.Menù;
import Segnalazioni.SegnalazionePanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Te4o
 */
public class TopPanel extends JPanel{
    
    //dichiarazione oggetti
    private JComboBox<String> menu;
    private JButton backButton, segnalazioni;
    private JLabel title;
    private JPanel empty;
    
    //dichiarazione variabili
    private String[] opzioniMenù;
    
    //dichiarazione ascoltatori
    private Back back;
    private Menù menù;
    
    public TopPanel(String t) {
        
        //inizializzazione variabili
        opzioniMenù = new String[]{"Home","Account","Preferiti","Logout"};
        
        //inizializzazione oggetti
        backButton = new JButton(new ImageIcon(getClass().getResource("/immagini/buttonNormal.png")));
        title = new JLabel(t);
        menu = new JComboBox<>(opzioniMenù);
        empty = new JPanel();
        segnalazioni = new JButton();

        //inizializzazione ascoltatori
        back = new Back();
        menù = new Menù(menu);
        
        //creazione oggetti
        creaBottoneSegnalazioni();
        creaPannello();
        
    }

    public void creaBottoneSegnalazioni(){

        segnalazioni.setText("Segnalazioni");
        segnalazioni.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        segnalazioni.setForeground(new Color(255, 102, 102));
        segnalazioni.setBorder(new LineBorder(new Color(255, 102, 102), 1));
        segnalazioni.setBackground(Color.white);
        segnalazioni.setPreferredSize(new Dimension(110, 40));
        segnalazioni.setFocusPainted(false);
        
        segnalazioni.addActionListener((ActionEvent e) -> {
            Applicazione.back.add("segnalazione");
            
            SegnalazionePanel segnalazione = new SegnalazionePanel();
            Grafica.container.add(segnalazione, "segnalazione");
            Grafica.card.show(Grafica.container, "segnalazione");
        });
    }
    
    public void creaPannello(){
    
        backButton.setBorder(BorderFactory.createEmptyBorder());
        backButton.setContentAreaFilled(false);
        backButton.setRolloverIcon(new ImageIcon(getClass().getResource("/immagini/buttonHover.png")));
        backButton.setPressedIcon(new ImageIcon(getClass().getResource("/immagini/buttonPressed.png")));
        backButton.setText("<   BACK");
        backButton.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        backButton.setForeground(Color.white);
        backButton.setIconTextGap(-85);
        backButton.setPreferredSize(new Dimension(110, 40));
        backButton.addActionListener(back);
        
        empty.setPreferredSize(new Dimension(110, 40));
        empty.setBackground(Color.white);

        title.setToolTipText(title.getText());
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Century Gothic", Font.BOLD, 20));
        title.setPreferredSize(new Dimension(420, 40));
        title.requestFocus();
        
        menu.setBackground(Color.white);
        menu.setFont(new Font("Century Gothic", Font.PLAIN, 13));
        menu.setPreferredSize(new Dimension(110, 40));
        menu.addActionListener(menù);
        resetMenu();
        
        if (Applicazione.back.get(Applicazione.back.size()-1).equals("facoltà")) add(segnalazioni);
        else add(backButton);
        add(title);
        add(menu);
    }

    public void resetMenu() {
        menu.setEditable(true);
        menu.setSelectedItem("Menù");
        menu.setEditable(false);
    }
    
}
