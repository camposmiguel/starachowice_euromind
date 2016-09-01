package com.miguelcr.a02_mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Bundle extras = getIntent().getExtras();

        String cover = extras.getString("cover");
        //TODO: get the artist and the title


    }
}
