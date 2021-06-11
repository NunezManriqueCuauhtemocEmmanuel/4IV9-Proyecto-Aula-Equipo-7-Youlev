/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.AccionesNutriologo;
import Modelo.Nutriologo;
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
public class registrarNutri extends HttpServlet {

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
            String nom,appat,apmat,fn,sex,tel,email,usu,pass, ced;
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appa");
            apmat = request.getParameter("apma");
            fn = request.getParameter("nacimiento");
            sex = request.getParameter("sexo");
            ced = request.getParameter("cedula");
            email = request.getParameter("correo");
            tel = request.getParameter("telefono");
            usu = request.getParameter("user");
            pass = request.getParameter("contrasena");
            
            AccionesNutriologo acc = new AccionesNutriologo();
            
            Nutriologo busc = acc.verificarENutriologo(usu);

            if(usu.equals("adminSante")){
                
            }else{
                if(busc==null){
                    Nutriologo objNutri = new Nutriologo();

                    objNutri.setNom(nom);
                    objNutri.setAppat(appat);
                    objNutri.setApmat(apmat);
                    objNutri.setFN(fn);
                    objNutri.setSex(sex);
                    objNutri.setCed(Integer.parseInt(ced));
                    objNutri.setEmail(email);
                    objNutri.setTel(Integer.parseInt(tel));
                    objNutri.setUsu(usu);
                    objNutri.setPass(pass);

                    int estatus = AccionesNutriologo.registrarNutriologo(objNutri);


                    if(estatus > 0){
                        response.sendRedirect("inicio.jsp");
                    }else{
                        response.sendRedirect("index.html");
                    }
                }else{
                        response.sendRedirect("registron.jsp");
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
            Logger.getLogger(registrarNutri.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(registrarNutri.class.getName()).log(Level.SEVERE, null, ex);
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
