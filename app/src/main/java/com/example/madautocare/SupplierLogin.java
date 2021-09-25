package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SupplierLogin extends AppCompatActivity {

    private EditText name,password;
    private Button login;
    private ImageButton back_login;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier_login);

        name = findViewById(R.id.supplier_name);
        password = findViewById(R.id.Supplier_password);
        login = findViewById(R.id.Login);
        back_login = findViewById(R.id.loginBack);
        context = this;
        dbHandler = new DbHandler(context);

        back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,StartActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(SupplierLogin.this,"please enter all fields",Toast.LENGTH_SHORT).show();
                else {
                    boolean CheckSupplier = dbHandler.CheckSupplierPassword(user, pass);
                    if (CheckSupplier == true) {
                        Toast.makeText(SupplierLogin.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context,MainActivity.class);
                        intent.putExtra("code",user);
                        startActivity(intent);

                    }else {
                        Toast.makeText(SupplierLogin.this,"Wrong Password or Name",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}