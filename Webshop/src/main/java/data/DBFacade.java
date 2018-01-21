package data;

import domain.entity.Order;
import domain.entity.Customer;
import domain.exception.OrderException;
import domain.exception.CustomerException;
import java.util.ArrayList;
import java.util.List;


public class DBFacade implements IDBFacade {

    CustomerMapper cm = new CustomerMapper();
    
    @Override
    public Customer getCustomer(int id) throws CustomerException
    {
       return cm.getCustomer(id);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() throws CustomerException
    {
        return cm.getAllCustomers();
    }

    @Override
    public Customer login(String name, String password) throws CustomerException
    {
        return cm.login(name, password);
    }
    



}
