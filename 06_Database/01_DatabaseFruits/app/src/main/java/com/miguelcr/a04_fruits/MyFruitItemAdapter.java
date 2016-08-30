package com.miguelcr.a04_fruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 30/8/16.
 */
public class MyFruitItemAdapter extends ArrayAdapter {
    Context ctx;
    int layout;
    List<FruitItem> values;


    public MyFruitItemAdapter(Context context, int resource, List<FruitItem> objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.layout = resource;
        this.values = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(layout, parent, false);

        // 1. Get all component views references
        ImageView imageViewIcon = (ImageView)v.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
        TextView textViewQuantity = (TextView) v.findViewById(R.id.textViewQuantity);

        // 2. Get all properties from current element of 'values' List
        FruitItem current = values.get(position);
        int icon = current.getIcon();
        String name = current.getName();
        int quantity = current.getQuantity();

        // 3. Set in component view the current element's values
        textViewName.setText(name);
        textViewQuantity.setText(String.valueOf(quantity));
        imageViewIcon.setImageResource(icon);

        return v;
    }
}
