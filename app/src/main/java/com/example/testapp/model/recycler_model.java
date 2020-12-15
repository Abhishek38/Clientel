package com.example.testapp.model;

public  class recycler_model{
    private final String imgLink;
    private final String price;
    private final String discount;
    private final String Name;

    public recycler_model(String imgLink, String price, String discount, String Name) {
        this.imgLink = imgLink;
        this.price = price;
        this.discount = discount;
        this.Name=Name;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }

    public String getName() { return Name; }





}
