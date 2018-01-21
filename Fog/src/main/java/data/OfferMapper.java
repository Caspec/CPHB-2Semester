/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import domain.entity.Offer;
import domain.exception.OfferException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Makemewant tobako
 */
public class OfferMapper {

     // Get one offer, show in "vistilbud.jsp"
    public Offer getOffer(int id) throws OfferException {
        Offer offer = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM Offer WHERE Offer_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int tilbud_id = rs.getInt("Offer_id");
                String tilbud_name = rs.getString("Offer_headline");
                String tilbud_info = rs.getString("Offer_text");
                String tilbud_img = rs.getString("Offer_img");
                int tilbud_rabat = rs.getInt("Offer_discount");
                offer = new Offer(tilbud_id, tilbud_name, tilbud_info, tilbud_img, tilbud_rabat);
            }
            else{
             throw new OfferException("forkert id");
            }
                    
                
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OfferException("Forkert indtasting. ");
        }

        return offer;
    }
    
    // Get all Offer, show in "tilbud.jsp"
    public ArrayList<Offer> getAllOffer() throws OfferException 
    {
        Offer offer = null;
        ArrayList<Offer> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM Offer";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int tilbud_id = rs.getInt("Offer_id");
                String tilbud_name = rs.getString("Offer_headline");
                String tilbud_info = rs.getString("Offer_text");
                String tilbud_img = rs.getString("Offer_img");
                int tilbud_rabat = rs.getInt("Offer_discount");
                offer = new Offer(tilbud_id, tilbud_name, tilbud_info, tilbud_img, tilbud_rabat);
                al.add(offer);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OfferException("Error in getAllOffer () " + ex.getMessage());
        }

        return al;
    }

    // Create new offer, used in ControlInsertOffer
    public void createNewOffer(String tilbud_name, String tilbud_info, String tilbud_img, int tilbud_rabat) throws OfferException 
    {

        Connection conn = new DB().getConnection();
        try {

            String ins_offer = "INSERT INTO `fogdb`.`Offer` (`Offer_headline`, `Offer_img`, `Offer_text`, `Offer_discount`) VALUES (?, ?, ?, ?)";
            PreparedStatement customerStmt = conn.prepareStatement(ins_offer);

            conn.setAutoCommit(false);

            customerStmt.setString(1, tilbud_name);
            customerStmt.setString(2, tilbud_img);
            customerStmt.setString(3, tilbud_info);
            customerStmt.setInt(4, tilbud_rabat);
            customerStmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new OfferException("Error in createNewOffer " + ex1.getMessage());
            }
        }
    }
    
    
    // Update offer, used in ControlEditOffer
    public void setOffer(int offerId, String offerName, String offerInfo, String offerImg, int offerNumber) throws OfferException 
    {

        Connection conn = new DB().getConnection();
        try {

            String updateOffer = "UPDATE `fogdb`.`Offer` SET `Offer_headline`=?, `Offer_img`=?, `Offer_text`=?, `Offer_discount`=? WHERE `Offer_id`=?";
            PreparedStatement offerStmt = conn.prepareStatement(updateOffer);

            conn.setAutoCommit(false);

            offerStmt.setString(1, offerName);
            offerStmt.setString(2, offerImg);
            offerStmt.setString(3, offerInfo);
            offerStmt.setInt(4, offerNumber);
            offerStmt.setInt(5, offerId);
            offerStmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new OfferException("Error in createNewOffer " + ex1.getMessage());
            }
        }
    }
    
    
     // Delete offer, used in ControlDeleteOffer
    public void deleteOffer(int offerId) throws OfferException 
    {

        Connection conn = new DB().getConnection();
        try {

            String updateOffer = "DELETE FROM `fogdb`.`Offer` WHERE `Offer_id`=?";
            PreparedStatement offerStmt = conn.prepareStatement(updateOffer);

            conn.setAutoCommit(false);
            
            offerStmt.setInt(1, offerId);
            offerStmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new OfferException("Error in createNewOffer " + ex1.getMessage());
            }
        }
    }

    public static void main(String[] args) throws OfferException 
    {
        ArrayList<Offer> all = new OfferMapper().getAllOffer();
        System.out.println(all);
        System.out.println("");

    }
}
