package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {
    Button admin;
    EditText name,pass;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        admin=findViewById(R.id.aLogin);
        name=findViewById(R.id.admin_name);
        pass=findViewById(R.id.admin_password);
        back=findViewById(R.id.loginBack);

        String nam=name.getText().toString();
        String p=pass.getText().toString();


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean result=true;

                if(result==true){
                    Intent send = new Intent( adminLogin.this,admin_category_page.class );
                    startActivity(send);

                    startActivity(send);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( adminLogin.this,StartActivity.class );
                startActivity(send);
            }
        });
    }
}