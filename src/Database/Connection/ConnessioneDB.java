
package Database.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
* Classe che effettua la connessione al nostro server MySql e ritorna una variabile di tipo Conneciton
* 
*/
public class ConnessioneDB {
    
    private static ConnessioneDB instance;
    
    private ConnessioneDB(){
    }
    
    /**
     * Assicura che la classe sia singleton.
     * Se la classe non è ancora stata istanziata, il metodo crea l'istanza e la restituisce.
     * Se invece l'istanza è gia stata creata, la restituisce semplicemente.
     * 
     */
    public static synchronized ConnessioneDB getInstance(){
    
        if(instance == null){ 
            instance = new ConnessioneDB(); }
        return instance;
    }
    
    /**
     * Effettua effetivamente la connessione usando il driver jdbc mysql al nostro database
     * tramite il link: jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898
     * 
     * @throws Exception 
     */
    public Connection connect() throws Exception{
        
        Connection connessione = null;
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Connection Success");
        }
        catch(ClassNotFoundException cnfe){
            
            System.out.println("Connection Failed"+ cnfe);
        }
        
        try {
            //effettua la connessione al server freemysqlhosting.net con i nostri dati di accesso
            connessione = (Connection) DriverManager.getConnection("jdbc:mysql://sql2.freemysqlhosting.net:3306/sql2227273","sql2227273","dB4%qG1!");
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.out.println("Impossible to connect to the database");
            throw new Exception();
        }
            
        return connessione;
    }
    
}
