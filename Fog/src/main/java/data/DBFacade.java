package data;


import domain.entity.Item;
import domain.entity.Offer;
import domain.entity.Order;
import domain.entity.OrderData;
import domain.entity.OrderDetail;
import domain.entity.User;
import domain.entity.getRegion;
import domain.exception.ItemException;
import domain.exception.OfferException;
import domain.exception.OrderException;
import domain.exception.RegionException;
import domain.exception.UserException;
import java.time.LocalDate;
import java.util.ArrayList;


public class DBFacade implements IDBFacade  {


    ItemMapper im = new ItemMapper();
    OfferMapper om = new OfferMapper();
    OrderMapper orm = new OrderMapper();
    RegionMapper rm = new RegionMapper();
    UserMapper um = new UserMapper();

    @Override
    public void createNewItem(String item_name, String item_info, double item_price, int FK_Item_id) throws ItemException {
      im.createNewItem(item_name, item_info, item_price, FK_Item_id);
    }

    @Override
    public Item getItem(int id) throws ItemException {
        return im.getItem(id);
    }

    @Override
    public ArrayList<Item> getAllItem() throws ItemException {
       return im.getAllItem();
    }

    @Override
    public Offer getOffer(int id) throws OfferException {
        return om.getOffer(id);
    }

    @Override
    public ArrayList<Offer> getAllOffer() throws OfferException {
       return om.getAllOffer();
    }

    @Override
    public void createNewOffer(String tilbud_name, String tilbud_info, String tilbud_img, int tilbud_rabat) throws OfferException {
        om.createNewOffer(tilbud_name, tilbud_info, tilbud_img, tilbud_rabat);
    }

    @Override
    public void setOffer(int offerId, String offerName, String offerInfo, String offerImg, int offerNumber) throws OfferException {
        om.setOffer(offerId, offerName, offerInfo, offerImg, offerNumber);
    }

    @Override
    public void deleteOffer(int offerId) throws OfferException {
        om.deleteOffer(offerId);
    }

    @Override
    public Order getOrder(int id) throws OrderException {
       return  orm.getOrder(id);
    }

    @Override
    public domain.entity.getOrder getOrderPopup(int id) throws OrderException {
        return orm.getOrderPopup(id);
    }

    @Override
    public ArrayList<Order> getOrderByStatusNotApprove() throws OrderException {
        return orm.getOrderByStatusApprove();
    }

    @Override
    public ArrayList<Order> getOrderByStatusApprove() throws OrderException {
        return orm.getOrderByStatusApprove();
    }

    @Override
    public ArrayList<Order> getOrderByStatusPacked() throws OrderException {
        return orm.getOrderByStatusPacked();
    }

    @Override
    public ArrayList<Order> getOrderByStatusShipped() throws OrderException {
        return orm.getOrderByStatusShipped();
    }

    @Override
    public Order getOrderByUserIdAndOrderRecived(int userId, LocalDate orderRecive) throws OrderException {
        return orm.getOrderByUserIdAndOrderRecived(userId, orderRecive);
    }

    @Override
    public int getZipRange(int minZip, int maxZip) throws OrderException {
        return orm.getZipRange(minZip, maxZip);
    }

    @Override
    public void setOrderStatus(int id, String status) throws OrderException {
        orm.setOrderStatus(id, status);
    }

    @Override
    public void setOrderData(int length, int width, int height, int floor, int roof, int side, int FK_Order_id) throws OrderException {
        orm.setOrderData(length, width, height, floor, roof, side, FK_Order_id);
    }

    @Override
    public OrderData getOrderData(int orderId) throws OrderException {
       return orm.getOrderData(orderId);
    }
    

    @Override
    public void deleteOrder(int id) throws OrderException {
        orm.deleteOrder(id);
    }

    @Override
    public void insertNewOrder(int userId, LocalDate date) throws OrderException {
        orm.insertNewOrder(userId, date);
    }

    @Override
    public void insertNewOrderData(int orderData_length, int orderData_width, int orderData_height, int orderData_floor, int orderData_roof, int orderData_side, int orderId) throws OrderException {
        orm.insertNewOrderData(orderData_length, orderData_width, orderData_height, orderData_floor, orderData_roof, orderData_side, orderId);
    }

    @Override
    public void insertNewOrderDetail(int orderdetail_quantity, int orderdetail_measurement,int FK_Order_id, int FK_Item_id) throws OrderException {
        orm.insertNewOrderDetail(orderdetail_quantity, orderdetail_measurement, FK_Order_id, FK_Item_id);
    }

    @Override
    public ArrayList<getRegion> getAllRegionsStartRange1100() throws RegionException {
      return  rm.getAllRegionsStartRange1100();
    }

    @Override
    public ArrayList<getRegion> getAllRegionsStartRange3510() throws RegionException {
        return rm.getAllRegionsStartRange3510();
    }

    @Override
    public ArrayList<getRegion> getAllRegionsStartRange5510() throws RegionException {
        return rm.getAllRegionsStartRange5510();
    }

    @Override
    public ArrayList<getRegion> getAllRegionsStartRange7510() throws RegionException {
        return rm.getAllRegionsStartRange7510();
    }

    @Override
    public ArrayList<getRegion> getAllRegionsStartRange9010() throws RegionException {
        return rm.getAllRegionsStartRange9010();
    }

    @Override
    public User getUser(int id) throws UserException {
     return   um.getUser(id);
    }

    @Override
    public User getUserByEmail(String email) throws UserException {
       return um.getUserByEmail(email);
    }

    @Override
    public User getZip(int Zip) throws UserException {
        return um.getZip(Zip);
    }

    @Override
    public User login(String email, String password) throws UserException {
        return um.login(email, password);
    }

    @Override
    public void insertNewUser(String name, String email, String adress, String phone, int zip) throws UserException {
        um.insertNewUser(name, email, adress, phone, zip);
    }

    @Override
    public ArrayList<OrderDetail> getAllOrderDetailById(int orderId) throws OrderException {
        return orm.getAllOrderDetailById(orderId);
    }

    @Override
    public void setItem(String item_name, String item_info, double item_price, int item_id) throws ItemException {
       im.setItem(item_name, item_info, item_price, item_id);
    }

    @Override
    public ArrayList<Item> getAllItemByTypeId(int typeId) throws ItemException {
        return im.getAllItemByTypeId(typeId);
    }

   
 
}
