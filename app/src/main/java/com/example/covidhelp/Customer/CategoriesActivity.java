package com.example.covidhelp.Customer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covidhelp.DataModels.Category;
import com.example.covidhelp.R;
import com.example.covidhelp.Utils.categoryAdapter;

import java.util.Objects;

public class CategoriesActivity extends AppCompatActivity {
    private GridView categoryGV;
    private Context mContext;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private TextView shopName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        setupWidgets();
    }

    private void setupGV() {
        final Category[] categories = {
                new Category("Grocery & Staples", R.drawable.groceries_stock),
                new Category("Vegetables & Fruits", R.drawable.groceries_stock),
                new Category("Personal Care", R.drawable.groceries_stock),
                new Category("Household Items", R.drawable.groceries_stock),
                new Category("Home & Kitchen", R.drawable.groceries_stock),
                new Category("Biscuits, Snacks & Chocolates", R.drawable.groceries_stock),
                new Category("Beverages", R.drawable.groceries_stock),
                new Category("Breakfast & Dairy", R.drawable.groceries_stock),
                new Category("Baby Care", R.drawable.groceries_stock)

        };
        categoryAdapter categoryAdapter = new categoryAdapter(this, categories);
        categoryGV.setAdapter(categoryAdapter);
        categoryGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(mContext, categories[i].getCategory(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupWidgets(){
        categoryGV = (GridView) findViewById(R.id.cat_gv);
        mContext = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.cat_drawer);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Intent intent = getIntent();
        shopName = (TextView) findViewById(R.id.shop_name_TV);
        shopName.setText(intent.getStringExtra("shop"));

        setupGV();
    }


    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
