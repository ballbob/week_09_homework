package com.codeclan.shopping_basket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by user on 02/04/2017.
 */

public class ShopperTest {

    Product pear;
    Product earphones;
    Shopper shopper;

    @Before
    public void before(){
        pear = new Product("pear", ItemType.FRUIT, 0.5);
        earphones = new Product("earphones", ItemType.ELECTRICAL, 30);
        shopper = new Shopper("Kevin");
    }

    @Test
    public void testgetName(){
        assertEquals("Kevin",shopper.getName());
    }

    @Test
    public void basketStartsEmpty(){
        assertEquals(0,shopper.numItems());
    }

    @Test
    public void canAddItem(){
        shopper.add(pear);
        assertEquals(1,shopper.numItems());
    }

    @Test
    public void canRemoveItem(){
        shopper.add(pear);
        shopper.remove(pear);
        assertEquals(0,shopper.numItems());
    }
}
