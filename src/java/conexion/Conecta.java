package conexion;

import java.sql.*;

public class Conecta {
    
    Connection conexion; //Variable para hacer las conexiones
    Statement stmt;//Variable para ejecutar las Querys
    
   //Hace la conexion con los drivers y la base de datos.
   public void conexion() throws SQLException, ClassNotFoundException{
       System.out.println("Registro del driver. Conecta");
       //Registro del driver     
       try {
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       //Variables para la conexión
       String db = "SUBTERRA_CLASE";
       String user = "SUBTERRA";
       String pass = "SUBTERRA";
       String url = "jdbc:sqlserver://SERVERST:1433;databaseName=" + db + ";user=" + user + ";password=" + pass;
       //Apertura de la conexión
       conexion = DriverManager.getConnection (url);
       // Se crea un Statement, para realizar consultas
       stmt = conexion.createStatement();
       } catch (Exception e) {
           System.out.println("error al conectar "+e);
       }
   }
   
   //Cierra el STATEMENT y la Conexion
   public void cerrarConexion(){
       try{
       stmt.close();
       conexion.close();
       }catch(Exception e){
       }}

   //PARA LOS SELECTS
   public ResultSet consultas(String query) throws SQLException{
       try{
            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = stmt.executeQuery(query);
            return rs;
       }catch(Exception e){
           return null;}
       
   }

   //PARA LOS UPDATES
   public void acciones(String query) throws SQLException{
       try{
            stmt.execute(query);
       }catch(Exception e){}
    }

}
