package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Bookings_main extends AppCompatActivity {

    Button btn1,btn2;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings_main);

        btn1=findViewById(R.id.view_booking);
        btn2=findViewById(R.id.view_Cbookings);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send = new Intent( Bookings_main.this, Booking_Details_Page.class );
                startActivity(send);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send = new Intent( Bookings_main.this, BookingComplete_View_Page.class );
                startActivity(send);

            }
        });

        back=findViewById(R.id.bbbb);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( Bookings_main.this, customerSideAdmin.class );
                startActivity(send);

            }
        });



    }
}