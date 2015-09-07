
package ejemplojdbc;

/**
 *
 * @author Julio
 */

import java.sql.*;//importo todo
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EjemploJDBC {

    public static void main(String[] args) {
        
            String user= "root";//local
            String pasword="1036661631";//local
            String user2= "juliocanchala";//internet
            String pasword2="1036661631";//internet
            
        try {    
            System.out.println("Intentando conectar a la base de datos..");
            Class.forName("com.mysql.jdbc.Driver");            
            
           // Connection con=DriverManager.getConnection("jdbc:mysql://localhost/contactos",user,pasword);
            Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net/contactosjc",user2,pasword2);//para internet
            
            
            System.out.println("Conexion exitosa...");
            
        } catch (SQLException ex) {
            System.out.println("Error de mysql");
        }
         catch (Exception e) {
            System.out.println("Se ha encontrado un error: "+ e.getMessage());
        }
        
        
        
    }
    
}
