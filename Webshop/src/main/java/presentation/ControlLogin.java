package presentation;

import data.CustomerMapper;
import domain.entity.Customer;
import domain.exception.CustomerException;
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

    CustomerMapper cm = new CustomerMapper();
    String msg = "";
//    boolean status;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, CustomerException
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //Get data from jsp form
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        Customer customer = cm.login(username, password);

        if (customer == null)
        {
//            status = false;
//            request.getSession().setAttribute("status", status);
            msg = "Du har indtastet en bruger som ikke eksistere!";
            request.getSession().setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } 
        else
        {
//            status = true;
//            request.getSession().setAttribute("status", status);
            request.getSession().setAttribute("customer", customer);
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
        } catch (CustomerException ex)
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
        } catch (CustomerException ex)
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
