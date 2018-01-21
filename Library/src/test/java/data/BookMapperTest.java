
package data;

import domain.entity.Book;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BookMapperTest
{
    
    public BookMapperTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
        BookMapper instance = null;
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getBook method, of class BookMapper.
     */
    @Test
    public void testGetBook() throws Exception
    {
        System.out.println("getBook");
        int id = 0;
        BookMapper instance = new BookMapper();
        Book expResult = instance.getBook(id);
        Book result = instance.getBook(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllBooks method, of class BookMapper.
     */
//    @Test
//    public void testGetAllBooks() throws Exception
//    {
//        System.out.println("getAllBooks");
//        BookMapper instance = new BookMapper();
//        ArrayList<Book> expResult = instance.getAllBooks();
//        ArrayList<Book> result = instance.getAllBooks();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of main method, of class BookMapper.
     */
//    @Test
//    public void testMain() throws Exception
//    {
//        System.out.println("main");
//        String[] args = null;
//        BookMapper.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
