package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class sales_list extends AppCompatActivity {

    private List<sales_modle> lists;
    private DbHandler dbHandler;
    private ListView listView;
    private ImageButton Back;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_list);

        context=this;
        listView = findViewById(R.id.list_sales);
        dbHandler = new DbHandler(context);
        lists = new ArrayList<>();

        Back=findViewById(R.id.backbtn);

        lists = dbHandler.getallsales();

        SalesAdpter adapter = new SalesAdpter(context,R.layout.single_sales,lists);
        listView.setAdapter(adapter);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,manage_sales.class));
            }
        });
    }
}