/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Creator;

import Application.Controller.Applicazione;
import Frame.MainFrame;
import Login.LoginPanel;
import Application.Vista.Grafica;
import java.awt.CardLayout;
import javax.swing.JPanel;


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


