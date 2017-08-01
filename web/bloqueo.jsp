<%-- 
    Document   : bloqueo
    Created on : 21-03-2017, 09:45:36 AM
    Author     : Scott
--%>

<%@page import="negocio.Dao_apagar"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="negocio.Dao_bloqueo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nudo;
    Dao_bloqueo bloqueo = new Dao_bloqueo();
    
%>
<html>
    <head>
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="refresh" content="1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript"> 
            function update(){
                <%bloqueo.ocRecibida();%>}
        </script> 
    </head>
    <body>
        <div class="container-fluid">
            <br>
            <div class="col-md-offset-2 col-md-8 col-md-offset-2">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3>OCC Bloqueada recientemente</h3>
                    </div>
                    <%
                        ResultSet rs = bloqueo.ver();
                    try {
                        while (rs.next()) {
                                nudo = rs.getString(1);
                    %>
                    <div class="panel-body">
                    <h4><%=nudo%></h4>
                    </div>  
                    <%}
                        } catch (Exception e) {
                            e.printStackTrace();
                            out.println(e);}
                    %>
                </div>
            </div>
        </div>
    </body>
</html>