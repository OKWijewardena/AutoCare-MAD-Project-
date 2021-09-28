package com.example.madautocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class order_page extends AppCompatActivity {

    EditText oid,cusname,cusmail,itemid,itemname,qun,date;
    Button update,conplete;
    ImageButton back;


    private DbHandler dbHandler;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);


        context=this;
        dbHandler=new DbHandler(context);

        update=findViewById(R.id.orderdelete_btn);
        conplete=findViewById(R.id.confirm_btn);


        oid=findViewById(R.id.oid);
        cusname=findViewById(R.id.cusname);
        cusmail=findViewById(R.id.cusEmail);
        itemid=findViewById(R.id.itemId);
        itemname=findViewById(R.id.itemname);
        qun=findViewById(R.id.qun);
        date=findViewById(R.id.date);
        back=findViewById(R.id.bbbb);

        Intent i = getIntent();
        String id=i.getStringExtra("id");
        String cname=i.getStringExtra("name");
        String cmail=i.getStringExtra("mail");
        String iiid=i.getStringExtra("iid");
        String iname=i.getStringExtra("iname");
        String iqun=i.getStringExtra("qun");
        String datee=i.getStringExtra("date");
        int d=Integer.parseInt(id);

        int cid=Integer.parseInt(id);

        oid.setText(id);
        cusname.setText(cname);
        cusmail.setText(cmail);
        itemid.setText(iiid);
        itemname.setText(iname);
        qun.setText(iqun);
        date.setText( datee);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent send = new Intent( order_page.this,order_update_page.class );
                send.putExtra("id",id);
                send.putExtra("name",cname);
                send.putExtra("mail",cmail);
                send.putExtra("iid",iiid);
                send.putExtra("iname",iname);
                send.putExtra("qun",iqun);
                send.putExtra("date",datee);

                startActivity(send);

//                int a=1;
//               String b="a";
//               String c="a";
//               String d="a";
//               String e="a";
//               String f="a";
//               String g="a";
//               Order order = new Order(a,b,c,d,e,f,g);
//               dbHandler.addorders(order);
//



            }
        });

        conplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Order order = new Order(cid,cname,cmail,iiid,iname,iqun,datee);
                dbHandler.addCompleteOrdes(order);

                dbHandler.deleteOrders(d);
                Toast.makeText(order_page.this,"Completed",Toast.LENGTH_LONG).show();
                Intent send = new Intent( order_page.this,order_home.class );
                startActivity(send);


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent send = new Intent( order_page.this,order_home.class );
                startActivity(send);
            }
        });

    }
}