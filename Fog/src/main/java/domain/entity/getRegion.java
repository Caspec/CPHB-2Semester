/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

import java.util.Date;

/**
 *
 * @author Makemewant
 */
public class getRegion {
    
   // User
    private int user_id;
    private String user_name;
    private String user_email;
    private String user_adress;
    private String user_phone;
    private int user_zip;
    
    // Order
    private Date order_recived;

    public getRegion(int user_id, String user_name, String user_email, String user_adress, String user_phone, int user_zip, Date order_recived) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_adress = user_adress;
        this.user_phone = user_phone;
        this.user_zip = user_zip;
        this.order_recived = order_recived;
    }

   

    public getRegion() {
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

    public Date getOrder_recived() {
        return order_recived;
    }

    public int getUser_id() {
        return user_id;
    }

    @Override
    public String toString() {
        return "getRegion{" + "user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_adress=" + user_adress + ", user_phone=" + user_phone + ", user_zip=" + user_zip + ", order_recived=" + order_recived + '}';
    }

    

   
    
}
