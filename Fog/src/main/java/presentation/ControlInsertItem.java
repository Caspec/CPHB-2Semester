package presentation;

import data.DBFacade;
import data.ItemMapper;
import domain.exception.ItemException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControlInsertItem", urlPatterns = {"/ControlInsertItem"})
public class ControlInsertItem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ItemException {
        response.setContentType("text/html;charset=UTF-8");

//        ItemMapper im = new ItemMapper();
         DBFacade dbf = new DBFacade();        

        String item_name = (String) request.getParameter("item_name");
        String item_info = (String) request.getParameter("item_info");
        double item_price  = Double.parseDouble((String) request.getParameter("item_price"));
        int FK_Item_id = Integer.parseInt((String) request.getParameter("FK_Item_id"));

        dbf.createNewItem(item_name, item_info, item_price, FK_Item_id);
        
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
        } catch (ItemException ex) {
            Logger.getLogger(ControlInsertItem.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ItemException ex) {
            Logger.getLogger(ControlInsertItem.class.getName()).log(Level.SEVERE, null, ex);
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
