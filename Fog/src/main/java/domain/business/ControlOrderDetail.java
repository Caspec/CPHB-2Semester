/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.business;

import data.DBFacade;
import domain.entity.OrderData;
import domain.entity.OrderDetail;
import domain.exception.ItemException;
import domain.exception.OrderException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ControlOrderDetail", urlPatterns = {"/ControlOrderDetail"})
public class ControlOrderDetail extends HttpServlet {

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
            throws ServletException, IOException, OrderException, ItemException {
        response.setContentType("text/html;charset=UTF-8");
        
        DOFacade dof = new DOFacade();
        Calc c = new Calc();
        
        // int orderId = Integer.parseInt((String)request.getAttribute("orderId"));
        int orderId = (int) request.getAttribute("orderId");
        
        int orderLength = dof.getOrderData( orderId ).getOrderDataLength();
        int orderWidth = dof.getOrderData( orderId ).getOrderDataWidth();
        int orderHeight = dof.getOrderData( orderId ).getOrderDataHeight();
        int orderFloor = dof.getOrderData( orderId ).getOrderDataFloor();
        int orderRoof = dof.getOrderData( orderId ).getOrderDataRoof();
        int orderSide = dof.getOrderData( orderId ).getOrderDataSide();
        
        // A Carport allways have 8 or 10 Træstolper in different sizes
        // A Carport allways have 1 or 2 Skruer with 50stk
        // A Carport allways have a Roof if its flat its (width x length) else its  ((width x length) x 1.5)
        // A Carport allways have a Floor and its (width x length)
        // A Carport allways have sides and its two times (height x length) and one time (width x height) 
        
        if( orderLength > 500 ){
            // Skruer item_id = 2
            dof.insertNewOrderDetail( 2, 1, orderId, 2 ) ;
            // Træstolter item_id = 1 
            dof.insertNewOrderDetail( 6, c.getMeasurementForWoodPillar(orderHeight), orderId, 1 );
            // Træstolper Item_id 1 for top length
            dof.insertNewOrderDetail( 2, orderLength, orderId, 1 );
            // Træstolper Item_id 1 for top Width
            dof.insertNewOrderDetail( 2, orderWidth, orderId, 1 );
            
            // Roof is FK_Item_id = 2 (Item_Type)
            dof.insertNewOrderDetail( c.getQuantityForRoof(orderLength), c.getMeasurementForRoof(orderWidth), orderId, orderRoof );
            // Side is FK_Item_id = 2 (Item_Type) 
            dof.insertNewOrderDetail( orderHeight, c.getQuantityForSide(orderLength, orderWidth), orderId, orderSide );
            // Floor is FK_Item_id = 4 (Item_Type)
            dof.insertNewOrderDetail( c.getMeasurementForFloor(orderLength), orderWidth, orderId, orderFloor );
            
           
        }else{
            // Skruer item_id = 2
            dof.insertNewOrderDetail( 1, 1, orderId, 2 );
            // Træstolter item_id = 1
            dof.insertNewOrderDetail( 4, c.getMeasurementForWoodPillar(orderHeight), orderId, 1 );
               // Træstolper Item_id 1 for top length
            dof.insertNewOrderDetail( 2, orderLength, orderId, 1 );
               // Træstolper Item_id 1 for top Width
            dof.insertNewOrderDetail( 2, orderWidth, orderId, 1 );
            
             // Roof is FK_Item_id = 2 (Item_Type)
            dof.insertNewOrderDetail( c.getQuantityForRoof(orderLength), c.getMeasurementForRoof(orderWidth), orderId, orderRoof );
            // Side is FK_Item_id = 2 (Item_Type) 
            dof.insertNewOrderDetail( orderHeight, c.getQuantityForSide(orderLength, orderWidth), orderId, orderSide );
            // Floor is FK_Item_id = 4 (Item_Type)
            dof.insertNewOrderDetail( c.getMeasurementForFloor(orderLength), orderWidth, orderId, orderFloor );
        }
        
        
        // Gets all orderDetails from DB in an ArrayList so we can go thru every one and calculate a totalprice
        ArrayList<OrderDetail> alod = dof.getAllOrderDetailById(orderId);
        // Gets totalPrice
        double totalPrice = c.getTotalPrice(alod);
        double moms = c.getMomsPrice(totalPrice);
       
            // setting attribute OrderId 
            request.getSession().setAttribute("totalPrice",totalPrice);
            request.getSession().setAttribute("length",orderLength);
            request.getSession().setAttribute("width",orderWidth);
            request.getSession().setAttribute("moms", moms);
            
            
        
         response.sendRedirect("order.jsp");
        
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
            } catch (ItemException ex) {
                Logger.getLogger(ControlOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (OrderException ex) {
            Logger.getLogger(ControlOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (ItemException ex) {
                Logger.getLogger(ControlOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (OrderException ex) {
            Logger.getLogger(ControlOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
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
