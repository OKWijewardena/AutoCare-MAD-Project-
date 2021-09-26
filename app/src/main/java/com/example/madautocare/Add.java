package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Add extends AppCompatActivity {
    private EditText add_code,add_name,add_price,add_quantity;
    private ImageButton back_button;
    private Button add_submit;
    private DbHandler dbHandler;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_items_page);

        back_button = findViewById(R.id.BackButton);
        add_code = findViewById(R.id.addcode);
        add_name = findViewById(R.id.addname);
        add_price = findViewById(R.id.addprice);
        add_quantity = findViewById(R.id.addquantity);
        add_submit = findViewById(R.id.addsubmit);
        context = this;
        dbHandler = new DbHandler(context);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,MainActivity.class));
            }
        });

        add_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Code = add_code.getText().toString();
                String Name = add_name.getText().toString();
                String Price = add_price.getText().toString();
                String Quantity = add_quantity.getText().toString();
//                String Image = add_image.getText().toString();

                boolean result=validation(Code,Name,Price,Quantity);

                if(result==true) {

                    AddDbPass ad = new AddDbPass(Code, Name, Price, Quantity);
                    dbHandler.add(ad);
                    Toast.makeText(Add.this,"Successfully added",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context,Add.class));

                }

            }
        });


    }


    public boolean validation(String code,String name,String price,String quantity){
        if(code.isEmpty()){
            add_code.requestFocus();
            add_code.setError("Enter Item Code");
            return false;
        }
        else if(name.isEmpty()){
            add_name.requestFocus();
            add_name.setError("Enter Item Name");
            return false;
        }
        else if(price.isEmpty()){
            add_price.requestFocus();
            add_price.setError("Enter Item Price");
            return false;
        }
        else if(quantity.isEmpty()){
            add_quantity.requestFocus();
            add_quantity.setError("Enter Item Quantity");
            return false;
        }

        else{
            return true;
        }

    }

}
