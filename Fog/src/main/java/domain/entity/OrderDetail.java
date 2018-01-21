/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author stev
 */
public class OrderDetail {
    
    private int orderQuantity;
    private int orderMeasurement;
    private int fkOrderId;
    private int fkItemId;

    public OrderDetail(int orderQuantity, int orderMeasurement, int fkOrderId, int fkItemId) {
        this.orderQuantity = orderQuantity;
        this.orderMeasurement = orderMeasurement;
        this.fkOrderId = fkOrderId;
        this.fkItemId = fkItemId;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getOrderMeasurement() {
        return orderMeasurement;
    }

    public void setOrderMeasurement(int orderMeasurement) {
        this.orderMeasurement = orderMeasurement;
    }

    public int getFkOrderId() {
        return fkOrderId;
    }

    public int getFkItemId() {
        return fkItemId;
    }  
    
}
