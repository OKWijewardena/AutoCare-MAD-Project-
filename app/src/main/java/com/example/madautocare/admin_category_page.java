package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_category_page extends AppCompatActivity {

    private Button btn_ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_category_page);

        btn_ss=findViewById(R.id.btn_ss);
        btn_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent item_page = new Intent(admin_category_page.this, SaSDashboard.class);
                startActivity(item_page);
                finish();
            }
        });
    }
}