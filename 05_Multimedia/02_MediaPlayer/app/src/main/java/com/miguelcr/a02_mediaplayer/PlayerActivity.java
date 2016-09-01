package com.miguelcr.a02_mediaplayer;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewTitle, textViewArtist;
    ImageView btnPlayPause, imageViewCover;
    boolean isOnPause = true;
    MediaPlayer mediaPlayer;
    int currentPositionSong;

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
        if(cover!=null && !cover.isEmpty()) {
            Picasso.with(this).load(cover).resize(800, 800).into(imageViewCover);
        }

        btnPlayPause.setOnClickListener(this);

        // Play the song
        String url = "http://dl.mp3xd.eu/xd/wlpaGoeeZql9coWmaapCalqqm5/justin-bieber-sorry.mp3"; // your URL here
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.start();
    }

    @Override
    public void onClick(View v) {
        if(isOnPause) {
            btnPlayPause.setImageResource(R.drawable.ic_replay);
            isOnPause = false;
            mediaPlayer.pause();
            currentPositionSong = mediaPlayer.getCurrentPosition();
        } else {
            btnPlayPause.setImageResource(R.drawable.ic_pause);
            isOnPause = true;
            mediaPlayer.start();
            mediaPlayer.seekTo(currentPositionSong);
        }
    }
}
