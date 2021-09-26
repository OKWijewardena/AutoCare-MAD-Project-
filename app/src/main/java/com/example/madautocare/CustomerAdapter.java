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

public class CustomerAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    List<AddDbPass> ge;

    public CustomerAdapter(Context context, int resource,List<AddDbPass> ge) {
        super(context, resource, ge);
        this.context = context;
        this.resource = resource;
        this.ge = ge;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView ViewCode = row.findViewById(R.id.CustomerCode);
        TextView ViewName = row.findViewById(R.id.CustomerName);
        TextView ViewPrice = row.findViewById(R.id.CustomerPrice);
//        TextView ViewQuantity = row.findViewById(R.id.CustomerQuantity);

        AddDbPass getdata = ge.get(position);
        ViewCode.setText(getdata.getCode());
        ViewName.setText(getdata.getNames());
        ViewPrice.setText(getdata.getPrice());
//        ViewQuantity.setText(getdata.getQuantity());

        return row;
    }
}
