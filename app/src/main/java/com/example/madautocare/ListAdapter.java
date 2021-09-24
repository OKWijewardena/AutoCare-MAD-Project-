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

public class ListAdapter extends ArrayAdapter<supplier_modle>{

        private Context context;
        private int resource;
        List<supplier_modle> Lists;

    ListAdapter(Context context, int resource, List<supplier_modle> Lists){
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

            TextView supplier_n = row.findViewById(R.id.supplier_name);
            TextView supplier_e = row.findViewById(R.id.supplier_email);
            TextView supplier_p = row.findViewById(R.id.Supplerphone);
//            ImageView imageView = row.findViewById(R.id.onGoing);


            // todos [obj1,obj2,obj3]
            supplier_modle list = Lists.get(position);
            supplier_n.setText(list.getSuppliers_Name());
            supplier_e.setText(list.getSuppliers_Email());
            supplier_p.setText("Mobile: "+(list.getSuppliers_Phone_Number()));

            return row;
        }
    }
