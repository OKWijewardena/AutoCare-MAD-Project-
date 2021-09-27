package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrderView extends AppCompatActivity {
    private EditText updateOrderName,updateOrderEmail,updateOrderQun,updateOrderDate;
    private Button Update,Confirm,Delete;
    private Context context;
    private DbHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_order_view);

        context = this;
        dbHandler = new DbHandler(context);

        updateOrderName = findViewById(R.id.update_order_name);
        updateOrderEmail = findViewById(R.id.update_order_email);
        updateOrderQun = findViewById(R.id.update_order_qty);
        updateOrderDate = findViewById(R.id.update_order_date);
        Update = findViewById(R.id.update_order_btn);
        Confirm = findViewById(R.id.confirm_order_btn);
        Delete = findViewById(R.id.delete_order_btn);

        final String codex = getIntent().getStringExtra("codex");
        order_parts_model or = dbHandler.getCustomerOrderSingleData(codex);

        updateOrderName.setText(or.getCustomer_Names());
        updateOrderEmail.setText(or.getCustomer_Email());
        updateOrderQun.setText(or.getQun());
        updateOrderDate.setText(or.getDates());

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = updateOrderName.getText().toString();
                String Email = updateOrderEmail.getText().toString();
                String Qun = updateOrderQun.getText().toString();
                String Date = updateOrderDate.getText().toString();

                order_parts_model or = new order_parts_model(Name,Email,Qun,Date);
                dbHandler.updateOrdrsSingleRow(or);
                startActivity(new Intent(context,HomePage.class));
                Toast.makeText(CustomerOrderView.this,"Update Successfully",Toast.LENGTH_LONG).show();
            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHandler.deleteCustomerOrder(or.getCustomer_Email());
                Toast.makeText(CustomerOrderView.this,"Order deleted",Toast.LENGTH_LONG).show();
                startActivity(new Intent(context,HomePage.class));

            }
        });

        Confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,HomePage.class));
            }
        });



    }
}