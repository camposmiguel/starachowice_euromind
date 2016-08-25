package com.miguelcr.a05_randomdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {
    TextView textViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        textViewHistory = (TextView) findViewById(R.id.text_view_history);

        Bundle extras = getIntent().getExtras();
        int his1 = extras.getInt("history1");
        int his2 = extras.getInt("history2");
        int his3 = extras.getInt("history3");
        int his4 = extras.getInt("history4");
        int his5 = extras.getInt("history5");
        int his6 = extras.getInt("history6");

        textViewHistory.setText("Number 1: "+his1+"\n\n"
        +"Number 2: "+his2+"\n\n"
        +"Number 3: "+his3+"\n\n"
        +"Number 4: "+his4+"\n\n"
        +"Number 5: "+his5+"\n\n"
        +"Number 6: "+his6+"\n\n");
    }
}
