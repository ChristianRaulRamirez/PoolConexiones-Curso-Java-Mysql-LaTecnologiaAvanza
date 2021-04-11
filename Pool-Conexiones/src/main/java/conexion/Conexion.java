package conexion;
import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.*;
public class Conexion{
 
    private Conexion(){
        
    }
    
     private static final String URL = "jdbc:mysql://localhost/control_clientes";
     private static final String USER = "root";
     private static final String PASSWORD = "admin";
     private static Conexion instancia;
     
     
     public DataSource obtenerFuenteDeDatos(){
         BasicDataSource datos = new BasicDataSource();
         datos.setUrl(URL); // url de la base de datos
         datos.setUsername(USER); // usuario de la base de datos
         datos.setPassword(PASSWORD); // contraseña de la base de datos
         datos.setInitialSize(50); //tamaño de conexiones a la base de datos
         return datos;
     }
     
     public Connection conectar() throws SQLException{
           return obtenerFuenteDeDatos().getConnection();
     }
     
     public void desconectar(Connection conexion){
         try{
               conexion.close();
         }catch(SQLException error){
             System.out.println(error);
         }
     }
     
     public void cerrarResultSet(ResultSet resultado){
         try{
             resultado.close();
         }catch(SQLException error){
             System.out.println(error);
         }
     }
     
     public void cerrarStatement(PreparedStatement statement){
         try{
             statement.close();
         }catch(SQLException error){
             System.out.println(error);
         }
     }
     
     public static Conexion getInstance(){
         if(instancia == null){
             instancia = new Conexion();
         }
         return instancia;
     }
}