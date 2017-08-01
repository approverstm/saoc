/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import conexion.Interfase;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_apagar {
    
    Interfase interfase = new Interfase();
    String e = "";

    public String getE() {
        return e;
    }
    
    public void interruptor(String i) throws SQLException, ClassNotFoundException{
        System.out.println("INTERRUPTOR");
        interfase.conInterface();
        String query = "UPDATE USUARIO SET ACTIVO = '"+i+"' WHERE CODIGO = 'ADM'";
        interfase.acciones(query);
        interfase.cerrarConexion();
    }
    
    public void verEstado() throws SQLException, ClassNotFoundException {
    interfase.conInterface();
    String query = "SELECT ACTIVO FROM USUARIO WHERE CODIGO = 'ADM'";
    ResultSet rs = interfase.consultas(query);
    while(rs.next()){
       e = rs.getString(1);
    }}
    
}
