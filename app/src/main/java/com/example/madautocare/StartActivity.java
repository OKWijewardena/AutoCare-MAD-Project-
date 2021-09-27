package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button Admin,Supplier,Customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        Admin = findViewById(R.id.Admin);
        Supplier = findViewById(R.id.Supplier);
        Customer = findViewById(R.id.Customer);

        Supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(StartActivity.this,SupplierLogin.class);
                startActivity(intent1);
            }
        });
        Admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admin = new Intent(StartActivity.this,adminLogin.class);
                startActivity(admin);
            }
        });



        Customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent customer = new Intent(StartActivity.this,Login.class);
                startActivity(customer);
            }
        });


    }
}