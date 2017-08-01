package negocio;

import conexion.Conecta;
import conexion.Interfase;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_aprobador {
    Conecta conexion = new Conecta();
    Interfase interfase = new Interfase();
    
    String codigo;
    String pass;
    
    String estado;
    String id;
    String area;
    float valor;
    String aprob1;
    String aprob2;
    String aprob3;
    String aprob4;
    
    String idmaeedo;
    String tido;
    String nudo;
    String endo;
    String suendo;
    String feemdo;
    String cpdo;
    String feer;
    String endofi;
    String modo;
    String vanedo;
    String vaivdo;
    String vabrdo;
    
    String rten;
    String nokoen;
    String dien;
    String foen;
    String faen;
    
    String de;
    String tramo;

    public String getIdmaeedo() {
        return idmaeedo;
    }
    public String getTido() {
        return tido;
    }
    public String getEndo() {
        return endo;
    }
    public String getNudo() {
        return nudo;
    }
    public String getFeemdo() {
        return feemdo;
    }
    public String getCpdo() {
        return cpdo;
    }
    public String getFeer() {
        return feer;
    }
    public String getModo() {
        return modo;
    }
    public String getId() {
        return id;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getPass() {
        return pass;
    }
    public String getEstado() {
        return estado;
    }
    public String getRten() {
        return rten;
    }
    public String getNokoen() {
        return nokoen;
    }
    public String getDien() {
        return dien;
    }
    public String getFoen() {
        return foen;
    }
    public String getFaen() {
        return faen;
    }
    public String getVanedo() {
        return vanedo;
    }
    public String getVaivdo() {
        return vaivdo;
    }
    public String getVabrdo() {
        return vabrdo;
    }
    
    /* PAGINA INDEX.JSP */
    public ResultSet index(String u) throws SQLException, ClassNotFoundException {
    System.out.println("INDEX");
    interfase.conInterface();
    String query = "SELECT (SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '0' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')))),"
                + "(SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '1' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')))),"
                + "(SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '2' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"'))))";
    ResultSet rs = interfase.consultas(query);
    return (rs);
    }
    public ResultSet visIndex() throws SQLException, ClassNotFoundException {
    System.out.println("VISINDEX");
    interfase.conInterface();
    String query = "SELECT (SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '0'),"
                + "(SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '1'),"
                + "(SELECT COUNT(APROBADO) FROM APROBADOR WHERE APROBADO = '2')";
    ResultSet rs = interfase.consultas(query);
    return (rs);
    }
    
    /* PAGINA PORAPROBAR.JSP */
    public ResultSet porAprobar(String u) throws SQLException, ClassNotFoundException {
    System.out.println("PORAPROBAR");
    interfase.conInterface();
    String query = "SELECT COUNT(*) FROM APROBADOR WHERE APROBADO = '1' AND IDMAEEDO IN ("
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')))";
    ResultSet rs = interfase.consultas(query);
    return (rs);
    }
    public ResultSet visPorAprobar() throws SQLException, ClassNotFoundException {
        System.out.println("VISPORAPROBAR");
        interfase.conInterface();
        String query = "SELECT COUNT(*) FROM APROBADOR WHERE APROBADO = '1'";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    /* UPDATE PARA PODER APROBAR UNA ORDEN */
    public void updateAprobar(String a, String user) throws SQLException, ClassNotFoundException {
    System.out.println("UPDATEAPROBAR");
    area(a);
    String e1;
    String e2;
    String e3;
    String e4;
    String e5;
    String e6;
    String e7;
    String e8;
        if ("ARENTAL   ".equals(area) || "ATALLER   ".equals(area)) {
        int[] depto = {1,2,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR MAX.8
        user(user);
        for (int i = 0; i < depto.length; i++) {
            if (depto[i] == Integer.parseInt(de)) {
                String aux = "";
                ResultSet cs = verificar(a,i+1);
                while (cs.next()){
                aux = cs.getString(1);}
                if ("0".equals(aux)){update(a,"1");}
                updateAprobador(user,a,i+1,"2");
                ResultSet rs = estado(a);
                while (rs.next()){
                e1 = rs.getString(1);
                e2 = rs.getString(2);
                e3 = rs.getString(3);
                e4 = rs.getString(4);
                e5 = rs.getString(5);
                e6 = rs.getString(6);
                e7 = rs.getString(7);
                e8 = rs.getString(8);
                int cont = 0;
                if (e1!=null){cont = cont + 1;}
                if (e2!=null){cont = cont + 1;}
                if (e3!=null){cont = cont + 1;}
                if (e4!=null){cont = cont + 1;}
                if (e5!=null){cont = cont + 1;}
                if (e6!=null){cont = cont + 1;}
                if (e7!=null){cont = cont + 1;}
                if (e8!=null){cont = cont + 1;}
                
                switch (cont) {
                    case 1:
                        if("2".equals(e1)){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 2:
                        if(("2".equals(e1))&&("2".equals(e2))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 3:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 4:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 5:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 6:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 7:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))&&("2".equals(e7))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 8:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))&&("2".equals(e7))&&("2".equals(e8))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;}
                }break;
            }
        }}
        else{
        int[] depto = {1,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR
        user(user);
            for (int i = 0; i < depto.length; i++) {
                if (depto[i] == Integer.parseInt(de)) { 
                    String aux = "";
                    ResultSet cs = verificar(a,i+1);
                    while (cs.next()){
                    aux = cs.getString(1);}
                    if ("0".equals(aux)){update(a,"1");}
                    updateAprobador(user,a,i+1,"2");
                    ResultSet rs = estado(a);
                    while (rs.next()){
                    e1 = rs.getString(1);
                    e2 = rs.getString(2);
                    e3 = rs.getString(3);
                    e4 = rs.getString(4);
                    e5 = rs.getString(5);
                    e6 = rs.getString(6);
                    e7 = rs.getString(7);
                    e8 = rs.getString(8);
                    int cont = 0;
                    if (e1!=null){cont = cont + 1;}
                    if (e2!=null){cont = cont + 1;}
                    if (e3!=null){cont = cont + 1;}
                    if (e4!=null){cont = cont + 1;}
                    if (e5!=null){cont = cont + 1;}
                    if (e6!=null){cont = cont + 1;}
                    if (e7!=null){cont = cont + 1;}
                    if (e8!=null){cont = cont + 1;}
                
                switch (cont) {
                    case 1:
                        if("2".equals(e1)){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 2:
                        if(("2".equals(e1))&&("2".equals(e2))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 3:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 4:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 5:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 6:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 7:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))&&("2".equals(e7))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;
                    case 8:
                        if(("2".equals(e1))&&("2".equals(e2))&&("2".equals(e3))&&("2".equals(e4))&&("2".equals(e5))&&("2".equals(e6))&&("2".equals(e7))&&("2".equals(e8))){
                            update(a,"2");
                            updateMaeedo(a);}
                    break;}
                    }break;
                }
            } 
        }
    }
    
    public void updateMaeedo(String r) throws SQLException, ClassNotFoundException {
    System.out.println("UPDATEMAEEDO");
    conexion.conexion();
    String query = "UPDATE MAEEDO SET ESDO = '' WHERE  TIDO = 'OCC' AND FEEMDO BETWEEN '20170101 00:00:00' and '20171231 23:59:59' AND IDMAEEDO = '"+r+"'";
    conexion.acciones(query);
    conexion.cerrarConexion();
    }
    /* UPDATE PARA PODER RECHAZAR UNA ORDEN */
    public void updateRechazar(String r, String user) throws SQLException, ClassNotFoundException {
    System.out.println("UPDATERECHAZAR");
    area(r);
        if ("ARENTAL   ".equals(area) || "ATALLER   ".equals(area)) {
        int[] depto = {1,2,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR
        user(user);
            for (int i = 0; i < depto.length; i++) {
                if (depto[i] == Integer.parseInt(de)) { 
                    updateAprobador(user,r,i+1,"0");
                    update(r,"0");
                    break;
                }
            }
        }
        else{
        int[] depto = {1,4,5,6};//INDICA CUANTOS DEPTOS SE NECESITAN PARA APROBAR
        user(user);
            for (int i = 0; i < depto.length; i++) {
                if (depto[i] == Integer.parseInt(de)) { 
                    updateAprobador(user,r,i+1,"0");
                    update(r,"0");
                    break;
                }
            } 
        }
    }
    
    public void id(String n) throws SQLException, ClassNotFoundException {
        System.out.println("ID");
        interfase.conInterface();
        String a = "SELECT IDMAEEDO FROM APROBADOR WITH (NOLOCK) WHERE IDMAEEDO = '"+n+"' AND NUDO LIKE '0%'";
        ResultSet rs = interfase.consultas(a);
        while (rs.next()) {
            id = rs.getString(1);
        }
    }
    
    public void area() throws SQLException, ClassNotFoundException {
        System.out.println("AREA");
        conexion.conexion();
        String b = "SELECT KOCARAC FROM MEVENTO WITH (NOLOCK) WHERE IDRVE = "+id+"";
        ResultSet rs = conexion.consultas(b);
        while (rs.next()) {
        this.area = rs.getString(1);
        }
    }
    
    public void area(String id) throws SQLException, ClassNotFoundException {
        System.out.println("AREA");
        conexion.conexion();
        String b = "SELECT KOCARAC FROM MEVENTO WITH (NOLOCK) WHERE IDRVE = "+id+"";
        ResultSet rs = conexion.consultas(b);
        while (rs.next()) {
        this.area = rs.getString(1);
        }
    }
    
    /* CONSULTA PARA TRAER EL CODIGO DEL USUARIO */
    public void valUser(String u) throws SQLException, ClassNotFoundException {
        System.out.println("VALUSER");
        interfase.conInterface();
        String query = "SELECT CODIGO FROM USUARIO WHERE CODIGO = '"+u+"'";
        ResultSet rs = interfase.consultas(query);
        while (rs.next()){
            codigo = rs.getString(1);
        }
    }
    
    public void valPass(String p) throws SQLException, ClassNotFoundException {
        System.out.println("VALPASS");
        interfase.conInterface();
        String query = "SELECT CONTRASEÑA FROM USUARIO WHERE CONTRASEÑA = '"+p+"'";
        ResultSet rs = interfase.consultas(query);
        while (rs.next()){
            pass = rs.getString(1);
        }
    }
    
    /* DATOS PARA PODER IMPRIMIR */
    public ResultSet imprimir(String u) throws SQLException, ClassNotFoundException {
        System.out.println("IMPRIMIR");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,"
                + "ENDOFI,CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                + "FROM APROBADOR WHERE NUDO LIKE '0%' AND IDMAEEDO IN ("
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"'))) ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
     /* DATOS PARA PODER IMPRIMIR */
    public ResultSet visualizar() throws SQLException, ClassNotFoundException {
        System.out.println("VISUALIZAR");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE NUDO LIKE '0%' ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet impPoraprobar(String u) throws SQLException, ClassNotFoundException {
        System.out.println("IMPPORAPROBAR**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '1' AND NUDO LIKE '0%' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"'))) ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet visPoraprobar() throws SQLException, ClassNotFoundException {
        System.out.println("VISPORAPROBAR**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '1' AND NUDO LIKE '0%' ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet impAprobadas(String u) throws SQLException, ClassNotFoundException {
        System.out.println("IMPAPROBADAS**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '2' AND NUDO LIKE '0%' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"'))) ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet visAprobadas() throws SQLException, ClassNotFoundException {
        System.out.println("VISAPROBADAS**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '2' AND NUDO LIKE '0%' ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet impRechazadas(String u) throws SQLException, ClassNotFoundException {
        System.out.println("IMPRECHAZADAS");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '0' AND NUDO LIKE '0%' AND IDMAEEDO IN ("
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB1 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB2 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB3 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB4 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB5 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB6 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB7 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"')) UNION ALL "
                    + "SELECT IDMAEEDO FROM APROBADOR WHERE APROB8 IN (SELECT CODIGO FROM USUARIO WHERE DEPTO = (SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+u+"'))) ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet visRechazadas() throws SQLException, ClassNotFoundException {
        System.out.println("VISRECHAZADAS**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,TIDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,SUENDO,ENDOFI,"
                    + "CPDO,CONVERT(DATE, FEER),APROBADO,VANEDO,VAIVDO,VABRDO "
                    + "FROM APROBADOR WHERE APROBADO = '0' AND NUDO LIKE '0%' ORDER BY IDMAEEDO DESC";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet datosUsuario(String i) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSUSUARIO");
        interfase.conInterface();
        String query = "SELECT KOFUDO,APROB1,APROB2,APROB3,APROB4,APROB5,APROB6,APROB7,APROB8 "
                + "FROM APROBADOR WHERE IDMAEEDO = '"+i+"' AND NUDO LIKE '0%'";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet datosCodigo(String u) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSCODIGO**--");
        interfase.conInterface();
        String query = "SELECT NOMBRE FROM USUARIO WHERE CODIGO = '"+u+"'";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public ResultSet datosProvee(String endo) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSPROVEE");    
        conexion.conexion();
        String query = "SELECT RTEN,NOKOEN,DIEN,FOEN,FAEN FROM MAEEN WHERE KOEN = '"+endo+"'";
        System.out.println(query); 
        ResultSet rs = conexion.consultas(query);
        return (rs);
    }
    
    // DATOS PARA IMPRIMIR FILTRADO POR DIVISA USD Y EURO
    public void datosOrden(String i) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSORDEN**--");
        interfase.conInterface();
        String query = "SELECT IDMAEEDO,NUDO,ENDO,CONVERT(DATE, FEEMDO),MODO,ENDOFI,CPDO,CONVERT(DATE, FEER),VANEDO,VAIVDO,VABRDO "
                + "FROM APROBADOR WHERE IDMAEEDO = '"+i+"' AND NUDO LIKE '0%'";
        ResultSet rs = interfase.consultas(query);
        while (rs.next()){
            idmaeedo = rs.getString(1);
            nudo = rs.getString(2);
            endo = rs.getString(3);
            feemdo = rs.getString(4);
            modo = rs.getString(5);
            cpdo = rs.getString(7);
            feer = rs.getString(8);
            vanedo = rs.getString(9);
            vaivdo = rs.getString(10);
            vabrdo = rs.getString(11);}
    }
    
    public ResultSet datosLineas(String i) throws SQLException, ClassNotFoundException {
        conexion.conexion();
        String query = "SELECT A.KOPRCT,CONVERT(varchar(50),A.NOKOPR),CONVERT(DATE, A.FEERLI),A.CAPRCO1,A.PPPRNE,A.PODTGLLI,A.MOPPPR,A.VANELI "
                + "FROM MAEDDO AS A JOIN MAEEDO AS B ON (A.IDMAEEDO=B.IDMAEEDO) WHERE A.IDMAEEDO = '"+i+"' AND B.MODO <> '$  '";
        ResultSet rs = conexion.consultas(query);
        return (rs);
    }
    
    // DATOS PARA IMPRIMIR FILTRADO POR DIVISA $    
    public ResultSet datosLineas$(String i) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSLINEA**--");
        conexion.conexion();
        String query = "SELECT A.KOPRCT,"
                + "CONVERT(varchar(50),A.NOKOPR),"
                + "CONVERT(DATE, A.FEERLI),"
                + "REPLACE(CONVERT(varchar(20),CONVERT(MONEY,A.CAPRCO1),1),'.00',''),"
                + "REPLACE(CONVERT(varchar(20),CONVERT(MONEY,A.PPPRNE),1),'.00',''),"
                + "CONVERT(varchar(20),A.PODTGLLI),"
                + "CONVERT(varchar(20),A.MOPPPR),"
                + "REPLACE(CONVERT(varchar(20),CONVERT(MONEY,A.VANELI),1),'.00','') "
                + "FROM MAEDDO AS A JOIN MAEEDO AS B ON (A.IDMAEEDO=B.IDMAEEDO) WHERE A.IDMAEEDO = '"+i+"' AND B.MODO = '$  '";
        ResultSet rs = conexion.consultas(query);
        return (rs);
    }
    
    public void datosTotal$(String i) throws SQLException, ClassNotFoundException {
        System.out.println("DATOSTOTAL**--");
        interfase.conInterface();
        String query = "SELECT VANEDO,VAIVDO,VABRDO "
                + "FROM APROBADOR WHERE IDMAEEDO = '"+i+"' AND NUDO LIKE '0%' AND MODO = '$  '";
        ResultSet rs = interfase.consultas(query);
        while (rs.next()){
            vanedo = rs.getString(1);
            vaivdo = rs.getString(2);
            vabrdo = rs.getString(3);}
    }
    
    //Ver el estado de todos los usuarios
    public ResultSet estado(String i) throws SQLException, ClassNotFoundException {
        System.out.println("ESTADO**--");
        interfase.conInterface();
        String query = "SELECT E1,E2,E3,E4,E5,E6,E7,E8,FECHAPROB1,FECHAPROB2,FECHAPROB3,FECHAPROB4,FECHAPROB5,FECHAPROB6,FECHAPROB7,FECHAPROB8 "
                + "FROM APROBADOR WHERE IDMAEEDO = '"+i+"'";
        System.out.println("estado");
        System.out.println(query);
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    //Ver el depto del usuario ingresado
    public void user(String t) throws SQLException, ClassNotFoundException {
        System.out.println("USER**--");
        interfase.conInterface();
        String h = "SELECT A.CODIGO FROM DEPTO AS A JOIN USUARIO AS B ON (A.CODIGO = B.DEPTO) WHERE B.CODIGO = '"+t+"'";
        ResultSet rs = interfase.consultas(h);
        while (rs.next()) {
        this.de = rs.getString(1);}
    }
    
    //Actualizar al usuario y el estado
    public ResultSet verificar(String a,int i) throws SQLException, ClassNotFoundException {
        System.out.println("VERIFICAR**--");
        interfase.conInterface();
        String query = "SELECT E"+i+" FROM APROBADOR WHERE IDMAEEDO = '"+a+"'";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
    
    public void updateAprobador(String user, String a,int i,String b) throws SQLException, ClassNotFoundException{
        System.out.println("UPDATEAPROBADOR**--");
        interfase.conInterface();
        String query = "UPDATE APROBADOR SET E"+i+" = '"+b+"', FECHAPROB"+i+" = (SELECT '"+user+" '+CAST(CONVERT (date, GETDATE()) AS VARCHAR(20))) WHERE IDMAEEDO = '"+a+"'";
        interfase.acciones(query);
        interfase.cerrarConexion();
    }
    
    public void update(String a,String b) throws SQLException, ClassNotFoundException{
        System.out.println("UPDATE**--");
        interfase.conInterface();
        String query = "UPDATE APROBADOR SET APROBADO = '"+b+"' WHERE IDMAEEDO = '"+a+"'";
        interfase.acciones(query);
        interfase.cerrarConexion();
    }
    
    public BigDecimal round(String i) throws SQLException, ClassNotFoundException {
        BigDecimal b = new BigDecimal(i);
        b = b.setScale(0, RoundingMode.HALF_UP);
        return (b);
    }
    
    public ResultSet filtro(String u) throws SQLException, ClassNotFoundException{
        System.out.println("FILTRO**--");
        interfase.conInterface();
        String query = "SELECT VISUALIZAR FROM USUARIO WHERE CODIGO = '"+u+"'";
        ResultSet rs = interfase.consultas(query);
        return (rs);
    }
}



