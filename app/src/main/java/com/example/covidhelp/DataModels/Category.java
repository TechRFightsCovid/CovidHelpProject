package com.example.covidhelp.DataModels;

import android.media.Image;

import androidx.annotation.NonNull;

public class Category {

    private String category;
    private int catThumbnail;


    public Category(String category, int catThumbnail) {
        this.category = category;
        this.catThumbnail = catThumbnail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCatThumbnail() {
        return catThumbnail;
    }

    public void setCatThumbnail(int catThumbnail) {
        this.catThumbnail = catThumbnail;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category='" + category + '\'' +
                ", catThumbnail=" + catThumbnail +
                '}';
    }
}
