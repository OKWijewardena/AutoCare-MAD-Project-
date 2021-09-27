package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    private TextView Update_Name,Update_Price,Update_Qunatity;
    private Button Update_Button;
    private Context context;
    private DbHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_page);

        context = this;
        dbHandler = new DbHandler(context);

        Update_Name = findViewById(R.id.UpdateName);
        Update_Price = findViewById(R.id.UpdatePrice);
        Update_Qunatity = findViewById(R.id.UpdateQuntity);
        Update_Button = findViewById(R.id.UpdateButton);

        final String code = getIntent().getStringExtra("code");
        AddDbPass addDbPass =  dbHandler.getSingleData(code);

        Update_Name.setText(addDbPass.getNames());
        Update_Price.setText(addDbPass.getPrice());
        Update_Qunatity.setText(addDbPass.getQuantity());

        Update_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NameText = Update_Name.getText().toString();
                String PriceText = Update_Price.getText().toString();
                String QuantityText = Update_Qunatity.getText().toString();

                AddDbPass data = new AddDbPass(code,NameText,PriceText,QuantityText);

                int state = dbHandler.updateSingleRow(data);
                System.out.println(state);
                Toast.makeText(Update.this,"Update Successfully",Toast.LENGTH_LONG).show();

                startActivity(new Intent(context,Stores.class));
            }
        });

    }

}