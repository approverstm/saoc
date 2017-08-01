<%-- 
    Document   : login
    Created on : 27-03-2017, 10:26:46 AM
    Author     : Scott
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" session="true"%>
<!DOCTYPE html>
<html lang="es">
  <head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/buscador.js"></script>
  </head>
  <body style="padding-top: 50px; background-color: #eee; repeat">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-4 col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title pull-left">Iniciar Sesión</span>
                        <span class="pull-right">
                            <a type="button" href="http://www.subterramineria.cl" class="btn btn-primary btn-xs">
                            <span class="glyphicon glyphicon-home" name="login"></span></a>
                        </span>
                        <br>
                    </div>
                    <div class="panel-body">
                        <form role="form" method="POST" action="Login">
                            <div class="form-group">
                                <input class="form-control" placeholder="Usuario" name="user" type="text" autofocus required="true">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Contraseña" name="pass" type="password" required="true">
                            </div>
                            <button type="submit" class="btn btn-lg btn-primary btn-block">Ingresar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>

