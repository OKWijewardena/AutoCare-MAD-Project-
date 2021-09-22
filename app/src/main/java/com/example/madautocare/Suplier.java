package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Suplier extends AppCompatActivity {

    ImageButton Selling;
    ImageButton MyStore;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suplier);

        MyStore = findViewById(R.id.MyStore);
        Selling = findViewById(R.id.Selling);

        MyStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Opening Store Components";
                int duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.show();
                Intent intent = new Intent(Suplier.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Selling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Opening Store Components";
                int duration = Toast.LENGTH_SHORT;
                toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.show();
                Intent intent = new Intent(Suplier.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}