
package data;

import domain.entity.Bottom;
import domain.entity.Customer;
import domain.entity.Topping;
import domain.exception.CupCakeException;
import domain.exception.CustomerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CupCakeMapper
{
     public Topping getTopping(int id) throws CupCakeException {
        Topping topping = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM topping WHERE topping_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int topping_id = rs.getInt("topping_id");
                String topping_name = rs.getString("topping_name");
                double topping_price = rs.getDouble("topping_price");
                String topping_img = rs.getString("topping_img");
                topping = new Topping(topping_id, topping_name, topping_price, topping_img);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CupCakeException("Error in getTopping() " +ex.getMessage());
        }

        return topping;
    }
     
    public ArrayList<Topping> getAllTopping() throws CupCakeException 
    {
        Topping topping = null;
        ArrayList<Topping> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM topping";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                int topping_id = rs.getInt("topping_id");
                String topping_name = rs.getString("topping_name");
                double topping_price = rs.getDouble("topping_price");
                String topping_img = rs.getString("topping_img");
                topping = new Topping(topping_id, topping_name, topping_price, topping_img);
                al.add(topping);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CupCakeException("Error in getAllTopping() " +ex.getMessage());
        }
        
        return al;
    }
    
    public Bottom getBottom(int id) throws CupCakeException {
        Bottom bottom = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottom WHERE bottom_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int bottom_id = rs.getInt("bottom_id");
                String bottom_name = rs.getString("bottom_name");
                double bottom_price = rs.getDouble("bottom_price");
                String bottom_img = rs.getString("bottom_img");
                bottom = new Bottom(bottom_id, bottom_name, bottom_price, bottom_img);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CupCakeException("Error in getBottom() " +ex.getMessage());
        }

        return bottom;
    }
    
    public ArrayList<Bottom> getAllBottom() throws CupCakeException 
    {
        Bottom bottom = null;
        ArrayList<Bottom> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM bottom";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                int bottom_id = rs.getInt("bottom_id");
                String bottom_name = rs.getString("bottom_name");
                double bottom_price = rs.getDouble("bottom_price");
                String bottom_img = rs.getString("bottom_img");
                bottom = new Bottom(bottom_id, bottom_name, bottom_price, bottom_img);
                al.add(bottom);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new CupCakeException("Error in getAllBottom() " +ex.getMessage());
        }
        
        return al;
    }
     
      public static void main(String[] args) throws CupCakeException {
        Topping topping = new CupCakeMapper().getTopping(1);
        System.out.println(topping);
        ArrayList<Topping> topping2 = new CupCakeMapper().getAllTopping();
        System.out.println(topping2);
        Bottom bottom = new CupCakeMapper().getBottom(1);
        System.out.println(bottom);
        ArrayList<Bottom> bottom2 = new CupCakeMapper().getAllBottom();
        System.out.println(bottom2);
    }
}
