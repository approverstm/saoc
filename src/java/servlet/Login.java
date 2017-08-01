/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import negocio.Dao_apagar;
import negocio.Dao_aprobador;

/**
 *
 * @author Scott
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Dao_aprobador d = new Dao_aprobador();
        Dao_apagar a = new Dao_apagar();
        HttpSession misession= request.getSession(true);
        String u = request.getParameter("user"); //Recojo el user
        String p = request.getParameter("pass"); //Recojo la pass
        String codigo;
        String pass;
        String estado;
        System.out.println("processRequest");
        try {
            d.valUser(u);
            d.valPass(p);
            codigo = d.getCodigo();
            pass = d.getPass();
            
            a.verEstado();
            estado = a.getE();
            
            if ("ADM".equals(codigo) && "ADM".equals(pass)){
                System.out.println("processRequest - ADM");
                misession.setAttribute("codigo",codigo);
                misession.setAttribute("estado",estado);
                out.println("<html>");
                out.println("<head>");
                out.println("<meta http-equiv='Refresh' content='0; url=apagar.jsp'>");
                out.println("</head>");
                out.println("</html>");
            }
            else{
                if ("1".equals(estado)){
                    if (codigo != null){
                        if (pass != null){
                            misession.setAttribute("codigo",codigo);
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv='Refresh' content='0; url=index.jsp'>");
                            out.println("</head>");
                            out.println("</html>");
                        }
                        else{
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv='Refresh' content='3; url=login.jsp'>");
                            out.println("<title>Error</title>");
                            out.println("<meta charset='utf-8'>");
                            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                            out.println("<link type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                            out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
                            out.println("<script type='text/javascript' src='js/bootstrap.js'></script>");
                            out.println("</head>");
                            out.println("<body style='padding-top: 50px; background-color: #eee;'>");
                            out.println("<div class='container'>");
                                out.println("<div class='row'>");
                                    out.println("<div class='col-md-offset-4 col-md-4 col-md-offset-4'>");
                                        out.println("<div class='login-panel panel panel-default'>");
                                            out.println("<div class='panel-heading'>");
                                                out.println("<span class='panel-title pull-left'>Error</span>");
                                                out.println("<span class='pull-right'>");
                                                    out.println("<a href='javascript:window.history.back();'><button type='button' class='btn btn-primary btn-xs'>");
                                                    out.println("<span class='glyphicon glyphicon-chevron-left'></span>Volver</button></a>");
                                                out.println("</span>");
                                                out.println("<BR>");
                                            out.println("</div>");
                                            out.println("<div class='panel-body'>");
                                                out.println("<form role='form' method='' action=''>");
                                                    out.println("<div class='form-group'>");
                                                        out.println("<h4 class='text-center'>La contraseña no corresponde</h4>");
                                                    out.println("</div>");
                                                out.println("</form>");
                                            out.println("</div>");
                                        out.println("</div>");
                                    out.println("</div>");
                                out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }else {
                        if (pass != null){
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv='Refresh' content='3; url=login.jsp'>");
                            out.println("<title>Error</title>");
                            out.println("<meta charset='utf-8'>");
                            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                            out.println("<link type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                            out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
                            out.println("<script type='text/javascript' src='js/bootstrap.js'></script>");
                            out.println("</head>");
                            out.println("<body style='padding-top: 50px; background-color: #eee;'>");
                            out.println("<div class='container'>");
                                out.println("<div class='row'>");
                                    out.println("<div class='col-md-offset-4 col-md-4 col-md-offset-4'>");
                                        out.println("<div class='login-panel panel panel-default'>");
                                            out.println("<div class='panel-heading'>");
                                                out.println("<span class='panel-title pull-left'>Error</span>");
                                                out.println("<span class='pull-right'>");
                                                    out.println("<a href='javascript:window.history.back();'><button type='button' class='btn btn-primary btn-xs'>");
                                                    out.println("<span class='glyphicon glyphicon-chevron-left'></span>Volver</button></a>");
                                                out.println("</span>");
                                                out.println("<BR>");
                                            out.println("</div>");
                                            out.println("<div class='panel-body'>");
                                                out.println("<form role='form' method='' action=''>");
                                                    out.println("<div class='form-group'>");
                                                        out.println("<h4 class='text-center'>El usuario no corresponde</h4>");
                                                    out.println("</div>");
                                                out.println("</form>");
                                            out.println("</div>");
                                        out.println("</div>");
                                    out.println("</div>");
                                out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                        else{
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<meta http-equiv='Refresh' content='3; url=login.jsp'>");
                            out.println("<title>Error</title>");
                            out.println("<meta charset='utf-8'>");
                            out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                            out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                            out.println("<link type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                            out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
                            out.println("<script type='text/javascript' src='js/bootstrap.js'></script>");
                            out.println("</head>");
                            out.println("<body style='padding-top: 50px; background-color: #eee;'>");
                            out.println("<div class='container'>");
                                out.println("<div class='row'>");
                                    out.println("<div class='col-md-offset-4 col-md-4 col-md-offset-4'>");
                                        out.println("<div class='login-panel panel panel-default'>");
                                            out.println("<div class='panel-heading'>");
                                                out.println("<span class='panel-title pull-left'>Error</span>");
                                                out.println("<span class='pull-right'>");
                                                    out.println("<a href='javascript:window.history.back();'><button type='button' class='btn btn-primary btn-xs'>");
                                                    out.println("<span class='glyphicon glyphicon-chevron-left'></span>Volver</button></a>");
                                                out.println("</span>");
                                                out.println("<BR>");
                                            out.println("</div>");
                                            out.println("<div class='panel-body'>");
                                                out.println("<form role='form' method='' action=''>");
                                                    out.println("<div class='form-group'>");
                                                        out.println("<h4 class='text-center'>Usuario y contraseña no corresponden</h4>");
                                                    out.println("</div>");
                                                out.println("</form>");
                                            out.println("</div>");
                                        out.println("</div>");
                                    out.println("</div>");
                                out.println("</div>");
                            out.println("</div>");
                            out.println("</div>");
                            out.println("</body>");
                            out.println("</html>");
                        }
                    }
                }
                else{
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<meta http-equiv='Refresh' content='4; url=login.jsp'>");
                    out.println("<title>Error</title>");
                    out.println("<meta charset='utf-8'>");
                    out.println("<meta http-equiv='X-UA-Compatible' content='IE=edge'>");
                    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
                    out.println("<link type='text/css' rel='stylesheet' href='css/bootstrap.css'>");
                    out.println("<script type='text/javascript' src='js/jquery.min.js'></script>");
                    out.println("<script type='text/javascript' src='js/bootstrap.js'></script>");
                    out.println("</head>");
                    out.println("<body style='padding-top: 50px; background-color: #eee;'>");
                    out.println("<div class='container'>");
                        out.println("<div class='row'>");
                            out.println("<div class='col-md-offset-4 col-md-4 col-md-offset-4'>");
                                out.println("<div class='login-panel panel panel-default'>");
                                    out.println("<div class='panel-heading'>");
                                        out.println("<span class='panel-title pull-left'>Error</span>");
                                        out.println("<span class='pull-right'>");
                                            out.println("<a href='javascript:window.history.back();'><button type='button' class='btn btn-primary btn-xs'>");
                                            out.println("<span class='glyphicon glyphicon-chevron-left'></span>Volver</button></a>");
                                        out.println("</span>");
                                        out.println("<BR>");
                                    out.println("</div>");
                                    out.println("<div class='panel-body'>");
                                        out.println("<form role='form' method='' action=''>");
                                            out.println("<div class='form-group'>");
                                                out.println("<h4 class='text-center'>El sistema está temporalmente Apagado, vuelve a intentar más tarde o contacta a un Administrador</h4>");
                                            out.println("</div>");
                                        out.println("</form>");
                                    out.println("</div>");
                                out.println("</div>");
                            out.println("</div>");
                        out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</body>");
                    out.println("</html>");
                        
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
