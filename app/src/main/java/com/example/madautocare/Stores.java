package com.example.madautocare;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Stores extends AppCompatActivity {
    private ListView listView;
    private List<AddDbPass> ge;
    private DbHandler dbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stores_page);

        dbHandler = new DbHandler(context);
        listView = findViewById(R.id.ListView);
        context = this;

        ge = new ArrayList<>();
        ge = dbHandler.getDetails();

        GetAdapter getAdapter = new GetAdapter(context,R.layout.get_single,ge);
        listView.setAdapter(getAdapter);
    }

}
