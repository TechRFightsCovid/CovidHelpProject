package com.example.covidhelp.Onboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.covidhelp.R;

public class SplashScreen extends AppCompatActivity {
    private static int splashtimeout=2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Onboarding.class);
                startActivity(intent);
                finish();
            }
        },splashtimeout);

    }

}
