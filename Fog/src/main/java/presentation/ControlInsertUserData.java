/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DBFacade;
import data.OrderMapper;
import data.UserMapper;
import domain.entity.Order;
import domain.entity.User;
import domain.exception.OrderException;
import domain.exception.UserException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
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
 * @author stev
 */
@WebServlet(name = "ControlInsertUserData", urlPatterns = {"/ControlInsertUserData"})
public class ControlInsertUserData extends HttpServlet {

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
            throws ServletException, IOException, UserException, OrderException {

        DBFacade dbf = new DBFacade();
        // Get parameters from post
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));

        int floor = Integer.parseInt(request.getParameter("floor"));
        int roof = Integer.parseInt(request.getParameter("roof"));
        int side = Integer.parseInt(request.getParameter("side"));

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String adress = request.getParameter("adress");
        String phone = request.getParameter("phone");
        int zip = Integer.parseInt(request.getParameter("zip"));

        // create sql date
        LocalDate ld = LocalDate.now();

        // Insert new user 
        dbf.insertNewUser(name, email, adress, phone, zip);

        // Get user by email 
        User u = dbf.getUserByEmail(email);

        // get user_id
        int userId = u.getId();

        // Insert new order by user_id and date
        dbf.insertNewOrder(userId, ld);

        // get order by user_id and orderRecived date
        Order o = dbf.getOrderByUserIdAndOrderRecived(userId, ld);

        // get order_id
        int orderId = o.getOrderId();

        // Insert orderData
        dbf.insertNewOrderData(length, width, height, floor, roof, side, orderId);

        // setting attribute OrderId 
        request.setAttribute("orderId", orderId);

        // Where the request go 
        RequestDispatcher rd = request.getRequestDispatcher("ControlOrderDetail");

        // sending the request
        rd.forward(request, response);


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
            try {
                processRequest(request, response);
            } catch (OrderException ex) {
                Logger.getLogger(ControlInsertUserData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UserException ex) {
            Logger.getLogger(ControlInsertUserData.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (OrderException ex) {
                Logger.getLogger(ControlInsertUserData.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (UserException ex) {
            Logger.getLogger(ControlInsertUserData.class.getName()).log(Level.SEVERE, null, ex);
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
