package com.codeclan.shopping_basket;

import java.util.ArrayList;

/**
 * Created by user on 02/04/2017.
 */

public class Cashier {

    private Product item;
    private Shopper shopper;
    private String name;
    private ArrayList<Product> items;
    private ItemType discountedType;
    private int offerThreshold;

    public Cashier(String name){
        this.name = name;
        this.items = new ArrayList<Product>();
    }

    public String getName(){
        return this.name;
    }

    public int numItems(){
        return this.items.size();
    }

    public void handOver(Shopper shopper){
        this.items.addAll(shopper.getBasket());
    }

    public ItemType getDiscountedType() {
        return discountedType;
    }

    public void setDiscountedType(ItemType discountedType) {
        this.discountedType = discountedType;
    }
}
