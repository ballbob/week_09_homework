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
    private double sumTotal;


    public Shopper(String name, boolean loyalty){
        this.name = name;
        this.basket = new ArrayList<Product>();
        this.loyalty = loyalty;
        this.sumTotal = 0;
    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public double getSumTotal(){
        return this.sumTotal;
    }

    public boolean getLoyalty(){
        return this.loyalty;
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

    //basket
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

    //price
    public double basicTotal(){
        for (Product item : basket){
            sumTotal = sumTotal + item.getPrice();
        }
        return sumTotal;
    }

    public int numberOfType(){
        int typeCount = 0;
        for (Product item : basket){
            if (item.getType() == discountedType){
                typeCount ++;
            }
        }
        return typeCount;
    }

    public void thresholdTotal(){
        if (sumTotal >= offerThreshold){
            sumTotal = sumTotal * 0.9;
        }
    }

    public void loyaltyTotal(){
        if (loyalty == true){
            sumTotal = sumTotal * 0.98;
        }
    }

//    public void discountedTypeTotal(){
//        for (int i=0; i < basket.size(); i++){
//            if (basket.get(i).getType() == discountedType){
//                double priceAdd = basket.get(i).getPrice()/2;
//                basket.remove(basket.get(i));
//                sumTotal = sumTotal + priceAdd;
//            }
//        }
//    }

    public void adjustedTotal(){
        this.basicTotal();
        this.loyaltyTotal();
        this.thresholdTotal();
    }

}
