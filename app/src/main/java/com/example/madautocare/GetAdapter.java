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

public class GetAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    List<AddDbPass> ge;

    public GetAdapter(Context context, int resource,List<AddDbPass> ge) {
        super(context, resource, ge);
        this.context = context;
        this.resource = resource;
        this.ge = ge;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView ViewCode = row.findViewById(R.id.ViewCode);
        TextView ViewName = row.findViewById(R.id.ViewName);
        TextView ViewPrice = row.findViewById(R.id.ViewPrice);
        TextView ViewQuantity = row.findViewById(R.id.ViewQuantity);

        AddDbPass getdata = ge.get(position);
        ViewCode.setText(getdata.getCode());
        ViewName.setText(getdata.getNames());
        ViewPrice.setText(getdata.getPrice());
        ViewQuantity.setText(getdata.getQuantity());



        return row;
    }
}
