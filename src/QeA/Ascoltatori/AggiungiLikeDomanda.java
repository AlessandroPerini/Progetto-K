/*
* Ascoltatore dedicato alla modifica del numero di like della domanda attuale
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.DeleteQuery;
import Database.Query.InsertQuery;
import Database.Query.ListeQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class AggiungiLikeDomanda implements ActionListener{
    
    //dichiarazione oggetti
    private JButton like;
    private JLabel Nlike;
    
    public AggiungiLikeDomanda(JButton like, JLabel Nlike) {
        this.like = like;
        this.Nlike = Nlike;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        try {
            
            if(!ControlloQuery.controlloLikeDomanda()){
                    
                DeleteQuery.decrementaLikeDomanda();
                DeleteQuery.eliminaLikeDomanda();
                Applicazione.domandaAttuale.setLike(Applicazione.domandaAttuale.getLike()-1);
                Nlike.setText(Applicazione.domandaAttuale.getLike()+" likes");
                like.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbup.png")));
                
            }else{
                
                InsertQuery.inserisciLikeDomanda();
                InsertQuery.updateLikeDomanda();
                Applicazione.domandaAttuale.setLike(Applicazione.domandaAttuale.getLike()+1);
                Nlike.setText(Applicazione.domandaAttuale.getLike()+" likes");
                like.setIcon(new ImageIcon(this.getClass().getResource("/immagini/thumbupON.png")));
            }
           
            Applicazione.svuotaRisposte();
            
            ListeQuery.caricaRisposteDomanda();
            Grafica.container.add(GoToDomanda.getDomanda(), "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante l'aggiunta del like", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
