package com.example.covidhelp.DataModels;

import android.media.Image;

public class Category {

    private String category;
    private int img;


    public Category(String category, int img) {
        this.category = category;
        this.img = img;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                ", img=" + img +
                '}';
    }
}
