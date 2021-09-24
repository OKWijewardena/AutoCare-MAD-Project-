package com.example.madautocare;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Sales extends AppCompatActivity {

    private ListView listView;
    private List<AddDbPass> ge;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sales_page);

        listView = findViewById(R.id.SalesView);
        context = this;
        dbHandler = new DbHandler(context);

        ge = new ArrayList<>();
        ge = dbHandler.getDetails();

        SalesAdapter getAdapter = new SalesAdapter(context,R.layout.sales_single,ge);
        listView.setAdapter(getAdapter);
    }

}
