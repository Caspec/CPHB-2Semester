
package domain.entity;


public class Order
{
    private int id;
    private int topping_id;
    private int bottom_id;
    private int customer_id;
    private double totalprice;

    public Order(int id, int topping_id, int bottom_id, int customer_id, double totalprice)
    {
        this.id = id;
        this.topping_id = topping_id;
        this.bottom_id = bottom_id;
        this.customer_id = customer_id;
        this.totalprice = totalprice;
    }

    public Order()
    {
    }

    public int getId()
    {
        return id;
    }


    public int getTopping_id()
    {
        return topping_id;
    }

    public void setTopping_id(int topping_id)
    {
        this.topping_id = topping_id;
    }

    public int getBottom_id()
    {
        return bottom_id;
    }

    public void setBottom_id(int bottom_id)
    {
        this.bottom_id = bottom_id;
    }

    public int getCustomer_id()
    {
        return customer_id;
    }

    public void setCustomer_id(int customer_id)
    {
        this.customer_id = customer_id;
    }

    public double getTotalprice()
    {
        return totalprice;
    }

    @Override
    public String toString()
    {
        return "Order{" + "id=" + id + ", topping_id=" + topping_id + ", bottom_id=" + bottom_id + ", customer_id=" + customer_id + ", totalprice=" + totalprice + '}';
    }

    

    
    
}
