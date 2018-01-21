package presentation;

import data.BorrowerMapper;
import domain.entity.Borrower;
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

@WebServlet(name = "ControlLogin", urlPatterns =
{
    "/ControlLogin"
})
public class ControlLogin extends HttpServlet
{

    BorrowerMapper cm = new BorrowerMapper();
    String msg = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, BorrowerException
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //Get data from jsp form
        String username = request.getParameter("user");
        int SSN = Integer.parseInt(request.getParameter("SSN"));

        String search = request.getParameter("search");
        String done = request.getParameter("done");
        request.getSession().setAttribute("search", search);
        request.getSession().setAttribute("done", done);

        request.setAttribute("search", search);
        request.setAttribute("done", done);

        Borrower login = cm.login(username, SSN);

        if (login == null)
        {
            msg = "Du har indtastet en bruger som ikke eksistere!";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } 
        else
        {
            request.getSession().setAttribute("login", login);
            request.getRequestDispatcher("view.jsp").forward(request, response);
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (BorrowerException ex)
        {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (BorrowerException ex)
        {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
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
