package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_category_page extends AppCompatActivity {

    private Button btn_ss,btnn,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_category_page);

        btn_ss=findViewById(R.id.btnn_ss);
        btnn=findViewById(R.id.btn_co);
        logout=findViewById(R.id.log);

        btn_ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent item_page = new Intent(admin_category_page.this, SaSDashboard.class);
                startActivity(item_page);
                finish();
            }
        });

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(admin_category_page.this,customerSideAdmin.class);
                startActivity(i);
                finish();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(admin_category_page.this,adminLogin.class);
                startActivity(i);
            }
        });


    }
}