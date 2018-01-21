
package junit;

import data.OrderMapper;
import domain.exception.OrderException;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class testOrderMapper {
    
    OrderMapper om = new OrderMapper();
    
    public testOrderMapper() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    // Test on GetOrderById, at that time number 3 was in stage at "Godkendt"
    @Test
    public void testOrderMapperGetOrderById() throws OrderException
    {
        assertEquals("Godkendt", om.getOrder(3).getOrderStatus());
    }
    
    // Test on GetOrderByStatusNotApprove, at that time StatusNotApprove had a size of 1 in that status
    @Test
    public void testOrderMapperGetOrderByStatusNotApprove() throws OrderException
    {
        assertEquals(1, om.getOrderByStatusNotApprove().size());
    }
    
    // Test on GetZipRange, at that time there were 8 Orders in that range 1100, 3500
    @Test
    public void testOrderMapperGetZipRange() throws OrderException
    {
         assertEquals(8, om.getZipRange(1100, 3500));
    }
    
    
    
    
}
