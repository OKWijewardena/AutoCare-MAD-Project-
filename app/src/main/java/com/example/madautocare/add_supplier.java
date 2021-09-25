package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class add_supplier extends AppCompatActivity {

    //variables
    private EditText Supplier_name;
    private EditText Supplier_email;
    private EditText Supplier_pass;
    private EditText Supplier_phone_number;
    private ImageButton Back;

    //Database variables
    private DbHandler dbHandler;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_supplier);

        Supplier_name = findViewById(R.id.supplier_name);
        Supplier_email = findViewById(R.id.supplier_email);
        Supplier_pass = findViewById(R.id.supplier_pass);
        Supplier_phone_number = findViewById(R.id.supplier_phone_number);
        Back = findViewById(R.id.backbtn);
        context = this;

        dbHandler = new DbHandler(context);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,supplier_page.class));
            }
        });
    }
    private Boolean validatename(){
        String Supplier_n = Supplier_name.getText().toString();
        if(Supplier_n.isEmpty()){
            Supplier_name.setError("Supplier Name Field is Empty!");
            return false;
        }else {
            Supplier_name.setError(null);
            return true;
        }
    }
    private Boolean validateemail(){
        String Supplier_e = Supplier_email.getText().toString();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(Supplier_e.isEmpty()){
            Supplier_email.setError("Supplier Email Field is Empty!");
            return false;
        }else if(!Supplier_e.matches(emailpattern)){
            Supplier_email.setError("Supplier Email is invalid!");
            return false;
        }else{
            Supplier_email.setError(null);
            return true;
        }
    }
    private Boolean validatepass(){
        String Supplier_p = Supplier_pass.getText().toString();
        String passwordval = "^"+".{6,}";
        if(Supplier_p.isEmpty()){
            Supplier_pass.setError("Supplier Password Field is Empty!");
            return false;
        }else if(!Supplier_p.matches(passwordval)){
            Supplier_pass.setError("Please Enter The Minimum 6 Characters");
            return false;
        }else{
            Supplier_pass.setError(null);
            return true;
        }
    }
    private Boolean validatenumber(){
        String Supplier_p_number = Supplier_phone_number.getText().toString();
        String numberval = "^"+".{10}";
        if(Supplier_p_number.isEmpty()){
            Supplier_phone_number.setError("Supplier Phone Number Field is Empty!");
            return false;
        }else if(!Supplier_p_number.matches(numberval)){
            Supplier_phone_number.setError("Supplier Phone Number is invalid!");
            return false;
        }else{
            Supplier_phone_number.setError(null);
            return true;
        }
    }

    public void Register_Supplier(View view) {

        if(!validatename() | !validateemail() | !validatepass() | !validatenumber()){
            return;
        }
        String Supplier_n = Supplier_name.getText().toString();
        String Supplier_e = Supplier_email.getText().toString();
        String Supplier_p = Supplier_pass.getText().toString();
        String Supplier_p_number = Supplier_phone_number.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{Supplier_e});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Wellcome to the AutoCare Admin Panel.");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear Supplier,\n\nYou can use this email"+" "+Supplier_e+" and use this " +
                "password"+" "+ Supplier_p+" "+"login to the our supplier system.\n\n\nThank you.\n(Auto Care Admin Panel).");
        emailIntent.setType("message/rfc822");
        chooser=emailIntent.createChooser(emailIntent,"Send E-mail to Supplier");


        supplier_modle add = new supplier_modle(Supplier_n,Supplier_e,Supplier_p,Supplier_p_number);

        dbHandler.additem(add);
        startActivity(new Intent(context,supplier_page.class));
        startActivity(chooser);
        Toast.makeText(getApplicationContext(),"Supplier Added Successfully!",Toast.LENGTH_LONG).show();



    }

}
