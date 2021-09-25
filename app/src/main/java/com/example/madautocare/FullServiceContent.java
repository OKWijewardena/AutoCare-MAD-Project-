package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FullServiceContent extends AppCompatActivity {
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_service_content);

        button1= (Button) findViewById(R.id.btn_continue) ;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openVehicleDetails();
            }
        });

    }
    public void openVehicleDetails(){
        Intent intent = new Intent(this,VehicleDetails.class);
        startActivity(intent);
    }
}