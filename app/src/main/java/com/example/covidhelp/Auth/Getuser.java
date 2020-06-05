package com.example.covidhelp.Auth;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covidhelp.Customer.CustomerHomeActivity;
import com.example.covidhelp.R;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class Getuser extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getuser);
        setupRadioBtn();


    }

    private void setupRadioBtn(){
        final RadioGroup radioGroup = findViewById(R.id.customer_shopkeeper);

        Button next = findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioGroup.getCheckedRadioButtonId() == R.id.customer_radio_btn){
                    Intent intent = new Intent(getParent(), CustomerHomeActivity.class);
                    startActivity(intent);
                } else if(radioGroup.getCheckedRadioButtonId() == R.id.customer_radio_btn) {
                    Intent intent = new Intent(getParent(), CustomerHomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getParent(), "Please choose one option", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
