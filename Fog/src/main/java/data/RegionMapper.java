/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.getRegion;
import domain.exception.RegionException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Makemewant
 */
public class RegionMapper {

    // Get all region range 1100
    public ArrayList<getRegion> getAllRegionsStartRange1100() throws RegionException {
        getRegion region = null;
        ArrayList<getRegion> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User INNER JOIN `Order` ON `Order`.FK_User_id = User.User_id WHERE User_zip >= 1100 && User_zip <= 3500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");
                Date order_recived = rs.getDate("Order_recived");
                region = new getRegion(user_id, user_name, user_email, user_adress, user_phone, user_zip, order_recived);
                al.add(region);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RegionException("Error in getAllCustomers() " + ex.getMessage());
        }

        return al;
    }

    // Get all region range 3510
    public ArrayList<getRegion> getAllRegionsStartRange3510() throws RegionException {
        getRegion region = null;
        ArrayList<getRegion> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User INNER JOIN `Order` ON `Order`.FK_User_id = User.User_id WHERE User_zip >= 3510 && User_zip <= 5500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");
                Date order_recived = rs.getDate("Order_recived");
                region = new getRegion(user_id, user_name, user_email, user_adress, user_phone, user_zip, order_recived);
                al.add(region);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RegionException("Error in getAllCustomers() " + ex.getMessage());
        }

        return al;
    }

    // Get all region range 5510
    public ArrayList<getRegion> getAllRegionsStartRange5510() throws RegionException {
        getRegion region = null;
        ArrayList<getRegion> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User INNER JOIN `Order` ON `Order`.FK_User_id = User.User_id WHERE User_zip >= 5510 && User_zip <= 7500";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");
                Date order_recived = rs.getDate("Order_recived");
                region = new getRegion(user_id, user_name, user_email, user_adress, user_phone, user_zip, order_recived);
                al.add(region);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RegionException("Error in getAllCustomers() " + ex.getMessage());
        }

        return al;
    }

    // Get all region range 7510
    public ArrayList<getRegion> getAllRegionsStartRange7510() throws RegionException {
        getRegion region = null;
        ArrayList<getRegion> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User INNER JOIN `Order` ON `Order`.FK_User_id = User.User_id WHERE User_zip >= 7510 && User_zip <= 9000";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");
                Date order_recived = rs.getDate("Order_recived");
                region = new getRegion(user_id, user_name, user_email, user_adress, user_phone, user_zip, order_recived);
                al.add(region);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RegionException("Error in getAllCustomers() " + ex.getMessage());
        }

        return al;
    }

    // Get all region range 9010
    public ArrayList<getRegion> getAllRegionsStartRange9010() throws RegionException {
        getRegion region = null;
        ArrayList<getRegion> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM User INNER JOIN `Order` ON `Order`.FK_User_id = User.User_id WHERE User_zip >= 9010 && User_zip <= 9990";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("User_id");
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");
                Date order_recived = rs.getDate("Order_recived");
                region = new getRegion(user_id, user_name, user_email, user_adress, user_phone, user_zip, order_recived);
                al.add(region);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RegionException("Error in getAllCustomers() " + ex.getMessage());
        }

        return al;
    }

    public static void main(String[] args) throws RegionException {
        ArrayList<getRegion> al = new RegionMapper().getAllRegionsStartRange1100();
        System.out.println(al);

    }
}
