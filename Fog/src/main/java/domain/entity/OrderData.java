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
public class OrderData {
 
    private int orderDataLength;
    private int orderDataWidth;
    private int orderDataHeight;
    private int orderDataFloor;
    private int orderDataRoof;
    private int orderDataSide;
    private int fkOrderId;

    public OrderData(int orderDataLength, int orderDataWidth, int orderDataHeight, int orderDataFloor, int orderDataRoof, int orderDataSide, int fkOrderId) {
        this.orderDataLength = orderDataLength;
        this.orderDataWidth = orderDataWidth;
        this.orderDataHeight = orderDataHeight;
        this.orderDataFloor = orderDataFloor;
        this.orderDataRoof = orderDataRoof;
        this.orderDataSide = orderDataSide;
        this.fkOrderId = fkOrderId;
    }

    public int getFkOrderId() {
        return fkOrderId;
    }

    public int getOrderDataLength() {
        return orderDataLength;
    }

    public void setOrderDataLength(int orderDataLength) {
        this.orderDataLength = orderDataLength;
    }

    public int getOrderDataWidth() {
        return orderDataWidth;
    }

    public void setOrderDataWidth(int orderDataWidth) {
        this.orderDataWidth = orderDataWidth;
    }

    public int getOrderDataHeight() {
        return orderDataHeight;
    }

    public void setOrderDataHeight(int orderDataHeight) {
        this.orderDataHeight = orderDataHeight;
    }

    public int getOrderDataFloor() {
        return orderDataFloor;
    }

    public void setOrderDataFloor(int orderDataFloor) {
        this.orderDataFloor = orderDataFloor;
    }

    public int getOrderDataRoof() {
        return orderDataRoof;
    }

    public void setOrderDataRoof(int orderDataRoof) {
        this.orderDataRoof = orderDataRoof;
    }

    public int getOrderDataSide() {
        return orderDataSide;
    }

    public void setOrderDataSide(int orderDataSide) {
        this.orderDataSide = orderDataSide;
    }
    
    
}
