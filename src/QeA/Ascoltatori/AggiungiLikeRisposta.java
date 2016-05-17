/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.InfoQuery;
import QeA.Vista.DomandaPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author danie
 */
public class AggiungiLikeRisposta implements MouseListener{
    
    private int id;
    private JLabel j1 ,j2;
    private JButton likeRisposta;
    private JButton dislikeRisposta;
    private String text = "";
    private int indice;
    private int valoreLike;
    public AggiungiLikeRisposta (int indice, int id, JLabel j1, JLabel j2, JButton likeRisposta, JButton dislikeRisposta){
        this.id = id;
        this.j1=j1;
        this.j2=j2;
        this.likeRisposta = likeRisposta;
        this.dislikeRisposta = dislikeRisposta;
        this.indice = indice;
    }
    @Override
    public void mouseClicked(MouseEvent e){
        
        if(e.getComponent() instanceof JButton) {
            JButton button = (JButton)e.getComponent();
            text = button.getName();
        }
        
        String nome = text;
         try {
            valoreLike = ControlloQuery.controlloLikeRisposta(Applicazione.listaRisposteAttuali.get(indice).getId());
        } catch (SQLException ex) {
            Logger.getLogger(DomandaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int valore = 0;
       //******************************
       if(nome.equals("like")){
            valore = 1;
            System.out.println(valoreLike);
            if(valoreLike==0){
                likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbupON.png")));
            }else{
                if(valoreLike==1){
                    likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
                }else{
                   likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbupON.png")));  
                dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdown.png"))); 
                }
            }
       }
        if(nome.equals("dislike")){
            valore = -1;
            System.out.println(valoreLike);
            if(valoreLike==0){
                dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdownON.png")));
            }else{
                if(valoreLike==-1){
                    dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdown.png")));
                }else{
                   likeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
               dislikeRisposta.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbdownON.png")));
                }
            }
       }
       
       //*******************
        
       
       
     
        try {
            ControlloQuery.controlloLike(id, valore);
            
            j1.setText(""+InfoQuery.likeRisposta(id, 1));
            
            j2.setText(""+InfoQuery.likeRisposta(id,-1));
            Grafica.container.add(GoToDomanda.getDomanda(), "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            System.out.println("Errore durante il controllo del like della risposta");
            
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
