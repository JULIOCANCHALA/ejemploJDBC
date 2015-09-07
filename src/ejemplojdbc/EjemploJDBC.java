
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
            
            Scanner teclado=new Scanner(System.in);

            
        try {    
            System.out.println("Intentando conectar a la base de datos..");
            Class.forName("com.mysql.jdbc.Driver");            
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/contactos",user,pasword);
            //Connection con=DriverManager.getConnection("jdbc:mysql://db4free.net/contactosjc",user2,pasword2);//para internet      
            System.out.println("Conexion exitosa...");
            
            Statement estado=con.createStatement(); //
            
            //Cargar todos los contactos
            System.out.println("Imprecion de tabla:");
            ResultSet resultado=estado.executeQuery("SELECT * FROM `clientes`");//traemos la tabla 
            
            while (resultado.next())
            {//imprime todas las casillas de la tabla
                System.out.println(resultado.getString("id")+ "\t" +resultado.getString("nombre")
                +"\t"+resultado.getString("apellido")+"\t"+resultado.getString("telefono"));
            }
            
            //buscar por nombre
            System.out.println("\t\t");
            
            System.out.println("Busqueda por Nombre:");
            System.out.println("Digite el nombre a buscar:");
            String nombre=teclado.nextLine();
            
            
            //resultado=estado.executeQuery("SELECT * FROM `clientes` WHERE `nombre` LIKE 'luis'");
            resultado=estado.executeQuery("SELECT * FROM `clientes` WHERE `nombre` LIKE '"+nombre+"'");//se tiene qe concatenar la varibale +"nombre"+
            while (resultado.next())
            {//imprime todas las casillas de la tabla
                System.out.println(resultado.getString("id")+ "\t" +resultado.getString("nombre")
                +"\t\t"+resultado.getString("apellido")+"\t"+resultado.getString("telefono"));
            }
            
            //Ingresar contacto
            System.out.println("Digite el nombre: ");
            nombre=teclado.nextLine();
            System.out.println("Digite el apellido: ");
            String apellido=teclado.nextLine();
            System.out.println("Digite el telefono: ");
            String telefono=teclado.nextLine();
            estado.executeUpdate("INSERT INTO `clientes` VALUES (NULL, '"+nombre+"', '"+apellido+"', '"+telefono+"')");
            
            System.out.println("Cliente Agregado con exito");
            
            //Borrar  contacto
            System.out.println("Digite el nombre: ");
            nombre=teclado.nextLine();
            
            estado.executeUpdate("DELETE FROM `clientes` WHERE `nombre` LIKE '"+nombre+"'");
            
            
        } catch (SQLException ex) {//error en la sintaxis de mysql
            System.out.println("Error de mysql");
        }
         catch (Exception e) {//cualquier otro error
            System.out.println("Se ha encontrado un error: "+ e.getMessage());
        }
        
        
        
    }
    
}
