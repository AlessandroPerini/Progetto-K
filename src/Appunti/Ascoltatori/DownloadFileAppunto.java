/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package Appunti.Ascoltatori;

import Application.Controller.Applicazione;
import Dropbox.Download;
import com.dropbox.core.DbxException;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private JFrame loadingFrame;
    private String nome = Applicazione.appuntoAttuale.getNome();
    private String corso = Applicazione.corsoAttuale.getNome();
    private String facoltà = Applicazione.facoltàAttuale.getNome();
    private String formato = "";
    private JButton bottone;

    public DownloadFileAppunto(JButton bottone) {
        this.bottone = bottone;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        bottone.setEnabled(false);
        
        loadingFrame();
        
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            
                            Download download = new Download();
                            formato = download.down();
                            if(Download.downloadOK){
                                
                                loadingFrame.setVisible(false);
                                
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
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(DownloadFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (DbxException ex) {
                            Logger.getLogger(DownloadFileAppunto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                },
                10
        );
        
    }
    
    public void loadingFrame(){
                
        loadingFrame = new JFrame("Loading ...");
        loadingFrame.setLocation(650, 300);
        
        ImageIcon loading = new ImageIcon("files\\immagini\\loading.gif");
        loadingFrame.add(new JLabel("", loading, JLabel.CENTER));
        
        loadingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loadingFrame.setSize(300, 300);
        
        loadingFrame.setVisible(true);
    }
}
