package com.example.madautocare;


import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button Home_Add,Home_Store,Home_Update,Home_Delete,Home_Sales,Home_Settings,log_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Home_Add = findViewById(R.id.HomeAdd);
        Home_Store = findViewById(R.id.HomeStore);
//        Home_Update = findViewById(R.id.HomeUpdate);
//        Home_Delete = findViewById(R.id.HomeDelete);
        Home_Sales = findViewById(R.id.HomeSales);
        Home_Settings = findViewById(R.id.HomeSettings);
        log_out = findViewById(R.id.logout);

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent0 = new Intent(MainActivity.this,SupplierLogin.class);
                startActivity(intent0);
            }
        });

        Home_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Add.class);
                startActivity(intent1);
            }
        });

        Home_Store.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,Stores.class);
                startActivity(intent2);
            }
        });

//        Home_Update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent3 = new Intent(MainActivity.this,Update.class);
//                startActivity(intent3);
//            }
//        });
//
//        Home_Delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent4 = new Intent(MainActivity.this,Delete.class);
//                startActivity(intent4);
//            }
//        });

        Home_Sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this,Sales.class);
                startActivity(intent5);
            }
        });

        Home_Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this,Settings.class);
                final String code1 = getIntent().getStringExtra("code");
                intent6.putExtra("code2",code1);
                startActivity(intent6);
            }
        });

    }

}