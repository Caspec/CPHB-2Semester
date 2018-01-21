/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import data.CustomerMapper;
import data.OrderMapper;
import domain.entity.Customer;
import domain.entity.Order;
import domain.exception.CustomerException;
import domain.exception.OrderException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Makemewant
 */
@WebServlet(name = "ControlOrder", urlPatterns = {"/ControlOrder"})
public class ControlOrder extends HttpServlet {

    OrderMapper om = new OrderMapper();
    CustomerMapper cm = new CustomerMapper();
    List myList = new ArrayList<>();
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, OrderException
    {

        String[] topids =  request.getParameterValues("cakestopid");
        String[] bottomids = request.getParameterValues("cakesbottomid");
        String[] quantities = request.getParameterValues("cakesquantity");
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        
        om.createNewOrder(1, 1, customer.getId(), 1, 5);
        
//        Collections.addAll(myList, topids, bottomids, quantities);
//        for (int i = 0; i < topids.length; i++) {
//            System.out.println(topids[i] + bottomids[i] + quantities[i]);
//        }
//        request.getSession().setAttribute("basket", myList);
//        request.getRequestDispatcher("info.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        } catch (OrderException ex)
        {
            Logger.getLogger(ControlOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try
        {
            processRequest(request, response);
        } catch (OrderException ex)
        {
            Logger.getLogger(ControlOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
