package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class customerSideAdmin extends AppCompatActivity {

    TextView users,orderc,Corderc;
    Button customers,orders,bookings;

    Context context;
    private DbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_side_admin);




        context = this;
        dbHandler = new DbHandler(context);

        users=findViewById(R.id.user);
        orderc=findViewById(R.id.orderss);
        Corderc=findViewById(R.id.corderc);



        customers=findViewById(R.id.view_cus);
        orders=findViewById(R.id.view_orders);
        bookings=findViewById(R.id.view_bookings);

       int count=dbHandler.countCustomers();
        String c=String.valueOf(count);
        users.setText(c);

        int or=dbHandler.countOrders();
        String orr=String.valueOf(or);
        orderc.setText(orr);

        int corr=dbHandler.countCOrders();
        String orrc=String.valueOf(corr);
        Corderc.setText(orrc);




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
                Intent send = new Intent( customerSideAdmin.this, order_home.class );
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