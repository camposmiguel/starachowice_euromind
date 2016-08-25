package com.miguelcr.a02_fbmessengerlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MessageItem> messages;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ListView
        lista = (ListView) findViewById(R.id.list_view);

        // List of data
        messages = new ArrayList<MessageItem>();

        messages.add(new MessageItem(
                "Kevin Kim",
                "https://s3.amazonaws.com/uifaces/faces/twitter/jsa/128.jpg",
                "Nice to meet you Elena!",
                "5:57PM"));

        messages.add(new MessageItem(
                "Chloe bower",
                "https://s3.amazonaws.com/uifaces/faces/twitter/kfriedson/128.jpg",
                "You: Did I leave my umbrella at your place?",
                "9:10AM"));

        messages.add(new MessageItem(
                "Roxanne Clediere",
                "https://s3.amazonaws.com/uifaces/faces/twitter/evagiselle/128.jpg",
                "Roxanne send 3 photos",
                "7:15AM"));

        // Adapter
        MessageItemAdapter adapter = new MessageItemAdapter(
                MainActivity.this,
                R.layout.message_item,
                messages
        );

        lista.setAdapter(adapter);
    }
}
