package presentation;

import data.DBFacade;
import data.UserMapper;
import domain.entity.User;
import domain.exception.UserException;
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

@WebServlet(name = "ControlLogin", urlPatterns
        = {
            "/ControlLogin"
        })
public class ControlLogin extends HttpServlet {



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UserException {
        response.setContentType("text/html;charset=UTF-8");
        
        DBFacade dbf = new DBFacade();
        
        //Get data from jsp form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = dbf.login(email, password);

        if (user == null) {
   
            response.sendRedirect("login.jsp");
        } else {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("username", user.getName());
            response.sendRedirect("adminstrap_theme/index.jsp");
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
        } catch (UserException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
            
           String msg = ex.getMessage();
           
           request.setAttribute("msg", msg);
            
           RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
           
           rd.forward(request, response);
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
        } catch (UserException ex) {
            Logger.getLogger(ControlLogin.class.getName()).log(Level.SEVERE, null, ex);
             String msg = ex.getMessage();
           
           request.setAttribute("msg", msg);
            
           RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
           
           rd.forward(request, response);
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
