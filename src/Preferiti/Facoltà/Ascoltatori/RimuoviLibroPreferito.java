/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Preferiti.Facoltà.Ascoltatori;

import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Appunti.Vista.AppuntoPanel;
import Database.Query.DeleteQuery;
import Libri.Vista.LibroPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Te4o
 */
public class RimuoviLibroPreferito implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery.eliminaLibroPreferito();
        
        Applicazione.preferiti.getLibriPreferiti().remove(Applicazione.libroAttuale);
        
        LibroPanel libro = new LibroPanel();
        Grafica.container.add(libro, "libro");
        Grafica.card.show(Grafica.container, "libro");
    }
}
