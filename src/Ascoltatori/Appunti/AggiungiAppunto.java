/*
* Ascoltatore dedicato al caricamento di un nuovo appunto al corso
* (Sia i dati scritti su database che il file su dropbox)
*/
package Ascoltatori.Appunti;

import Application.Applicazione;
import Grafica.AggiungiAppuntoPanel;
import Grafica.ListaAppuntiPanel;
import Grafica.Grafica;
import Database.ControlloQuery;
import Database.InsertQuery;
import Database.ListeQuery;
import Dropbox.Upload;
import Grafica.GifFrame;
import Utility.Ordina;
import com.dropbox.core.DbxException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiAppunto implements ActionListener{
    
    
    private Applicazione applicazione = Applicazione.getInstance();
    
    //dichiarazione oggetti
    private JTextArea nome;
    private JTextArea descrizione;
    private File file;
    private JButton bottone;
    private JButton botton2;
    private GifFrame gif;
    
    private ListaAppuntiPanel appunti;
    private Upload upload;
    
    //dichiarazioni variabili
    private String percorso, formato, nomeFile;
    private int i;
    
    public AggiungiAppunto(JTextArea nome, JTextArea descrizione, File file, JButton bottone, JButton botton2) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.file = file;
        this.bottone = bottone;
        this.botton2 = botton2;
        this.gif = new GifFrame();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int err = 0;
        Exception ex = new Exception("Eccezione generica");
        
        try {
            
            if((nome.getText().equals(""))||(descrizione.getText().equals("")))         { err = 1; throw ex; }
            if((nome.getText().length()>100)||(descrizione.getText().length()>500))     { err = 2; throw ex; }
            if(ControlloQuery.controlloNomeAppunto(nome.getText()) == false)            { err = 3; throw ex; }
            if(file.length()>21000000)                                                  { err = 4; throw ex; }
            
            bottone.setEnabled(false);
            botton2.setEnabled(false);
            
            gif.apri();
            
            new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            try {
                                InsertQuery.inserisciAppunto(nome.getText(), descrizione.getText());
                                
                                //parte di caricamento file su dropbox
                                percorso = file.getPath();
                                i = percorso.lastIndexOf('.');
                                formato = percorso.substring(i+1);
                                nomeFile = nome.getText()+"."+applicazione.corsoAttuale.getNome()+"."+applicazione.facoltàAttuale.getNome()+"."+formato+"";
                                
                                upload = new Upload(percorso, nomeFile);
                                upload.up();
                                //fine parte caricamento su dropbox
                                
                                if(Upload.uploadOK){
                                    
                                    gif.chiudi();
                                    
                                    JOptionPane.showMessageDialog(null, "Appunto aggiunto correttamente.", "Operazione avvenuta con successo", JOptionPane.INFORMATION_MESSAGE);
                                    
                                    applicazione.svuotaAppunti();
                                    ListeQuery.caricaAppunti();
                                    
                                    Ordina.Appunti();
                                    
                                    applicazione.back.remove(applicazione.back.size()-1);
                                    
                                    appunti = new ListaAppuntiPanel();
                                    Grafica.container.add(appunti, "appunti");
                                    Grafica.card.show(Grafica.container, "appunti");
                                    
                                    AggiungiAppuntoPanel.clearForm();
                                    
                                    bottone.setEnabled(true);
                                    botton2.setEnabled(true);
                                    
                                }
                                
                            } catch (SQLException ex) {
                                gif.chiudi();
                                System.out.println("Errore durante il controllo del nome dell'appunto");
                            } catch (IOException ex) {
                                gif.chiudi();
                                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                            } catch (DbxException ex) {
                                gif.chiudi();
                                JOptionPane.showMessageDialog(null, "Errore durante il caricamento del file dell'appunto", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    },
                    10
            );
            
        }
        
        catch (Exception eccezioni){
            
            switch (err) {
                
                case 1:
                    JOptionPane.showMessageDialog(null, "Nome e/o descrizione non validi", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Nome(max 100 caratteri) e/o Descrizione (max 500 caratteri troppo lunghi)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Un appunto con lo stesso nome è già presente all'interno \ndi '"+applicazione.facoltàAttuale.getNome()+">"+applicazione.corsoAttuale.getNome()+"', verifica "
                            + "che non sia \nlo stesso e riprova cambiando nome.","Impossibile caricare appunto" , JOptionPane.ERROR_MESSAGE);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Il file supera la dimensione massima consentita (max 20Mb)", "Impossibile completare l'operazione", JOptionPane.ERROR_MESSAGE);
                    file.delete();
                    break;
            }
        }
    }
    
}