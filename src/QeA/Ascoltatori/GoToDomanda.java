/*
* Ascoltatore dedicato all'apertura della domanda selezionata
* In base alla domanda selezionata, al corso e alla facoltà viene mandata in 
* esecuzione una query che carica i dati relativi a tale appunto
* e vengono visualizzati in un pannello
*/
package QeA.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.InfoQuery;
import Database.Query.ListeQuery;
import QeA.Vista.DomandaPanel;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class GoToDomanda implements MouseListener{
    
    public Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione variabili
    private String nomeDomanda;
    private String corso;
    private String facoltà;
    private JLabel domande;
    
    private static DomandaPanel domanda;
    
    public GoToDomanda(String corso, String facoltà, JLabel domande) {
        this.corso = corso;
        this.facoltà = facoltà;
        this.domande = domande;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        applicazione.back.add("domanda");
        
        JLabel label = (JLabel)e.getComponent();
        nomeDomanda = label.getText();
        
        String parts[] = nomeDomanda.split("          ");
        nomeDomanda = parts[0];
        
        applicazione.domandaAttuale.setTitolo(nomeDomanda);
        
        try {
            InfoQuery.caricaInfoDomanda(corso, facoltà);
            
            applicazione.facoltàAttuale.setNome(facoltà);
            applicazione.corsoAttuale.setNome(corso);
            
            ListeQuery.caricaRisposteDomanda();
            
            domanda = new DomandaPanel();
            
            Grafica.container.add(domanda, "domanda");
            Grafica.card.show(Grafica.container, "domanda");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei dati", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
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
        domande.setForeground(new Color(3,201,169));
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        domande.setForeground(null);
    }
    
    public static DomandaPanel getDomanda() {
        return domanda;
    }
    
    
}
