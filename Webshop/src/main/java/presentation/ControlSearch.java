
package presentation;

import data.OrderMapper;
import domain.entity.Order;
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


@WebServlet(name = "ControlSearch", urlPatterns =
{
    "/ControlSearch"
})
public class ControlSearch extends HttpServlet
{
    OrderMapper bm = new OrderMapper();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, OrderException
    {
        
//        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        //Get data from jsp form
//        String search = request.getParameter("search");
//        Order book = bm.getBook(Integer.parseInt(search));
//
//        
//        request.getSession().setAttribute("search", book);
//        
//        request.setAttribute("search", book);
//        request.getRequestDispatcher("view.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (OrderException ex)
        {
            Logger.getLogger(ControlSearch.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (OrderException ex)
        {
            Logger.getLogger(ControlSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
