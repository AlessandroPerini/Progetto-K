
package Application.Creator;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import javax.swing.JOptionPane;


/**
 * Questa classe non è altro che il Main del progetto, lo starter, ciò che crea
 * le istanze della grafica e di Applicazione. Poiche quest'ultima è singleton
 * tramite il metodo getInstance viene creata la prima ed unica instanza di Applicazione.
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


