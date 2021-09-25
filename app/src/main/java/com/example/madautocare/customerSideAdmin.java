package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class customerSideAdmin extends AppCompatActivity {

    TextView users,order;
    Button customers,orders,bookings;

//    Context context;
//    private DbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_side_admin);



//        context = this;
//        dbHandler = new DbHandler(context);


        customers=findViewById(R.id.view_cus);
        orders=findViewById(R.id.view_orders);
        bookings=findViewById(R.id.view_bookings);

        customers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( customerSideAdmin.this, Customer_Add_Page.class );
                startActivity(send);

            }
        });

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( customerSideAdmin.this, Order_Details_Page.class );
                startActivity(send);

            }
        });

        bookings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send = new Intent( customerSideAdmin.this, Bookings_main.class );
                startActivity(send);

            }
        });


    }
}