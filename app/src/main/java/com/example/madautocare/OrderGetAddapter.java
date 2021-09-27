package com.example.madautocare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class OrderGetAddapter extends ArrayAdapter {
    private Context context;
    private int resource;
    List<order_parts_model> or;

    public OrderGetAddapter(Context context, int resource,List<order_parts_model> or) {
        super(context, resource, or);
        this.context = context;
        this.resource = resource;
        this.or = or;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView Name = row.findViewById(R.id.CusOrderName);
        TextView Email = row.findViewById(R.id.CusOrderEmail);
        TextView Qun = row.findViewById(R.id.CusOrderQun);
        TextView Date = row.findViewById(R.id.CusOrderDate);

        order_parts_model getdata = or.get(position);
        Name.setText(getdata.getCustomer_Names());
        Email.setText(getdata.getCustomer_Email());
        Qun.setText(getdata.getQun());
        Date.setText(getdata.getDates());



        return row;
    }
}
