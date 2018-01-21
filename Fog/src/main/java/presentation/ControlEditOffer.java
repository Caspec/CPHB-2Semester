
package presentation;

import data.DBFacade;
import data.OfferMapper;
import domain.business.DOFacade;
import domain.exception.OfferException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stev
 */
@WebServlet(name = "ControlEditOffer", urlPatterns = {"/ControlEditOffer"})
public class ControlEditOffer extends HttpServlet {

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
        

        DOFacade dof = new DOFacade();
        
        int offerId = Integer.parseInt((String)request.getParameter("offerId"));
        String offerName = request.getParameter("offerName");
        String offerImg = request.getParameter("offerImg");
        String offerInfo = request.getParameter("offerInfo");
        int offerNumber = Integer.parseInt((String)request.getParameter("offerNumber"));
 
        
    
        
            dof.setOffer(offerId, offerName, offerInfo, offerImg, offerNumber);
            
            response.sendRedirect("adminstrap_theme/tilbud.jsp");
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
            Logger.getLogger(ControlEditOffer.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControlEditOffer.class.getName()).log(Level.SEVERE, null, ex);
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
