package com.example.madautocare;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends AppCompatActivity {
    private Button Home_Order,Home_Complete,Home_Settings2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Home_Order = findViewById(R.id.HomeOrder);
        Home_Complete = findViewById(R.id.HomeComplete);
        Home_Settings2 = findViewById(R.id.HomeSettings2);

        Home_Order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,Orders.class);
                startActivity(intent);
            }
        });

        Home_Complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,Complete.class);
                startActivity(intent);
            }
        });

        Home_Settings2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this,Settings2.class);
                startActivity(intent);
            }
        });

    }

}