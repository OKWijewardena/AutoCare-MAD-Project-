package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class order_home extends AppCompatActivity {
    Button btn1,btn2;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_home);

        btn1=findViewById(R.id.view_order);
        btn2=findViewById(R.id.view_Corder);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( order_home.this, Order_Details_Page.class );
                startActivity(send);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( order_home.this, order_complete_view_page.class );
                startActivity(send);

            }
        });

        back=findViewById(R.id.bbbb);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send = new Intent( order_home.this, customerSideAdmin.class );
                startActivity(send);
            }
        });


    }
}