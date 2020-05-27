package com.example.covidhelp.Onboarding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.covidhelp.R;
import com.example.covidhelp.Utils.SectionsPagerAdapter;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class Onboarding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);


        setupViewPager();
    }

    private void setupViewPager() {

        SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Onboarding1());
        adapter.addFragment(new Onboarding2());
        adapter.addFragment(new Onboarding3());
        adapter.addFragment(new Onboarding4());
        adapter.addFragment(new Onboarding5());
        ViewPager viewPager =(ViewPager) findViewById(R.id.containerVP);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).select();

    }
}
