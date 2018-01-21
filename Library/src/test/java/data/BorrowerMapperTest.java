
package data;

import domain.entity.Borrower;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BorrowerMapperTest
{
    
    public BorrowerMapperTest()
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
        BorrowerMapper instance = null;
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getBorrower method, of class BorrowerMapper.
     */
    @Test
    public void testGetBorrower() throws Exception
    {
        System.out.println("getBorrower");
        int id = 0;
        BorrowerMapper instance = new BorrowerMapper();
        Borrower expResult = instance.getBorrower(id);
        Borrower result = instance.getBorrower(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAllBorrowers method, of class BorrowerMapper.
     */
//    @Test
//    public void testGetAllBorrowers() throws Exception
//    {
//        System.out.println("getAllBorrowers");
//        BorrowerMapper instance = new BorrowerMapper();
//        ArrayList<Borrower> expResult = null;
//        ArrayList<Borrower> result = instance.getAllBorrowers();
//        assertEquals(expResult, result);
//    }

    /**
     * Test of main method, of class BorrowerMapper.
     */
//    @Test
//    public void testMain() throws Exception
//    {
//        System.out.println("main");
//        String[] args = null;
//        BorrowerMapper.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
