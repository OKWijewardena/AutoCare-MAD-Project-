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

public class SalesAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    List<AddDbPass> ge;

    public SalesAdapter(Context context, int resource,List<AddDbPass> ge) {
        super(context, resource, ge);
        this.context = context;
        this.resource = resource;
        this.ge = ge;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView SalesCode = row.findViewById(R.id.SalesCode);
        TextView SalesName = row.findViewById(R.id.SalesName);
        TextView Sales = row.findViewById(R.id.Sales);

        AddDbPass getdata = ge.get(position);
        SalesCode.setText(getdata.getCode());
        SalesName.setText(getdata.getNames());
        Sales.setText(getdata.Sales());

        return row;
    }
}
