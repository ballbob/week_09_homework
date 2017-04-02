package com.codeclan.shopping_basket;

import android.content.ClipData;

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
        assertEquals(0,cashier.numItems());
    }

    @Test
    public void canGetItemsFromShopper(){
        shopper.add(mango);
        shopper.add(pear);
        cashier.handOver(shopper);
        assertEquals(2,cashier.numItems());
    }

    @Test
    public void canGetAndSetDiscountedType(){
        cashier.setDiscountedType(ItemType.FRUIT);
        assertEquals(ItemType.FRUIT,cashier.getDiscountedType());
    }

    @Test
    public void canGetAndSetOfferThreshold(){
        cashier.setThreshold(20);
        assertEquals(20,cashier.getThreshold());
    }
}
