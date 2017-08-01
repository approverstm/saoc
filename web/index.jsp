<%-- 
    Document   : index
    Created on : 24-03-2017, 12:39:53 PM
    Author     : Scott
--%>

<%@page import="negocio.Dao_apagar"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="negocio.Dao_aprobador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    HttpSession misession= (HttpSession) request.getSession();
    String u = (String) String.valueOf(misession.getAttribute("codigo"));
    
    String poraprobar;
    String aprobadas;
    String rechazadas;
    
    String idmaeedo;
    String tido;
    String nudo;
    String endo;//rut
    String suendo; //dig
    String feemdo; //fecha orden
    String cpdo;//terminos de pago
    String feer;//fecha entrega
    String endofi;//fono
    String modo;//divisa
    String kofudo = "";//nombre solicitante
    
    String rten;//rut
    String nokoen ;//nombre proveedor
    String dien;//direccion
    String foen;//fono
    String faen;//fax
    
    String aprobado;
    
    String tdct = "";//total dcto.
    String vanedo = "";//subtotal y total neto
    String vaivdo = "";//total iva
    String vabrdo = "";//total

    String aprob1 = "";
    String aprob2 = "";
    String aprob3 = "";
    String aprob4 = "";
    String aprob5 = "";
    String aprob6 = "";
    String aprob7 = "";
    String aprob8 = "";
    String e1 = "";
    String e2 = "";
    String e3 = "";
    String e4 = "";
    String e5 = "";
    String e6 = "";
    String e7 = "";
    String e8 = "";
    String a1 = "";
    String a2 = "";
    String a3 = "";
    String a4 = "";
    String a5 = "";
    String a6 = "";
    String a7 = "";
    String a8 = "";
    String f1 = "";
    String f2 = "";
    String f3 = "";
    String f4 = "";
    String f5 = "";
    String f6 = "";
    String f7 = "";
    String f8 = "";
    
    Dao_aprobador d = new Dao_aprobador();
        
    String vis = "";
    ResultSet ps = d.filtro(u);
    while (ps.next()){
            vis = ps.getString(1);}
%>
<html lang="es">
<head>
    <title>Inicio</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/buscador.js"></script>
    <script language="javascript" type="text/javascript" src="js/jspdf.min.js"></script>
    <script language="javascript" type="text/javascript" src="js/pdf.js"></script>
