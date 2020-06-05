package com.example.covidhelp.DataModels;

public class Shop {

    private String sName;
    private String sAddress;
    private int sRating;
    private int sThumbnail;

    public Shop(String sName, String sAddress, int sRating, int sThumbnail) {
        this.sName = sName;
        this.sAddress = sAddress;
        this.sRating = sRating;
        this.sThumbnail = sThumbnail;
    }


    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public int getsRating() {
        return sRating;
    }

    public void setsRating(int sRating) {
        this.sRating = sRating;
    }

    public int getsThumbnail() {
        return sThumbnail;
    }

    public void setsThumbnail(int sThumbnail) {
        this.sThumbnail = sThumbnail;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "sName='" + sName + '\'' +
                ", sAddress='" + sAddress + '\'' +
                ", rating=" + sRating +
                '}';
    }


}
