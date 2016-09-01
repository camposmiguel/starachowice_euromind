package com.miguelcr.a02_mediaplayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by miguelcampos on 1/9/16.
 */
public class MediaPlayerAdapter extends ArrayAdapter<SongItem> {
    Context ctx;
    int layout;
    List<SongItem> values;


    public MediaPlayerAdapter(Context context, int resource, List<SongItem> objects) {
        super(context, resource, objects);
        ctx = context;
        layout = resource;
        values = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);

        //TODO: complete the code to draw one song item

        Picasso.with(ctx).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }
}
