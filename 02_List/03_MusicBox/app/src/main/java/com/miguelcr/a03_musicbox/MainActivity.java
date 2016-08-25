package com.miguelcr.a03_musicbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView lista;
    private List<MusicItem> instruments;
    private MusicAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (GridView) findViewById(R.id.grid_view);
        instruments = new ArrayList<MusicItem>();

        instruments.add(new MusicItem(
                R.drawable.ic_guitar,
                "Guitar",
                R.raw.guitar_sound
        ));

        adapter = new MusicAdapter(MainActivity.this,
                R.layout.music_item,instruments);


    }
}
