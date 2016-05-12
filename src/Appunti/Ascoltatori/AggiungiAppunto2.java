/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Ascoltatori;

import Database.Query.ControlloQuery;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiAppunto2 {
    
    private JTextArea nome;
    private JTextArea descrizione;
    private File file;
    private JButton bottone;
    private JButton botton2;

    public AggiungiAppunto2(JTextArea nome, JTextArea descrizione, File file, JButton bottone, JButton botton2) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.file = file;
        this.bottone = bottone;
        this.botton2 = botton2;
    }
    
        public void actionPerformed(ActionEvent e) {
        
            int err = 0;
            Exception ex = new Exception();
            
            try {
                
                if((nome.getText().equals(""))||(descrizione.getText().equals("")))         { err = 1; throw ex; }
                if((nome.getText().length()>100)||(descrizione.getText().length()>500))     { err = 2; throw ex; }
                if(ControlloQuery.controlloNomeAppunto(nome.getText()) == false)            { err = 3; throw ex; }
                if(file.length()>21000000)                                                  { err = 4; throw ex; }
                
            } catch (Exception ex1) {     }   
            
        }
}
