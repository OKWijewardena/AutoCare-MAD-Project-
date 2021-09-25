package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class update_supplier extends AppCompatActivity {

    private EditText SupplierName;
    private EditText SupplierPhoneNumber;
    private EditText SupplierPassword;
    private Button Update;
    private ImageButton Back;
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_supplier);

        context = this;
        dbHandler = new DbHandler(context);

        Back = findViewById(R.id.backbtn);
        SupplierName = findViewById(R.id.update_s_name);
        SupplierPhoneNumber = findViewById(R.id.update_s_phone);
        SupplierPassword = findViewById(R.id.update_s_pass);
        Update = findViewById(R.id.update_btn);

        final String email = getIntent().getStringExtra("SuppliersEmail");
//        System.out.println(email);
        supplier_modle up = dbHandler.getSinglesupplier(email);

        SupplierName.setText(up.getSuppliers_Name());
        SupplierPhoneNumber.setText(up.getSuppliers_Phone_Number());
        SupplierPassword.setText(up.getSuppliers_Password());

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S_name = SupplierName.getText().toString();
                String S_phonenumber = SupplierPhoneNumber.getText().toString();
                String S_password = SupplierPassword.getText().toString();

                supplier_modle up = new supplier_modle(S_name,email,S_password,S_phonenumber);
                int state = dbHandler.updateSinglesupplier(up);
                System.out.println(state);
                startActivity(new Intent(context, supplier_page.class));
            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,view_supplier.class));
            }
        });
    }
}