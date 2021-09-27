package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    private ImageButton imageButton;
    private Context context;
    private EditText s_name,s_email,s_password,s_number;
    private Button s_submit;
    private DbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_page);

        context = this;
        dbHandler = new DbHandler(context);

        imageButton = findViewById(R.id.imageButton3);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
            }
        });

        s_name = findViewById(R.id.SName);
        s_email = findViewById(R.id.SEmail);
        s_password = findViewById(R.id.SPassword);
        s_number = findViewById(R.id.SNumber);
        s_submit = findViewById(R.id.SSubmit);

        final String code3 = getIntent().getStringExtra("code2");
        supplier_modle supplier = dbHandler.getSingleSupplier(code3);

        s_name.setText(supplier.getSuppliers_Name());
        s_email.setText(supplier.getSuppliers_Email());
        s_password.setText(supplier.getSuppliers_Password());
        s_number.setText(supplier.getSuppliers_Phone_Number());

        s_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = s_name.getText().toString();
                String Email = s_email.getText().toString();
                String Password = s_password.getText().toString();
                String Number = s_number.getText().toString();

                    supplier_modle update = new supplier_modle(Name, Email, Password, Number);
                    dbHandler.updateSinglesupplier(update);

                    Toast.makeText(Settings.this, "Update Successful", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, MainActivity.class));
            }
        });


    }

}
