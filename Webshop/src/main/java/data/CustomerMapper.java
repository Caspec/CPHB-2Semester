package data;

import domain.entity.Customer;
import domain.exception.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerMapper {

    public Customer getCustomer(int id) throws CustomerException {
        Customer customer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE customer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_password = rs.getString("customer_password");
                int fk_role_id = rs.getInt("fk_role_id");
                double customer_balance = rs.getDouble("customer_balance");
                customer = new Customer(customer_id, customer_name, customer_password, fk_role_id, customer_balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CustomerException("Error in getCustomer() " +ex.getMessage());
        }

        return customer;
    }
    
    public ArrayList<Customer> getAllCustomers() throws CustomerException 
    {
        Customer customer = null;
        ArrayList<Customer> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_password = rs.getString("customer_password");
                int fk_role_id = rs.getInt("fk_role_id");
                double customer_balance = rs.getDouble("customer_balance");
                customer = new Customer(customer_id, customer_name, customer_password, fk_role_id, customer_balance);
                al.add(customer);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CustomerException("Error in getAllCustomers() " +ex.getMessage());
        }
        
        return al;
    }
    
    public void createNewCustomer(String customer_name, String customer_password) throws CustomerException
    {
        CustomerMapper customer = new CustomerMapper();
       
            Connection conn = new DB().getConnection();
            try
            {
                //Starter transaktion
                String ins_customer = "INSERT INTO customer (customer_name, customer_password, fk_role_id, customer_balance) VALUES (?, ?, ?, ?)";
                PreparedStatement customerStmt = conn.prepareStatement(ins_customer);

                //Transaction
                conn.setAutoCommit(false);
                //Create new user
                customerStmt.setString(1, customer_name);
                customerStmt.setString(2, customer_password);
                customerStmt.setInt(3, 2);
                customerStmt.setDouble(4, 10);
                customerStmt.executeUpdate();

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
                    throw new CustomerException("Error in createNewCustomer " + ex1.getMessage());
                }
            }
    }
    
    public Customer login(String name, String password) throws CustomerException {
        CustomerMapper cm = new CustomerMapper();
        Customer customer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM customer WHERE customer_name = ? AND customer_password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_password = rs.getString("customer_password");
                int fk_role_id = rs.getInt("fk_role_id");
                double customer_balance = rs.getDouble("customer_balance");
                customer = new Customer(customer_id, customer_name, customer_password, fk_role_id, customer_balance);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CustomerException("Error in login() " +ex.getMessage());
        }

        return customer;
    }

    
    public static void main(String[] args) throws CustomerException {
        Customer customer = new CustomerMapper().getCustomer(1);
        System.out.println(customer);
        ArrayList<Customer> customer2 = new CustomerMapper().getAllCustomers();
        System.out.println(customer2);
    }
}
