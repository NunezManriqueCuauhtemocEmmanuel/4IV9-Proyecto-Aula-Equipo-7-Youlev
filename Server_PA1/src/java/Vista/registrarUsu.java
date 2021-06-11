/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.AccionesRyL;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adrai
 */
public class registrarUsu extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nom,appat,apmat,fn,sex,tel,email,usu,pass;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appa");
            apmat = request.getParameter("apma");
            fn = request.getParameter("fecha");
            sex = request.getParameter("sexo");
            email = request.getParameter("correo");
            tel = request.getParameter("telefono");
            usu = request.getParameter("user");
            pass = request.getParameter("contrasena");
            
            AccionesRyL acc = new AccionesRyL();
            
            Usuario busc = acc.verificarEUsuario(usu);
            
            if(usu.equals("adminSante")){
                
            }else{
                if(busc==null){
                    Usuario objUsu = new Usuario();

                    objUsu.setNom(nom);
                    objUsu.setAppat(appat);
                    objUsu.setApmat(apmat);
                    objUsu.setFN(fn);
                    objUsu.setSexo(sex);
                    objUsu.setEmail(email);
                    objUsu.setTel(Integer.parseInt(tel));
                    objUsu.setUsu(usu);
                    objUsu.setPass(pass);

                    int estatus = AccionesRyL.registrarUsuario(objUsu);


                    if(estatus > 0){
                        response.sendRedirect("inicio.jsp");
                    }else{
                        response.sendRedirect("index.html");
                    }
                }else{
                        response.sendRedirect("registrou.jsp");
                }
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registrarUsu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(registrarUsu.class.getName()).log(Level.SEVERE, null, ex);
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
