package com.miguelcr.a02_fbmessengerlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.miguelcr.a02_fbmessengerlist.MessageItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 24/8/16.
 */
public class MessageItemAdapter extends ArrayAdapter {
    Context ctx;
    List<MessageItem> values;
    int layout;

    public MessageItemAdapter(Context context, int resource, List<MessageItem> objects) {
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


        // GEt references to view components
        ImageView photo = (ImageView) v.findViewById(R.id.image_view_photo);
        TextView name = (TextView)v.findViewById(R.id.text_view_name);
        TextView message = (TextView)v.findViewById(R.id.text_view_message);
        TextView time = (TextView)v.findViewById(R.id.text_view_time);
        ImageView online = (ImageView)v.findViewById(R.id.image_view_online);

        // Get current object
        MessageItem current = values.get(position);
        String currentPhoto = current.getPhoto();
        String currentName = current.getName();
        String currentMessage = current.getText();
        String currentTime = current.getTime();
        boolean isOnline = current.isOnline();

        // Set values to view components
        name.setText(currentName);
        message.setText(currentMessage);
        time.setText(currentTime);
        Picasso.with(ctx).load(currentPhoto).into(photo);
        if(isOnline) {
            online.setVisibility(View.VISIBLE);
        }

     

        return v;
    }
}
