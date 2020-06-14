package com.example.covidhelp.Customer;

import android.app.Activity;
import android.content.Intent;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.covidhelp.Auth.LoginActivity;
import com.example.covidhelp.DataModels.Shop;
import com.example.covidhelp.LoKi;
import com.example.covidhelp.R;
import com.example.covidhelp.Utils.ShopAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;


public class CustomerHomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;
    private LoKi loki;

    private Button mLogoutBtn;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private RecyclerView shopRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        loki = (LoKi) this.getApplicationContext();


        setupWidgets();
        //initFirebase();


    }

    private void setupWidgets() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        shopRV = (RecyclerView) findViewById(R.id.shopsRV);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        inflateRV();
    }

    private void inflateRV() {
        final Shop[] listShops = {
                new Shop("Shop 1", "Address 1", 5, R.drawable.shops_stock),
                new Shop("Shop 2", "Address 2", 5, R.drawable.animated_city_skyline),
                new Shop("Shop 3", "Address 3", 5, R.drawable.shops_stock),
                new Shop("Shop 4", "Address 4", 5, R.drawable.animated_city_skyline)
        };

        ShopAdapter shopAdapter = new ShopAdapter(listShops, this);
        shopRV.setAdapter(shopAdapter);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_bar_menu, menu);
        return true;
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        if(mCurrentUser == null){
//            sendUserToLogin();
//        }
//    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
        loki.setmCurrentActivity(this);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        int id = item.getItemId();
        if (id == R.id.notif) {
            Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.cart) {
            Toast.makeText(getApplicationContext(), "Cart", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, CartActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFirebase(){
        mAuth = FirebaseAuth.getInstance();
        mCurrentUser = mAuth.getCurrentUser();


        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mAuth.signOut();
                sendUserToLogin();

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        clearReferences();
    }

    private void clearReferences() {
        Activity curr = loki.getmCurrentActivity();
        if(this.equals(curr)){
            loki.setmCurrentActivity(null);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void sendUserToLogin() {
        Intent loginIntent = new Intent(CustomerHomeActivity.this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }

}
