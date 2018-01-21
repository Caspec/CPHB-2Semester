SELECT Order_id, Order_status, Order_logicstic, Order_recived, Order_delivered,
OrderData.Orderdata_length, OrderData.Orderdata_width, OrderData.Orderdata_height, OrderData.Orderdata_floor, OrderData.Orderdata_roof, OrderData.Orderdata_side,
OrderDetail.Orderdetail_quantity, Item.Item_price, Item.Item_measurement 
FROM `Order` INNER JOIN OrderDetail ON OrderDetail.FK_Order_id = Order_id INNER JOIN Item ON OrderDetail.FK_Item_id = Item.Item_id INNER JOIN OrderData ON `Order`.Order_id = OrderData.FK_Order_id INNER JOIN OrderData ON ;


SELECT * FROM `Order` INNER JOIN OrderDetail ON OrderDetail.FK_Order_id = Order_id INNER JOIN Item ON Item.Item_id = OrderDetail.FK_Item_id INNER JOIN User ON `Order`.FK_User_id = User.User_id INNER JOIN OrderData ON `Order`.Order_id = OrderData.FK_Order_id WHERE Order_id = 9;

 OrderData ON OrderData.FK_Order_id = Order_id INNER JOIN User ON User.User_id = `Order`.FK_User_id INNER JOIN OrderDetail ON OrderDetail.FK_Order_id = Order_id INNER JOIN Item ON Item.Item_id = OrderDetail.FK_Item_id;

User.User_name, User.User_email, User.User_adress, User.User_phone, User.User_zip, 
SELECT column_name(s)
FROM table1
INNER JOIN table2 ON table1.column_name = table2.column_name;