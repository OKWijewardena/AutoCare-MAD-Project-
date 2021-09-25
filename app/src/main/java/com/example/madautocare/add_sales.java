package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class add_sales extends AppCompatActivity {

    private ImageButton Back;
    private EditText CustomerName;
    private EditText CustomerEmail;
    private EditText CustomerNumber;
    private EditText CustomerAmount;
    private RadioButton Parts;
    private RadioButton Service;
    private Context context;

    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_sales);

        context=this;
        dbHandler = new DbHandler(context);

        Back=findViewById(R.id.backbtn);
        CustomerName=findViewById(R.id.sales_cus_name);
        CustomerEmail=findViewById(R.id.sales_cus_email);
        CustomerNumber=findViewById(R.id.sales_cus_phone);
        CustomerAmount=findViewById(R.id.sales_cus_amount);
        Parts=findViewById(R.id.sales_cus_radio_parts);
        Service=findViewById(R.id.sales_cus_radio_service);

        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,manage_sales.class));
            }
        });
    }
    private Boolean validatename(){
        String Customer_n = CustomerName.getText().toString();
        if(Customer_n.isEmpty()){
            CustomerName.setError("Customer Name Field is Empty!");
            return false;
        }else {
            CustomerName.setError(null);
            return true;
        }
    }
    private Boolean validateemail(){
        String Customer_e = CustomerEmail.getText().toString();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(Customer_e.isEmpty()){
            CustomerEmail.setError("Customer Email Field is Empty!");
            return false;
        }else if(!Customer_e.matches(emailpattern)){
            CustomerEmail.setError("Customer Email is invalid!");
            return false;
        }else{
            CustomerEmail.setError(null);
            return true;
        }
    }
    private Boolean validatenumber(){
        String Customer_p_number = CustomerNumber.getText().toString();
        String numberval = "^"+".{10}";
        if(Customer_p_number.isEmpty()){
            CustomerNumber.setError("Customer Phone Number Field is Empty!");
            return false;
        }else if(!Customer_p_number.matches(numberval)){
            CustomerNumber.setError("Customer Phone Number is invalid!");
            return false;
        }else{
            CustomerNumber.setError(null);
            return true;
        }
    }
    private Boolean validateamount(){
        String Customer_a = CustomerAmount.getText().toString();
        if(Customer_a.isEmpty()){
            CustomerAmount.setError("Customer Amount Field is Empty!");
            return false;
        }else {
            CustomerAmount.setError(null);
            return true;
        }
    }

    public void Add_sales(View view) {

        if(!validatename() | !validateemail() | !validatenumber() | !validateamount()){
            return;
        }
        String Customer_n = CustomerName.getText().toString();
        String Customer_e = CustomerEmail.getText().toString();
        String Customer_p_number = CustomerNumber.getText().toString();
        String Customer_a = CustomerAmount.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        final Intent chooser;
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{Customer_e});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Wellcome to the AutoCare Billing Center.");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear "+Customer_n+",\n\nYou made our day, thank " +
                "you for choosing us for your purchase. We are happy to meet your purchase order or " +
                "service and value our loyal customers. You have already paid Rs."+Customer_a+" today to us." +
                "\n\nRegards\n(AutoCare Billing Center)");
        emailIntent.setType("message/rfc822");
        chooser=emailIntent.createChooser(emailIntent,"Select The App Send To The E-Bill");


        if(Parts.isChecked()){

            sales_modle add = new sales_modle(Customer_n,Customer_e,"Parts",Customer_p_number,Customer_a);

            dbHandler.addsales(add);
            startActivity(new Intent(context,manage_sales.class));
            startActivity(chooser);
            Toast.makeText(getApplicationContext(),"Sales Added Successfully!",Toast.LENGTH_LONG).show();

        }else if(Service.isChecked()){

            sales_modle add = new sales_modle(Customer_n,Customer_e,"Service",Customer_p_number,Customer_a);

            dbHandler.addsales(add);
            startActivity(new Intent(context,manage_sales.class));
            startActivity(chooser);
            Toast.makeText(getApplicationContext(),"Sales Added Successfully!",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(this,"Please Select the Customer Billing Type",Toast.LENGTH_LONG).show();
        }
    }
}