/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DBFacade;
import data.OfferMapper;
import domain.exception.OfferException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author auron
 */
@WebServlet(name = "ControlInsertOffer", urlPatterns = {"/ControlInsertOffer"})
public class ControlInsertOffer extends HttpServlet {

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
            throws ServletException, IOException, OfferException {
        response.setContentType("text/html;charset=UTF-8");
        
            DBFacade dof = new DBFacade();       

        String tilbud_name = (String) request.getParameter("Offer_headline");
        String tilbud_img = (String) request.getParameter("Offer_img");
        String tilbud_info = (String) request.getParameter("editor1");
        int tilbud_rabat  = Integer.parseInt((String) request.getParameter("Offer_discount"));

        dof.createNewOffer(tilbud_name, tilbud_img, tilbud_info, tilbud_rabat);
        
        response.sendRedirect("adminstrap_theme/index.jsp");
        
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
        } catch (OfferException ex) {
            Logger.getLogger(ControlInsertOffer.class.getName()).log(Level.SEVERE, null, ex);
            
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
        } catch (OfferException ex) {
            Logger.getLogger(ControlInsertOffer.class.getName()).log(Level.SEVERE, null, ex);
            
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
