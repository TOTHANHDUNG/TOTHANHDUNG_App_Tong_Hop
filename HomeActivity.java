package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case R.id.action_home:
                       Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.action_farovite:
                       Intent intent=new Intent(HomeActivity.this,Fashion_Activity.class);
                       startActivity(intent);
                       Toast.makeText(HomeActivity.this, "Farovite", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.action_profile:
                       Intent intent1=new Intent(HomeActivity.this,Profile_Activity.class);
                       startActivity(intent1);
                       Toast.makeText(HomeActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                       break;
               }
                return true;
            }
        });
    }
}