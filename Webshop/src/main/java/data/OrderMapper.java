package data;

import domain.entity.Order;
import domain.exception.OrderException;
import domain.exception.CustomerException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper
{

    public Order getOrder(int id) throws OrderException
    {
        Order order = null;
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM order WHERE order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                int order_id = rs.getInt("order_id");
                int fk_topping_id = rs.getInt("fk_topping_id");
                int fk_bottom_id = rs.getInt("fk_bottom_id");
                int fk_customer_id = rs.getInt("fk_customer_id");
                double order_totalprice = rs.getDouble("totalprice");
                order = new Order(order_id, fk_topping_id, fk_bottom_id, fk_customer_id, order_totalprice);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new OrderException("Error in getOrder() " + ex.getMessage());
        }

        return order;
    }

    public ArrayList<Order> getAllOrder() throws OrderException
    {
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM order";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                int order_id = rs.getInt("order_id");
                int fk_topping_id = rs.getInt("fk_topping_id");
                int fk_bottom_id = rs.getInt("fk_bottom_id");
                int fk_customer_id = rs.getInt("fk_customer_id");
                double order_totalprice = rs.getDouble("totalprice");
                order = new Order(order_id, fk_topping_id, fk_bottom_id, fk_customer_id, order_totalprice);
                al.add(order);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new OrderException("Error in getAllOrder () " + ex.getMessage());
        }

        return al;
    }

    public ArrayList<Order> getAllOrderByCustomerId(int id) throws OrderException
    {
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try
        {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer, cupcakes.order, bottom, topping WHERE customer.customer_id = cupcakes.order.fk_customer_id and cupcakes.order.fk_bottom_id = bottom.bottom_id and cupcakes.order.fk_topping_id = topping.topping_id and cupcakes.customer.customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                int order_id = rs.getInt("order_id");
                int fk_topping_id = rs.getInt("fk_topping_id");
                int fk_bottom_id = rs.getInt("fk_bottom_id");
                int fk_customer_id = rs.getInt("fk_customer_id");
                double order_totalprice = rs.getDouble("order_totalprice");
                order = new Order(order_id, fk_topping_id, fk_bottom_id, fk_customer_id, order_totalprice);
                al.add(order);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            throw new OrderException("Error in getAllOrderByCustomerId() " + ex.getMessage());
        }

        return al;
    }
    
     public void createNewOrder(int fk_topping_id, int fk_bottom_id, int fk_customer_id, int order_quantity, double order_totalprice) throws OrderException
    {
       
            Connection conn = new DB().getConnection();
            try
            {
                //Starter transaktion
                String ins_order = "INSERT INTO cupcakes.order (fk_topping_id, fk_bottom_id, fk_customer_id, order_quantity, order_totalprice) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement orderStmt = conn.prepareStatement(ins_order);

                //Transaction
                conn.setAutoCommit(false);
                //Create new user
                orderStmt.setInt(1, fk_topping_id);
                orderStmt.setInt(2, fk_bottom_id);
                orderStmt.setInt(3, fk_customer_id);
                orderStmt.setInt(4, order_quantity);
                orderStmt.setDouble(5, order_totalprice);
                orderStmt.executeUpdate();

                conn.commit();
            } catch (SQLException ex)
            {
                ex.printStackTrace();
                try
                {
                    conn.rollback();
                } catch (SQLException ex1)
                {
                    ex1.printStackTrace();
                    throw new OrderException("Error in createNewOrder " + ex1.getMessage());
                }
            }
    }

    public static void main(String[] args) throws OrderException
    {
        ArrayList<Order> all = new OrderMapper().getAllOrderByCustomerId(1);
        System.out.println(all);
    }
}
