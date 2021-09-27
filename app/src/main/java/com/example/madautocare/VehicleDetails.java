package com.example.madautocare;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class VehicleDetails extends AppCompatActivity {
    private EditText username;
    private EditText email;
    private EditText km;
    private EditText vehicletype;
    private EditText date;
    private Button button;
    private Context context;
    private DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_details);

        username = findViewById(R.id.editname);
        email = findViewById(R.id.editemail);
        km = findViewById(R.id.editkm);
        vehicletype = findViewById(R.id.editvehicle);
        date = findViewById(R.id.editdate);
        button = findViewById(R.id.btn_book);

        context = this;
        dbHandler = new DbHandler(context);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String Username = username.getText().toString();
                    String Email = email.getText().toString();
                    String Km = km.getText().toString();
                    String Vehicletype = vehicletype.getText().toString();
                    String Date = date.getText().toString();
                    int kilometeres = Integer.parseInt(Km);

                    boolean result = validateemail();

                    if (result == true){
                        VehicleDetailsModel db = new VehicleDetailsModel(kilometeres, Vehicletype, Username, Email, Date);
                        dbHandler.add_cus(db);

                        Toast.makeText(VehicleDetails.this,"Successfully added",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(context,VehicleDetails.class));
                    }
            }
        });
    }
    private Boolean validateemail(){
        String Supplier_e = email.getText().toString();
        String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(Supplier_e.isEmpty()){
            email.setError("Supplier Email Field is Empty!");
            return false;
        }else if(!Supplier_e.matches(emailpattern)){
            email.setError("Supplier Email is invalid!");
            return false;
        }else{
            email.setError(null);
            return true;
        }
    }
}