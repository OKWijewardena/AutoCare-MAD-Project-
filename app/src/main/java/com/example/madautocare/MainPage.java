package com.example.madautocare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        button1 = (Button) findViewById(R.id.btn_full_service);
        button2= (Button) findViewById(R.id.btn_normal_service) ;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFullServiceContent();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNormalServiceContent();
            }
        });
    }
    public void openFullServiceContent(){
        Intent intent = new Intent(this,FullServiceContent.class);
        startActivity(intent);

    }
    public void openNormalServiceContent(){
        Intent intent = new Intent(this,NormalServiceContent.class);
        startActivity(intent);
    }
}
