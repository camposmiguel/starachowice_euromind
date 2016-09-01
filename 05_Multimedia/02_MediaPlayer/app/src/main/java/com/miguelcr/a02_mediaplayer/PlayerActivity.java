package com.miguelcr.a02_mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayerActivity extends AppCompatActivity {
    TextView textViewTitle, textViewArtist;
    ImageView btnPlayPause, imageViewCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // Get component references
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        textViewArtist = (TextView) findViewById(R.id.textViewArtist);
        btnPlayPause = (ImageView) findViewById(R.id.imageViewPlayPause);
        imageViewCover = (ImageView) findViewById(R.id.imageViewCover);

        Bundle extras = getIntent().getExtras();

        String cover = extras.getString("cover");
        String title = extras.getString("title");
        String artist = extras.getString("artist");

        // Set data in components
        textViewTitle.setText(title);
        textViewArtist.setText(artist);
        Picasso.with(this).load(cover).resize(800,800).into(imageViewCover);


    }
}
