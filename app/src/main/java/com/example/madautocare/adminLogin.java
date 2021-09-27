package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminLogin extends AppCompatActivity {
    Button admin;
    EditText name,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        admin=findViewById(R.id.aLogin);
        name=findViewById(R.id.admin_name);
        pass=findViewById(R.id.admin_password);

        String nam=name.getText().toString();
        String p=pass.getText().toString();


        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean result=vali(nam,p);

                if(result==true){
                    Intent send = new Intent( adminLogin.this,  Customer_View_Page.class );
                    startActivity(send);

                    startActivity(send);
                }
            }
        });
    }
    public boolean vali(String a,String b){
        if(a.length()!=2){
           name.requestFocus();
           name.setError("Enter the valid phone number");
            return false;
        }
        else if(b.length()!=2){
            pass.requestFocus();
            pass.setError("check the password");
            return false;
        }
        else{
            return true;
        }

    }
}