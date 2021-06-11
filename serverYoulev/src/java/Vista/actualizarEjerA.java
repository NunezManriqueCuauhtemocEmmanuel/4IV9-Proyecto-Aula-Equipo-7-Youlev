/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Control.accNutriologo;
import Modelo.MEjerciciosA;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Emiliano
 */
public class actualizarEjerA extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String ejer,inten,rep,numS,obs;
            int ejerAnt;
            
            ejer = request.getParameter("ejercicio");
            inten = request.getParameter("intensidad");
            rep = request.getParameter("repeticiones");
            numS = request.getParameter("numseries");
            obs = request.getParameter("observaciones");
            
            HttpSession sesionNut = request.getSession();
            int idN = (int)sesionNut.getAttribute("id");
            int idU = (int)sesionNut.getAttribute("idS");
            
            accNutriologo acc = new accNutriologo();

                    MEjerciciosA objEjer = new MEjerciciosA();

                    objEjer.setId_usu(idU);
                    objEjer.setId_nut(idN);
                    objEjer.setId_ejer(Integer.parseInt(ejer));
                    objEjer.setId_inten(Integer.parseInt(inten));
                    objEjer.setRep(rep);
                    objEjer.setNumS(Integer.parseInt(numS));
                    objEjer.setObs(obs);

                    ejerAnt = (int)sesionNut.getAttribute("ejerAnt");
                    
                    int estatus = acc.actualizarEjercicioA(objEjer,ejerAnt);
                    if(estatus > 0){
                        response.sendRedirect("regimenNut.jsp");
                    }else{
                        response.sendRedirect("regimenNut.jsp");
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
        processRequest(request, response);
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
