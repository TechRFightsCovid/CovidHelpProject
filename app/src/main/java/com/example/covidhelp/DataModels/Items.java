package com.example.covidhelp.DataModels;

import android.os.Parcel;
import android.os.Parcelable;


public class Items implements Parcelable {

    private String iName;
    private int price;
    private boolean check = false;


    public Items(String iName, int price) {
        this.iName = iName;
        this.price = price;
    }

    protected Items(Parcel in) {
        iName = in.readString();
        price = in.readInt();
    }


    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

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

    public boolean isChecked(){
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    @Override
    public String toString() {
        return "Items{" +
                "iName='" + iName + '\'' +
                ", price=" + price +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(iName);
        parcel.writeInt(price);
    }
}
