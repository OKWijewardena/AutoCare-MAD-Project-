package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class order_complete_view_page extends AppCompatActivity {
    Context context;
    private DbHandler dbHandler;
    private List< Order> orders;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete_view_page);

        context=this;
        dbHandler = new DbHandler(context);
        listView=findViewById(R.id.CompleateorderList);

        orders=new ArrayList<>();
        orders=dbHandler.getComOrderDetails();

        orderCompleteAdapter adapter=new  orderCompleteAdapter(context,R.layout.single_order,orders);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>  parent, View view, int position, long l) {

                Order order=orders.get(position);







            }
        });



    }
}