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
}
