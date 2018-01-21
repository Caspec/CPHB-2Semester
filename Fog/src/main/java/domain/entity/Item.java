
package domain.entity;


public class Item {
    
    private int item_id;
    private String item_name;
    private String item_info;
    private double item_price;
    private int FK_Item_id;

    public Item(int item_id, String item_name, String item_info, double item_price, int FK_Item_id) {
        this.item_id = item_id;
        this.item_name = item_name;
        this.item_info = item_info;
        this.item_price = item_price;
        this.FK_Item_id = FK_Item_id;
    }

    public int getItem_id() {
        return item_id;
    }


    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_info() {
        return item_info;
    }

    public void setItem_info(String item_info) {
        this.item_info = item_info;
    }

    public double getItem_price() {
        return item_price;
    }

    public void setItem_price(double item_price) {
        this.item_price = item_price;
    }

    public int getFK_Item_id() {
        return FK_Item_id;
    }

    public void setFK_Item_id(int FK_Item_id) {
        this.FK_Item_id = FK_Item_id;
    }

   
    
    
}
