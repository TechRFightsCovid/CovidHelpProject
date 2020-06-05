package com.example.covidhelp.DataModels;

public class Items {

    private String iName;
    private int price;


    public Items(String iName, int price) {
        this.iName = iName;
        this.price = price;
    }

    public String getiName() {
        return iName;
    }

    public void setiName(String iName) {
        this.iName = iName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Items{" +
                "iName='" + iName + '\'' +
                ", price=" + price +
                '}';
    }
}
