package com.miguelcr.a02_mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<SongItem> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listViewSongs);

        songs = new ArrayList<SongItem>();

        //TODO: complete with real data to show items in song list

        songs.add(new SongItem(...));
        songs.add(new SongItem(...));
        songs.add(new SongItem(...));


        MediaPlayerAdapter mySongAdapter = new MediaPlayerAdapter(
                MaintActivity.this,
                R.layout.song_item,
                songs
        );

        lista.setAdapter(mySongAdapter);



    }
}
