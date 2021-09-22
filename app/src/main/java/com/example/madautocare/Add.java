package com.example.madautocare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Add extends AppCompatActivity {
    private EditText add_code,add_name,add_price,add_quantity,add_image;
    private Button add_submit;
    private DbHandler dbHandler;
    private Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_items_page);

        add_code = findViewById(R.id.addcode);
        add_name = findViewById(R.id.addname);
        add_price = findViewById(R.id.addprice);
        add_quantity = findViewById(R.id.addquantity);
        add_image = findViewById(R.id.addimage);
        add_submit = findViewById(R.id.addsubmit);
        context = this;
        dbHandler = new DbHandler(context);

        add_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Code = add_code.getText().toString();
                String Name = add_name.getText().toString();
                String Price = add_price.getText().toString();
                String Quantity = add_quantity.getText().toString();
                String Image = add_image.getText().toString();

                AddDbPass ad = new AddDbPass(Code,Name, Price, Quantity, Image);
                dbHandler.add(ad);

            }
        });


    }
}
