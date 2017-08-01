/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Dao_aprobador;

/**
 *
 * @author Scott
 */
@WebServlet(name = "Aprobador", urlPatterns = {"/Aprobador"})
public class Aprobador extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Dao_aprobador d = new Dao_aprobador();
            String u = request.getParameter("user"); //Recojo los datos
            String a = request.getParameter("aprobar"); 
            String r = request.getParameter("rechazar");
            String i = request.getParameter("imprimir");
            String rr = request.getHeader("Referer");
            if (u != null){
                if (a == null){
                    if (r == null){
                        
                        d.datosOrden(i);

                        String nudo = d.getNudo();
                        String feemdo = d.getFeemdo();
                        String cpdo = d.getCpdo();
                        String modo = d.getModo();
                        String feer = d.getFeer();
                        String endo = d.getEndo();
                        
                        String rten = "";
                        String nokoen = "";
                        String dien = "";
                        String foen = "";
                        String faen = "";
                        
                        String vanedo = d.getVanedo();
                        String vaivdo = d.getVaivdo();
                        String vabrdo = d.getVabrdo();
                        
                        String kofudo = "";
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
                                                
                        ResultSet rs = d.datosProvee(endo);
                        ResultSet bs = d.datosUsuario(i);
                        while (rs.next()){
                            rten = rs.getString(1);
                            nokoen = rs.getString(2);
                            dien = rs.getString(3);
                            foen = rs.getString(4);
                            faen = rs.getString(5);}
                        while (bs.next()){
                            kofudo = bs.getString(1);
                            aprob1 = bs.getString(2);
                            aprob2 = bs.getString(3);
                            aprob3 = bs.getString(4);
                            aprob4 = bs.getString(5);
                            aprob5 = bs.getString(6);
                            aprob6 = bs.getString(7);
                            aprob7 = bs.getString(8);
                            aprob8 = bs.getString(9);}

                        out.println("<html>");
                        out.println("<head>");
                          out.println("<meta http-equiv='Refresh' content='0; url=index.jsp'>");
                          out.println("<meta type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                          out.println("<link type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                          out.println("<script type=text/javascript' src='js/jquery.min.js'></script>");
                          out.println("<script type='text/javascript' src='js/jspdf.min.js'></script>");
                          out.println("<script type='text/javascript' src='js/pdf.js'></script>");
                        out.println("</head>");
                        out.println("<body onload='javascript:pdf();' style='display: none'>");
                        if (nudo == null){nudo="";}
                        if (rten == null){rten="";}
                        if (feemdo == null){feemdo="";}
                        if (nokoen == null){nokoen="";}
                        if (cpdo == null){cpdo="";}
                        if (dien == null){dien="";}
                        if (modo == null){modo="";}
                        if (feer == null){feer="";}
                        if (foen == null){foen="";}
                        if (faen == null){faen="";}
                            out.println("nume<input type='text' id='nume' value='"+nudo+"'><br>");
                            out.println("rut<input type='text' id='rut' value='"+rten+"'><br>");
                            out.println("fecO<input type='text' id='fecO' value='"+feemdo+"'><br>");
                            out.println("prov<input type='text' id='prov' value='"+nokoen+"'><br>");
                            out.println("term<input type='text' id='term' value='"+cpdo+"'><br>");
                            out.println("dire<input type='text' id='dire' value='"+dien+"'><br>");
                            out.println("mone<input type='text' id='mone' value='"+modo+"'><br>");
                            out.println("comu<input type='text' id='comu' value=''><br>");
                            out.println("fecE<input type='text' id='fecE' value='"+feer+"'><br>");
                            out.println("fono<input type='text' id='fono' value='"+foen+"'><br>");
                            out.println("fax<input type='text' id='fax' value='"+faen+"'><br>");
                            out.println("aten<input type='text' id='aten' value=''><br>");
                        if ("$  ".equals(modo)) {
                            d.datosTotal$(i);
                            vanedo = vanedo.substring(0, vanedo.length() - 2);
                            ResultSet as = d.datosLineas$(i);
                            int cont = -10;
                            while (as.next()){
                                cont = cont + 10;
                                String nulido = as.getString(1);
                                String nokopr = as.getString(2);
                                String feerli = as.getString(3);
                                String caprco1 = as.getString(4);
                                String ppprne = as.getString(5);
                                String podtglli = as.getString(6);
                                String mopppr = as.getString(7);
                                String vaneli = as.getString(8);
                                if (nulido == null){nulido="";}
                                if (nokopr == null){nokopr="";}
                                if (feerli == null){feerli="";}
                                if (caprco1 == null){caprco1="";}
                                if (ppprne == null){ppprne="";}
                                if (podtglli == null){podtglli="";}
                                if (mopppr == null){mopppr="";}
                                if (vaneli == null){vaneli="";}
                            out.println("item"+cont+"<input type='text' id='"+cont+"' value='"+nulido+"'><br>");cont = cont + 1;
                            out.println("arti"+cont+"<input type='text' id='"+cont+"' value='"+nokopr+"'><br>");cont = cont + 1;
                            out.println("fecEL"+cont+"<input type='text' id='"+cont+"' value='"+feerli+"'><br>");cont = cont + 1;
                            out.println("cant"+cont+"<input type='text' id='"+cont+"' value='"+caprco1+"'><br>");cont = cont + 1;
                            out.println("prec"+cont+"<input type='text' id='"+cont+"' value='"+ppprne+"'><br>");cont = cont + 1;
                            out.println("dcto"+cont+"<input type='text' id='"+cont+"' value='"+podtglli+"'><br>");cont = cont + 1;
                            out.println("mont"+cont+"<input type='text' id='"+cont+"' value='"+mopppr+"'><br>");cont = cont + 1;
                            out.println("tota"+cont+"<input type='text' id='"+cont+"' value='"+vaneli+"'><br>");
                            out.println("<input type='text' id='cont' value='"+(cont+1)+"'><br>");
                            }
                            if (kofudo == null){kofudo="";}
                            if (aprob1 == null){aprob1="";}
                            if (aprob2 == null){aprob2="";}else{aprob2 = " / " + aprob2;}
                            if (aprob3 == null){aprob3="";}else{aprob3 = " / " + aprob3;}
                            if (aprob4 == null){aprob4="";}else{aprob4 = " / " + aprob4;}
                            if (aprob5 == null){aprob5="";}else{aprob5 = " / " + aprob5;}
                            if (aprob6 == null){aprob6="";}else{aprob6 = " / " + aprob6;}
                            if (aprob7 == null){aprob7="";}else{aprob7 = " / " + aprob7;}
                            if (aprob8 == null){aprob8="";}else{aprob8 = " / " + aprob8;}
                            if (vanedo == null){vanedo="";}
                            if (vaivdo == null){vaivdo="";}
                            if (vabrdo == null){vabrdo="";}
                            out.println("obsv<input type='text' id='obsv' value=''><br>");
                            out.println("soli<input type='text' id='soli' value='"+kofudo+"'><br>");
                            out.println("auto<input type='text' id='auto' value='"+aprob1+aprob2+aprob3+aprob4+aprob5+aprob6+aprob7+aprob8+"'><br>");
                            out.println("subt<input type='text' id='subt' value='"+vanedo+"'><br>");
                            out.println("tdct<input type='text' id='tdct' value=''><br>");
                            out.println("tnet<input type='text' id='tnet' value='"+vanedo+"'><br>");
                            out.println("iva<input type='text' id='iva' value='"+vaivdo+"'><br>");
                            out.println("tbru<input type='text' id='tbru' value='"+vabrdo+"'>");
                        }else{
                            ResultSet as = d.datosLineas(i);
                            int cont = 0;
                            while (as.next()){
                                String nulido = as.getString(1);
                                String nokopr = as.getString(2);
                                String feerli = as.getString(3);
                                String caprco1 = as.getString(4);
                                String ppprne = as.getString(5);
                                String podtglli = as.getString(6);
                                String mopppr = as.getString(7);
                                String vaneli = as.getString(8);
                                if (nulido == null){nulido="";}
                                if (nokopr == null){nokopr="";}
                                if (feerli == null){feerli="";}
                                if (caprco1 == null){caprco1="";}
                                if (ppprne == null){ppprne="";}
                                if (podtglli == null){podtglli="";}
                                if (mopppr == null){mopppr="";}
                                if (vaneli == null){vaneli="";}
                            out.println("item"+cont+"<input type='text' id='"+cont+"' value='"+nulido+"'><br>");cont = cont + 1;
                            out.println("arti"+cont+"<input type='text' id='"+cont+"' value='"+nokopr+"'><br>");cont = cont + 1;
                            out.println("fecEL"+cont+"<input type='text' id='"+cont+"' value='"+feerli+"'><br>");cont = cont + 1;
                            out.println("cant"+cont+"<input type='text' id='"+cont+"' value='"+caprco1+"'><br>");cont = cont + 1;
                            out.println("prec"+cont+"<input type='text' id='"+cont+"' value='"+ppprne+"'><br>");cont = cont + 1;
                            out.println("dcto"+cont+"<input type='text' id='"+cont+"' value='"+podtglli+"'><br>");cont = cont + 1;
                            out.println("mont"+cont+"<input type='text' id='"+cont+"' value='"+mopppr+"'><br>");cont = cont + 1;
                            out.println("tota"+cont+"<input type='text' id='"+cont+"' value='"+vaneli+"'><br>");cont = cont + 10;
                            }
                            if (kofudo == null){kofudo="";}
                            if (aprob1 == null){aprob1="";}
                            if (aprob2 == null){aprob2="";}else{aprob2 = " / " + aprob2;}
                            if (aprob3 == null){aprob3="";}else{aprob3 = " / " + aprob3;}
                            if (aprob4 == null){aprob4="";}else{aprob4 = " / " + aprob4;}
                            if (aprob5 == null){aprob5="";}else{aprob5 = " / " + aprob5;}
                            if (aprob6 == null){aprob6="";}else{aprob6 = " / " + aprob6;}
                            if (aprob7 == null){aprob7="";}else{aprob7 = " / " + aprob7;}
                            if (aprob8 == null){aprob8="";}else{aprob8 = " / " + aprob8;}
                            if (vanedo == null){vanedo="";}
                            if (vaivdo == null){vaivdo="";}
                            if (vabrdo == null){vabrdo="";}
                            out.println("<input type='text' id='obsv' value=''><br>");
                            out.println("<input type='text' id='soli' value='"+kofudo+"'><br>");
                            out.println("<input type='text' id='auto' value='"+aprob1+aprob2+aprob3+aprob4+aprob5+aprob6+aprob7+aprob8+"'><br>");
                                    
                            out.println("<input type='text' id='subt' value='"+vanedo+"'><br>");
                            out.println("<input type='text' id='tdct' value=''><br>");
                            out.println("<input type='text' id='tnet' value='"+vanedo+"'><br>");
                            out.println("<input type='text' id='iva' value='"+vaivdo+"'><br>");
                            out.println("<input type='text' id='tbru' value='"+vabrdo+"'>");
                        }
                        out.println("</body>");
                        out.println("</html>");
                    }else{
                        d.updateRechazar(r,u);
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<meta http-equiv='Refresh' content='0; url="+rr+"'>");
                        out.println("</head>");
                        out.println("</html>");
                    }
                }else{
                    d.updateAprobar(a,u);
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta http-equiv='Refresh' content='0; url="+rr+"'>");
                    out.println("</head>");
                    out.println("</html>");
                }
            } else {
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv='Refresh' content='0; url="+rr+"'>");
                out.println("</head>");
                out.println("</html>");
                }    
        } catch (SQLException e) {
            out.println("Error:" + e.toString());
            throw new IOException(e);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Aprobador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

