package com.example.covidhelp.DataModels;

public class UserInfo {

    public String getShopnm() {
        return shopnm;
    }

    public void setShopnm(String shopnm) {
        this.shopnm = shopnm;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLogitude() {
        return logitude;
    }

    public void setLogitude(Double logitude) {
        this.logitude = logitude;
    }

    private String shopnm;
    private long phone;
    private Double latitude;
    private Double logitude;
    public UserInfo() {
    }
}
