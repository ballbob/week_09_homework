package com.codeclan.shopping_basket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by user on 02/04/2017.
 */

public class ProductTest {

    Product pear;
    Product earphones;

    @Before
    public void before(){
        pear = new Product("pear", ItemType.FRUIT, 0.5);
        earphones = new Product("earphones", ItemType.ELECTRICAL, 30);
    }

    @Test
    public void canGetName(){
        assertEquals("pear",pear.getName());
        assertEquals("earphones",earphones.getName());
    }

    @Test
    public void canGetType(){
        assertEquals(ItemType.FRUIT,pear.getType());
        assertEquals(ItemType.ELECTRICAL,earphones.getType());
    }

    public void testDelta(){
        assertEquals(0.5,0.5,0.001);
    }

    @Test
    public void canGetPrice(){
        assertEquals(0.5,pear.getPrice(),0.001);
        assertEquals(30,earphones.getPrice(),0.001);
    }

    @Test
    public void canSetPrice(){
        pear.setPrice(3);
        assertEquals(3,pear.getPrice(),0.001);
    }


}
