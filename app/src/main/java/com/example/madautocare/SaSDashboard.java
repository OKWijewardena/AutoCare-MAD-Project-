package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SaSDashboard extends AppCompatActivity {

    private Button Supplier;
    private ImageButton Back;
    private Context context;
    private TextView Suppliercount;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sas_dashboard);

        context=this;
        dbHandler = new DbHandler(context);


        Suppliercount = findViewById(R.id.suppliercount);
        Supplier=findViewById(R.id.supplier_btn);
        Back=findViewById(R.id.backbtn);

        int suppliercount = dbHandler.countsuppliers();
        System.out.println(suppliercount);
        Suppliercount.setText(""+suppliercount+"");

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,admin_category_page.class));
            }
        });

        Supplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,supplier_page.class));
            }
        });


    }
}