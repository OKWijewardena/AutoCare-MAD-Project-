package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Sales extends AppCompatActivity {

    private ListView listView;
    private List<AddDbPass> ge;
    private DbHandler dbHandler;
    private Context context;
    private ImageButton imageButton;

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

        imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
            }
        });
    }

}
