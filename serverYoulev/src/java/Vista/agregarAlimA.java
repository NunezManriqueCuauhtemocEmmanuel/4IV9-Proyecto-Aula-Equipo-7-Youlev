/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.accNutriologo;
import Modelo.MAlimentosA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emiliano
 */
public class agregarAlimA extends HttpServlet {

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
            String alim,hora,cant,obs,idU,idN;
            
            HttpSession sesionNut = request.getSession();
            idN = String.valueOf(sesionNut.getAttribute("id"));
            idU = String.valueOf(sesionNut.getAttribute("idS"));
            alim = request.getParameter("alimento");
            hora = request.getParameter("hora");
            cant = request.getParameter("cantidad");
            obs = request.getParameter("observaciones");
            
            accNutriologo acc = new accNutriologo();
            
            MAlimentosA busc = acc.repetidosAlimentosA(idU,idN,alim);
            
                if(busc==null){
                    MAlimentosA objAlimA = new MAlimentosA();

                    objAlimA.setId_nut(Integer.parseInt(idN));
                    objAlimA.setId_usu(Integer.parseInt(idU));
                    objAlimA.setId_alimento(Integer.parseInt(alim));
                    objAlimA.setHora(hora);
                    objAlimA.setCant(cant);
                    objAlimA.setObs(obs);

                    int estatus = acc.registrarAlimentoA(objAlimA);


                    if(estatus > 0){
                        response.sendRedirect("planNut.jsp");
                    }else{
                        response.sendRedirect("planNut.jsp");
                    }
                }else{
                    response.sendRedirect("planNut.jsp");
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
            Logger.getLogger(agregarAlimA.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(agregarAlimA.class.getName()).log(Level.SEVERE, null, ex);
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
