package com.miguelcr.a04_fruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FruitsListActivity extends AppCompatActivity {
    ListView lista;
    List<FruitItem> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits_list);

        // 1. ListView Component
        lista  = (ListView) findViewById(R.id.listViewFruits);

        // 2. Datalist to show in the ListView
        fruits = new ArrayList<FruitItem>();
        fruits.add(new FruitItem(R.drawable.ic_watermelon,"Watermelon",1));
        fruits.add(new FruitItem(R.drawable.ic_strawberry,"Strawberry",2));
        fruits.add(new FruitItem(R.drawable.ic_bananas,"Banana",1));
        fruits.add(new FruitItem(R.drawable.ic_cherry,"Cherry",3));

        // 3. Draw list with our custom adapter
        MyFruitItemAdapter adapterFruits = new MyFruitItemAdapter(this,
                R.layout.fruit_item,
                fruits);

        lista.setAdapter(adapterFruits);
    }
}
