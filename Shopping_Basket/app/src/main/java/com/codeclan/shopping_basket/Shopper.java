package com.codeclan.shopping_basket;

import java.util.ArrayList;

/**
 * Created by user on 02/04/2017.
 */

public class Shopper {

    private String name;
    private Product item;
    private ArrayList<Product> basket;
    private boolean loyalty;
    private ItemType discountedType;
    private int offerThreshold;


    public Shopper(String name, boolean loyalty){
        this.name = name;
        this.basket = new ArrayList<Product>();
        this.loyalty = loyalty;
    }

    public String getName(){
        return this.name;
    }

    public int numItems(){
        return this.basket.size();
    }

    public void add(Product item){
        basket.add(item);
    }

    public void remove(Product item){
        basket.remove(item);
    }

    public void empty(){
        basket.clear();
    }

    public boolean getLoyalty(){
        return this.loyalty;
    }

    public ArrayList<Product> getBasket(){
        return this.basket;
    }


    public ItemType getDiscountedType() {
        return discountedType;
    }

    public void setDiscountedType(ItemType discountedType) {
        this.discountedType = discountedType;
    }

    public int getThreshold() {
        return offerThreshold;
    }

    public void setThreshold(int threshold) {
        this.offerThreshold = threshold;
    }
    
    public double basicTotal(){
        double sumTotal = 0;
        for (Product item : basket){
            sumTotal = sumTotal + item.getPrice();
        }
        return sumTotal;
    }


}
