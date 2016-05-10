/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package QeA.Ascoltatori;

import Application.Vista.Grafica;
import Database.Query.ControlloQuery;
import Database.Query.InfoQuery;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author danie
 */
public class AggiungiLikeRisposta implements ActionListener{
    private int id;
    private JLabel j1 ,j2;
    
    public AggiungiLikeRisposta (int id,JLabel j1,JLabel j2){
        this.id = id;
        this.j1=j1;
        this.j2=j2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = e.getActionCommand();
        int valore = 0;
        
        if(nome.equals("Like")){
            valore = 1;
            
        }else{
            valore = -1;
        }
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
    
    
}
