package com.example.madautocare;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Delete extends AppCompatActivity {

    private EditText add_code;
    private Button delete;
    private Context context;
    private DbHandler dbHandler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_page);

        add_code = findViewById(R.id.deletecode);
        context = this;
        dbHandler = new DbHandler(context);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Code = add_code.getText().toString();

                AddDbPass ad = new AddDbPass();
                ad.setCode(Code);

                dbHandler.deleteItem(ad.getCode());
            }
        });
    }

}
