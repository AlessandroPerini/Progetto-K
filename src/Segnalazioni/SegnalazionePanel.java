/*
* Pannello con il form per l'invio delle segnalazioni da parte degli
* altri gruppi del corso.
*/
package Segnalazioni;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Header.Vista.TopPanel;
import Utils.Vista.CustomScrollBar;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

/**
 *
 * @author te4o
 */
public class SegnalazionePanel extends JPanel{
    
    public Applicazione applicazione = Applicazione.getInstance();

    //dichiarazione oggetti
    private JPanel top;
    private JTextArea testo;
    private JScrollPane scrollPanelTesto;
    private JButton submitButton;
    
    //dichiarazione variabili
    private boolean ok = false;
    
    public SegnalazionePanel(){
        
        //inizializzazione oggetti
        top = new TopPanel("Inviaci un consiglio o una segnalazione"); top.setBackground(Color.white);
        testo = new JTextArea("");
        scrollPanelTesto = new JScrollPane(testo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        submitButton = new JButton("INVIA",new ImageIcon(getClass().getResource("/immagini/buttonNormal.png")));
        
        //creazione oggetti
        creaPannelloTesto(testo, scrollPanelTesto);
        creaBottoneConferma(submitButton);
        
        submitButton.addActionListener((ActionEvent e) -> {
            if((!testo.getText().equals(""))&&(testo.getText().length()<2000)){
                
                String insertSegnalazione = "INSERT INTO segnalazioni VALUES (?, ?);";
                
                PreparedStatement ps1;
                
                try {
                    
                    ps1 = applicazione.DBconnection.prepareStatement(insertSegnalazione);
                    
                    ps1.clearParameters();
                    ps1.setString(1, applicazione.guest.getEmail());
                    ps1.setString(2, testo.getText());
                    
                    ps1.execute();
                    
                    ok = true;
                } catch (SQLException ex) {
                    System.out.println("Errore durante l'invio della segnalazione");
                }
            }
            else{
                
                JOptionPane.showMessageDialog(null, "Testo non valido (max 2000 caratteri)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
            }
            if(ok){
                
                JOptionPane.showMessageDialog(null, "Grazie per la segnalazione ;)", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                
                applicazione.back.remove(applicazione.back.size()-1);
                Grafica.card.show(Grafica.container, applicazione.back.get(applicazione.back.size()-1));
                
                testo.setText("");
            }
        });
        
        setBackground(Color.white);
        
        add(top);
        add(scrollPanelTesto);
        add(submitButton);
    }
    
    public void creaBottoneConferma(JButton b){
        
        b.setRolloverIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonHover.png")));
        b.setPressedIcon(new ImageIcon(this.getClass().getResource("/immagini/buttonPressed.png")));
        b.setBorder(BorderFactory.createEmptyBorder());
        b.setContentAreaFilled(false);
        b.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        b.setForeground(Color.white);
        b.setIconTextGap(-72);
        b.setPreferredSize(new Dimension(110, 40));
    }
    
    public void creaPannelloTesto(JTextArea ta, JScrollPane sp){
        
        ta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        ta.setBackground(new Color(204, 229, 255));
        ta.setForeground(Color.BLACK);
        
        sp.setPreferredSize(new Dimension(600, 400));
        sp.setBackground(Color.white);
        sp.setBorder(new LineBorder(Color.white));
        sp.setVerticalScrollBar(new CustomScrollBar());
        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
    }
}
