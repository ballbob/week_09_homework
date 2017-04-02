package com.codeclan.shopping_basket;

/**
 * Created by user on 02/04/2017.
 */

public class Product {
    private String name;
    private ItemType type;
    private double price;

    public Product(String name, ItemType type, double price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

}
