
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
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
* Ascoltatore dedicato al download di un appunto
* L'utente può selezionare se scaricare il file e basta oppure
* scaricare e aprire il file.
*/
public class DownloadFileAppunto implements ActionListener{
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    private String nome ;
    private String corso ;
    private String facoltà ;
    private String formato = "";
    
    private JButton bottone;
    private JButton bottone2;
    private GifFrame gif;
    
    private Download download;
    private Desktop desktop;
    private File file;
    private String computerUserName ,nomeCompleto;
    private String[] opzioni = new String[] {"Ok", "Apri File"};
    
    public DownloadFileAppunto(JButton bottone, JButton bottone2) {
        
        this.bottone = bottone;
        this.bottone2 = bottone2;
        this.gif = new GifFrame();
        
        nome = applicazione.appuntoAttuale.getNome();
        corso = applicazione.corsoAttuale.getNome();
        facoltà = applicazione.facoltàAttuale.getNome();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        bottone.setEnabled(false);
        bottone2.setEnabled(false);
        
        gif.apri();
        
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        try {
                            
                            download = new Download();
                            formato = download.down();
                            if(Download.downloadOK){
                                
                                gif.chiudi();
                                
                                computerUserName = System.getProperty("user.home");
                                nomeCompleto = nome+"."+corso+"."+facoltà;
                                
                                int risposta = JOptionPane.showOptionDialog(null, "Download correttamente eseguito.\nIl file è stato salvato nella tua cartella \ndei Download  "
                                        + "("+computerUserName+"\\Downloads)", "Operazione avvenuta con successo", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                                        null, opzioni, opzioni[0]);
                                
                                if(risposta==1){
                                    desktop = Desktop.getDesktop();
                                    file = new File(computerUserName+"\\Downloads\\"+nome+""+formato+"");
                                    desktop.open(file);
                                }
                                
                                bottone.setEnabled(true);
                                bottone2.setEnabled(true);
                            }
                        } catch (IOException ex) {
                            gif.chiudi();
                            JOptionPane.showMessageDialog(null, "Errore durante il download del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        } catch (DbxException ex) {
                            gif.chiudi();
                            JOptionPane.showMessageDialog(null, "Errore durante il download del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                },
                10
        );
        
    }
    
}
