package data;

import domain.entity.Order;
import domain.entity.Customer;
import domain.exception.OrderException;
import domain.exception.CustomerException;
import java.util.ArrayList;
import java.util.List;


public interface IDBFacade {

// Customer
Customer getCustomer(int id) throws CustomerException;
ArrayList<Customer> getAllCustomers() throws CustomerException;
Customer login(String name, String password) throws CustomerException;


// Order

    
}
