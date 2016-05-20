/*
* Questa classe non è altro che il Main del progetto, lo starter, ciò 
* che fa partire il controller e la grafica.
*/
package Application.Creator;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;


/**
 *
 * @author te4o
 */
public class Starter {

    public static void main(String[] args) {
        
        new Applicazione();
        new Grafica();

    }
}


