package data;


import domain.entity.Item;
import domain.entity.Offer;
import domain.entity.Order;
import domain.entity.OrderData;
import domain.entity.OrderDetail;
import domain.entity.User;
import domain.entity.getOrder;
import domain.entity.getRegion;
import domain.exception.ItemException;
import domain.exception.OfferException;
import domain.exception.OrderException;
import domain.exception.RegionException;
import domain.exception.UserException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public interface IDBFacade {

// Item
public void createNewItem(String item_name, String item_info, double item_price, int FK_Item_id) throws ItemException;
public Item getItem(int id) throws ItemException;
public ArrayList<Item> getAllItem() throws ItemException;
public void setItem(String item_name, String item_info, double item_price, int item_id) throws ItemException;
public ArrayList<Item> getAllItemByTypeId(int typeId) throws ItemException;


// Offer
public Offer getOffer(int id) throws OfferException;
public ArrayList<Offer> getAllOffer() throws OfferException;
public void createNewOffer(String tilbud_name, String tilbud_info, String tilbud_img, int tilbud_rabat) throws OfferException;
public void setOffer(int offerId, String offerName, String offerInfo, String offerImg, int offerNumber) throws OfferException;
public void deleteOffer(int offerId) throws OfferException;


// Order
public Order getOrder(int id) throws OrderException;
public getOrder getOrderPopup(int id) throws OrderException;
public ArrayList<Order> getOrderByStatusNotApprove() throws OrderException;
public ArrayList<Order> getOrderByStatusApprove() throws OrderException;
public ArrayList<Order> getOrderByStatusPacked() throws OrderException;
public ArrayList<Order> getOrderByStatusShipped() throws OrderException;
public Order getOrderByUserIdAndOrderRecived(int userId, LocalDate orderRecive) throws OrderException;
public int getZipRange(int minZip, int maxZip) throws OrderException;
public void setOrderStatus(int id, String status) throws OrderException;
public void setOrderData(int length, int width, int height, int floor, int roof, int side, int FK_Order_id) throws OrderException;
public void deleteOrder(int id) throws OrderException;
public void insertNewOrder(int userId, LocalDate date) throws OrderException;
public void insertNewOrderData(int orderData_length, int orderData_width, int orderData_height, int orderData_floor, int orderData_roof, int orderData_side, int orderId) throws OrderException;
public void insertNewOrderDetail(int orderdetail_quantity,int orderdetail_measurement, int FK_Order_id, int FK_Item_id) throws OrderException;
public OrderData getOrderData(int orderId) throws OrderException;
public ArrayList<OrderDetail> getAllOrderDetailById(int orderId) throws OrderException;

// Region
public ArrayList<getRegion> getAllRegionsStartRange1100() throws RegionException;
public ArrayList<getRegion> getAllRegionsStartRange3510() throws RegionException;
public ArrayList<getRegion> getAllRegionsStartRange5510() throws RegionException;
public ArrayList<getRegion> getAllRegionsStartRange7510() throws RegionException;
public ArrayList<getRegion> getAllRegionsStartRange9010() throws RegionException;

// User
public User getUser(int id) throws UserException;
public User getUserByEmail(String email) throws UserException;
public User getZip(int Zip) throws UserException;
public User login(String email, String password) throws UserException;
public void insertNewUser(String name, String email, String adress, String phone, int zip) throws UserException;

    
}
