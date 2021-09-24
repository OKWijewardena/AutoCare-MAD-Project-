package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class supplier_page extends AppCompatActivity {

    private Button add_btn;
    private Button update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier_page);

        add_btn = findViewById(R.id.add_item_btn);
        update_btn = findViewById(R.id.update_btn);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add_item_page = new Intent(supplier_page.this, add_supplier.class);
                startActivity(add_item_page);
//                finish();
            }
        });
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent update_item_page = new Intent(supplier_page.this, view_supplier.class);
                startActivity(update_item_page);
                finish();
            }
        });
//        startActivity(new Intent(supplier_page.this,supplier_page.class));
    }
}

