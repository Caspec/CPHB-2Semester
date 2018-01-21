
package junit;

import data.ItemMapper;
import domain.entity.Item;
import domain.exception.ItemException;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class testItemMapper {
    
    ItemMapper im = new ItemMapper();
    
    public testItemMapper() {
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
    
    // Test on GetItem, at that time Item 1 was named "Træ rundstok 1"
    @Test
    public void testItemMapperGetItemById() throws ItemException
    {
         assertEquals("Træ Stolpe", im.getItem(1).getItem_name());
    }
    
    // Test on GetAllItem, there were 11 items in the list
    @Test
    public void testItemMapperGetAllItem() throws ItemException
    {
        assertEquals(11, im.getAllItem().size());
    }
    
    
}
