
package presentation;

import data.BookMapper;
import data.BorrowerMapper;
import domain.entity.Book;
import domain.exception.BookException;
import domain.exception.BorrowerException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ControlReserve", urlPatterns =
{
    "/ControlReserve"
})
public class ControlReserve extends HttpServlet
{
    BookMapper bm = new BookMapper();
    BorrowerMapper cm = new BorrowerMapper();
    String msg = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, BookException, BorrowerException
    {
        response.setContentType("text/html;charset=UTF-8");
        //Get data from jsp form
        String date_from = request.getParameter("datepicker_from");
        String date_to = request.getParameter("datepicker_to");
        int copyno = Integer.parseInt(request.getParameter("copyno"));
        int SSN = Integer.parseInt(request.getParameter("SSN"));

        if(date_to.isEmpty())
        {
            date_to = date_from;
        }
        
        bm.reserveBook(date_from, date_to, copyno, SSN);
        
        if(cm.getBorrower(SSN).isStatus() == true)
        {
            msg = "Du har nu reserveret din bog!";
        }
        else if(cm.getBorrower(SSN).isStatus() == false)
        {
            msg = "Du har ikke rettigheder til at låne flere bøger!";
        }
        
        
        request.getSession().setAttribute("done", msg);
        
        request.getRequestDispatcher("view.jsp").forward(request, response);
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
            try
            {
                processRequest(request, response);
            } catch (BorrowerException ex)
            {
                Logger.getLogger(ControlReserve.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BookException ex)
        {
            Logger.getLogger(ControlReserve.class.getName()).log(Level.SEVERE, null, ex);
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
            try
            {
                processRequest(request, response);
            } catch (BorrowerException ex)
            {
                Logger.getLogger(ControlReserve.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (BookException ex)
        {
            Logger.getLogger(ControlReserve.class.getName()).log(Level.SEVERE, null, ex);
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
