package negocio;    

import conexion.Conecta;
import conexion.Interfase;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_bloqueo {

    Conecta conexion = new Conecta();
    Interfase interfase = new Interfase();
    String id;
    String existe;
    String area;
    float valor;
    String aprob1;
    String aprob2;
    String aprob3;
    String aprob4;
    String esdo;
    String idmaeedo;
    String tido;
    String nudo;
    String endo;
    String feemdo;
    String kofudo;
    String modo;
    String tamodo;
    float vabrdo;
    String lahora;
    String horagrab;
    String suendo;
    String cpdo;
    String feer;
    String endofi;
    String vanedo;
    String vaivdo;
    String tramoMIN;
    String tramoMAX;
    String user;

    public ResultSet ver() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String query = "SELECT TOP(1)NUDO FROM MAEEDO WITH (NOLOCK) WHERE TIDO = 'OCC' AND NUDO LIKE '0%' AND FEEMDO BETWEEN '20170101 00:00:00' and '20171231 23:59:59' ORDER BY NUDO DESC";
    ResultSet rs = conexion.consultas(query);
    return (rs);
    }
    public void id() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String a = "SELECT TOP(1)IDMAEEDO FROM MAEEDO WITH (NOLOCK) WHERE TIDO = 'OCC' AND NUDO LIKE '0%' AND FEEMDO BETWEEN '20170101 00:00:00' and '20171231 23:59:59' ORDER BY NUDO DESC";
    ResultSet rs = conexion.consultas(a);
    while (rs.next()) {
    this.id = rs.getString(1);}}
    public void area() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String b = "SELECT KOCARAC FROM MEVENTO WITH (NOLOCK) WHERE IDRVE = "+id+"";
    ResultSet rs = conexion.consultas(b);
    while (rs.next()) {
    this.area = rs.getString(1);}}
    public void valor() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String c = "SELECT VABRDO FROM MAEEDO WITH (NOLOCK) WHERE IDMAEEDO = "+id+" AND TIDO = 'OCC' AND NUDO LIKE '0%'";
    ResultSet rs = conexion.consultas(c);
    while (rs.next()) {
    this.valor = rs.getFloat(1);}}
    public void query() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String d = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,FEEMDO,KOFUDO,MODO,TAMODO,VABRDO,LAHORA,HORAGRAB,SUENDO,ENDOFI,FEER,VANEDO,VAIVDO "
            + "FROM MAEEDO WITH (NOLOCK) WHERE IDMAEEDO = "+id+" AND TIDO = 'OCC' AND NUDO LIKE '0%'";
    ResultSet rs = conexion.consultas(d);
    while (rs.next()) {
    this.idmaeedo = rs.getString(1);
    this.tido = rs.getString(2);
    this.nudo = rs.getString(3);
    this.endo = rs.getString(4);
    this.feemdo = rs.getString(5);
    this.kofudo = rs.getString(6);
    this.modo = rs.getString(7);
    this.tamodo = rs.getString(8);
    this.vabrdo = rs.getFloat(9);
    this.lahora = rs.getString(10);
    this.horagrab = rs.getString(11);
    this.suendo = rs.getString(12);
    this.feer = rs.getString(13);
    this.endofi = rs.getString(14);
    this.vanedo = rs.getString(15);
    this.vaivdo = rs.getString(16);
    }}
    
    public void cpdo() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String d = "SELECT CPDO FROM MAEEDOOB WITH (NOLOCK) "
            + "WHERE IDMAEEDO = '"+id+"'";
    ResultSet rs = conexion.consultas(d);
    while (rs.next()) {
    this.cpdo = rs.getString(1);
    }}
    public void esdo() throws SQLException, ClassNotFoundException {
    conexion.conexion();
    String d = "SELECT ESDO FROM MAEEDO WITH (NOLOCK) "
            + "WHERE IDMAEEDO = "+id+" AND TIDO = 'OCC' AND NUDO LIKE '0%'";
    ResultSet rs = conexion.consultas(d);
    while (rs.next()) {
    this.esdo = rs.getString(1);}}
    public void existe() throws SQLException, ClassNotFoundException {
    interfase.conInterface();
    String e = "SELECT IDMAEEDO FROM APROBADOR WITH (NOLOCK) WHERE IDMAEEDO = "+id+" AND TIDO = 'OCC' AND NUDO LIKE '0%'";
    ResultSet rs = interfase.consultas(e);
    while (rs.next()) {
    this.existe = rs.getString(1);}}
    
    public void insertAprob() throws SQLException, ClassNotFoundException{
    interfase.conInterface(); 
    String query = "INSERT INTO APROBADOR(IDMAEEDO) "
                 + "VALUES ("+id+")";
    interfase.acciones(query);
    interfase.cerrarConexion();
    }
    public void updateAprob() throws SQLException, ClassNotFoundException{
    interfase.conInterface();
    int v = (int) Math.ceil(vabrdo);
    String a = "UPDATE APROBADOR SET TIDO = '"+tido+"' WHERE IDMAEEDO = "+id+"";
    String b = "UPDATE APROBADOR SET NUDO = '"+nudo+"' WHERE IDMAEEDO = "+id+"";
    String c = "UPDATE APROBADOR SET ENDO = '"+endo+"' WHERE IDMAEEDO = "+id+"";
    String d = "UPDATE APROBADOR SET FEEMDO = '"+feemdo+"' WHERE IDMAEEDO = "+id+"";
    String e = "UPDATE APROBADOR SET KOFUDO = '"+kofudo+"' WHERE IDMAEEDO = "+id+"";
    String f = "UPDATE APROBADOR SET ESDO = 'c' WHERE IDMAEEDO = "+id+"";
    String g = "UPDATE APROBADOR SET MODO = '"+modo+"' WHERE IDMAEEDO = "+id+"";
    String h = "UPDATE APROBADOR SET TAMODO = '"+tamodo+"' WHERE IDMAEEDO = "+id+"";
    String i = "UPDATE APROBADOR SET VABRDO = '"+v+"' WHERE IDMAEEDO = "+id+"";
    String j = "UPDATE APROBADOR SET LAHORA = '"+lahora+"' WHERE IDMAEEDO = "+id+"";
    String k = "UPDATE APROBADOR SET HORAGRAB = '"+horagrab+"' WHERE IDMAEEDO = "+id+"";
    String l = "UPDATE APROBADOR SET APROBADO = '1' WHERE IDMAEEDO = "+id+"";
    String m = "UPDATE APROBADOR SET SUENDO = '"+suendo+"' WHERE IDMAEEDO = "+id+"";
    String n = "UPDATE APROBADOR SET ENDOFI = '"+endofi+"' WHERE IDMAEEDO = "+id+"";
    String o = "UPDATE APROBADOR SET CPDO = '"+cpdo+"' WHERE IDMAEEDO = "+id+"";
    String p = "UPDATE APROBADOR SET FEER = '"+feer+"' WHERE IDMAEEDO = "+id+"";
    String q = "UPDATE APROBADOR SET VANEDO = '"+vanedo+"' WHERE IDMAEEDO = "+id+"";
    String r = "UPDATE APROBADOR SET VAIVDO = '"+vaivdo+" WHERE IDMAEEDO = "+id+"";
    
    interfase.acciones(a);
    interfase.acciones(b);
    interfase.acciones(c);
    interfase.acciones(d);
    interfase.acciones(e);
    interfase.acciones(f);
    interfase.acciones(g);
    interfase.acciones(h);
    interfase.acciones(i);
    interfase.acciones(j);
    interfase.acciones(k);
    interfase.acciones(l);
    interfase.acciones(m);
    interfase.acciones(n);
    interfase.acciones(o);
    interfase.acciones(p);
    interfase.acciones(q);
    interfase.acciones(r);
    interfase.cerrarConexion();
    }
    public void updateMaeedo() throws SQLException, ClassNotFoundException{
    conexion.conexion();
    String query = "UPDATE MAEEDO SET ESDO = 'c' WHERE IDMAEEDO = "+id+" AND TIDO = 'OCC' AND NUDO LIKE '0%'";
    conexion.acciones(query);
    conexion.cerrarConexion();
    }
    public void tramoMIN(int t) throws SQLException, ClassNotFoundException {
    interfase.conInterface();
    String h = "SELECT RANGOMIN FROM RANGO WHERE TRAMO = '"+t+"'";
    ResultSet rs = interfase.consultas(h);
    while (rs.next()) {
    this.tramoMIN = rs.getString(1);}}
    public void tramoMAX(int t) throws SQLException, ClassNotFoundException {
    interfase.conInterface();
    String h = "SELECT RANGOMAX FROM RANGO WHERE TRAMO = '"+t+"'";
    ResultSet rs = interfase.consultas(h);
    while (rs.next()) {
    this.tramoMAX = rs.getString(1);}}
    public void user(int t) throws SQLException, ClassNotFoundException {
    interfase.conInterface();
    String h = "SELECT B.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.ACTIVO <> '0' AND A.CODIGO = '"+t+"'";
    ResultSet rs = interfase.consultas(h);
    while (rs.next()) {
    this.user = rs.getString(1);}}
    public void updatePR() throws SQLException, ClassNotFoundException{
    interfase.conInterface();
    String pal = "UPDATE APROBADOR SET APROB1 = 'PAL', E1 = '1' WHERE IDMAEEDO = "+id+"";
    String rlv = "UPDATE APROBADOR SET APROB2 = 'RLV', E2 = '1' WHERE IDMAEEDO = "+id+"";
    interfase.acciones(pal);
    interfase.acciones(rlv);
    interfase.cerrarConexion();
    }
    public void updateAprobador(String user, int i) throws SQLException, ClassNotFoundException{
    interfase.conInterface();
    String query = "UPDATE APROBADOR SET APROB"+i+" = '"+user+"', E"+i+" = '1' WHERE IDMAEEDO = "+id+"";
    interfase.acciones(query);
    interfase.cerrarConexion();
    }
      
    public void ocRecibida() throws SQLException, ClassNotFoundException {
    try{
        id();
        query();
        cpdo();
        esdo();
        if (" ".equals(esdo)) {
            existe();
            if (id.equals(existe)) {
                System.out.println("APROBADA");
            }else{
                insertAprob();
                updateAprob();
                updateMaeedo();
                area();
                valor();
                if ("ARENTAL   ".equals(area) || "ATALLER   ".equals(area)) {
                    int[] depto = {1,2,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR
                    int v = (int) Math.ceil(valor);
                    for (int i = 0; i < depto.length; i++) {
                        tramoMIN(i+1);
                        tramoMAX(i+1);
                        if (Integer.parseInt(tramoMIN)<=(v)){
                            if (Integer.parseInt(tramoMAX)<=(v)){
                                if ((depto[i]) == 1){
                                    user(depto[i]);
                                    updateAprobador(user,i+1);
                                    i = i+1;
                                    user(depto[i]);
                                    updateAprobador(user,i+1);
                                }
                                else{
                                    user(depto[i]);
                                    updateAprobador(user,i+1);
                                }
                            }
                            else{
                                if (Integer.parseInt(tramoMAX)>(v)){
                                    if ((depto[i]) == 1){
                                        user(depto[i]);
                                        updateAprobador(user,i+1);
                                        i = i+1;
                                        user(depto[i]);
                                        updateAprobador(user,i+1);
                                    }
                                    else{
                                        user(depto[i]);
                                        updateAprobador(user,i+1);
                                    }
                                }
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
                else{
                    int[] depto = {1,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR
                    int v = (int) Math.ceil(valor);
                    for (int i = 0; i < depto.length; i++) {
                        tramoMIN(i+1);
                        tramoMAX(i+1);
                        if (Integer.parseInt(tramoMIN)<=(v)){
                            if (Integer.parseInt(tramoMAX)<=(v)){
                                if ((depto[i]) == 1){
                                    user(depto[i]);
                                    updateAprobador(user,i+1);
                                }
                                else{
                                    user(depto[i]);
                                    updateAprobador(user,i+1);
                                }
                            }
                            else{
                                if (Integer.parseInt(tramoMAX)>(v)){
                                    if ((depto[i]) == 1){
                                        user(depto[i]);
                                        updateAprobador(user,i+1);
                                    }
                                    else{
                                        user(depto[i]);
                                        updateAprobador(user,i+1);
                                    }
                                }
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }else{
            System.out.println("RECHAZADA O EN PROCESO");
        }
        }catch(NumberFormatException ex){
            System.err.println(ex + " Ilegal input");
        }
    }

}
