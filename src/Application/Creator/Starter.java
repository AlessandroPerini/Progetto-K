/*
* Questa classe non è altro che il Main del progetto, lo starter, ciò 
* che fa partire la grafica.
*/
package Application.Creator;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import javax.swing.JOptionPane;


/**
 *
 * @author te4o
 */
public class Starter {

    public static void main(String[] args) {
        
        Applicazione applicazione = Applicazione.getInstance();
        Grafica grafica = new Grafica();
        
        if(applicazione.erroreConnessione){
           JOptionPane.showMessageDialog(null, "Verificare la propria connessione internet e riavviare l'applicazione", "Errore di rete", JOptionPane.ERROR_MESSAGE);
           grafica.chiudi();
        }
    }
}


