package com.example.gettingstocks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_nav_view);


        getSupportFragmentManager().beginTransaction().replace(R.id.FL_main, new PortfolioFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.portfolio: getSupportFragmentManager().beginTransaction().replace(R.id.FL_main, new PortfolioFragment()).commit();
                        return true;

                    case R.id.news: getSupportFragmentManager().beginTransaction().replace(R.id.FL_main, new NewsFragment()).commit();
                        return true;


                }
                return false;
            }
        });
    }
}