package com.motaz.productsapp;

import androidx.annotation.DrawableRes;

/** Model class for one product card in the grid. */
public class Product {
    private final String title;
    private final double price;
    @DrawableRes
    private final int imageRes;

    public Product(String title, double price, @DrawableRes int imageRes) {
        this.title = title;
        this.price = price;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    @DrawableRes
    public int getImageRes() {
        return imageRes;
    }
}
