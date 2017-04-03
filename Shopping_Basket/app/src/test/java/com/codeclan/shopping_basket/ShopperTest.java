package com.codeclan.shopping_basket;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created by user on 02/04/2017.
 */

public class ShopperTest {

    Product pear;
    Product mango;
    Product apple;
    Product earphones;
    Shopper shopper;
    Shopper disloyalShopper;

    @Before
    public void before(){
        pear = new Product("pear", ItemType.FRUIT, 0.5);
        mango = new Product("mango", ItemType.FRUIT, 1.5);
        apple = new Product("apple",ItemType.FRUIT,2.3);
        earphones = new Product("earphones", ItemType.ELECTRICAL, 30);
        shopper = new Shopper("Kevin",true);
        disloyalShopper = new Shopper("Judas",false);

        shopper.setDiscountedType(ItemType.FRUIT);
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

    @Test
    public void canEmptyBasket(){
        shopper.add(pear);
        shopper.add(earphones);
        shopper.empty();
        assertEquals(0,shopper.numItems());
    }

    @Test
    public void canTestLoyalty(){
        assertEquals(true,shopper.getLoyalty());
    }

    @Test
    public void canTestDisloyalty(){
        assertEquals(false,disloyalShopper.getLoyalty());
    }

//    @Test
//    public void canGetBasket(){
//        shopper.add(pear);
//        shopper.add(earphones);
//        assertEquals(0,shopper.getBasket());
//    }

    @Test
    public void canGetAndSetDiscountedType(){
        shopper.setDiscountedType(ItemType.FRUIT);
        assertEquals(ItemType.FRUIT,shopper.getDiscountedType());
    }

    @Test
    public void canGetAndSetOfferThreshold(){
        shopper.setThreshold(20);
        assertEquals(20,shopper.getThreshold());
    }

    @Test
    public void canGetBasicTotal(){
        shopper.add(pear);
        shopper.add(earphones);
        assertEquals(30.5,shopper.basicTotal());
    }

    @Test
    public void canGetNumberOfType(){
        shopper.add(pear);
        shopper.add(mango);
        assertEquals(2,shopper.numberOfType());
    }

    @Test
    public void sumTotalStartsEmpty(){
        assertEquals(0,shopper.getSumTotal(),0.001);
    }

    @Test
    public void canChangeCostAtThreshold(){
        shopper.add(pear);
        shopper.add(mango);
        shopper.add(earphones);
        shopper.basicTotal();
        shopper.thresholdTotal();
        assertEquals(28.8,shopper.getSumTotal(),0.001);
    }

    @Test
    public void canChangeCostOnLoyalty(){
        shopper.add(pear);
        shopper.add(mango);
        shopper.add(earphones);
        shopper.basicTotal();
        shopper.loyaltyTotal();

        disloyalShopper.add(pear);
        disloyalShopper.add(mango);
        disloyalShopper.add(earphones);
        disloyalShopper.basicTotal();
        disloyalShopper.loyaltyTotal();

        assertEquals(31.36,shopper.getSumTotal(),0.001);
        assertEquals(32,disloyalShopper.getSumTotal(),0.001);
    }

    @Test
    public void canAddCostOfHalfPriceItems(){
        shopper.add(pear);
        shopper.add(mango);
        shopper.add(apple);
        shopper.applyDiscountedType();
        shopper.basicTotal();

        assertEquals(2.15,shopper.getSumTotal(),0.001);
        assertEquals(3,shopper.numItems());
    }

    @Test
    public void canAdjustCost(){
        shopper.empty();
        shopper.add(pear);
        shopper.add(mango);
        shopper.add(earphones);
        shopper.adjustedTotal();

        assertEquals(25.67,shopper.getSumTotal(),0.001);
    }

    @Test
    public void canAdjustCostForDisloyalCustomer(){
        disloyalShopper.empty();
        disloyalShopper.add(pear);
        disloyalShopper.add(mango);
        disloyalShopper.add(earphones);
        disloyalShopper.adjustedTotal();

        assertEquals(27.9,disloyalShopper.getSumTotal(),0.001);
    }

}
