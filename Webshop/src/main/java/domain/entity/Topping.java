/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.entity;

/**
 *
 * @author auron
 */
public class Topping
{
    private int topping_id;
    private String topping_name;
    private double topping_price;
    private String topping_img;

    public Topping(int topping_id, String topping_name, double topping_price, String topping_img)
    {
        this.topping_id = topping_id;
        this.topping_name = topping_name;
        this.topping_price = topping_price;
        this.topping_img = topping_img;
    }

    public Topping()
    {
    }

    public int getTopping_id()
    {
        return topping_id;
    }

    public void setTopping_id(int topping_id)
    {
        this.topping_id = topping_id;
    }

    public String getTopping_name()
    {
        return topping_name;
    }

    public void setTopping_name(String topping_name)
    {
        this.topping_name = topping_name;
    }

    public double getTopping_price()
    {
        return topping_price;
    }

    public void setTopping_price(double topping_price)
    {
        this.topping_price = topping_price;
    }

    public String getTopping_img()
    {
        return topping_img;
    }

    public void setTopping_img(String topping_img)
    {
        this.topping_img = topping_img;
    }

    @Override
    public String toString()
    {
        return "Topping{" + "topping_id=" + topping_id + ", topping_name=" + topping_name + ", topping_price=" + topping_price + ", topping_img=" + topping_img + '}';
    }
    
    
}
