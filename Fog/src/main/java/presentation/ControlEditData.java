
package presentation;

import data.DBFacade;
import data.OrderMapper;
import domain.exception.OrderException;
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
 * @author auron
 */
@WebServlet(name = "test", urlPatterns = {"/test"})
public class ControlEditData extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, OrderException {
        
        response.setContentType("text/html;charset=UTF-8");
       
//        OrderMapper om = new OrderMapper();

        DBFacade dbf = new DBFacade();

        int orderId = Integer.parseInt((String) request.getParameter("orderId"));
        int lenght = Integer.parseInt((String) request.getParameter("lenght"));
        int width = Integer.parseInt((String) request.getParameter("width"));
        int height = Integer.parseInt((String) request.getParameter("height"));

        int floor = Integer.parseInt((String) request.getParameter("floor"));
        int roof = Integer.parseInt((String) request.getParameter("roof"));
        int side = Integer.parseInt((String) request.getParameter("side"));

        dbf.setOrderData(lenght, width, height, floor, roof, side, orderId);

        response.sendRedirect("adminstrap_theme/ordre.jsp");
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
        } catch (OrderException ex) {
            Logger.getLogger(ControlEditData.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (OrderException ex) {
            Logger.getLogger(ControlEditData.class.getName()).log(Level.SEVERE, null, ex);
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
