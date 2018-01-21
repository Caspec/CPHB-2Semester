/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit;

import domain.business.Calc;
import domain.entity.OrderDetail;
import domain.exception.ItemException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author auron
 */
public class testCalc {
    
    public testCalc() {
    }
    
    Calc c = new Calc();
    
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

    // Here we set 100 in parameter and expect 3 because its int its just 3. but the real number is 3,33333333333
    @Test
    public void testCalcMeasurementForFloor()
    {
        
        assertEquals(c.getMeasurementForFloor(100), 3);

    }
    
    // Here we set 100 in orderLength (orderLength / 30) * 2) = 6. And set 100 for orderWidth (orderWidth / 30) = 3..... 6 + 3 = 9 and thats why we expect 9.
    @Test
    public void testCalcGetQuantityForSide()
    {
        
        assertEquals(c.getQuantityForSide(100, 100), 9);

    }
    
    // Here we set 100 in orderLength (orderLength / 30) * 2 = 6. Thats why we expect 6.
    @Test
    public void testCalcGetQuantityForRoof()
    {
        
        assertEquals(c.getQuantityForRoof(100), 6);

    }
   
    // Here we set 100 in orderWidth (orderWidth / 1.4) = 71. Thats why we expect 71.
    @Test
    public void testCalcGetMeasurementForRoof()
    {
        
        assertEquals(c.getMeasurementForRoof(100), 71);

    }
    
    // Here we set 100 in orderHeight (orderHeight + 90) = 190. Thats why we except 190
    @Test
    public void testCalcGetMeasurementForWoodPillar()
    {
        
        assertEquals(c.getMeasurementForWoodPillar(100), 190);

    }
    
    // Here we set 100 in totalPrice (totalPrice / 100) * 25 = 25. Here we have a double so we need a deviation (afvigelse).
    @Test
    public void testCalcGetMomsPrice()
    {
        
        assertEquals(c.getMomsPrice(100), 0.0001, 25);

    }
    
    // 1 / 30 * 1 = 0,003333 * 30 = 1
    // 1 / 30 * 1, orderid 23, itemid 5 = 30,    = 1 x 2     = 2 That's why we expect 2
    @Test
    public void testCalcGetTotalPrice() throws ItemException
    {
        OrderDetail detail1 = new OrderDetail(1, 1, 23, 5);
        OrderDetail detail2 = new OrderDetail(1, 1, 23, 5);

        ArrayList<OrderDetail> alod = new ArrayList<>();
        alod.add(detail1);
        alod.add(detail2);
        
        assertEquals(c.getTotalPrice(alod), 0.0001, 2);

    }
    
}
