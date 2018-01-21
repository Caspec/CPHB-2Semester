
package junit;

import data.UserMapper;
import domain.exception.UserException;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class testUserMapper {
    
    UserMapper um = new UserMapper();
    
    public testUserMapper() {
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

    // Test on GetUser, at that time the name was "Casper" at UserId 1,
    @Test
    public void testUserMapperGetUser() throws UserException
    {
        assertEquals("Casper", um.getUser(1).getName());
    }
    
    // Test on GetZip, at that time the User at UserId 1 had a zipcode with 2730
    @Test
    public void testUserMapperGetZip() throws UserException
    {
        assertEquals(1, um.getZip(2730).getId());
    }
    
    // Test on Login, at that time the User "hest@cphbusiness.dk" had a password 1234
    @Test
    public void testUserMapperLogin() throws UserException
    {
        assertEquals("1234", um.login("hest@cphbusiness.dk", "1234").getPassword());
    }
    
    
}
