package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class sales_list extends AppCompatActivity {

    private List<sales_modle> lists;
    private DbHandler dbHandler;
    private ListView listView;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_list);

        context=this;
        listView = findViewById(R.id.list_sales);
        dbHandler = new DbHandler(context);
        lists = new ArrayList<>();

        lists = dbHandler.getallsales();

        SalesAdpter adapter = new SalesAdpter(context,R.layout.single_sales,lists);
        listView.setAdapter(adapter);
    }
}