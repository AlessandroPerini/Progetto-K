/*
* Classe che effettua la connessione al nostro server MySql e ritorna una variabile di tipo Conneciton
*/
package Database.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author te4o
 */
public class ConnessioneDB {
    
    //dichiarazione variabili
    private Connection DbConnection;
    
    public Connection connect(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection Success");
        }
        catch(ClassNotFoundException cnfe){
            
            System.out.println("Connection Fail"+ cnfe);
        }
        
        try{
            //effettua la connessione al server freemysqlhosting.net con i nostri dati di accesso
            DbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898","sql7114898","RC4ZIQMDHd");
            System.out.println("Database Connected");
        }catch(SQLException se){
            
            System.out.println("No Database "+ se);
            
        }
        return DbConnection;
    }
    
}
