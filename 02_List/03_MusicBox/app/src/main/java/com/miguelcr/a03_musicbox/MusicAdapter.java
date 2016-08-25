package com.miguelcr.a03_musicbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 25/8/16.
 */
public class MusicAdapter extends ArrayAdapter {
    Context ctx;
    List<MusicItem> values;
    int layout;

    public MusicAdapter(Context context, int resource, List<MusicItem> objects) {
        super(context, resource, objects);

        ctx = context;
        values = objects;
        layout = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(layout, parent, false);


        // Get references to view components
        ImageView icon = (ImageView) v.findViewById(R.id.image_view_instrument);
        TextView name = (TextView)v.findViewById(R.id.text_view_instrument);

        // Get current object
        MusicItem current = values.get(position);
        int currentIcon = current.getIcon();
        String currentName = current.getName();

        // Set values to view components
        icon.setImageResource(currentIcon);
        name.setText(currentName);

        return v;
    }
}