</head>
<body style="padding-top: 20px; background-image: url(image/background.png); repeat">
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
                <a class="navbar-brand" href="index.jsp">
                    <img alt="Brand" src="image/stmlogo.png" style="width: 65%; position:relative; top: -15px; left: 10px;">
                </a>
            </div>
            <!-- Agrupar los enlaces de navegación, los formularios y cualquier
                 otro elemento que se pueda ocultar al minimizar la barra -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
              <ul class="nav navbar-nav">
                    <li>
                    <%  
                        ResultSet rs;
                        if (vis != null){rs = d.visPorAprobar();}
                        else{rs = d.porAprobar(u);}
                        
                        while (rs.next()) {
                        poraprobar = rs.getString(1);%>
                        <%if ("0".equals(poraprobar)){%>
                            <a href="poraprobar.jsp">Por Aprobar</a>
                        <%}else{%>
                            <a href="poraprobar.jsp">Por Aprobar <span class="badge-w"><%=poraprobar%></span></a>
                        <%}%>
                    <%}%>
                    </li>
                    <li><a href="aprobadas.jsp">Aprobadas</a></li>
                    <li><a href="rechazadas.jsp">Rechazadas</a></li>
              </ul>
            <p class="pull-right navbar-text">
                <a href="#"><b><%=u%></b></a>&nbsp&nbsp&nbsp
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
    <div class="container-fluid">  
        <!-- Titulo -->
        <div class="panel panel-default">
            <div class="panel-body">
            <div class="col-md-4">
                <%   
                ResultSet bs;
                if (vis != null){bs = d.visIndex();}
                else{bs = d.index(u);}
                try {
                    while (bs.next()) {
                            rechazadas = bs.getString(1);
                            poraprobar = bs.getString(2);
                            aprobadas = bs.getString(3);
                %>
                <a href="poraprobar.jsp">
                <div class="panel panel-warning">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="glyphicon glyphicon-folder-open" style="font-size: 50px;"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div><h2><%=poraprobar%> <small style="color: #fff"> Por Aprobar</small></h2></div>
                            </div>

                        </div>
                    </div>
                </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="aprobadas.jsp">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="glyphicon glyphicon-thumbs-up" style="font-size: 50px;"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div><h2><%=aprobadas%> <small style="color: #fff"> Aprobadas</small></h2></div>
                            </div>

                        </div>
                    </div>
                </div>
                </a>
            </div>
            <div class="col-md-4">
                <a href="rechazadas.jsp">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="glyphicon glyphicon-thumbs-down" style="font-size: 50px;"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div><h2><%=rechazadas%> <small style="color: #fff"> Rechazadas</small></h2></div>
                            </div>

                        </div>
                    </div>
                </div>
                </a>
                <%}
                    } catch (Exception e) {
                        e.printStackTrace();
                        out.println(e);}
                %>
            </div>
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <form class="form-horizontal" role="form" method="post" action="">
                                <div class="form-group">
                                    <div class="col-sm-10">
                                        <br>
                                        <div class="input-group"><span class="input-group-addon">Buscador</span>
                                            <input id="filtrar" type="text" class="form-control" placeholder="Ingresa algún indicio de lo que deseas Buscar...">
                                        </div>
                                    </div>
                                    <div class="col-sm-2">
                                        <br>
                                        <a type="button" onclick="history.go(0);" class="btn btn-block btn-primary"><span class="glyphicon glyphicon-refresh"></span>  Refrescar</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    <!-- Fin Titulo -->
                        <div class="panel-body">
                                <div class="table-responsive">   
                                    <table class="table table-hover">
                                      <thead>
                                        <tr>
                                            <th></th>
                                            <th class="text-center">Nro OC</th>
                                            <th class="text-left">Proveedor</th>
                                            <th class="text-center">Divisa</th>
                                            <th class="text-center">Valor total</th>
                                            <th class="text-center">Terminos</th>
                                            <th class="text-center">Fecha Entrega</th>
                                            <th></th>
                                        </tr>
                                      </thead>
                                      <tbody class="buscar text-center">
                                        <%
                                        ResultSet aux;
                                        if (vis != null){aux = d.visualizar();}
                                        else{aux = d.imprimir(u);}
                                        
                                        try {
                                            while (aux.next()){
                                                idmaeedo = aux.getString(1);
                                                tido = aux.getString(2);
                                                nudo = aux.getString(3);
                                                endo = aux.getString(4);
                                                feemdo = aux.getString(5);
                                                modo = aux.getString(6);
                                                suendo = aux.getString(7);
                                                endofi = aux.getString(8);
                                                cpdo = aux.getString(9);
                                                feer = aux.getString(10);
                                                aprobado = aux.getString(11);
                                                vanedo = aux.getString(12);
                                                vaivdo = aux.getString(13);
                                                vabrdo = aux.getString(14);
                                                if (endo == null){endo="";}
                                                if (feemdo == null){feemdo="";}
                                                if (modo == null){modo="";}
                                                if (suendo == null){suendo="";}
                                                if (endofi == null){endofi="";}
                                                if (cpdo == null){cpdo="";}
                                                if (feer == null){feer="";}
                                                if (vanedo == null){vanedo="";}
                                                if (vaivdo == null){vaivdo="";}
                                                if (vabrdo == null){vabrdo="";}
                                                
                                            ResultSet as = d.datosProvee(endo);
                                            while (as.next()){
                                                rten = as.getString(1);
                                                nokoen = as.getString(2);
                                                dien = as.getString(3);
                                                foen = as.getString(4);
                                                faen = as.getString(5);
                                                    
                                                if (rten == null){rten="";}
                                                if (nokoen == null){nokoen="";}
                                                if (dien == null){dien="";}
                                                if (foen == null){foen="";}
                                                if (faen == null){faen="";}
                                            
                                            ResultSet xs = d.estado(idmaeedo);
                                            while (xs.next()){
                                            e1 = xs.getString(1);
                                            e2 = xs.getString(2);
                                            e3 = xs.getString(3);
                                            e4 = xs.getString(4);
                                            e5 = xs.getString(5);
                                            e6 = xs.getString(6);
                                            e7 = xs.getString(7);
                                            e8 = xs.getString(8);
                                            f1 = xs.getString(9);
                                            f2 = xs.getString(10);
                                            f3 = xs.getString(11);
                                            f4 = xs.getString(12);
                                            f5 = xs.getString(13);
                                            f6 = xs.getString(14);
                                            f7 = xs.getString(15);
                                            f8 = xs.getString(16);}
                                            
                                            ResultSet hs = d.datosUsuario(idmaeedo);
                                            while (hs.next()){
                                                kofudo = hs.getString(1);
                                                aprob1 = hs.getString(2);
                                                a1 = aprob1;
                                                aprob2 = hs.getString(3);
                                                a2 = aprob2;
                                                aprob3 = hs.getString(4);
                                                a3 = aprob3;
                                                aprob4 = hs.getString(5);
                                                a4 = aprob4;
                                                aprob5 = hs.getString(6);
                                                a5 = aprob5;
                                                aprob6 = hs.getString(7);
                                                a6 = aprob6;
                                                aprob7 = hs.getString(8);
                                                a7 = aprob7;
                                                aprob8 = hs.getString(9);
                                                a8 = aprob8;}
                                            
                                            if (kofudo == null){kofudo="";}
                                            if (aprob1 == null){a1="";}
                                            if (aprob2 == null){a2="";}else{a2 = " / " + aprob2;}
                                            if (aprob3 == null){a3="";}else{a3 = " / " + aprob3;}
                                            if (aprob4 == null){a4="";}else{a4 = " / " + aprob4;}
                                            if (aprob5 == null){a5="";}else{a5 = " / " + aprob5;}
                                            if (aprob6 == null){a6="";}else{a6 = " / " + aprob6;}
                                            if (aprob7 == null){a7="";}else{a7 = " / " + aprob7;}
                                            if (aprob8 == null){a8="";}else{a8 = " / " + aprob8;}
                                        %>
                                        <%if ("0".equals(aprobado)){%>
                                            <tr class="danger"> <%}%>
                                        <%if ("1".equals(aprobado)){%>
                                            <tr class="warning"><%}%>
                                        <%if ("2".equals(aprobado)){%>
                                            <tr class="success"><%}%>
                                        <td class="">
                                          <!---Modal verOC--->
                                              <div class="modal fade" id="ver<%=nudo%>" tabindex="-1" role="dialog" aria-labelledby="verOC<%=nudo%>">
                                                  <div class="modal-dialog" role="document">
                                                      <div class="modal-content">
                                                          <div class="modal-header">
                                                              <button type="button" class="close pull-rift" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                                                              <span class="sr-only">Close</span></button>
                                                              <h4 class="modal-title" id="verOC<%=nudo%>">Vista Previa OCC</h4>
                                                          </div>
                                                          <div class="modal-body">
                                                            <div class="row">
                                                                <div class="col-md-8 col-sm-8"></div>
                                                                <div class="col-md-4 col-sm-4"><br>
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-heading">
                                                                            <label>Orden de Compra</label>
                                                                            <label type="text" class="text-center form-control"><%=nudo%></label>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel panel-default">
                                                                    <div class="panel-body">
                                                                        <div class="col-md-6">
                                                                            <div class="text-left">
                                                                                <label class="col-sm-3 col-md-3 control-label">Rut</label>
                                                                                <div class="col-sm-9 col-md-9">
                                                                                    <label type="text" class="form-control"><%=rten%></label>
                                                                                </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-3 control-label">Proveedor</label>
                                                                              <div class="col-sm-9 col-md-9">
                                                                                  <label type="text" class="form-control"><%=nokoen%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                                <label class="col-sm-3 col-md-3 control-label">Dirección</label>
                                                                                <div class="col-sm-9 col-md-9">
                                                                                    <label type="text" class="form-control"><%=dien%></label>
                                                                                </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-3 control-label">Comuna</label>
                                                                              <div class="col-sm-9 col-md-9">
                                                                                  <label type="text" class="form-control"></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                                <label class="col-sm-3 col-md-3 control-label">Fono</label>
                                                                                <div class="col-sm-9 col-md-9">
                                                                                    <label type="text" class="form-control"><%=foen%></label>
                                                                                </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-3 control-label">Atención</label>
                                                                              <div class="col-sm-9 col-md-9">
                                                                                  <label type="text" class="form-control"></label>
                                                                              </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="col-md-6">
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Fecha Entrega</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control"><%=feemdo%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                                <label class="col-sm-3 col-md-5 control-label">Términos Pago</label>
                                                                                <div class="col-sm-9 col-md-7">
                                                                                    <label type="text" class="form-control"><%=cpdo%></label>
                                                                                </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Divisa</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control"><%=modo%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Fecha Orden</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control"><%=feer%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Fax</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control"><%=faen%></label>
                                                                              </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="panel panel-default">
                                                                    <div class="panel-body">
                                                                        <div class="table-responsive">   
                                                                            <table class="table table-hover table-condensed">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th class="text-left">Item</th>
                                                                                    <th class="text-left">Artículo</th>
                                                                                    <th class="text-left">F.Entrega</th>
                                                                                    <th class="text-left">Cant.</th>
                                                                                    <th class="text-left">Precio</th>
                                                                                    <th class="text-left">% Dcto.</th>
                                                                                    <th class="text-left">Div</th>
                                                                                    <th class="text-left">Total</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody class="text-left">
                                                                                <%
                                                                                if ("$  ".equals(modo)) {
                                                                                ResultSet fs = d.datosLineas$(idmaeedo);
                                                                                    try {
                                                                                        while (fs.next()){
                                                                                            String nulido = fs.getString(1);
                                                                                            String nokopr = fs.getString(2);
                                                                                            String feerli = fs.getString(3);
                                                                                            String caprco1 = fs.getString(4);
                                                                                            String ppprne = fs.getString(5);
                                                                                            String podtglli = fs.getString(6);
                                                                                            String mopppr = fs.getString(7);
                                                                                            String vaneli = fs.getString(8);
                                                                                            if (nulido == null){nulido="";}
                                                                                            if (nokopr == null){nokopr="";}
                                                                                            if (feerli == null){feerli="";}
                                                                                            if (caprco1 == null){caprco1="";}
                                                                                            if (ppprne == null){ppprne="";}
                                                                                            if (podtglli == null){podtglli="";}
                                                                                            if (mopppr == null){mopppr="";}
                                                                                            if (vaneli == null){vaneli="";}
                                                                                %>
                                                                                <tr>
                                                                                    <td><%=nulido%></td>
                                                                                    <td><%=nokopr%></td>
                                                                                    <td><%=feerli%></td>
                                                                                    <td><%=caprco1%></td>
                                                                                    <td><%=ppprne%></td>
                                                                                    <td><%=podtglli%></td>
                                                                                    <td><%=mopppr%></td>
                                                                                    <td><%=vaneli%></td>
                                                                                </tr>
                                                                                <%}} catch (Exception e) {}}
                                                                                else{
                                                                                ResultSet gs = d.datosLineas(idmaeedo);
                                                                                    try {
                                                                                        while (gs.next()){
                                                                                            String nulido = gs.getString(1);
                                                                                            String nokopr = gs.getString(2);
                                                                                            String feerli = gs.getString(3);
                                                                                            String caprco1 = gs.getString(4);
                                                                                            String ppprne = gs.getString(5);
                                                                                            String podtglli = gs.getString(6);
                                                                                            String mopppr = gs.getString(7);
                                                                                            String vaneli = gs.getString(8);
                                                                                            if (nulido == null){nulido="";}
                                                                                            if (nokopr == null){nokopr="";}
                                                                                            if (feerli == null){feerli="";}
                                                                                            if (caprco1 == null){caprco1="";}
                                                                                            if (ppprne == null){ppprne="";}
                                                                                            if (podtglli == null){podtglli="";}
                                                                                            if (mopppr == null){mopppr="";}
                                                                                            if (vaneli == null){vaneli="";}
                                                                                %>
                                                                                <tr>
                                                                                    <td><%=nulido%></td>
                                                                                    <td><%=nokopr%></td>
                                                                                    <td><%=feerli%></td>
                                                                                    <td><%=caprco1%></td>
                                                                                    <td><%=ppprne%></td>
                                                                                    <td><%=podtglli%></td>
                                                                                    <td><%=mopppr%></td>
                                                                                    <td><%=vaneli%></td>
                                                                                </tr>
                                                                                <%}} catch (Exception e) {}}%>
                                                                            </tbody>
                                                                            </table>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-7 col-md-7">
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-4 control-label">Solicitado por</label>
                                                                              <div class="col-sm-9 col-md-8">
                                                                                  <label type="text" class="form-control"><%=kofudo%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-4 control-label">Autorizador(es)</label>
                                                                              <div class="col-sm-9 col-md-8">
                                                                                  <label type="text" class="form-control"><%=a1%><%=a2%><%=a3%><%=a4%><%=a5%><%=a6%><%=a7%><%=a8%></label>
                                                                              </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="col-sm-5 col-md-5">
                                                                    <div class="panel panel-default">
                                                                        <div class="panel-body">
                                                                            <% BigDecimal b = d.round(vanedo);%>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Subtotal</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control">$ <%=b%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Total Desc.</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control">$ <%=tdct%></label>
                                                                              </div>
                                                                            </div>
                                                                              <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Total Neto</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control">$ <%=b%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">I.V.A.</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control">$ <%=vaivdo%></label>
                                                                              </div>
                                                                            </div>
                                                                            <div class="text-left">
                                                                              <label class="col-sm-3 col-md-5 control-label">Total Bruto</label>
                                                                              <div class="col-sm-9 col-md-7">
                                                                                  <label type="text" class="form-control">$ <%=vabrdo%></label>
                                                                              </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          <!---/Modal verOC--->
                                          <form class="form-horizontal" role="form" method="POST" action="Aprobador?user=<%=misession.getAttribute("codigo")%>">
                                            <%if ("0".equals(aprobado)){
                                                if (vis != null){%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print"  disabled="true"></button>
                                                <%}else{%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok"></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print"  disabled="true"></button>
                                                <%}
                                            }%>
                                            <%if ("1".equals(aprobado)){
                                                if (vis != null){%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print"  disabled="true"></button>
                                                <%}else{%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok"></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove"></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print"  disabled="true"></button>
                                                <%}
                                            }%>
                                            <%if ("2".equals(aprobado)){
                                                if (vis != null){%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print" ></button>
                                                <%}else{%>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Aprobar" name="aprobar" value="<%=idmaeedo%>" class="btn btn-xs btn-success glyphicon glyphicon-ok" disabled="true" ></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Rechazar" name="rechazar" value="<%=idmaeedo%>" class="btn btn-xs btn-danger glyphicon glyphicon-remove"></button>
                                                    <button type="submit" data-toggle="tooltip" data-placement="bottom" title="Imprimir" name="imprimir" value="<%=idmaeedo%>" class="btn btn-xs btn-default glyphicon glyphicon-print"></button>
                                                <%}
                                            }%>
                                          </form>
                                          </td>
                                          <td class="text-capitalize"><a data-toggle="modal" data-target="#ver<%=nudo%>"><%=nudo%></a></td>
                                          <td class="text-capitalize text-left"><%=nokoen%></td>
                                          <td class="text-capitalize"><%=modo%></td>
                                          <td class="text-capitalize"><%=vabrdo%></td>
                                          <td class="text-capitalize"><%=cpdo%></td>
                                          <td class="text-capitalize"><%=feemdo%></td>
                                          <td>
                                              <!---Modal listadoOC--->
                                              <div class="modal fade bs-example-modal-sm" id="listado<%=nudo%>" tabindex="-1" role="dialog" aria-labelledby="listadoOC<%=nudo%>">
                                                  <div class="modal-dialog modal-sm" role="document">
                                                      <div class="modal-content">
                                                          <div class="modal-header">
                                                              <button type="button" class="close pull-rift" data-dismiss="modal"><span aria-hidden="true">&times;</span>
                                                              <span class="sr-only">Close</span></button>
                                                              <h4 class="modal-title" id="listadoOC<%=nudo%>">Autorizador(es)</h4>
                                                          </div>
                                                          <div class="modal-body">
                                                            <div class="table-responsive">
                                                                
                                                                <table class="table table-hover table-condensed">
                                                                    <thead>
                                                                        <tr>
                                                                            <%
                                                                                if (aprob2 == null){a2="";}else{a2 = aprob2;}
                                                                                if (aprob3 == null){a3="";}else{a3 = aprob3;}
                                                                                if (aprob4 == null){a4="";}else{a4 = aprob4;}
                                                                                if (aprob5 == null){a5="";}else{a5 = aprob5;}
                                                                                if (aprob6 == null){a6="";}else{a6 = aprob6;}
                                                                                if (aprob7 == null){a7="";}else{a7 = aprob7;}
                                                                                if (aprob8 == null){a8="";}else{a8 = aprob8;}
                                                                            %>
                                                                            <th class="text-left">Nro Oc</th>
                                                                            <th><%=a1%></th>
                                                                            <th><%=a2%></th>
                                                                            <th><%=a3%></th>
                                                                            <th><%=a4%></th>
                                                                            <th><%=a5%></th>
                                                                            <th><%=a6%></th>
                                                                            <th><%=a7%></th>
                                                                            <th><%=a8%></th>
                                                                        </tr>
                                                                    </thead>
                                                                    <tbody class="text-left">
                                                                        <tr>
                                                                            <td><%=nudo%></td>
                                                                            <%if ("1".equals(e1)){%>
                                                                              <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                                <%}else{if("2".equals(e1)){%>
                                                                                        <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f1%>"></a>
                                                                                    <%}else{if("0".equals(e1)){%>
                                                                                        <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f1%>"></a>   
                                                                                        <%}else{if(e1 == null){%>
                                                                                            <td></td>
                                                                                            <%}}}}%>
                                                                            <%if ("1".equals(e2)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e2)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f2%>"></a>
                                                                                  <%}else{if("0".equals(e2)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f2%>"></a>   
                                                                                      <%}else{if(e2 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e3)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e3)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f3%>"></a>
                                                                                  <%}else{if("0".equals(e3)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f3%>"></a>   
                                                                                      <%}else{if(e3 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e4)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e4)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f4%>"></a>
                                                                                  <%}else{if("0".equals(e4)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f4%>"></a>   
                                                                                      <%}else{if(e4 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e5)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e5)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f5%>"></a>
                                                                                  <%}else{if("0".equals(e5)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f5%>"></a>   
                                                                                      <%}else{if(e5 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e6)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e6)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f6%>"></a>
                                                                                  <%}else{if("0".equals(e6)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f6%>"></a>   
                                                                                      <%}else{if(e6 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e7)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e7)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f7%>"></a>
                                                                                  <%}else{if("0".equals(e7)){%>
                                                                                      <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f7%>"></a>   
                                                                                      <%}else{if(e7 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                            <%if ("1".equals(e8)){%>
                                                                            <td class="text-capitalize"><button type="button" class="btn btn-warning btn-xs glyphicon glyphicon-ban-circle"></button></td>
                                                                              <%}else{if("2".equals(e8)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-success btn-xs glyphicon glyphicon-ok" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Autorizado por" data-content="<%=f8%>"></a>
                                                                                  <%}else{if("0".equals(e8)){%>
                                                                                  <td class="text-capitalize"><a tabindex="0" class="btn btn-danger btn-xs glyphicon glyphicon-remove" role="button" data-toggle="popover" data-trigger="focus"  
                                                                                        data-placement="bottom" title="Rechazado por" data-content="<%=f8%>"></a>                                              
                                                                                      <%}else{if(e8 == null){%>
                                                                                          <td></td>
                                                                                          <%}}}}%>
                                                                        </tr>
                                                                    </tbody>
                                                                </table>
                                                            </div>
                                                          </div>
                                                      </div>
                                                  </div>
                                              </div>
                                          <!---/Modal listadoOC--->
                                              <button type="button" data-toggle="modal" data-target="#listado<%=nudo%>" class="btn btn-xs btn-primary glyphicon glyphicon-th-list"></button></td>
                                      </tr>
                                      <%}}} catch (Exception e) {}%>
                                      </tbody>
                                    </table>
                                </div>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <script>$(function pop() { $('[data-toggle="popover"]').popover({ html : true })})</script>
    </body>
</html>


