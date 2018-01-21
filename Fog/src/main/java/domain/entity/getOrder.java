
package domain.entity;

import java.util.Date;

public class getOrder {
    
    // Order
    private int order_id;
    private String order_status;
    private boolean order_logistic;
    private Date order_recived;
    private Date order_delivered;
    
    // OrderData
    private int orderdata_lenght;
    private int orderdata_width;
    private int orderdata_height;
    private int orderdata_floor;
    private int orderdata_roof;
    private int orderdata_side;
    
    // User
    private String user_name;
    private String user_email;
    private String user_adress;
    private String user_phone;
    private int user_zip;
    
    // Orderdetail
    private int orderdetail_quantity;
    
    // Item
    private String item_name;
    private double item_price;

    public getOrder(int order_id, String order_status, boolean order_logistic, Date order_recived, Date order_delivered, int orderdata_lenght, int orderdata_width, int orderdata_height, int orderdata_floor, int orderdata_roof, int orderdata_side, String user_name, String user_email, String user_adress, String user_phone, int user_zip, int orderdetail_quantity, String item_name, double item_price) {
        this.order_id = order_id;
        this.order_status = order_status;
        this.order_logistic = order_logistic;
        this.order_recived = order_recived;
        this.order_delivered = order_delivered;
        this.orderdata_lenght = orderdata_lenght;
        this.orderdata_width = orderdata_width;
        this.orderdata_height = orderdata_height;
        this.orderdata_floor = orderdata_floor;
        this.orderdata_roof = orderdata_roof;
        this.orderdata_side = orderdata_side;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_adress = user_adress;
        this.user_phone = user_phone;
        this.user_zip = user_zip;
        this.orderdetail_quantity = orderdetail_quantity;
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public boolean isOrder_logistic() {
        return order_logistic;
    }

    public void setOrder_logistic(boolean order_logistic) {
        this.order_logistic = order_logistic;
    }

    public Date getOrder_recived() {
        return order_recived;
    }

    public void setOrder_recived(Date order_recived) {
        this.order_recived = order_recived;
    }

    public Date getOrder_delivered() {
        return order_delivered;
    }

    public void setOrder_delivered(Date order_delivered) {
        this.order_delivered = order_delivered;
    }

    public int getOrderdata_lenght() {
        return orderdata_lenght;
    }

    public void setOrderdata_lenght(int orderdata_lenght) {
        this.orderdata_lenght = orderdata_lenght;
    }

    public int getOrderdata_width() {
        return orderdata_width;
    }

    public void setOrderdata_width(int orderdata_width) {
        this.orderdata_width = orderdata_width;
    }

    public int getOrderdata_height() {
        return orderdata_height;
    }

    public void setOrderdata_height(int orderdata_height) {
        this.orderdata_height = orderdata_height;
    }

    public int getOrderdata_floor() {
        return orderdata_floor;
    }

    public void setOrderdata_floor(int orderdata_floor) {
        this.orderdata_floor = orderdata_floor;
    }

    public int getOrderdata_roof() {
        return orderdata_roof;
    }

    public void setOrderdata_roof(int orderdata_roof) {
        this.orderdata_roof = orderdata_roof;
    }

    public int getOrderdata_side() {
        return orderdata_side;
    }

    public void setOrderdata_side(int orderdata_side) {
        this.orderdata_side = orderdata_side;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_adress() {
        return user_adress;
    }

    public void setUser_adress(String user_adress) {
        this.user_adress = user_adress;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public int getUser_zip() {
        return user_zip;
    }

    public void setUser_zip(int user_zip) {
        this.user_zip = user_zip;
    }

    public int getOrderdetail_quantity() {
        return orderdetail_quantity;
    }

    public void setOrderdetail_quantity(int orderdetail_quantity) {
        this.orderdetail_quantity = orderdetail_quantity;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }
    

    
           
    
}
