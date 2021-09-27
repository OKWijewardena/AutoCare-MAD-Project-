package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        button1 = (Button) findViewById(R.id.btn_book_service);
        button2= (Button) findViewById(R.id.btn_order) ;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openMainPage();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openOrderParts();
            }
        });
    }
    public void openMainPage(){
        Intent intent = new Intent(this,MainPage.class);
        startActivity(intent);
    }

    public void openOrderParts(){

        Intent intent = new Intent(this,CustomerItemList.class);
        startActivity(intent);
    }
}