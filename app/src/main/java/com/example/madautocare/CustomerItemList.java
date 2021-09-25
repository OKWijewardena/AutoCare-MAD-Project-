package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomerItemList extends AppCompatActivity {

    private ListView listView;
    private List<AddDbPass> ge;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_item_list);

        listView = findViewById(R.id.CustmerList);
        context = this;
        dbHandler = new DbHandler(context);


        ge = new ArrayList<>();
        ge = dbHandler.getDetails();

        CustomerAdapter customerAdapter = new CustomerAdapter(context,R.layout.customer_single,ge);
        listView.setAdapter(customerAdapter);
    }
}