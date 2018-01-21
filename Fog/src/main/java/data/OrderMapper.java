package data;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import domain.entity.Order;
import domain.entity.OrderData;
import domain.entity.OrderDetail;
import domain.entity.getOrder;
import domain.exception.OrderException;
import domain.exception.UserException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import jdk.nashorn.internal.objects.NativeDate;

/**
 *
 * @author Makemewant tobakoz
 */
public class OrderMapper {

    // Get one order, for testing that can recive one order from console in the first part
    public Order getOrder(int id) throws OrderException {
        Order order = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE Order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrder() " + ex.getMessage());
        }

        return order;
    }

    // Get OrderData, used in ControlOrderDetail 
    public OrderData getOrderData(int orderId) throws OrderException {
        OrderData od = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `OrderData` WHERE FK_Order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int od_length = rs.getInt("Orderdata_length");
                int od_width = rs.getInt("Orderdata_width");
                int od_height = rs.getInt("Orderdata_height");
                int od_floor = rs.getInt("Orderdata_floor");
                int od_roof = rs.getInt("Orderdata_roof");
                int od_side = rs.getInt("Orderdata_side");
                int fk_order_id = rs.getInt("FK_Order_id");

                od = new OrderData(od_length, od_width, od_height, od_floor, od_roof, od_side, fk_order_id);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrder() " + ex.getMessage());
        }

        return od;
    }

    /**
     * This method getView to show all data in modal popup
     *
     * @param id
     * @return returns getOrder object
     * @throws domain.exception.OrderException throws an OrderException
     */
    public getOrder getOrderPopup(int id) throws OrderException {
        getOrder getorder = null;
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` INNER JOIN OrderDetail ON OrderDetail.FK_Order_id = Order_id INNER JOIN Item ON Item.Item_id = OrderDetail.FK_Item_id INNER JOIN User ON `Order`.FK_User_id = User.User_id INNER JOIN OrderData ON `Order`.Order_id = OrderData.FK_Order_id WHERE `Order`.Order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                // Order
                int order_id = rs.getInt("Order_id");
                String order_status = rs.getString("Order_status");
                Boolean order_logicstic = rs.getBoolean("Order_logicstic");
                Date order_recived = rs.getDate("Order_recived");
                Date order_delivered = rs.getDate("Order_delivered");

                // Order Data
                int orderdata_lenght = rs.getInt("Orderdata_length");
                int orderdata_width = rs.getInt("Orderdata_width");
                int orderdata_height = rs.getInt("Orderdata_height");
                int orderdata_floor = rs.getInt("Orderdata_floor");
                int orderdata_roof = rs.getInt("Orderdata_roof");
                int orderdata_side = rs.getInt("Orderdata_side");

                // Orderdetail
                int orderdetail_quantity = rs.getInt("Orderdetail_quantity");

                // Item
                String item_name = rs.getString("Item_name");
                Double item_price = rs.getDouble("Item_price");

                // User
                String user_name = rs.getString("User_name");
                String user_email = rs.getString("User_email");
                String user_adress = rs.getString("User_adress");
                String user_phone = rs.getString("User_phone");
                int user_zip = rs.getInt("User_zip");

                getorder = new getOrder(order_id, order_status, order_logicstic, order_recived, order_delivered, orderdata_lenght, orderdata_width, orderdata_height, orderdata_floor, orderdata_roof, orderdata_side, user_name, user_email, user_adress, user_phone, user_zip, orderdetail_quantity, item_name, item_price);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderPopup() " + ex.getMessage());
        }

        return getorder;
    }

    /**
     * This method gets a list of order by notApproved
     *
     * @return returns a list of order
     * @throws domain.exception.OrderException
     */
    public ArrayList<Order> getOrderByStatusNotApprove() throws OrderException {
        String notApprove = "Ikke godkendt";
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE Order_status = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, notApprove);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
                al.add(order);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderByStatusNotApprove() " + ex.getMessage());
        }

        return al;
    }

    // used in ControlOrderDetail to get all details to that order
    public ArrayList<OrderDetail> getAllOrderDetailById(int orderId) throws OrderException {

        OrderDetail od = null;
        ArrayList<OrderDetail> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM fogdb.OrderDetail WHERE FK_Order_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                int orderQuantity = rs.getInt("Orderdetail_quantity");
                int orderMeasurement = rs.getInt("Orderdetail_measurement");
                int fkOrderId = rs.getInt("FK_Order_id");
                int fkItemId = rs.getInt("FK_Item_id");

                od = new OrderDetail(orderQuantity, orderMeasurement, fkOrderId, fkItemId);
                al.add(od);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderByStatusNotApprove() " + ex.getMessage());
        }

        return al;
    }

    /**
     * This method gets a list of order by Approved
     *
     * @return returns a list of order
     * @throws domain.exception.OrderException
     */
    public ArrayList<Order> getOrderByStatusApprove() throws OrderException {
        String Approve = "Godkendt";
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE Order_status = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Approve);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
                al.add(order);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderByStatusApprove() " + ex.getMessage());
        }

        return al;
    }

    /**
     * This method gets a list of order by Packed
     *
     * @return returns a list of order
     * @throws domain.exception.OrderException
     */
    public ArrayList<Order> getOrderByStatusPacked() throws OrderException {
        String Packed = "Pakket";
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE Order_status = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Packed);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
                al.add(order);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderByStatusPacked() " + ex.getMessage());
        }

        return al;
    }

    /**
     * This method gets a list of order by Shipped
     *
     * @return returns a list of order
     * @throws domain.exception.OrderException
     */
    public ArrayList<Order> getOrderByStatusShipped() throws OrderException {
        String Packed = "Afsendt";
        Order order = null;
        ArrayList<Order> al = new ArrayList<>();
        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE Order_status = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Packed);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
                al.add(order);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrderByStatusShipped() " + ex.getMessage());
        }

        return al;

    }

    /**
     * This method gets a order with paramter id and localdate. Used to
     * Step-wizard, ControlInsertUserData
     *
     * @param userId
     * @param orderRecive
     * @return returns a order with paramter id and localdate
     * @throws domain.exception.OrderException
     */
    public Order getOrderByUserIdAndOrderRecived(int userId, LocalDate orderRecive) throws OrderException {
        Order order = null;
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(orderRecive);

            Connection conn = new DB().getConnection();
            String sql = "SELECT * FROM `Order` WHERE FK_User_id = ? AND Order_recived = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setDate(2, sqlDate);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int orderId = rs.getInt("Order_id");
                String orderStatus = rs.getString("Order_status");
                Boolean orderLogistic = rs.getBoolean("Order_logicstic");
                Date orderRecived = rs.getDate("Order_recived");
                Date orderDelivered = rs.getDate("Order_delivered");
                int fkUserId = rs.getInt("FK_User_id");
                int fkUserRole = rs.getInt("FK_User_role_id");
                order = new Order(orderId, orderStatus, orderLogistic, orderRecived, orderDelivered, fkUserId, fkUserRole);
            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getOrder() " + ex.getMessage());
        }

        return order;
    }

    /**
     * This method is used to count how many zips in a range (Afdeling.jsp)
     *
     * @param minZip
     * @param maxZip
     * @return returns a order with paramter id and localdate
     * @throws domain.exception.OrderException
     */
    public int getZipRange(int minZip, int maxZip) throws OrderException {
        int countOrderByZip = 0;

        try {
            Connection conn = new DB().getConnection();
            String sql = "SELECT COUNT(Order_id) AS TOTALORDERS FROM `Order` INNER JOIN User ON User.User_id = `Order`.FK_User_id WHERE User_zip >= ? && User_zip <= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, minZip);
            pstmt.setInt(2, maxZip);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                countOrderByZip = rs.getInt("TOTALORDERS");

            }
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in getZipRange() " + ex.getMessage());
        }

        return countOrderByZip;
    }

    // UPDATE METHODS--------------
    // Update an order by Order_id, ControlEditOrder
    public void setOrderStatus(int id, String status) throws OrderException {
        try {
            Connection conn = new DB().getConnection();
            String sql = "UPDATE `fogdb`.`Order` SET `Order_status`=? WHERE `Order_id`=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, status);
            pstmt.setInt(2, id);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderStatus() " + ex.getMessage());
        }
    }

    // Update order data  by Order_id
    // ControlEditData
    public void setOrderData(int length, int width, int height, int floor, int roof, int side, int FK_Order_id) throws OrderException {
        try {
            Connection conn = new DB().getConnection();
            String sql = "UPDATE `fogdb`.`OrderData` SET `Orderdata_length`=?, `Orderdata_width`=?, `Orderdata_height`=?, `Orderdata_floor`=?, `Orderdata_roof`=?, `Orderdata_side`=? WHERE `FK_Order_id`=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, length);
            pstmt.setInt(2, width);
            pstmt.setInt(3, height);
            pstmt.setInt(4, floor);
            pstmt.setInt(5, roof);
            pstmt.setInt(6, side);
            pstmt.setInt(7, FK_Order_id);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderData() " + ex.getMessage());
        }
    }

    // ControlDeleteOrder
    public void deleteOrder(int id) throws OrderException {
        try {

            Connection conn = new DB().getConnection();
            String sql = "DELETE FROM `fogdb`.`Order` WHERE `Order_id`=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderStatus() " + ex.getMessage());
        }
    }

    // Insert new order in stepwizard
    public void insertNewOrder(int userId, LocalDate date) throws OrderException {
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);

            Connection conn = new DB().getConnection();
            String sql = "INSERT INTO `fogdb`.`Order` (`Order_status`, `Order_logicstic`, `FK_User_id`, `FK_User_role_id`, `Order_recived`) VALUES ('Ikke godkendt', '0', ?, '1', ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);

            pstmt.setDate(2, sqlDate);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderStatus() " + ex.getMessage());
        }
    }

    // Insert new orderData in stepwizard
    public void insertNewOrderData(int orderData_length, int orderData_width, int orderData_height, int orderData_floor, int orderData_roof, int orderData_side, int orderId) throws OrderException {
        try {

            Connection conn = new DB().getConnection();
            String sql = "INSERT INTO `fogdb`.`OrderData` (`orderData_length`, `orderData_width`, `orderData_height`, `orderData_floor`, `orderData_roof`, `orderData_side`, `FK_Order_id`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, orderData_length);
            pstmt.setInt(2, orderData_width);
            pstmt.setInt(3, orderData_height);
            pstmt.setInt(4, orderData_floor);
            pstmt.setInt(5, orderData_roof);
            pstmt.setInt(6, orderData_side);
            pstmt.setInt(7, orderId);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderStatus() " + ex.getMessage());
        }
    }

    // Insert orderDetails in stepwizard
    public void insertNewOrderDetail(int orderdetail_quantity, int orderdetail_measurement, int FK_Order_id, int FK_Item_id) throws OrderException {
        try {

            Connection conn = new DB().getConnection();
            String sql = "INSERT INTO `fogdb`.`OrderDetail` (`Orderdetail_quantity`, `Orderdetail_measurement`, `FK_Order_id`, `FK_Item_id`) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, orderdetail_quantity);
            pstmt.setInt(2, orderdetail_measurement);
            pstmt.setInt(3, FK_Order_id);
            pstmt.setInt(4, FK_Item_id);

            // executeUpdate
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new OrderException("Error in setOrderStatus() " + ex.getMessage());
        }
    }

    public static void main(String[] args) throws OrderException {
        //  Order o = new OrderMapper().getOrder(1);
        // System.out.println(o);
        System.out.println("");
        ArrayList<Order> getOrderByStatusNotApprove = new OrderMapper().getOrderByStatusNotApprove();
        System.out.println(getOrderByStatusNotApprove);
        getOrder o = new OrderMapper().getOrderPopup(1);
        System.out.println(o);

        LocalDate ld = LocalDate.now();
        java.sql.Date sqlDate = java.sql.Date.valueOf(ld);
        System.out.println(sqlDate);

    }

}
