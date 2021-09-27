package com.example.madautocare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomerMakeOrder extends AppCompatActivity {

    private EditText OCUSNAME,OCUSEMAIL,OITEMID,OITEMNAME,OQUN,ODATE;
    private Button ConfirmBtn;
    private Context context;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_make_order);

        context = this;
        dbHandler = new DbHandler(context);

        OCUSNAME = findViewById(R.id.cusName);
        OCUSEMAIL = findViewById(R.id.cusEmail);
        OITEMID = findViewById(R.id.CusItemID);
        OITEMNAME = findViewById(R.id.CusItemName);
        OQUN = findViewById(R.id.cusItemQunatity);
        ODATE = findViewById(R.id.cusDate);
        ConfirmBtn = findViewById(R.id.OrderAddBtn);

        final String code = getIntent().getStringExtra("cuscode");
        AddDbPass addDbPass =  dbHandler.getSingleData(code);

        OITEMID.setText(addDbPass.getCode());
        OITEMNAME.setText(addDbPass.getNames());

        ConfirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ocusname = OCUSNAME.getText().toString();
                String ocusemail = OCUSEMAIL.getText().toString();
                String oitemid = OITEMID.getText().toString();
                String oitemname = OITEMNAME.getText().toString();
                String oqun = OQUN.getText().toString();
                String odate = ODATE.getText().toString();

                order_parts_model od = new order_parts_model(ocusname,ocusemail,oitemid,oitemname,oqun,odate);
                dbHandler.addOrderParts(od);
                Toast.makeText(CustomerMakeOrder.this,"Successfully Ordered",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context,CustomerOrderView.class);
                intent.putExtra("codex",od.getCustomer_Email());
                startActivity(intent);
            }
        });

    }
}