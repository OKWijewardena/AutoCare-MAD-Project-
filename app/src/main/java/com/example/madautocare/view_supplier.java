package com.example.madautocare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class view_supplier extends AppCompatActivity {

    private List<supplier_modle> lists;
    private DbHandler dbHandler;
    private ListView listView;
    private ImageButton Back;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_supplier);
        context = this;

        Back=findViewById(R.id.backbtn);
        listView = findViewById(R.id.listview);
        dbHandler = new DbHandler(context);
        lists = new ArrayList<>();

        lists = dbHandler.getallsuppliers();

        ListAdapter adapter = new ListAdapter(context,R.layout.single_supplier,lists);
        listView.setAdapter(adapter);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,supplier_page.class));
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final supplier_modle data = lists.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Supplier Name: "+data.getSuppliers_Name());
                builder.setMessage("You Can Update or Delete The Supplier");

                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, update_supplier.class);
                        intent.putExtra("SuppliersEmail",String.valueOf(data.getSuppliers_Email()));
                        startActivity(intent);
                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deletesupplier(data.getSuppliers_Email());
                        startActivity(new Intent(context, supplier_page.class));
                    }
                });
                builder.show();
            }
        });
    }
}