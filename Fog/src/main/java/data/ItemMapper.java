package data;

import domain.entity.Item;
import domain.exception.ItemException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemMapper {

    // Insert new item, Transaction
    public void createNewItem(String item_name, String item_info, double item_price, int FK_Item_id) throws ItemException {

        Connection conn = new DB().getConnection();
        try {
            //Starter transaktion
            String ins_item = "INSERT INTO `fogdb`.`Item` (`Item_name`, `Item_info`, `Item_price`, `FK_Item_id`) VALUES (?, ?, ?, ?)";
            PreparedStatement orderStmt = conn.prepareStatement(ins_item);

            //Transaction
            conn.setAutoCommit(false);

            orderStmt.setString(1, item_name);
            orderStmt.setString(2, item_info);
            orderStmt.setDouble(3, item_price);
            orderStmt.setInt(4, FK_Item_id);
            orderStmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new ItemException("Error in createNewItem " + ex1.getMessage());
            }
        }
    }

    // Get one item, show item "vismateriale.jsp"
    public Item getItem(int id) throws ItemException {
        Item item = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM Item WHERE Item_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int item_id = rs.getInt("Item_id");
                String item_name = rs.getString("Item_name");
                String item_info = rs.getString("Item_info");
                Double item_price = rs.getDouble("Item_price");
                int FK_Item_id = rs.getInt("FK_Item_id");
                item = new Item(item_id, item_name, item_info, item_price, FK_Item_id);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ItemException("Error in getItem() " + ex.getMessage());
        }

        return item;
    }

    // Get all Item, show all items "lager.jsp"
    public ArrayList<Item> getAllItem() throws ItemException {
        Item item = null;
        ArrayList<Item> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM Item";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int item_id = rs.getInt("Item_id");
                String item_name = rs.getString("Item_name");
                String item_info = rs.getString("Item_info");
                Double item_price = rs.getDouble("Item_price");
                int FK_Item_id = rs.getInt("FK_Item_id");
                item = new Item(item_id, item_name, item_info, item_price, FK_Item_id);
                al.add(item);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ItemException("Error in getAllItem () " + ex.getMessage());
        }

        return al;
    }

    // Used in step wizard.jsp (dropdowns)
    public ArrayList<Item> getAllItemByTypeId(int typeId) throws ItemException 
    {
        Item item = null;
        ArrayList<Item> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM Item WHERE FK_Item_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, typeId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                int item_id = rs.getInt("Item_id");
                String item_name = rs.getString("Item_name");
                String item_info = rs.getString("Item_info");
                Double item_price = rs.getDouble("Item_price");
                int FK_Item_id = rs.getInt("FK_Item_id");
                item = new Item(item_id, item_name, item_info, item_price, FK_Item_id);
                al.add(item);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new ItemException("Error in getAllItem () " + ex.getMessage());
        }

        return al;
    }
    
    // update item, ControlEditItem
    public void setItem(String item_name, String item_info, double item_price, int item_id) throws ItemException {

        Connection conn = new DB().getConnection();
        try {
            //Starter transaktion
            String ins_item = "UPDATE `fogdb`.`Item` SET `Item_name`=?, `Item_info`=?, `Item_price`=? WHERE `Item_id`=?";
            PreparedStatement orderStmt = conn.prepareStatement(ins_item);

            //Transaction
            conn.setAutoCommit(false);

            orderStmt.setString(1, item_name);
            orderStmt.setString(2, item_info);
            orderStmt.setDouble(3, item_price);
            orderStmt.setInt(4, item_id);
            orderStmt.executeUpdate();

            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new ItemException("Error in setItem " + ex1.getMessage());
            }
        }
    }

    public static void main(String[] args) throws ItemException {

        Item o = new ItemMapper().getItem(1);
        System.out.println(o);

        ArrayList<Item> getAllItem = new ItemMapper().getAllItem();
        System.out.println(getAllItem);
    }

}
