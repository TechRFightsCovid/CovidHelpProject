package com.example.covidhelp.DataModels;

import android.media.Image;

public class Category {

    private String category;


    public Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' + '}';
    }
}
