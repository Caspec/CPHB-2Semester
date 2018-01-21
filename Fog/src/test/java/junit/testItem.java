
package junit;

import domain.entity.Item;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class testItem {
    
    public testItem() {
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

    @Test
    public void testItem()
    {
        Item i = new Item(2, "Skruer", "Skruer 7cm, 50stk", 30, 1);
        
        assertEquals(i.getItem_name(), "Skruer");

    }
}
