package com.osan.lokr.model;

public class Product
{
    private int thumbUrl;
    private String name;
    private String price;

    public Product(int thumbUrl, String name, String price) {
        this.thumbUrl = thumbUrl;
        this.name = name;
        this.price = price;
    }

    public int getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(int thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
