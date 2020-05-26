package com.example.covidhelp;

import android.content.Intent;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.covidhelp.Auth.LoginActivity;
import com.example.covidhelp.DataModels.Category;
import com.example.covidhelp.Utils.categoryAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;
import java.util.Objects;


public class CustomerHomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser mCurrentUser;

    private Button mLogoutBtn;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private GridView categoryGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        setupWidgets();
        //initFirebase();


    }

    private void setupWidgets() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_home);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        categoryGV = (GridView) findViewById(R.id.catGV);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        inflateGV();
    }

    private void inflateGV() {
//        final String[] category = {
//                "Staples",
//                "Vegetables & Fruits",
//                "Personal Care",
//                "Snacks",
//                "Household",
//                "Kitchen",
//                "Beverages",
//                "Dairy",
//                "Instant Food",
//                "Baby Care",
//                "Pet Care"
//        };
//
//        final int[] catImages = {
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples,
//                R.drawable.staples
//        };

//        ArrayList<Category> listCat = new ArrayList();
//        for(int i = 0; i < category.length; i++){
//            Category c = new Category(category[i], catImages[i]);
//            listCat.add(c);
//        }
//        categoryAdapter categoryAdapter = new categoryAdapter(this, listCat);
//        categoryGV.setAdapter(categoryAdapter);
//
//        categoryGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(CustomerHomeActivity.this, category[i], Toast.LENGTH_SHORT).show();
//            }
//        });

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
