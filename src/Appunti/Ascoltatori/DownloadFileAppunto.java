/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Dropbox.Download;
import Frame.GifFrame;
import com.dropbox.core.DbxException;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Te4o
 */
public class DownloadFileAppunto implements ActionListener{

    private String nome = Applicazione.appuntoAttuale.getNome();
    private String corso = Applicazione.corsoAttuale.getNome();
    private String facoltà = Applicazione.facoltàAttuale.getNome();
    private String formato = "";
    private JButton bottone;
    private JButton bottone2;
    
    public DownloadFileAppunto(JButton bottone, JButton bottone2) {
        this.bottone = bottone;
        this.bottone2 = bottone2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        bottone.setEnabled(false);
        bottone2.setEnabled(false);
        
        GifFrame.apri();
        
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            
                            Download download = new Download();
                            formato = download.down();
                            if(Download.downloadOK){
                                
                                GifFrame.chiudi();
                                
                                String computerUserName = System.getProperty("user.home");
                                String nomeCompleto = nome+"."+corso+"."+facoltà;
                                
                                String[] opzioni = new String[] {"Ok", "Apri File"};
                                
                                int risposta = JOptionPane.showOptionDialog(null, "Download correttamente eseguito.\nIl file è stato salvato nella tua cartella \ndei Download  "
                                        + "("+computerUserName+"\\Downloads)", "Operazione avvenuta con successo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                        null, opzioni, opzioni[0]);
                                
                                if(risposta==1){
                                    Desktop desktop = Desktop.getDesktop();
                                    File file = new File(computerUserName+"\\Downloads\\"+nome+""+formato+"");
                                    desktop.open(file);
                                }
                                
                                bottone.setEnabled(true);
                                bottone2.setEnabled(true);
                            }
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(null, "Errore durante il download del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        } catch (DbxException ex) {
                            JOptionPane.showMessageDialog(null, "Errore durante il download del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                },
                10
        );
        
    }
    
}
