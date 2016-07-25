/*
* Ascoltatore dedicato alla modifica del numero di like di una risposta
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.InfoQuery;
import QeA.Vista.DomandaPanel;
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
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JLabel j1 ,j2;
    private JButton likeRisposta;
    private JButton dislikeRisposta;
    
    //dichiarazione variabili
    private int id;
    private String nomeBottone = "";
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
            nomeBottone = button.getName();
        }
        
        String nome = nomeBottone;
        try {
            valoreLike = ControlloQuery.controlloLikeRisposta(applicazione.listaRisposteAttuali.get(indice).getId());
        } catch (SQLException ex) {
            Logger.getLogger(DomandaPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        int valore = 0;
        
        //************************
        if(nome.equals("like")){
            valore = 1;
            if(valoreLike==0){
                likeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbupON.png")));
            }else{
                if(valoreLike==1){
                    likeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbup.png")));
                }else{
                    likeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbupON.png")));
                    dislikeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbdown.png")));
                }
            }
        }
        if(nome.equals("dislike")){
            valore = -1;
            if(valoreLike==0){
                dislikeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbdownON.png")));
            }else{
                if(valoreLike==-1){
                    dislikeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbdown.png")));
                }else{
                    likeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbup.png")));
                    dislikeRisposta.setIcon(new ImageIcon(getClass().getResource("/immagini/thumbdownON.png")));
                }
            }
        }
        //************************
        
        try {
            ControlloQuery.controlloLikeRisposta(id, valore);
            
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
