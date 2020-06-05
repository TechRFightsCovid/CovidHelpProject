package com.example.covidhelp.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.ClipData;
import android.os.Bundle;

import com.example.covidhelp.DataModels.Items;
import com.example.covidhelp.R;
import com.example.covidhelp.Utils.checkoutAdapter;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        setupRecycler();

    }

    private void setupRecycler(){


        Items item1 = new Items("Item 1", 100), item2 = new Items("Item 2", 150);
        Items[] items = {item1, item2};

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView rv = (RecyclerView) findViewById(R.id.checkoutList);
        rv.setLayoutManager(layoutManager);
        RecyclerView.Adapter adapter = new checkoutAdapter(items);
        rv.setAdapter(adapter);
    }
}
