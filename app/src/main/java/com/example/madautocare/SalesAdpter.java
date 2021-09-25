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

public class SalesAdpter extends ArrayAdapter<sales_modle> {

    private Context context;
    private int resource;
    List<sales_modle> Lists;

    SalesAdpter(Context context, int resource, List<sales_modle> Lists){
        super(context,resource,Lists);
        this.context = context;
        this.resource = resource;
        this.Lists = Lists;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView Sales_n = row.findViewById(R.id.sales_name);
        TextView Sales_e = row.findViewById(R.id.sales_email);
        TextView Sales_t = row.findViewById(R.id.sales_type);
        TextView Sales_p = row.findViewById(R.id.sales_amount);


        // todos [obj1,obj2,obj3]
        sales_modle list = Lists.get(position);
        Sales_n.setText(list.getCustomerName());
        Sales_e.setText(list.getCustomerEmail());
        Sales_t.setText(list.getCustomerBillType());
        Sales_p.setText(list.getCustomerBillAmount());

        return row;
    }

}
