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

public class Stores extends AppCompatActivity {
    private ListView listView;
    private List<AddDbPass> ge;
    private DbHandler dbHandler;
    private Context context;
    private ImageButton imageButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stores_page);

        listView = findViewById(R.id.getList);
        context = this;
        dbHandler = new DbHandler(context);


        ge = new ArrayList<>();
        ge = dbHandler.getDetails();

        GetAdapter getAdapter = new GetAdapter(context,R.layout.get_single,ge);
        listView.setAdapter(getAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AddDbPass data = ge.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(data.getCode());
                builder.setMessage(data.getNames());
                builder.setPositiveButton("Finished", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(context,Stores.class));
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteItem(data.getCode());
                        startActivity(new Intent(context,Stores.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,Update.class);
                        intent.putExtra("code",data.getCode());
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });

        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
            }
        });

    }

}
