package com.codeclan.shopping_basket;

import org.junit.*;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 02/04/2017.
 */

public class CashierTest {

    Product pear;
    Product mango;
    Product earphones;
    Shopper shopper;
    Shopper disloyalShopper;
    Cashier cashier;

    @Before
    public void before(){
        pear = new Product("pear", ItemType.FRUIT, 0.5);
        mango = new Product("big mango",ItemType.FRUIT,1);
        earphones = new Product("earphones", ItemType.ELECTRICAL, 30);
        shopper = new Shopper("Kevin",true);
        disloyalShopper = new Shopper("Judas",false);
        cashier = new Cashier("Etienne");
    }

    @Test
    public void canGetName(){
        assertEquals("Etienne",cashier.getName());
    }

    @Test
    public void cashierBeginsWithNoItems(){
        assertEquals(0,cashier.numItems);
    }
}
