package com.example.gymtest.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.gymtest.Adapters.MainViewPagerAdapters;
import com.example.gymtest.Fragments.Fragment_Home;
import com.example.gymtest.Fragments.Fragment_Shop;
import com.example.gymtest.Fragments.Fragment_User;
import com.example.gymtest.R;
import com.example.gymtest.Service.ApiGymMaster;
import com.example.gymtest.Service.RetrofitClient;
import com.example.gymtest.Utils.Utils;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ApiGymMaster apiGymMaster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        anhxa();
        init();
    }



    private void anhxa() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

    }

    private void init() {
        MainViewPagerAdapters mainViewPagerAdapters = new MainViewPagerAdapters(getSupportFragmentManager());
        mainViewPagerAdapters.addFragment(new Fragment_Home(), "Home");
        mainViewPagerAdapters.addFragment(new Fragment_Shop(), "SHOP");
        mainViewPagerAdapters.addFragment(new Fragment_User(), "User");

        viewPager.setAdapter(mainViewPagerAdapters);
        tabLayout.setupWithViewPager(viewPager);
    }
}