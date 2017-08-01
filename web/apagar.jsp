<%-- 
    Document   : apagar
    Created on : 05-05-2017, 05:05:01 PM
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true"%>
<!DOCTYPE html>
<%
    HttpSession misession= (HttpSession) request.getSession();
    String estado = (String) String.valueOf(misession.getAttribute("estado"));    
%>
<html lang="es">
  <head>
    <title>Apagar</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/buscador.js"></script>
    <style>
    .btn-default.btn-on.active{background-color: #5BB75B;color: white;}
    .btn-default.btn-off.active{background-color: #DA4F49;color: white;}

    </style>
  </head>
  <body style="padding-top: 20px; background-color: #eee; repeat">
    <div class="container-fluid">
        <!-- Navegador -->
        <nav class="navbar navbar-default" role="navigation">
            <!-- El logotipo y el icono que despliega el menú se agrupan 
            para mostrarlos mejor en los dispositivos móviles -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse"
                      data-target=".navbar-ex1-collapse">
                <span class="sr-only">Desplegar navegación</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
                <a class="navbar-brand" href="#">
                    <img alt="Brand" src="image/stmlogo.png" style="width: 65%; position:relative; top: -15px; left: 10px;">
                </a>
            </div>
            <!-- Agrupar los enlaces de navegación, los formularios y cualquier
                 otro elemento que se pueda ocultar al minimizar la barra -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            <p class="pull-right navbar-text">
                <a href="#"><b><%=misession.getAttribute("codigo")%></b></a>&nbsp&nbsp&nbsp
                <a href="login.jsp">
                    <button type="button" class="btn btn-primary btn-xs">Salir
                        <span class="glyphicon glyphicon-log-out" name="salir"></span>
                    </button>
                </a>
            </p>
            </div>
        </nav>
        <!-- Fin Navegador -->
    </div>
    <div class="container" style="padding-top: 20px;">
        <div class="row">
            <div class="col-md-offset-4 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title pull-left">Apagar/Encender Sistema</span>
                        <span class="pull-right">
                            <button type="button" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#apagar">
                            <span class="glyphicon glyphicon-adjust" name="apagar"></span></button>
                        </span>
                        <br>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="Apagar">
                            <div class="row">
                                <% if ("1".equals(estado)) {%>
                                <div class="col-md-3"></div>
                                <div class="col-md-6">
                                    <div class="btn-group" data-toggle="buttons">
                                      <label class="btn btn-default btn-on btn-lg active">
                                      <input type="radio" value="1" name="int" checked="checked">ON</label>
                                      <label class="btn btn-default btn-off btn-lg">
                                      <input type="radio" value="0" name="int">OFF</label>
                                    </div>                                    
                                </div>
                                <div class="col-md-3"></div>
                                <%}
                                   if ("0".equals(estado)) {%>
                                <div class="col-md-3"></div>
                                <div class="col-md-6">
                                    <div class="btn-group" data-toggle="buttons">
                                      <label class="btn btn-default btn-on btn-lg">
                                      <input type="radio" value="1" name="int">ON</label>
                                      <label class="btn btn-default btn-off btn-lg active">
                                      <input type="radio" value="0" name="int" checked="checked">OFF</label>
                                    </div>
                                </div>
                                <div class="col-md-3"></div>
                                <%}%>
                            </div>
                            <!---Modal--->
                                <div class="modal fade bs-example-modal-sm" id="apagar" tabindex="-1" role="dialog" aria-labelledby="Apagar">
                                    <div class="modal-dialog modal-sm" role="document">
                                      <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                                                <span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="Apagar">Apagar/Encender Sistema</h4>
                                      </div>
                                      <div class="modal-body">
                                        <h5>Está seguro que desea guardar los cambios?</h5>
                                        <br>
                                        <button type="submit" class="btn btn-lg btn-warning btn-block">Guardar</button>
                                      </div>
                                      <div class="modal-footer">
                                      </div>
                                      </div>
                                    </div>
                                </div>
                            <!---/Modal---> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-offset-4 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title pull-left">Página Bloqueo</span>
                        <span class="pull-right">
                        </span>
                        <br>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-3"></div>
                            <div class="col-md-6">
                                <a type="button" href="bloqueo.jsp" target="_blank" class="btn btn-lg btn-primary btn-block">Abrir</a>
                            </div>
                            <div class="col-md-3"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

