package com.codeclan.shopping_basket;

import java.util.ArrayList;

/**
 * Created by user on 02/04/2017.
 */

public class Shopper {

    private String name;
    private Product item;
    private ArrayList<Product> basket;

    public Shopper(String name){
        this.name = name;
        this.basket = new ArrayList<Product>();
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
}
