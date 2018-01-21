
package domain.entity;

import java.util.Date;



public class Order {
    
    private int orderId;
    /**
     * This is komack with fucker id
     */
    private String orderStatus;
    private Boolean orderLogicstic;
    private Date orderRecived;
    private Date orderDelivered;
    private int fkUserId;
    private int fkUserRole;

    public Order(int orderId, String orderStatus, Boolean orderLogicstic, Date orderRecived, Date orderDelivered, int fkUserId, int fkUserRole) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.orderLogicstic = orderLogicstic;
        this.orderRecived = orderRecived;
        this.orderDelivered = orderDelivered;
        this.fkUserId = fkUserId;
        this.fkUserRole = fkUserRole;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Boolean getOrderLogicstic() {
        return orderLogicstic;
    }

    public void setOrderLogicstic(Boolean orderLogicstic) {
        this.orderLogicstic = orderLogicstic;
    }

    public Date getOrderRecived() {
        return orderRecived;
    }

    public void setOrderRecived(Date orderRecived) {
        this.orderRecived = orderRecived;
    }

    public Date getOrderDelivered() {
        return orderDelivered;
    }

    public void setOrderDelivered(Date orderDelivered) {
        this.orderDelivered = orderDelivered;
    }

    public int getFkUserId() {
        return fkUserId;
    }

    public int getFkUserRole() {
        return fkUserRole;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderStatus=" + orderStatus + ", orderLogicstic=" + orderLogicstic + ", orderRecived=" + orderRecived + ", orderDelivered=" + orderDelivered + ", fkUserId=" + fkUserId + ", fkUserRole=" + fkUserRole + '}';
    }

    
    
}
