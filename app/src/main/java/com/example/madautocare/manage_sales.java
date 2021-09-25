package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class manage_sales extends AppCompatActivity {

    private ImageButton Back;
    private Button Add;
    private Button View;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_sales);
        context=this;

        Back=findViewById(R.id.backbtn);
        Add=findViewById(R.id.add_btn);
        View=findViewById(R.id.view_btn);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,SaSDashboard.class));
            }
        });

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(new Intent(context,add_sales.class));
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                startActivity(new Intent(context,sales_list.class));
            }
        });
    }
}