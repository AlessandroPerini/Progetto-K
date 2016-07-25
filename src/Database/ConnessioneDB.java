/*
* Classe che effettua la connessione al nostro server MySql e ritorna una variabile di tipo Conneciton
*/
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author te4o
 */
public class ConnessioneDB {
    
    private static ConnessioneDB instance;
    
    private ConnessioneDB(){
    }
    
    public static synchronized ConnessioneDB getInstance(){
    
        if(instance == null){ 
            instance = new ConnessioneDB(); }
        return instance;
    }
    
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
            connessione = (Connection) DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898","sql7114898","RC4ZIQMDHd");
            System.out.println("Database Connected");
        } catch (SQLException ex) {
            System.out.println("Impossible to connect jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898");
            throw new Exception();
        }
            
        return connessione;
    }
    
}
