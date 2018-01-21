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
public class Bottom
{
    private int bottom_id;
    private String bottom_name;
    private double bottom_price;
    private String bottom_img;

    public Bottom(int bottom_id, String bottom_name, double bottom_price, String bottom_img)
    {
        this.bottom_id = bottom_id;
        this.bottom_name = bottom_name;
        this.bottom_price = bottom_price;
        this.bottom_img = bottom_img;
    }

    public Bottom()
    {
    }

    public int getBottom_id()
    {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id)
    {
        this.bottom_id = bottom_id;
    }

    public String getBottom_name()
    {
        return bottom_name;
    }

    public void setBottom_name(String bottom_name)
    {
        this.bottom_name = bottom_name;
    }

    public double getBottom_price()
    {
        return bottom_price;
    }

    public void setBottom_price(double bottom_price)
    {
        this.bottom_price = bottom_price;
    }

    public String getBottom_img()
    {
        return bottom_img;
    }

    public void setBottom_img(String bottom_img)
    {
        this.bottom_img = bottom_img;
    }

    @Override
    public String toString()
    {
        return "Bottom{" + "bottom_id=" + bottom_id + ", bottom_name=" + bottom_name + ", bottom_price=" + bottom_price + ", bottom_img=" + bottom_img + '}';
    }
    
    
}
