/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
            DbConnection = (Connection) DriverManager.getConnection("jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7114898","sql7114898","RC4ZIQMDHd");
            System.out.println("Database Connected");
        }catch(SQLException se){
            System.out.println("No Database "+ se);
            
        }
        return DbConnection;
    }
    
}
