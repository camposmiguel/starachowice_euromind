package com.miguelcr.a03_musicbox;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView lista;
    private List<MusicItem> instruments;
    private MusicAdapter adapter;
    SoundPool soundPool;
    int soundGuitar;


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

        lista.setAdapter(adapter);

        // Player properties
        AudioAttributes aa = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(10)
                .setAudioAttributes(aa)
                .build();

        // Load sound of guitar
        soundGuitar = soundPool.load(this,R.raw.guitar_sound,1);


    }
}
