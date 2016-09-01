package com.miguelcr.a02_mediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(layout, parent, false);


        // GEt references to view components
        ImageView cover = (ImageView) v.findViewById(R.id.imageViewCover);
        TextView title = (TextView)v.findViewById(R.id.textViewTitle);
        TextView artist = (TextView)v.findViewById(R.id.textViewArtist);


        // Get current object
        SongItem current = values.get(position);
        String currentCover = current.getCover();
        String currentTitle = current.getTitle();
        String currentArtist = current.getArtist();


        // Set values to view components
        title.setText(currentTitle);
        artist.setText(currentArtist);
        if(!currentCover.isEmpty()) {
            Picasso.with(ctx).load(currentCover).resize(120,120).into(cover);
        }

        return v;

    }
}
