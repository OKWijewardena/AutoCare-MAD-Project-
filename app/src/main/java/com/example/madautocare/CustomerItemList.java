package com.example.madautocare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AddDbPass data = ge.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(data.getCode());
                builder.setMessage(data.getNames());
                builder.setNeutralButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,CustomerMakeOrder.class);
                        intent.putExtra("cuscode",data.getCode());
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });
    }
}