package com.miguelcr.a02_mediaplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<SongItem> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listViewSongs);

        songs = new ArrayList<SongItem>();

        //TODO: complete with real data to show items in song list

        songs.add(new SongItem("https://i.ytimg.com/vi/UfSLlD2cGAY/maxresdefault.jpg",
                "Sorry",
                "Justin Fever"));

        songs.add(new SongItem("",
                "Thriller",
                "Michael Jackson"));

        songs.add(new SongItem("http://www.music-bazaar.com/album-images/vol12/627/627651/2473052-big/The-Very-Best-Of-AC-DC-CD1-cover.jpg",
                "Back in Black",
                "AC/DC"));


        MediaPlayerAdapter mySongAdapter = new MediaPlayerAdapter(
                MainActivity.this,
                R.layout.song_item,
                songs
        );

        lista.setAdapter(mySongAdapter);

        lista.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        SongItem current = songs.get(position);

        Intent i = new Intent(MainActivity.this,PlayerActivity.class);

        i.putExtra("title",current.getTitle());
        i.putExtra("cover",current.getCover());
        i.putExtra("artist",current.getArtist());
        startActivity(i);
    }
}
